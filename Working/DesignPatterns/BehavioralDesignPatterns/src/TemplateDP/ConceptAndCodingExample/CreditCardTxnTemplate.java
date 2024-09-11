package TemplateDP.ConceptAndCodingExample;

public class CreditCardTxnTemplate extends CardPaymentFlowTemplate{

    @Override
    public void validateRequest() {
        System.out.println("s1 - validate req cc");
    }

    @Override
    public void calculateTxnFee() {
        System.out.println("s2 - Calc fee cc");
    }

    @Override
    public void debitAmount() {
        System.out.println("s3 - debit amt cc");
    }

    @Override
    public void creditAmount() {
        System.out.println("s4 - credit amt cc");
    }
}
