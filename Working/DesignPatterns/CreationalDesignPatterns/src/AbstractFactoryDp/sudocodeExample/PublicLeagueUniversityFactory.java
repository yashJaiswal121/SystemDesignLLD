package AbstractFactoryDp.sudocodeExample;

//Concrete Factory 1
public class PublicLeagueUniversityFactory extends UniversityFactory {
        @Override
        public AdmitCard getAdmitCard(String course) {
            switch (course){
                case "Math":
                    return new USAdmitCard();
                case "CS":
                    return new ASUAdmitCard();

            }

            return null;
        }

        @Override
        public FeeCalculator getFeeCalculator(String course) {
            switch (course){
                case "Math":
                    return new USFeeCalculator();
                case "CS":
                    return new ASUFeeCalulator();

            }

            return null;
        }
}
