package AbstractFactoryDp;

public class GeorgiaTechFeeCalulator implements FeeCalculator {
    @Override
    public void printFee() {
        System.out.println("Printing Fee of "+ this.getClass());
    }
}
