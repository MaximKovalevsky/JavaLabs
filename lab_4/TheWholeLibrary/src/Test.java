public class Test {
    public static void main(String[] args) {
        Library storage = new Library();

        Book novel1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book novel2 = new Book("1984", "George Orwell", 1949);
        Book novel3 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book novel4 = new Book("Animal Farm", "George Orwell", 1945);

        storage.addLiterature(novel1);
        storage.addLiterature(novel2);
        storage.addLiterature(novel3);
        storage.addLiterature(novel4);

        System.out.println("Complete collection:");
        storage.displayAll();

        System.out.println("\nUnique creators:");
        storage.showWriters();

        System.out.println("\nCreator statistics:");
        storage.displayWriterStats();

        System.out.println("\nWorks by George Orwell:");
        storage.findByWriter("George Orwell").forEach(System.out::println);

        System.out.println("\nWorks from 1949:");
        storage.findByPublicationYear(1949).forEach(System.out::println);

        storage.removeLiterature(novel2);
        System.out.println("\nAfter removal:");
        storage.displayAll();

        System.out.println("\nUpdated statistics:");
        storage.displayWriterStats();
    }
}