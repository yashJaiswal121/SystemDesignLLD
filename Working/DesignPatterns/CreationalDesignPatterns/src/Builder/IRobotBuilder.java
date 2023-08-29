package Builder;

public interface IRobotBuilder {
    void createHead();
    void createArms();
    IRobot build(); //Builder DP main method
}
