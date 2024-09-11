package TemplateDP.ConceptAndCodingExample;

public class Client {
    //This DP is used when u want to follow a sequence of steps of a flow(which u specify in abstract class-Template),
    // and the implementation classes of the template have their own implemetation of those steps

    //Suppose a Card merchant(VISA) making transaction to a Credit Card Machine Shopkeeper and Debit card Shopkeeper
    //Since Credit card transactions have higher processing charges than debit card transactions, the payment flow can be for them
    //but the implementation of each step in flow can be diffrent due to this business rule.

    public static void main(String[] args) {

        CardPaymentFlowTemplate cardPaymentFlow1 = new CreditCardTxnTemplate();
        CardPaymentFlowTemplate cardPaymentFlow2 = new DebitCardTxnTemplate();

        cardPaymentFlow1.sendMoney();
        cardPaymentFlow2.sendMoney();
    }


}
