import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;


    public static class CompareBooksByYearsAscending implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return Integer.compare(first.getYear(),second.getYear());
        }
    }    public static class CompareBooksByYearsDescending implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return Integer.compare(second.getYear(),first.getYear());
        }
    }

    public static class CompareBooksByTitleLength implements Comparator<Book> {

        @Override
        public int compare(Book first, Book second) {
            return Integer.compare(first.getTitle().length(),second.getTitle().length());
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    @Override
    public String toString() {
        return "Book " + title + ", year " + year + ", authors " + authors;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}