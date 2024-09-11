package Builder.RobotBuilderExample;

public class OldRobotBuilder implements IRobotBuilder {

    private IRobot robot;

    public OldRobotBuilder(){
        this.robot = new Robot();
    }

    @Override
    public void createHead() {
        System.out.println("Making Old Robot Head");
        ((Robot)robot).setHead("Tin Old Robot Head");
    }

    @Override
    public void createArms() {
        System.out.println("Making Old Robot Arms");
        ((Robot)robot).setArms("Tin Old Robot Arms");
    }

    @Override
    public IRobot build() {
        //Builder DP main method
        this.createArms();
        this.createHead();
        return robot;
    }


}
