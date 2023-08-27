package StrategyDP;

//Derek PlayList
public class Client {

    //https://www.youtube.com/watch?v=-NCgRD9-C6o&list=PLF206E906175C7E07&index=3
    //https://www.youtube.com/watch?v=u8DttUrXtEw
    /*
    * Use the Strategy pattern when you want to use different variants of an algorithm(ie strategies) within an object
    * and be able to switch from one algorithm to another during runtime.
    *
    * Problem and Usage Identifier: When something like Inheritance(IS-A) is there(Parent and Child) in your design. And THERE are some new behaviours(methods)
    * whose implementation needs to be there in approximately >=30-40%(upto 100%) of Child Classes  AND/OR
    * Each of the Child Class or a group of Child class needs specific implementation of these/parent-class(if overriding causing Duplicate Code) methods.
    *
    * Ans- In Such case First you define a Interface declaring such methods, implemented by various Classes(Strategy) giving diffrent algo-implementation to these/parent-class methods.
    *  Then in Parent class, you define HAS-A (Association) of this Interface  and Dynamically Inject the Implementation(Strategy) as per the Child Class or the Client Code.
    * */


    //Coding Example of 1st Link
    public static void main(String[] args) {

        Animal sparrow = new Bird();
        sparrow.setName("Sparrow 1");

        //Here Client can also Provide the type of Move or Fly at runtime for Duck(Just make a overloaded Constructor in Duck to support this).
        Animal duck = new Duck();
        duck.setName("Donald Duck");

        Animal dog = new Dog();
        dog.setName("ScoobyDoo");

        sparrow.getName();
        sparrow.flyAnimal();
        sparrow.moveAnimal();
        sparrow.makeSound();

        duck.getName();
        duck.flyAnimal();
        duck.moveAnimal();
        duck.makeSound();

        dog.getName();
        dog.flyAnimal();
        dog.moveAnimal();
        dog.makeSound();
    }



}
