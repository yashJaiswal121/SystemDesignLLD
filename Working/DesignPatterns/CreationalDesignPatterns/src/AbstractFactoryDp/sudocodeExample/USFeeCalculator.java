package AbstractFactoryDp.sudocodeExample;

public class USFeeCalculator implements FeeCalculator {
    @Override
    public void printFee() {
        System.out.println("Printing Fee of "+ this.getClass());
    }
}
