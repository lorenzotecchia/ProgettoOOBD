package Model;

import java.sql.Timestamp;

public class Book {

    private final String ISNb_b;
    private String doi_B;
    private String title;
    private String accessMode;
    private Timestamp yearRelease;
    private int edition;
    private String author;
    private String FK_Magazine;

    public Book(String doi_B, String ISNb_b,String title, String accessMode, Timestamp yearRelease,int edition, String author, String FK_Magazine) {
        this.ISNb_b = ISNb_b;
        this.doi_B = doi_B;
        this.title = title;
        this.accessMode = accessMode;
        this.yearRelease = yearRelease;
        this.edition = edition;
        this.author = author;
        this.FK_Magazine = FK_Magazine;
    }

    public String getDoi_B() {
        return doi_B;
    }

    public void setDoi_B(String doi_B) {
        this.doi_B = doi_B;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    public Timestamp getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(Timestamp yearRelease) {
        this.yearRelease = yearRelease;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFK_Magazine() {
        return FK_Magazine;
    }

    public void setFK_Magazine(String FK_Magazine) {
        this.FK_Magazine = FK_Magazine;
    }

    @Override
    public String toString() {
        return "Book{" +
                "doi_B='" + doi_B + '\'' +
                ", title='" + title + '\'' +
                ", accessMode='" + accessMode + '\'' +
                ", yearRelease=" + yearRelease +
                ", editor='" + edition + '\'' +
                ", author='" + author + '\'' +
                ", FK_Magazine='" + FK_Magazine + '\'' +
                '}';
    }
}
