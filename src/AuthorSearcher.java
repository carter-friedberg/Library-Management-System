abstract public class AuthorSearcher implements Searchable {
    @Override
    public boolean matches(Book book, String query){
        return book.getAuthor().toLowerCase().contains(query.toLowerCase());
    }

}
