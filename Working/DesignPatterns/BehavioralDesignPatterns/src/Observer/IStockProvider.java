package Observer;

import java.util.List;

//Subject/Provider Interface
//Must have methods of Provider
public interface IStockProvider {
    boolean register(IStock stock,IObserver observer);
    boolean unregister(IStock stock,IObserver observer);
    void notifyObservers(List<IObserver> observerList);
    boolean notifyOnStockRateChange(IStock stock);
}
