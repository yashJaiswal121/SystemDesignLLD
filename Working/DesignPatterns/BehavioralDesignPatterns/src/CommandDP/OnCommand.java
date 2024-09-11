package CommandDP;

//ConcreteCommand
public class OnCommand implements Command{
    private Device device;

    public OnCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.on();
    }
}
