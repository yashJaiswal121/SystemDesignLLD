package Observer;
//Derek PlayList
//https://www.youtube.com/watch?v=wiQdrH2YpT4&list=PLF206E906175C7E07&index=4 (Code is Written as per it)

public class Client {
    /*
    * Problem-Usage : When you need many other objects to observe the change happened to a certain Object.
    * Observer Pattern is a pattern in which an object(Publisher/Subject) maintains a list of its Dependents(Observers),
    * and Notifies them when there are any changes in Subject,usually by calling a method(update()) defined in Observers.
    *
    * Pros: Loose-Coupling Subject and Observers from one another.
    * Cons: Subject also notifies the Observer which may not be interested in some event of Subject.
    *
    * Subject/Publisher - Has 3 methods - addObserver(Observer){} | removeObserver(Observer){} | notifyObservers(){...}
    * Observers - Has a method - update(){}
    * */

    /*
    *
    * */

    public static void main(String[] args) {
        IStockProvider bombayStockExchange = StockProvider.getInstance();

        User user1 = new User("User A");
        User user2 = new User("User B");
        User user3 = new User("User C");
        User user4 = new User("User D");

        IStock stock1 = new StockImpl("Google","123");
        IStock stock2 = new StockImpl("Microsoft","124");
        IStock stock3 = new StockImpl("Siemens","125");
        IStock stock4 = new StockImpl("Facebook","126");

        stock1.setRate("120");

        ((StockProvider)bombayStockExchange).addStock(stock1);
        bombayStockExchange.register(stock1,user3);

        ((StockProvider)bombayStockExchange).addStock(stock2);
        bombayStockExchange.register(stock2,user4);

        ((StockProvider)bombayStockExchange).addStock(stock3);
        bombayStockExchange.register(stock3,user1);
        bombayStockExchange.register(stock3,user3);

        stock3.setRate("129");

        ((StockProvider)bombayStockExchange).addStock(stock4);
    }

}
