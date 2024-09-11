package CommandDP;

//https://www.youtube.com/watch?v=7Pj5kAhVBlg&list=PLF206E906175C7E07&index=14
//https://www.scaler.com/topics/design-patterns/command-design-pattern/
public class Client {
    /*
    *   Command DP allows you to store Code(i.e hidden in object) that is executed at a later time or many times.
    *   Client says I want a specific Command( which calls a code method) to run when execute() is called on one of these hidden object.
    *
    * It has:
    * Receiver- Receives command from the ConcreteCommand and knows how to perform operations associated with the command. E.g., Light, Speaker.
    * Command- An interface declared with an execute() method that individual commands would implement. It can also have an unexecute() method for unexecuting the last executed operation. For the sake of simplicity, we leave unexecute() out of the picture and focus just on the execute() method.
    * ConcreteCommand- Implements the Command interface and provides implementation for the execute() method. It communicates with the receiver to trigger appropriate action. Eg. OnCommand, OffCommand.
    * Invoker- Responsible for invoking the command assigned by the Client based on the incoming request.(Here RemoteApplication)
    * Client- Responsible for creating the ConcreteCommand, setting its receiver, and assigning it to the Invoker. E.g. RemoteApplication.
    * */

    public static void main(String[] args) {
        //Example Coded from Scaler link - Tweaked for my understanding too
        //Client
        Device tv = new Television();
        RemoteApplication tvRemote = new RemoteApplication(tv);

        tvRemote.pressOnBtn();
        tvRemote.pressOffBtn();

        System.out.println("=========================");

        Device soundBox = new SoundSystem();
        RemoteApplication soundBoxRemote = new RemoteApplication(soundBox);

        soundBoxRemote.pressOnBtn();
        soundBoxRemote.pressOffBtn();

    }


}
