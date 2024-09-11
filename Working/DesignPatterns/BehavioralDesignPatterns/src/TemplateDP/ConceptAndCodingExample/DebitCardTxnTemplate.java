package TemplateDP.ConceptAndCodingExample;

public class DebitCardTxnTemplate extends CardPaymentFlowTemplate{
    @Override
    public void validateRequest() {
        System.out.println("s1 - validate req dc");
    }

    @Override
    public void calculateTxnFee() {
        System.out.println("s2 - Calc fee dc");
    }

    @Override
    public void debitAmount() {
        System.out.println("s3 - debit amt dc");
    }

    @Override
    public void creditAmount() {
        System.out.println("s4 - credit amt dc");
    }
}
