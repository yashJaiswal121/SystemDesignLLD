package Observer.ConceptAndCodingExample.observables;

import Observer.ConceptAndCodingExample.observers.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneInventory implements InventoryObservable{

    private Integer iphoneCount = 0;
    private List<NotificationAlertObserver> waitingObserversList = new ArrayList<>();

    public Integer getIphoneCount(){
        return iphoneCount;
    }

    public void setIphoneCount(Integer newStockCount){
        boolean wereOutOfStock = this.iphoneCount <= 0;
        this.iphoneCount = newStockCount;
        //Empty stock but now New Iphones are added in stock
        if(wereOutOfStock && newStockCount>0){
            //Notify all Alerts made for various users
            this.notifyObservers();
        }
    }

    @Override
    public void addObserver(NotificationAlertObserver observer) {
        waitingObserversList.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        waitingObserversList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer : waitingObserversList){
            observer.update(this);
        }
    }
}
