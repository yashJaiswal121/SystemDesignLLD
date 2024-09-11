package StrategyDP.ConceptAndCodingExample;

public class Truck extends Vehicle{

    //Driving Strategy injeccted at runtime in this Vehicle Type/Vehicle Sibling
    public Truck() {
        super(new OffroadDriveStrategy());
    }


    @Override
    public Integer getWheelsCount() {
        return 4;
    }
}
