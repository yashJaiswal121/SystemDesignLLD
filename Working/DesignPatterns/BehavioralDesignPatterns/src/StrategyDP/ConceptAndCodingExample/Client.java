package StrategyDP.ConceptAndCodingExample;


// THIS PATTERN SAYS FAVORS ASSOCIATION OVER INHERITANCE BECAUSE DIFFRENT STRATEGY(Normal / Offroad) is required by diffrent SIBLINGS(Truck,Bike) OF SAME PARENT(Vehicle).
// ALSO A STRATEGY TYPE CAN BE USED ACROSS MULTIPLE(NOT ALL) SIBLINGS.(lIKE Many Vehicle Childs can have same OFFROADING STRATEGY)
    /*
    * Use the Strategy pattern when you want to use different variants of an algorithm(ie strategies) within an object
    * and be able to switch from one algorithm to another during runtime.
    *
    * Problem and Usage Identifier: When something like Inheritance(IS-A) is there(Parent and Child) in your design. And THERE are some new behaviours(methods)
    * whose implementation needs to be there in approximately >=30-40%(upto 100%) of Child Classes  AND/OR
    * Each of the Child Class or a group of Child class needs specific implementation of these/parent-class(if overriding causing Duplicate Code) methods.
    */
public class Client {

    public static void main(String[] args) {
        Vehicle bike = new Bike();
        Vehicle truck = new Truck();

        System.out.println(bike.getWheelsCount());
        bike.startAndRun();

        System.out.println(truck.getWheelsCount());
        truck.startAndRun();
    }

}
