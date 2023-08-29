package AbstractFactoryDp;

//Sudo Code: https://www.youtube.com/watch?v=5hXZnI86E2Y
public class Client {

    /*
    *  Same as Factory DP. Its Factory of Factories which all produces final objects related to each other(Like Sofa, Chair, Table all related to each other as Furniture).
    *
    * Problem and UseCase: Use it when you have many Factories and these Factories are Linked to each other i.e
    *  Use the Abstract Factory when your code needs to work with various families of related products(Like AdmitCard and Universities(Group of Collages)),
    *  but you don’t want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.
    *
    * Here also, like in Factory Pattern , We have a Common Interface to define,Implement and provide concrete classes.
    * Eg: DocumentBuilder in Java
    * */

    /*  Class Diagram for Implementation Steps:
                (EXTRA INTF.                            (SAME AS IN FACTORY D.P)                            (SAME AS IN FACTORY DP)
                HERE COMPARED TO        inherits                                        inherits
                FACTORY D.P)        <------------------                            <------------------
        --------------------------      interacts       ------------------------------     interacts    -------------------------
                Abstract          ------------------>   Concrete Factory           ------------------->  Concrete Object Class
                Factory                                     (Impl)
CLIENT---->                                            +createObject()                                    -createObject(){
              +createObject()                        -  Which Concrete Object                                   ....Impl
            -Decides and Uses                           of which class should be                           }
            concrete Factory                           instantiated is decided here.
            for createObject() impl                                                                       - Real Implementation
      ----------------------------                   -------------------------------                   -------------------------



        So it can be visualized as:
                                        param1               --------> Concrete Object 1
                                     ---------->   FACTORY1  --------> Concrete Object 2
        CLIENT ----> ABSTRACT FACTORY  param2                                             (Like in Factory DP, Here also ,Concrete Objects of Factories are closely related)
                                     ---------->   FACTORY2  ---------> Concrete Object 3
                                        param3
                                     ---------->   FACTORY3  ----------> Concrete Object 4
                                                             ----------> Concrete Object 5
    * */


    public static void main(String[] args) {
        /*
        * Here in Example,
        *   -we have 'UniversityFactory' as Abstract Factory, WHICH GIVES ONE OF FOLLOWING FACTORY as per Client Marks Score:
        *   -'IvyLeagueUniversityFactory' as Concrete Factory 1
        *   -'PublicUniversityFactory' as Concrete Factory 2
        *
        *   Now each of these Factories as per the Subject Course choice ,
        *   - Gives a Concrete Object of Admit card(Various Admit cards of Various Collage).
        *   - Gives a Concrete Object of Collage Fee Calculator.
         * */

        int examScore = 120;
        String courseChoice = "CS";

        UniversityFactory universityFactory = UniversityFactory.getUniversityAbstractFactory(examScore);
        AdmitCard admitCard = universityFactory.getAdmitCard(courseChoice);
        FeeCalculator feeCalculator = universityFactory.getFeeCalculator(courseChoice);

        admitCard.printInfo();
        feeCalculator.printFee();

        System.out.println("----------------------------------------------------");

        courseChoice = "Math";
        admitCard = universityFactory.getAdmitCard(courseChoice);
        feeCalculator = universityFactory.getFeeCalculator(courseChoice);

        admitCard.printInfo();
        feeCalculator.printFee();

        System.out.println("====================================================");

        examScore = 110;
        courseChoice = "CS";

        universityFactory = UniversityFactory.getUniversityAbstractFactory(examScore);
        admitCard = universityFactory.getAdmitCard(courseChoice);
        feeCalculator = universityFactory.getFeeCalculator(courseChoice);

        admitCard.printInfo();
        feeCalculator.printFee();

        System.out.println("----------------------------------------------------");

        courseChoice = "Math";
        admitCard = universityFactory.getAdmitCard(courseChoice);
        feeCalculator = universityFactory.getFeeCalculator(courseChoice);

        admitCard.printInfo();
        feeCalculator.printFee();




    }

}
