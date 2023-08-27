package StrategyDP;

public class Duck extends Bird{

    //Defining Strategy to USe for Move and Fly in Duck Bird
    public Duck(){
        super(new Swim(),new CannotFly());
    }

    @Override
    public void makeSound(){
        System.out.println("It Quacks");
    }
}
