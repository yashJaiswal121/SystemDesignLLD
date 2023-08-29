package Singleton;

public class LoggerSingleton {
    //private static LoggerSingleton loggerSingletonEager = new LoggerSingleton(); //Eager Loading in Singleton
    private static volatile LoggerSingleton loggerSingleton = null; // lAZY Loading and Thread Safe(Volatile)

    private LoggerSingleton(){
        if(loggerSingleton != null){
            throw new RuntimeException("Check So that You cant use reflection Apis to call Constructor twice externally and Create an Instance.!");
        }else{
            System.out.println("Instance Created ! ");
        }
    }

    //Eager Loading in Singleton
    //This is also Thread-Safe By default as loggerSingleton is static is initialized during Class Loading
//    public static LoggerSingleton getInstance(){
//        return loggerSingletonEager;
//    }

    //Lazy Loading in Singleton, Also made Thread Safe
    //But Due to Class Level Lock(Static + Synch.) it causes performance issues(locking whole function) if we also have some logic to extcute in this function.
    //So this approach for Thead Safety may be not very good in such schenarios.
//    public static synchronized LoggerSingleton getInstance(){
//
//        if(loggerSingleton == null){
//            loggerSingleton = new LoggerSingleton();
//        }
//
//        return loggerSingleton;
//    }

    //Final Approach : Thread Safety using Double Check Locking + Lazy Instantiation
    public static LoggerSingleton getInstance(){

        if(loggerSingleton == null){ //3. For the next Threads executing this line after time T (Thread T1 & T2 time), when they will execute this line, It will not go into Critical Section Code and return from here only. i.e PERFORMANCE INCREASED
            //1. For loggerSingleton=null, Say Threads (T1 and T2) concurrently reached this line at time T.
            synchronized (LoggerSingleton.class){ //synchronized at Class i.e One Thread at a time in Critical Section at Class level
                if(loggerSingleton == null){ //2. This check will ensure that only first thread(T1 or T2) which got access to critical section instantiates LoggerSingleton only.
                    loggerSingleton = new LoggerSingleton();
                }
            }
        }

        return loggerSingleton;
    }

}
