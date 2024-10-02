package Observer.DerekExample;

import java.util.List;

//Subject/Provider/Observable Interface
//Must have methods of Provider/Observable
public interface IStockProvider {
    boolean register(IStock stock,IObserver observer);
    boolean unregister(IStock stock,IObserver observer);
    void notifyObservers(List<IObserver> observerList);
    //boolean notifyOnStockRateChange(IStock stock); //-Just extra busniness logic, nothing to do with DP
}
