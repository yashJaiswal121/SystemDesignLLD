package Builder.RobotBuilderExample;

public class RobotDriver {
    IRobotBuilder robotBuilder;

    RobotDriver(IRobotBuilder builder){
        this.robotBuilder = builder; //Strategy DP type
    }

    public IRobot getRobot(){
        return this.robotBuilder.build();
    }
}
