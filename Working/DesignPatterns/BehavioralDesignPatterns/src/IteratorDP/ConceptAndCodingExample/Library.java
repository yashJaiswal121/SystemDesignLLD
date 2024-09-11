package IteratorDP.ConceptAndCodingExample;

import java.util.List;


public final class Library { //This final modifier can be ommitted.
    private final List<Book> bookList; //This final modifier can be ommitted.

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public IBookIterator getIterator(){
        return new BookIterator();
    }

    private final class BookIterator implements IBookIterator{
        private int size;
        private int index;

        BookIterator(){
            this.index = 0;
            this.size = bookList.size();
        }
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Book next() {
            if(index>=size)
                throw new RuntimeException("Out Of Limit");
            return bookList.get(index++);
        }
    }

}
