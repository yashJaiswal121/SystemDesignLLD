package StrategyDP.DerekYoutubeExample;

public class Bird extends Animal{


    public Bird(Move move,ItFlys fly){
        super(move,fly);
    }

    //Defining Strategy to USe for Move and Fly in Simple Bird
    public Bird() {
        super(new Walk(), new Flying());
    }

    @Override
    public void makeSound(){
        System.out.println("It Churps");
    }
}
