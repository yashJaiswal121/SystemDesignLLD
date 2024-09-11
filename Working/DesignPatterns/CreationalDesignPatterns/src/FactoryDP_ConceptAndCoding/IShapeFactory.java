package FactoryDP_ConceptAndCoding;

public class IShapeFactory {

    public IShape getShapeInstance(String type){
        if(type.equalsIgnoreCase("Circle")){
            return new CircleShape();
        }else if(type.equalsIgnoreCase("Rectangle")){
            return new RectangleShape();
        }
        return null;
    }
}
