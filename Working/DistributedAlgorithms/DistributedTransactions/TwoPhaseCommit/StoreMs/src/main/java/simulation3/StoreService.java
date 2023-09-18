package simulation3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreService {

    private Logger logger = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String viewHome() {
        return "store-index";
    }

    @Transactional
    @RequestMapping("/food/reserve/{orderId}")
    public Long reservePacket(@PathVariable Long orderId) {

        logger.info("Begin Reserving FoodPacket in DB for Order {} ",orderId);
        FoodPacket packet;
        try{
            //Note: We have Not Used OrderId in Txn here.
            // This is Because this is the PREPARE PHASE and SO No Business Related Data SHOULD BE Inserted in this Phase.
            //jdbcTemplate.execute("BEGIN"); //BEGIN TRANSACTION
            //Fetching 1st Valid Agent Only and holding Exclusive Lock on it
            packet = jdbcTemplate.queryForObject("SELECT * FROM PACKETS WHERE is_reserved = 'N' AND order_id IS NULL AND ROWNUM <= 1 FOR UPDATE", (rs, rowNum) -> {
                FoodPacket foodPacket = new FoodPacket();
                foodPacket.setId(rs.getLong("id"));
                foodPacket.setReserved(rs.getCharacterStream("is_reserved").toString().equalsIgnoreCase("Y"));
                foodPacket.setOrderId(rs.getLong("order_id"));
                foodPacket.setFoodId(rs.getLong("food_id"));
                return foodPacket;
            });
            jdbcTemplate.update("UPDATE PACKETS SET IS_RESERVED = 'Y' WHERE ID = ? ", new Object[]{packet.getId()});
            //jdbcTemplate.execute("END"); //END TRANSACTION
            //Now... Our RESOURCE IS RESERVED AND THUS OUR BLAST RADIUS IS REDUCED(Like Resource contention, Consistency, Concurrency issues will not happen after this point)

        }catch (Exception e){
            logger.info("Exception occurred! Rollback Reserving FoodPacket in DB for Order {}",orderId);
            jdbcTemplate.execute("ROLLBACK;");
            return -1L;
        }

        logger.info("Ended Reserving FoodPacket in DB Successfully! for Order {}",orderId);
        return packet.getId();
    }

    @Transactional
    @RequestMapping("/food/book/{orderId}")
    public String bookPacket(@PathVariable("orderId") Long orderId) {

        //Note: Business Related Data is Commited in this COMMIT Phase
        logger.info("Begin Booking Food Packet in DB for Order {}",orderId);
        Long packetId = null;
        try{

            //jdbcTemplate.execute("BEGIN"); //BEGIN TRANSACTION
            packetId = jdbcTemplate.queryForObject("SELECT ID FROM PACKETS WHERE IS_RESERVED = 'Y' AND ORDER_ID IS NULL AND ROWNUM<=1 FOR UPDATE",(rs,rowNum) -> rs.getLong("ID"));

            if(packetId == null)
                throw new RuntimeException("Null PacketId");

            jdbcTemplate.update("UPDATE PACKETS SET IS_RESERVED = 'N' ,  ORDER_ID = ? WHERE ID = ?",orderId,packetId);
           // jdbcTemplate.execute("END"); //END TRANSACTION

        }catch (Exception e){
            logger.info("Exception occurred! Rollback Food Packet in DB for Order {} and Packet {}",orderId,packetId);
            jdbcTemplate.execute("ROLLBACK;");
            return "Food Packet Unavailable";
        }

        logger.info("Ended Booking Food Packet in DB Successfully! for Order {} and Packet {}",orderId,packetId);
        return "Success";
    }
}