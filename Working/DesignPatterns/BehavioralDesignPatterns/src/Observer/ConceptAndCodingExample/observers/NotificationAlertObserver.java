package Observer.ConceptAndCodingExample.observers;

import Observer.ConceptAndCodingExample.observables.InventoryObservable;

public interface NotificationAlertObserver {
    public void update(InventoryObservable observable);
}
