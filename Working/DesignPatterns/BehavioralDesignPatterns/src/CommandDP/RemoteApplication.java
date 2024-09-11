package CommandDP;

//Invoker
public class RemoteApplication {
    private Device device;
    private Command onCommand;
    private Command offCommand;

    public RemoteApplication(Device device){
        this.device = device;
        this.onCommand = new OnCommand(device);
        this.offCommand = new OffCommand(device);
    }
    public void pressOnBtn(){
        System.out.println("Remote Application Invoking ON command");
        onCommand.execute();
    }

    public void pressOffBtn(){
        System.out.println("Remote Application Invoking OFF command");
        offCommand.execute();
    }

}
