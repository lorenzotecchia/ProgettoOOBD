package Model;

import java.sql.Timestamp;

public class Book {
    private final String doiB;

    public Book(String doiB, String isbnB, int edition, Timestamp releaseDate, String publishingHouse, String author, String accessMode, String title, String argument, boolean reprint, String fkSeries) {
            this.doiB = doiB;
    }
}
