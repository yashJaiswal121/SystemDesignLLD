package IteratorDP.ConceptAndCodingExample;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Book1","auth1"));
        bookList.add(new Book("Book2","auth2"));

        Library library = new Library(bookList);
        IBookIterator itr = library.getIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
