import java.util.*;

public class Library {
    private List<Book> bookCollection = new ArrayList<>();
    private Set<String> uniqueWriters = new HashSet<>();
    private Map<String, Integer> writerStats = new HashMap<>();

    public void addLiterature(Book item) {
        bookCollection.add(item);
        uniqueWriters.add(item.getWriter());
        writerStats.put(item.getWriter(),
                writerStats.getOrDefault(item.getWriter(), 0) + 1);
    }

    public void removeLiterature(Book item) {
        if (bookCollection.remove(item)) {
            String creator = item.getWriter();
            int updatedCount = writerStats.get(creator) - 1;

            if (updatedCount == 0) {
                writerStats.remove(creator);
                uniqueWriters.remove(creator);
            } else {
                writerStats.put(creator, updatedCount);
            }
        }
    }

    public List<Book> findByWriter(String creator) {
        List<Book> foundItems = new ArrayList<>();
        for (Book item : bookCollection) {
            if (item.getWriter().equals(creator)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<Book> findByPublicationYear(int year) {
        List<Book> foundItems = new ArrayList<>();
        for (Book item : bookCollection) {
            if (item.getPublicationYear() == year) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void displayAll() {
        bookCollection.forEach(System.out::println);
    }

    public void showWriters() {
        uniqueWriters.forEach(System.out::println);
    }

    public void displayWriterStats() {
        writerStats.forEach((creator, total) ->
                System.out.println(creator + ": " + total + " entries"));
    }
}