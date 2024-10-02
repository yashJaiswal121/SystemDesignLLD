package Observer.ConceptAndCodingExample.observables;

import Observer.ConceptAndCodingExample.observers.NotificationAlertObserver;

public interface InventoryObservable {
    void addObserver(NotificationAlertObserver observer);
    void removeObserver(NotificationAlertObserver observer);
    void notifyObservers();

}
