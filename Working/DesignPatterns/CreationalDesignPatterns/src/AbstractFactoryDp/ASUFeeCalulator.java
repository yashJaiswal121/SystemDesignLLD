package AbstractFactoryDp;

public class ASUFeeCalulator implements FeeCalculator {
    @Override
    public void printFee() {
        System.out.println("Printing Fee of "+ this.getClass());
    }
}
