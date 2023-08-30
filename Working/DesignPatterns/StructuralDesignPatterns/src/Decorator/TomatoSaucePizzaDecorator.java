package Decorator;

import java.util.List;

public class TomatoSaucePizzaDecorator extends ToppingsDecorator{

    TomatoSaucePizzaDecorator(IPizza pizza) {
        super(pizza);
        super.pizza.getToppings().add("Tomato Sauce");
    }

    @Override
    public void breadSpec() {
        System.out.println("Adding Tomato Sauce to Pizza Base");
        super.pizza.breadSpec();
    }

    @Override
    public List<String> getToppings() {
        System.out.println("Added Tomato Sauce to Pizza Toppings");
        return super.pizza.getToppings();
    }

    @Override
    public double getCost() {
        System.out.println("Adding Tomato Sauce Cost to Pizza");
        return super.pizza.getCost() + 0.5;
    }
}
