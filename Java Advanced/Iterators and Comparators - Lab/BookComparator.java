import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        return Comparator.comparing(Book::getTitle)
                .thenComparing(Book::getYear)
                .compare(first, second);
    }
}

