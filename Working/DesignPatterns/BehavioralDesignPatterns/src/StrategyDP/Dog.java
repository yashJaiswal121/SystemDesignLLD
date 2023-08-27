package StrategyDP;

public class Dog extends Animal{
    //Defining Strategy to USe for Move and Fly in Dog
    //Even though Dog cannot Fly, its specific Algo is given which will say Dog cannot Fly
    public Dog() {
        super(new Walk(), new CannotFly());
    }

    @Override
    public void makeSound(){
        System.out.println("It Barks");
    }
}
