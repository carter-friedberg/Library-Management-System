import java.util.*;




public class Library {

    private Set<String> authors = new HashSet<>();
    private List<Book> catalog = new ArrayList<Book>();
    private  Map<String, Book> isbnIndex = new HashMap<>();
    private Map<String, List<Book>> genreIndex= new HashMap<String, List<Book>>();

    public void addBook(Book book){
        String genre = book.getGenre();
        catalog.add(book);
        authors.add(book.getAuthor());
        isbnIndex.put(book.getIsbn(), book);

        if (!genreIndex.containsKey(genre)){
            genreIndex.put(genre, new ArrayList<>());
        }

        genreIndex.get(genre).add(book);
    }

    public List<Book> search(String query, Searchable strategy){
        List<Book> results = new ArrayList<>();
        for (Book book : catalog){
            if (strategy.matches(book, query)){
                results.add(book);
            }
        }
        return results;
    }

    public Book findByISBN(String isbn){
        return isbnIndex.get(isbn);
    }

    public List<Book> getCatalog(){
        return catalog;
    }

    public Set<String> getAuthors(){
        return authors;
    }

    public Map<String, List<Book>> getGenreIndex(){
        return genreIndex;
    }

    public void removeBook(String isbn){
        Book book = findByISBN(isbn);

        if (book != null){
            isbnIndex.remove(isbn);
            catalog.remove(book);
            genreIndex.get(book.getGenre()).remove(book);
            if (genreIndex.get(book.getGenre()).isEmpty()){
                genreIndex.remove(book.getGenre());
            }
            boolean stillbooksbyauthor = false;
            for (Book thisbook : catalog){
                if (thisbook.getAuthor().equals(book.getAuthor())){
                    stillbooksbyauthor = true;
                    break;
                }
            }
            if (!stillbooksbyauthor){
                authors.remove(book.getAuthor());
            }
        }
    }
}
