package Builder.ConceptAndCodingExample;


public class Client {

    /*
    *  Usage: Use Builder DP when the object needs to prepared from other object/s(Builder).
    *
    *   Here we have these main Components:
    *       - Builder: The Component who provide specifies implementation how the final object will be made.
    *       - Director: The Component who tells the specific Builder to Form the Object. And yes, there can be many builders creating a same object.
    *                   The Director tells the Builder to use, so somewhat use STRATEGY DP.
    *       - Client Interacts With Driver
    *
    * */

    public static void main(String[] args) {

        //Builder as outer class , seperate from Student
            StudentBuilder studentBuilder = new EngineeringStudentBuilder();
            Student studentEngg = studentBuilder.setName("Yesh").setRollNo(1).setSubjects().build();
            StudentBuilder studentBuilder2 = new MBAStudentBuilder();
            Student studentMba = studentBuilder2.setName("Yesh1").setRollNo(11).setSubjects().build();
            System.out.println(studentEngg);
            System.out.println(studentMba);

        //Builder as inner class
        ZomatoOrder zomatoOrder = ZomatoOrder.getBuilder()
                .setOrderId(1l).setContent("Pizza").setCustomerId(11l).setDiscount(100).build();
        System.out.println(zomatoOrder);

    }


}
