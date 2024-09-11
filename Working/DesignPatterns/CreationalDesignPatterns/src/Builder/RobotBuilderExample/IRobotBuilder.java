package Builder.RobotBuilderExample;

public interface IRobotBuilder {
    void createHead();
    void createArms();
    IRobot build(); //Builder DP main method
}
