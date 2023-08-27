package StrategyDP;

public class Animal {
    private String name;
    private Move move; // Needed by 100% of Child classes
    private ItFlys fly;  // Relavent for Some Child who can fly

    public Animal(Move move,ItFlys fly){
        this.move = move;
        this.fly = fly;
    }


    public String getName() {
        System.out.println("Name of Animal is : " + this.name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public ItFlys getFly() {
        return fly;
    }

    public void setFly(ItFlys fly) {
        this.fly = fly;
    }

    public void makeSound(){
        //This will be overrided in each Subclass as each of it has its own version
        System.out.println("Default Animal Sound");
    }

    public void flyAnimal(){
        this.fly.canFly();
    }

    public void moveAnimal(){
        this.move.moving();
    }


}
