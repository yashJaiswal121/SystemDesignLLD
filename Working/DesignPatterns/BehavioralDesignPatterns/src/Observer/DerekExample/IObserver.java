package Observer.DerekExample;

import java.util.List;

//Must have update() method in a Observer
public interface IObserver {
    public List<IStock> getSubscribedStocks();
    public void update(String msg);
}
