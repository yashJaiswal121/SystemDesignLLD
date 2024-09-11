package FactoryDP_ConceptAndCoding;


//Concrete Implementation 1 of Shape
public class CircleShape implements IShape{

    @Override
    public void computeArea() {
        System.out.println("Computing 2 pi r");
    }
}
