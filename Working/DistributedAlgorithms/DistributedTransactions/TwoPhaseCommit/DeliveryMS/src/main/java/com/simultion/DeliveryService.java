package com.simultion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryService {

    private Logger logger = LoggerFactory.getLogger(DeliveryService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String viewHome() {
        return "delivery-index";
    }

    @Transactional
    @GetMapping("/agent/reserve/{orderId}")
    public Long reserveAgent(@PathVariable("orderId") Long orderId) {

        logger.info("Begin Reserving Agent in DB for Order {} ",orderId);
        Agent agent;
        try{

            //Note: We have Not Used OrderId in Txn here.
            // This is Because this is the PREPARE PHASE and SO No Business Related Data SHOULD BE Inserted in this Phase.
           // jdbcTemplate.execute("BEGIN"); //BEGIN TXN
            //Fetching 1st Valid Agent Only and holding Exclusive Lock on it
            agent = jdbcTemplate.queryForObject("SELECT * FROM AGENT WHERE is_reserved = 'N' AND order_id IS NULL AND ROWNUM <= 1 FOR UPDATE", (rs, rowNum) -> {
                Agent agent1 = new Agent();
                agent1.setId(rs.getLong("id"));
                agent1.setReserved(rs.getCharacterStream("is_reserved").toString().equalsIgnoreCase("Y"));
                agent1.setOrderId(rs.getLong("order_id"));
                return agent1;
            });
            jdbcTemplate.update("UPDATE AGENT SET IS_RESERVED = 'Y' WHERE ID = ?", new Object[]{agent.getId()});
          //  jdbcTemplate.execute("END"); //END TXN
            //Now... Our RESOURCE IS RESERVED AND THUS OUR BLAST RADIUS IS REDUCED(Like Resource contention, Consistency, Concurrency issues will not happen after this point)

        }catch (Exception e){
            logger.info("Exception occurred! Rollback Reserving Agent in DB for Order {}",orderId);
            jdbcTemplate.execute("ROLLBACK");
            return -1L;
        }

        logger.info("Ended Reserving Agent in DB Successfully! for Order {}",orderId);
        return agent.getId();
    }

    @Transactional
    @GetMapping("/agent/book/{orderId}")
    public String bookAgent(@PathVariable("orderId") Long orderId) {

        logger.info("Begin Booking Agent in DB for Order {} and Agent {}",orderId);

        Long agentId = null;
        try{
         //   jdbcTemplate.execute("BEGIN");
            agentId = jdbcTemplate.queryForObject("SELECT ID FROM AGENT WHERE IS_RESERVED = 'Y' AND ORDER_ID IS NULL AND ROWNUM<=1 FOR UPDATE",(rs,rowNum) -> rs.getLong("ID"));

            if(agentId == null)
                throw new RuntimeException("Null AgentID");

            jdbcTemplate.update("UPDATE AGENT SET IS_RESERVED = 'N' ,  ORDER_ID = ? WHERE ID = ?",orderId,agentId);
        //    jdbcTemplate.execute("END");

        }catch (Exception e){
            logger.info("Exception occurred! Rollback Reserving Agent in DB for Order {} and Agent {}",orderId,agentId);
            jdbcTemplate.execute("ROLLBACK");
            return "Delivery Agent Unavailable";
        }

        logger.info("Ended Booking Agent in DB Successfully! for Order {} and Agent {}",orderId,agentId);
        return "Success";
    }
}