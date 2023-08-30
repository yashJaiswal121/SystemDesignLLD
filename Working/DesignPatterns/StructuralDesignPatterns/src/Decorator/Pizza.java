package Decorator;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements IPizza{

    private List<String> toppings;
    private double baseCost = 4.0;

    @Override
    public void breadSpec() {
        System.out.println("This is Plain Pizza Bread Layer");
    }

    @Override
    public List<String> getToppings() {
        if(this.toppings == null)
            this.toppings = new ArrayList<>();
        return this.toppings;
    }

    @Override
    public double getCost() {
        return baseCost;
    }


}
