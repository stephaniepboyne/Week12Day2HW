import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    public ArrayList<Book> books;
    private Integer capacity;
    private HashMap<String, Integer> bookCountByGenre;

    public Library(Integer capacity){
        this.books = new ArrayList<>();
        this.capacity = capacity;
        this.bookCountByGenre = new HashMap<>();
    }

    public int bookCount(){
        return this.books.size();
    }

    public HashMap getBookCountByGenre(){
        for (Book book: this.books){
            if (this.bookCountByGenre.containsKey(book.getGenre())){
                this.bookCountByGenre.put(book.getGenre(), bookCountByGenre.get(book.getGenre()) + 1);
            } else {
                this.bookCountByGenre.put(book.getGenre(), 1);
            }
        }
        return bookCountByGenre;
    }

    public void addBook(Book book){
        if (this.bookCount() < this.capacity){
            this.books.add(book);
        }
    }

    public Book removeBook(Book book){
        this.books.remove(book);
        return book;
    }

}
