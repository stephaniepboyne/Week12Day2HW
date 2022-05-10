import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void before(){
        book = new Book("Frankenstein", "Mary Shelley", "gothic");
    }

    @Test
    public void hasTitle(){
        assertEquals("Frankenstein", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Mary Shelley", book.getAuthor());
    }

    @Test
    public void hasGenre() {
        assertEquals("horror", book.getGenre());
    }

}
