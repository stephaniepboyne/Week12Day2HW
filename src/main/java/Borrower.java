import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> collection;

    public Borrower(){
        this.collection = new ArrayList<>();
    }

    public int collectionCount(){
        return this.collection.size();
    }

    public void addBookToCollection(Library library, Book book){
        if (library.books.contains(book)){
            Book takenBook = library.removeBook(book);
            collection.add(takenBook);
        }
    }

    public Book removeBook(Book book){
        this.collection.remove(book);
        return book;
    }

    public void returnBook(Library library, Book book){
        if(this.collection.contains(book)){
            Book returnedBook = this.removeBook(book);
            library.books.add(returnedBook);
        }
    }
}
