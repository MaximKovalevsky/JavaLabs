import java.util.Objects;

public class Book {
    private String name;
    private String writer;
    private int publicationYear;

    public Book(String name, String writer, int publicationYear) {
        this.name = name;
        this.writer = writer;
        this.publicationYear = publicationYear;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "LiteraryWork{" +
                "name='" + name + '\'' +
                ", creator='" + writer + '\'' +
                ", release=" + publicationYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book literaryWork = (Book) o;
        return publicationYear == literaryWork.publicationYear &&
                Objects.equals(name, literaryWork.name) &&
                Objects.equals(writer, literaryWork.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, writer, publicationYear);
    }
}