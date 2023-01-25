package Model;

import java.sql.Timestamp;

public class Book {

    private String ISNb_b;
    private String doi_B;
    private int edition;
    private String publishingHouse;
    private String language;
    private String title;
    private String accessMode;
    private String argument;
    private Boolean reprint;
    private Timestamp releaseDate;
    private String releaseLocation;
    private String presentationName;
    private String FK_author;
    private String FK_Series;


    public Book(String doi_B, String ISNb_b, int edition, String publishingHouse, String language, String title, String accessMode, String argument, Boolean reprint, Timestamp releaseDate, String releaseLocation, String presentationName, String FK_author, String FK_Series) {
        this.ISNb_b = ISNb_b;
        this.doi_B = doi_B;
        this.edition = edition;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.title = title;
        this.accessMode = accessMode;
        this.argument = argument;
        this.reprint = reprint;
        this.releaseDate = releaseDate;
        this.releaseLocation = releaseLocation;
        this.presentationName = presentationName;
        this.FK_author = FK_author;
        this.FK_Series = FK_Series;
    }

    public Book(String doiB, String isbnB, int edition, String publishingHouse, String language, String title, String argument, String accessMode, boolean reprint, Timestamp releaseDate, String releaseLocation, String presentationName, String fkAuthor, String fkSeries) {
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

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) { this.releaseDate = releaseDate; }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getAuthor() { return FK_author; }

    public void setAuthor(String author) {
        this.FK_author = author;
    }

    public String getFK_Series() {
        return FK_Series;
    }

    public void setFK_Series(String FK_Series) {
        this.FK_Series = FK_Series;
    }
    public Boolean getReprint() {return reprint; }

    public void setReprint(Boolean reprint) { this.reprint = reprint; }

    public String getArgument() { return argument; }

    public void setArgument(String argument) { this.argument = argument; }

    public String getLanguage() { return language; }

    public void setLanguage(String language) { this.language = language; }

    public String getISNb_b() { return ISNb_b; }
    public void setISNb_b(String ISNb_b) { this.ISNb_b = ISNb_b; }
    public String getPublishingHouse() { return publishingHouse; }
    public void setPublishingHouse(String publishingHouse) { this.publishingHouse = publishingHouse; }
    public String getReleaseLocation() { return releaseLocation; }
    public void setReleaseLocation(String releaseLocation) { this.releaseLocation = releaseLocation; }
    public String getPresentationName() { return presentationName; }
    public void setPresentationName(String presentationName) { this.presentationName = presentationName; }

    @Override
    public String toString() {
        return "Book{" +
                "doi_B='" + doi_B + '\'' +
                ", ISNb_b='" + ISNb_b + '\'' +
                ", edition='" + edition + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", argument='" + argument + '\'' +
                ", accessMode='" + accessMode + '\'' +
                ", reprint='" + reprint + '\'' +
                ", releaseDate=" + releaseDate + '\'' +
                ", releaseLocation='" + releaseLocation + '\'' +
                ", presentationName='" + presentationName + '\'' +
                ", FK_Series='" + FK_Series + '\'' +
                ", FK_author='" + FK_author + '\'' +
                '}';
    }
}
