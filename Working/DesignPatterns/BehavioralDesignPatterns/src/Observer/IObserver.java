package Observer;

import java.util.List;

//Must have method in a Observer
public interface IObserver {
    public List<IStock> getSubscribedStocks();
    public void update(String msg);
}
