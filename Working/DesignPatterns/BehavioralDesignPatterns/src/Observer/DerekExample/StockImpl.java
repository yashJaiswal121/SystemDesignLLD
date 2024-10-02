package Observer.DerekExample;

import java.util.Objects;

public class StockImpl implements IStock{

    private String name;
    private String rate;

    public StockImpl(String name,String rate){
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate){
        IStockProvider stockProvider = StockProvider.getInstance();
        this.rate = rate;
        //stockProvider.notifyOnStockRateChange(this); //-Just extra busniness logic, nothing to do with DP
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockImpl stock = (StockImpl) o;
        return name.equals(stock.name) ; //Since Its a Key in HashMap which should be Immutable, Thus not using rate here as it can be updated
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
