package AbstractFactoryDp;

public class MITFeeCalculator implements FeeCalculator {
    @Override
    public void printFee() {
        System.out.println("Printing Fee of "+ this.getClass());
    }
}
