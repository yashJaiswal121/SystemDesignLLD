package ChainOfResponsibiltyDP.ConceptAndCodingExample;

//Handler 1
public class InfoLogProcessor_Handler extends LogProcessor_AbstractHandler{
    InfoLogProcessor_Handler(LogProcessor_AbstractHandler nextLogProcessor) {
        super(nextLogProcessor);
    }

    // we can define the next handler in chain here too instead of client code as
    InfoLogProcessor_Handler(){
        super(new ErrorLogProcessor_Handler());
    }

    @Override
    public void log(Integer logLevel,String msg){

        System.out.println("Called InfoHandler log(..,..)");

        if(logLevel != InfoLogProcessor_Handler.INFO){
            super.log(logLevel,msg); ////next();//
            return;
        }

        System.out.println("INFO : " + msg);

    }
}
