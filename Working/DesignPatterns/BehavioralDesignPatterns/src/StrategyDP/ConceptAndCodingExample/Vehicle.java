package StrategyDP.ConceptAndCodingExample;

public abstract class Vehicle {
    private IDriveStrategy driveStrategy;

    public Vehicle(IDriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    //Common code using the runtime Injected Strategy in each sibling of Vehicle(Bike,Truck)
    public void startAndRun(){
        System.out.println("Start and Run Vehicle");
        driveStrategy.drive();
    }

    public abstract Integer getWheelsCount();
}
