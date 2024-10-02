package ChainOfResponsibiltyDP.ConceptAndCodingExample;

//Handler 2
public class ErrorLogProcessor_Handler extends LogProcessor_AbstractHandler{
    ErrorLogProcessor_Handler(LogProcessor_AbstractHandler nextLogProcessor) {
        super(nextLogProcessor);
    }

    // we can define the next handler in chain here too instead of client code as
    ErrorLogProcessor_Handler(){
        super(null);
    }

    @Override
    public void log(Integer logLevel,String msg){

        System.out.println("Called ErrorHandler log(..,..)");

        if(logLevel != InfoLogProcessor_Handler.ERROR){
            super.log(logLevel,msg); ////next();//
            return;
        }

        System.out.println("Error : " + msg);

    }
}
