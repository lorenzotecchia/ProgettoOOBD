package Model;

import java.sql.Timestamp;

public class Book {

    private String ISBN_b;
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
    private String FK_Series;
    private String author;


    public Book(String ISBN_b, int edition, String publishingHouse, String language,
                String title, String accessMode, String argument, Boolean reprint, Timestamp releaseDate,
                String releaseLocation, String presentationName, String FK_Series, String author) {

        this.ISBN_b = ISBN_b;
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
        this.FK_Series = FK_Series;
        this.author = author;
    }

    public String getAuthor() {
        return author;
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
                '}';
    }

}
