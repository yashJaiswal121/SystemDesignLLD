package AbstractFactoryDp;

public class ASUAdmitCard implements AdmitCard {
    @Override
    public void printInfo() {
        System.out.println("Printing AdmitCard of "+ this.getClass());
    }
}
