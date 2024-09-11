package StrategyDP.ConceptAndCodingExample;

public class Bike extends Vehicle{

    //Driving Strategy injeccted at runtime in this Vehicle Type/Vehicle Sibling
    public Bike(){
        super(new NormalDriveStrategy());
    }

    @Override
    public Integer getWheelsCount() {
        return 2;
    }
}
