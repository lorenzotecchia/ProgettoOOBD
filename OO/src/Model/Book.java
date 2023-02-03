package Model;

import java.sql.Timestamp;

public class Book {

    private String ISBN_b;
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


    public Book(String doi_B, String ISBN_b, int edition, String publishingHouse, String language,
                String title, String accessMode, String argument, Boolean reprint, Timestamp releaseDate,
                String releaseLocation, String presentationName, String FK_author, String FK_Series) {

        this.ISBN_b = ISBN_b;
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


    public String getDoi_B() {
        return doi_B;
    }


    public String getTitle() {
        return title;
    }


    public String getAccessMode() {
        return accessMode;
    }


    public Timestamp getReleaseDate() {
        return releaseDate;
    }


    public int getEdition() {
        return edition;
    }


    public String getAuthor() {
        return FK_author;
    }


    public String getFK_Series() {
        return FK_Series;
    }

    public Boolean getReprint() {
        return reprint;
    }


    public String getArgument() {
        return argument;
    }


    public String getLanguage() {
        return language;
    }


    public String getISBN_B() {
        return ISBN_b;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getReleaseLocation() {
        return releaseLocation;
    }

    public String getPresentationName() {
        return presentationName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "doi_B='" + doi_B + '\'' +
                ", ISBN_b='" + ISBN_b + '\'' +
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
