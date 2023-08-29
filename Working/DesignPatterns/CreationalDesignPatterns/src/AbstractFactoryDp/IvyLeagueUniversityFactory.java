package AbstractFactoryDp;

//Next Level Factory after Abstract Factory 'UniversityFactory'
public class IvyLeagueUniversityFactory extends UniversityFactory {
    @Override
    public AdmitCard getAdmitCard(String course) {
        switch (course){
            case "Math":
                    return new MITAdmitCard(); //Concrete Objects
            case "CS":
                    return new GeorgiaTechAdmitCard();

        }

        return null;
    }

    @Override
    public FeeCalculator getFeeCalculator(String course) {
        switch (course){
            case "Math":
                return new MITFeeCalculator();  ////Concrete Objects
            case "CS":
                return new GeorgiaTechFeeCalulator();

        }

        return null;
    }
}
