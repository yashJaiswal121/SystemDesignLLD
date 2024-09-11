package AbstractFactoryDp.sudocodeExample;

//Abstract Factory
public abstract class UniversityFactory {
    public static int cutOff = 119;

    public static UniversityFactory getUniversityAbstractFactory(int score){

        if(score >= cutOff){
            return new IvyLeagueUniversityFactory();
        }else {
            return new PublicLeagueUniversityFactory();
        }
    }

    public abstract AdmitCard getAdmitCard(String course);
    public abstract FeeCalculator getFeeCalculator(String course);

}
