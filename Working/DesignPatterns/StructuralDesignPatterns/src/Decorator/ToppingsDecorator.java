package Decorator;

import java.util.List;

public abstract class ToppingsDecorator implements IPizza {
    protected IPizza pizza;

    ToppingsDecorator(IPizza pizza){
        this.pizza = pizza;
    }


//    @Override
//    public void breadSpec() {
//        this.pizza.breadSpec();
//    }
//
//    @Override
//    public List<String> getToppings() {
//        return this.pizza.getToppings();
//    }
//
//    @Override
//    public double getCost() {
//        return this.pizza.getCost();
//    }
}
