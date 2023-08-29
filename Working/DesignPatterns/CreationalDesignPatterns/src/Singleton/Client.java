package Singleton;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//SudoCode(Example) : https://www.youtube.com/watch?v=EZDeEHXUf8w
//Riddhi-Dutta(Double Checked Locking Explanation): https://www.youtube.com/watch?v=2Dw1v9QC408
public class Client {
    /*
    * Problem and Usage : Design Pattern to make ensure to have a single Instance of a Class in Application -ie its a Shared RESOURCE. That is used across application.
    * Eg: DbConnection class(Session.class in Hibernate) or  ApplicationConfiguration class or Logger in Application.
    * oR Runtime.class in Java
    *
    * Singleton DP also uses concepts like Lazy Loading , Thread Sync.
    *
    * Imp Points for Singleton:
    * 1) Constructor Should be PRIVATE
    * 2) Singleton Type INSTANCE variable should be PRIVATE + STATIC .
    * 3) One STATIC method to get the INSTANCE refernced via INSTANCE. As per LAZY-LOADING, If INSTANCE == NULL , return making a NEW instance and Assign it to INSTANCE
    * 4) Your Singleton Class SHOULD NOT ACCEPT params. If it does, then its FACTORY DP
    *
    * */

    public static void main(String[] args) {

        //Example of Logger Singleton Class

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1;i<=10;i++){
            executorService.execute(LoggerSingleton::getInstance);
        }

        executorService.shutdown();

    }


}
