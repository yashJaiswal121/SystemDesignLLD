package FactoryDP_ConceptAndCoding;

public class Client {

    public static void main(String[] args) {
        IShapeFactory shapeFactory = new IShapeFactory();
        shapeFactory.getShapeInstance("Circle").computeArea();
        shapeFactory.getShapeInstance("Rectangle").computeArea();
    }
}
