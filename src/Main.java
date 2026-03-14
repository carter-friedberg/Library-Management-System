public class Main {

    public static void main(String[] args) {
        Library myLibrary = new Library();

        // 1. Add some books
        myLibrary.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "101", "Classic"));
        myLibrary.addBook(new Book("Project Hail Mary", "Andy Weir", "102", "Sci-Fi"));
        myLibrary.addBook(new Book("The Martian", "Andy Weir", "103", "Sci-Fi"));

        System.out.println("Initial Catalog Size: " + myLibrary.getCatalog().size());
        System.out.println("Genres before removal: " + myLibrary.getGenreIndex().keySet());

        // 2. Remove a book and check the "Zombie Genre" logic
        System.out.println("\n--- Removing 'The Great Gatsby' ---");
        myLibrary.removeBook("101");

        // 3. Verify
        System.out.println("Catalog Size: " + myLibrary.getCatalog().size());
        System.out.println("Genres left: " + myLibrary.getGenreIndex().keySet()); // 'Classic' should be gone!

        // 4. Check Author cleanup
        System.out.println("Authors left: " + myLibrary.getAuthors()); // 'F. Scott Fitzgerald' should be gone!
    }
}