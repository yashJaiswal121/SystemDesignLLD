package simulation2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;


//https://www.youtube.com/watch?v=oMhESvU87jM
//Only to Invoke this service externally. It will do 2PC
@RestController
@RequestMapping("/order")
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String viewHome() {
        return "order-index";
    }

    @GetMapping("/concurrent/place")
    public String placeConcurrentOrders(){
        try{
            final AtomicInteger orderId = new AtomicInteger(1);
            List<CompletableFuture<String>> allOrderFutures = new ArrayList<>();

            while (orderId.get() <= 4){
                int id = orderId.getAndIncrement();
                CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> placeOrder(id));
                allOrderFutures.add(future);
            }

            CompletableFuture.allOf(allOrderFutures.toArray(new CompletableFuture[0])).join();
            for(CompletableFuture<String> future : allOrderFutures){
                if(future.get().contains("Error")){
                    throw new RuntimeException();
                }
            }
        }catch (Exception e){
            logger.info("Error in placing 4 Order request Concurrently");
            return "Error in placing 4 Order request Concurrently";
        }

        logger.info("successfully placed request for 4 Orders Concurrently");
        return "successfully placed request for 4 Orders Concurrently";
    }

    private String placeOrder(Integer orderId){

        Long agentId,packetId;

            try{
                packetId = restTemplate.getForObject("http://localhost:8083/store/food/reserve/"+orderId,Long.class);
                if(packetId == null || packetId.intValue() == -1)
                    throw new RuntimeException();
            }catch (Exception e){
                logger.info("OrderSvc: Food Packet Unavaliable! for OrderId {}",orderId.toString());
                return "Error OrderSvc: Food Packet Unavaliable! for OrderId = "+orderId.toString();
            }

        try{
             agentId = restTemplate.getForObject("http://localhost:8085/delivery/agent/reserve/"+orderId,Long.class);
            if(agentId == null || agentId.intValue() == -1)
                throw new RuntimeException();
        }catch (Exception e){
            logger.info("OrderSvc: Agent Unavaliable! for OrderId {}",orderId.toString());
            return "Error OrderSvc: Agent Unavaliable! for OrderId = "+orderId.toString();
        }

        try{
            String responseMsg = restTemplate.getForObject("http://localhost:8083/store/food/book/"+orderId,String.class);
            if(responseMsg == null || !responseMsg.equalsIgnoreCase("Success"))
                throw new RuntimeException();
        }catch (Exception e){
            logger.info("OrderSvc: Food Packet cannot be booked! for OrderId {}",orderId.toString());
            return "Error OrderSvc: Food Packet cannot be booked! for OrderId = "+orderId.toString();

        }

        try{
            String responseMsg = restTemplate.getForObject("http://localhost:8085/delivery/agent/book/"+orderId,String.class);
            if(responseMsg == null || !responseMsg.equalsIgnoreCase("Success"))
                throw new RuntimeException();
        }catch (Exception e){
            logger.info("OrderSvc: Agent cannot be booked! for OrderId {}",orderId.toString());
            return "Error OrderSvc: Agent cannot be booked! for OrderId = "+orderId.toString();
        }

        return "Order Placed Successfully";

    }

}