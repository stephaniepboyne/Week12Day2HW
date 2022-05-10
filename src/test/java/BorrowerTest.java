import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    private Borrower borrower;
    private Book book;
    private Book bookTwo;
    private Library library;

    @Before
    public void before(){
        borrower = new Borrower();
        book = new Book("Jane Eyre", "Charlotte Bronte", "gothic");
        bookTwo = new Book("Frankenstein", "Mary Shelley", "gothic");
        library = new Library(5);
    }

    @Test
    public void hasCollectionCount(){
        assertEquals(0, borrower.collectionCount());
    }

    @Test
    public void testAddBookToCollection(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(bookTwo);
        library.addBook(bookTwo);
        borrower.addBookToCollection(library, bookTwo);
        assertEquals(3, library.bookCount());
        assertEquals(1, borrower.collectionCount());
    }

    @Test
    public void testCannotAddBookToCollection(){
        library.addBook(book);
        library.addBook(book);
        borrower.addBookToCollection(library, bookTwo);
        assertEquals(2, library.bookCount());
        assertEquals(0, borrower.collectionCount());
    }

    @Test
    public void testReturnBook(){
        library.addBook(book);
        library.addBook(bookTwo);
        borrower.addBookToCollection(library, bookTwo);
        borrower.returnBook(library, bookTwo);
        assertEquals(2, library.bookCount());
        assertEquals(0, borrower.collectionCount());
    }

    @Test
    public void cannotReturnBook(){
        library.addBook(book);
        library.addBook(bookTwo);
        borrower.addBookToCollection(library, bookTwo);
        borrower.returnBook(library, book);
        assertEquals(1, library.bookCount());
        assertEquals(1, borrower.collectionCount());
    }

}
