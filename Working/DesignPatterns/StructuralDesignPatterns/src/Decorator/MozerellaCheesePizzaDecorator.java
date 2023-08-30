package Decorator;

import java.util.List;

public class MozerellaCheesePizzaDecorator extends ToppingsDecorator{

    MozerellaCheesePizzaDecorator(IPizza pizza) {
        super(pizza);
        super.pizza.getToppings().add("Mozirella Cheese");
    }

    @Override
    public List<String> getToppings() {
        System.out.println("Added Cheese Topping to Pizza");
        return super.pizza.getToppings();
    }

    @Override
    public double getCost() {
        System.out.println("Adding Cheese Cost to Pizza");
        return super.pizza.getCost() + 2;
    }
}
