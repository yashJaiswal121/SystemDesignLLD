package AbstractFactoryDp;

public class USAdmitCard implements AdmitCard {
    @Override
    public void printInfo() {
        System.out.println("Printing AdmitCard of "+ this.getClass());
    }
}
