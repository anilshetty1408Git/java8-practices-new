package functionalInterface;

import java.util.Arrays;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks() {
        return Arrays.asList(new Book(101, "Core Java", 400),
                new Book(363, "Hibernate", 180),
                new Book(275, "Spring", 200),
                new Book(893, "WebService", 300));

    }


}
