abstract public class TitleSearcher implements Searchable {
    @Override
    public boolean matches(Book book, String query) {
        return book.getTitle().toLowerCase().contains(query.toLowerCase());
    }
}
