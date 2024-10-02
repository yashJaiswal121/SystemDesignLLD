package ChainOfResponsibiltyDP.ConceptAndCodingExample;

public class Client {

    public static void main(String[] args) {

        //Default Chain of HANDLER handling
        LogProcessor_AbstractHandler logProcessor = new InfoLogProcessor_Handler(); //1st Info then Error as per default chain

        logProcessor.log(LogProcessor_AbstractHandler.INFO,"Test Info Msg");
        logProcessor.log(LogProcessor_AbstractHandler.ERROR,"Test Error Msg");

        System.out.println(" ============ See Sequence of log() method calling in each HANDLERS due to chain sequence REVERSAL ======");

        //Manully defining the chain in reverse as above chain
        logProcessor = new ErrorLogProcessor_Handler(new InfoLogProcessor_Handler(null)) ;
        logProcessor.log(LogProcessor_AbstractHandler.INFO,"Test Info Msg");
        logProcessor.log(LogProcessor_AbstractHandler.ERROR,"Test Error Msg");


    }

}
