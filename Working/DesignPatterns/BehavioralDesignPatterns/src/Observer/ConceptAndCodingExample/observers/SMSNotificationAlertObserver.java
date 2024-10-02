package Observer.ConceptAndCodingExample.observers;

import Observer.ConceptAndCodingExample.observables.IPhoneInventory;
import Observer.ConceptAndCodingExample.observables.InventoryObservable;

import javax.sound.midi.SysexMessage;

public class SMSNotificationAlertObserver implements NotificationAlertObserver{

    private String phoneNumber;
    private String username;

    public SMSNotificationAlertObserver(String username, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    @Override
    public void update(InventoryObservable observable) {
        this.sendSMS(observable);
    }

    private void sendSMS(InventoryObservable observable){
        if(observable instanceof IPhoneInventory){
            //since IPhone is a expensive product, so send notification using expensive fast API
            System.out.println("Expensive API sending SMS to " + this.username +" on " + this.phoneNumber +"with iphones left = " + ((IPhoneInventory) observable).getIphoneCount());
        }else{
            //Not so expensive Product, so send sms via normal API.Also not sending IPhone count remaining to them
            System.out.println("Normal API Sending SMS to" + this.username +" on " + this.phoneNumber);
        }
    }
}
