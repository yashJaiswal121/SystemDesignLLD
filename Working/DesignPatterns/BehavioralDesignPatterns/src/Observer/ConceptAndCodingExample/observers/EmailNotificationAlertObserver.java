package Observer.ConceptAndCodingExample.observers;

import Observer.ConceptAndCodingExample.observables.IPhoneInventory;
import Observer.ConceptAndCodingExample.observables.InventoryObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver{

    private String emailAddress;
    private String username;

    public EmailNotificationAlertObserver(String username, String emailAddress) {
        this.emailAddress = emailAddress;
        this.username = username;
    }

    @Override
    public void update(InventoryObservable observable) {
        this.sendEmail(observable);
    }

    private void sendEmail(InventoryObservable observable){
        if(observable instanceof IPhoneInventory){
            //since IPhone is a expensive product, so send notification using expensive fast API
            System.out.println("Expensive API sending Email to " + this.username +" on " + this.emailAddress +"with iphones left = " + ((IPhoneInventory) observable).getIphoneCount());
        }else{
            //Not so expensive Product, so send sms via normal API. Also not sending IPhone count remaining to them
            System.out.println("Normal API Sending Email to" + this.username +" on " + this.emailAddress);
        }
    }

}
