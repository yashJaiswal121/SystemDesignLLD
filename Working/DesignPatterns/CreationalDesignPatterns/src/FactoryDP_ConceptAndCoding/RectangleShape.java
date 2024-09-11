package FactoryDP_ConceptAndCoding;


// Comncrete impl of shape
public class RectangleShape implements IShape{

    @Override
    public void computeArea() {
        System.out.println("Computing l*b");
    }
}
