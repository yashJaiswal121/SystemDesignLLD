package Observer.ConceptAndCodingExample;


import Observer.ConceptAndCodingExample.observables.IPhoneInventory;
import Observer.ConceptAndCodingExample.observables.InventoryObservable;
import Observer.ConceptAndCodingExample.observers.EmailNotificationAlertObserver;
import Observer.ConceptAndCodingExample.observers.SMSNotificationAlertObserver;

/*
*
*   WALMART INTERVIEW QUESTION - DESIGN THE NOTIFY ME IN AMAZON CART
*
* */
public class Client {
    public static void main(String[] args) {
        IPhoneInventory observable = new IPhoneInventory();
        observable.addObserver(new SMSNotificationAlertObserver("Yesh","+918126031124"));
        observable.addObserver(new EmailNotificationAlertObserver("Yesh","yash.jaiswal121@gmail.com"));
        observable.addObserver(new SMSNotificationAlertObserver("XYZ","+91348597485"));

        observable.setIphoneCount(0);
        System.out.println("No Notifications uptil now!!");
        observable.setIphoneCount(10);

    }
}
