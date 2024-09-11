package CommandDP;

//Reciever
public class SoundSystem implements Device{

    @Override
    public void on() {
        System.out.println("Sound System is starting up");
    }

    @Override
    public void off() {
        System.out.println("Sound System is shutting down");
    }
}
