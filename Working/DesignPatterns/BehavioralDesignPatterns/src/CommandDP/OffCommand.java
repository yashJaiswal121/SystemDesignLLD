package CommandDP;

//ConcreteCommand
public class OffCommand implements Command{
    private Device device;

    public OffCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.off();
    }
}
