package Observer.DerekExample;

import java.util.*;

// This class is the Subject/Publisher
// Notifies all User(which are atleast subscribed to 1 Stock) Observers when a Stock is Added/removed
// Notifies Associated Users/Observers if the rates of a Stock Change.
// Here Stock is not a publisher. It is calling a method of Publisher which is notifying the Observers on the rate-change.
public class StockProvider implements IStockProvider {

    private final Map<IStock,List<IObserver>> stockToObservers;
    private static IStockProvider stockProvider;
    private String msg;

    private StockProvider(){
        this.stockToObservers = new HashMap<>();
        this.msg = "";
    }

    // Singleton Only - Not part of Observer DP
    public static IStockProvider getInstance(){
        if(stockProvider == null){
            stockProvider = new StockProvider();
        }
        return stockProvider;
    }

    public boolean addStock(IStock stock){
        if(stockToObservers.containsKey(stock))
            return false;

        this.msg = "New Stock is Being Added ! = "+stock.getName();
        Set<IObserver> observerSet = new HashSet<>();

        for(Map.Entry<IStock,List<IObserver>> entry : stockToObservers.entrySet()){
            observerSet.addAll(entry.getValue());
        }

        notifyObservers(new ArrayList<>(observerSet));
        stockToObservers.put(stock,new ArrayList<>());

        return true;
    }

    public boolean removeStock(IStock stock){
        //If Stock has some User subsctibed to It, Cannot delete Stock
        if(!stockToObservers.containsKey(stock) || stockToObservers.get(stock).size() > 0)
            return false;

        this.msg = "Stock is Being Removed Completely ! = "+stock.getName();
        for(Map.Entry<IStock,List<IObserver>> entry : stockToObservers.entrySet()){
            notifyObservers(entry.getValue());
        }
         stockToObservers.remove(stock);
         return true;
    }


    @Override
    public boolean register(IStock stock, IObserver observer) {
        if(!stockToObservers.containsKey(stock))
            return false;

        stockToObservers.get(stock).add(observer);
        observer.getSubscribedStocks().add(stock);
        return true;
    }

    @Override
    public boolean unregister(IStock stock, IObserver observer) {
        if(!stockToObservers.containsKey(stock))
            return false;

        stockToObservers.get(stock).remove(observer);
        observer.getSubscribedStocks().remove(stock);
        return false;
    }

    @Override
    public void notifyObservers(List<IObserver> observerList) {

        for(IObserver observer : observerList){
            observer.update(this.msg);
        }
    }



    //-Just extra busniness logic, nothing to do with DP
//    @Override
//    public boolean notifyOnStockRateChange(IStock stock) {
//        //Rate of a stock has Changed, So Notifying its Subscribed Users/Observers
//        if(!stockToObservers.containsKey(stock))
//            return false;
//
//        this.msg = stock.getName() + " Stock Rates has been modified to = "+stock.getRate();
//        notifyObservers(stockToObservers.get(stock));
//        return true;
//    }


}
