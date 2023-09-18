package simulation3;

public class FoodPacket {

    private Long id;
    private Long foodId;
    //is_reserved=N means Packet is already either been assigned to an order or not been touched yet by any order request.
    //is_reserved=Y means Packet is about to be assigned to an order(i.e touched by PREPARE phase)
    private boolean reserved;
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
