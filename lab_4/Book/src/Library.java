import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Set<String> authors = new HashSet<>();
    private Map<String, Integer> authorCounts = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        authorCounts.put(book.getAuthor(),
                authorCounts.getOrDefault(book.getAuthor(), 0) + 1);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            String author = book.getAuthor();
            int newCount = authorCounts.get(author) - 1;
            if (newCount == 0) {
                authorCounts.remove(author);
                authors.remove(author);
            } else {
                authorCounts.put(author, newCount);
            }
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        books.forEach(System.out::println);
    }

    public void printUniqueAuthors() {
        authors.forEach(System.out::println);
    }

    public void printAuthorStatistics() {
        authorCounts.forEach((author, count) ->
                System.out.println(author + ": " + count + " books"));
    }
}