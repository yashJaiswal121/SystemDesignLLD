package AbstractFactoryDp.sudocodeExample;

public class GeorgiaTechAdmitCard implements AdmitCard {
    @Override
    public void printInfo() {
        System.out.println("Printing AdmitCard  of "+ this.getClass());
    }
}
