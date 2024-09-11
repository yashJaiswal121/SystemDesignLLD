package TemplateDP.ConceptAndCodingExample;

public abstract class CardPaymentFlowTemplate { //must be abstract
    //step1
    public abstract void validateRequest();
    //step2
    public abstract void calculateTxnFee();
    //step3
    public abstract void debitAmount();
    //step4
    public abstract void creditAmount();


    //Flow Template
    public void sendMoney(){
        validateRequest(); //s1
        calculateTxnFee();  //s2
        debitAmount();//s3
        creditAmount();//s4
    }



}
