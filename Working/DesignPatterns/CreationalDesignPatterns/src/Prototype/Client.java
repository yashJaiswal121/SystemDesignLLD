package Prototype;

public class Client {

    //Prototype -> Use to get deep cloned objects of an object, so it has a clone() function
    //Every cloneable object should be implementing this Prototype Interface and provide the clone() implementation

    public static void main(String[] args) {
        Student orignal = new Student(1,"xyz");
        Student cloned = (Student) orignal.clone();

        System.out.println("clone = "+cloned);
    }

}
