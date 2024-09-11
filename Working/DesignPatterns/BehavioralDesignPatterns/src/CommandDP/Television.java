package CommandDP;

//Reciever
public class Television implements Device{
    @Override
    public void on() {
        System.out.println("TV is starting up");
    }

    @Override
    public void off() {
        System.out.println("TV is shutting down");
    }
}
