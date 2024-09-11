package Builder.RobotBuilderExample;

//https://www.youtube.com/watch?v=9XnsOpjclUg&list=PLF206E906175C7E07&index=8
public class Client {

    /*
    *  Usage: Use Builder DP when the object needs to prepared from other object/s(Builder).
    *         Here when the creation of parts of Object needs to be independent from main object.
    *         In this pattern, the Builder Component only knows the specification how object will be made.
    *
    *   Here we have these main Components:
    *       - Builder: The Component who provide specifies implementation how the final object will be made.
    *       - Director: The Component who tells the specific Builder to Form the Object. And yes, there can be many builders creating a same object.
    *                   The Director tells the Builder to use, so somewhat use STRATEGY DP.
    *       - Client Interacts With Driver
    *
    * */

    public static void main(String[] args) {
        IRobotBuilder oldRobotBuilder = new OldRobotBuilder(); //Builder
        RobotDriver robotDriver = new RobotDriver(oldRobotBuilder); //As per the Builder, we get Robot from Driver

        IRobot robot = robotDriver.getRobot();
        System.out.println(robot);
    }


}
