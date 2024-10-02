package Observer.DerekExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements IObserver{
    private String name;
    private List<IStock> subscribedStocks;

    public User(String n){
        name = n;
        subscribedStocks = new ArrayList<>();
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + " " + msg);
    }

    @Override
    public List<IStock> getSubscribedStocks() {
        return subscribedStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
