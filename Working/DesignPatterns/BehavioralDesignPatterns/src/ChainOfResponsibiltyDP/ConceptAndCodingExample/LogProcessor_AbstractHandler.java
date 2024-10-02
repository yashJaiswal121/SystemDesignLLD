package ChainOfResponsibiltyDP.ConceptAndCodingExample;

public abstract class LogProcessor_AbstractHandler {

    public static Integer INFO = 1;
    public static Integer ERROR = 2;

    private LogProcessor_AbstractHandler nextLogProcessor;

    LogProcessor_AbstractHandler(LogProcessor_AbstractHandler nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(Integer logLevel,String message){ //next(){Implemetation}//
        if(this.nextLogProcessor != null)
            this.nextLogProcessor.log(logLevel,message);
    }

}
