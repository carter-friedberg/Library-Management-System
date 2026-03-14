import java.lang.String;
import java.util.*;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String genre;

    public Book(String title, String author, String isbn, String genre){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public String toString(){
        return "Book Name: " + title + "\n\tAuthor: " + author + "\n\tISBN: " + isbn;
    }
}
