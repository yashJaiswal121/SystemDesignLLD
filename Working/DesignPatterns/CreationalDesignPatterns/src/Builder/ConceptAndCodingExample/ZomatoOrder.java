package Builder.ConceptAndCodingExample;

public class ZomatoOrder {

    private Long orderId;
    private Long customerId;
    private Integer discount;
    private String content;

    public ZomatoOrder(ZomatoOrderBuilder builder){
        this.orderId = builder.orderId;
        this.discount = builder.discount;
        this.customerId = builder.customerId;
        this.content = builder.content;
    }

    @Override
    public String toString() {
        return "ZomatoOrder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", discount=" + discount +
                ", content='" + content + '\'' +
                '}';
    }

    public static ZomatoOrderBuilder getBuilder(){
        return new ZomatoOrderBuilder();
    }

     static class ZomatoOrderBuilder{
        private Long orderId;
        private Long customerId;
        private Integer discount;
        private String content;

        public ZomatoOrderBuilder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public ZomatoOrderBuilder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public ZomatoOrderBuilder setDiscount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public ZomatoOrderBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        ZomatoOrder build(){
            ZomatoOrder zomatoOrder = new ZomatoOrder(this);
            return zomatoOrder;
        }
    }


}
