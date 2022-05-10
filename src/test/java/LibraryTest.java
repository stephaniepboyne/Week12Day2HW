import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Book book;
    private Book bookTwo;
    private Book bookThree;
    private Library library;


    @Before
    public void before(){
        library = new Library(4);
        book = new Book("Jane Eyre", "Charlotte Bronte", "gothic");
        bookTwo = new Book("Frankenstein", "Mary Shelley", "gothic");
        bookThree = new Book("Mary Berry's Family Recipes", "Marry Berry", "cookbook");
    }

    @Test
    public void hasBookCount(){
        assertEquals(0, library.bookCount());
    }

    @Test
    public void testAddBook(){
        library.addBook(book);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void testRemoveBook(){
        library.addBook(book);
        library.addBook(bookTwo);
        library.removeBook(book);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void testCannotAddBook(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(4, library.bookCount());
    }

    @Test
    public void testGetBookCountByGenre(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(bookTwo);
        library.addBook(bookThree);
        HashMap<String, Integer> expected = new HashMap<String, Integer>(){
            {
                put("gothic", 3);
                put("cookbook", 1);
            }
        };
        assertEquals(expected, library.getBookCountByGenre());
    }

}
