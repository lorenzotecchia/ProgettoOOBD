package Model;

import java.sql.Timestamp;

public class Article {
    private String doi_A;
    private String title;
    private String accessMode;
    private String editor;
    private String topic;
    private Timestamp releaseDate;
    private String releaseLocation;
    private String conferenceName;
    private String FK_author;
    private String FK_Magazine;

    public Article(String doi_A, String title, String accessMode, String editor, String topic, Timestamp releaseDate, String releaseLocation, String conferenceName, String FK_author, String FK_Magazine) {
        this.doi_A = doi_A;
        this.title = title;
        this.accessMode = accessMode;
        this.editor = editor;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.releaseLocation = releaseLocation;
        this.conferenceName = conferenceName;
        this.FK_author = FK_author;
        this.FK_Magazine = FK_Magazine;
    }

    public String getDoi_A() {
        return doi_A;
    }


    public String getTitle() {
        return title;
    }


    public String getAccessMode() {
        return accessMode;
    }


    public String getEditor() {
        return editor;
    }


    public String getTopic() {
        return topic;
    }


    public Timestamp getReleaseDate() {
        return releaseDate;
    }


    public String getReleaseLocation() {
        return releaseLocation;
    }


    public String getConferenceName() {
        return conferenceName;
    }


    public String getAuthor() {
        return FK_author;
    }


    public String getFK_Magazine() {
        return FK_Magazine;
    }

    @Override
    public String toString() {
        return "Article{" +
                "doi_B='" + doi_A + '\'' +
                ", title='" + title + '\'' +
                ", accessMode='" + accessMode + '\'' +
                ", editor='" + editor + '\'' +
                ", topic='" + topic + '\'' +
                ", releaseDate=" + releaseDate + '\'' +
                ", releaseLocation='" + releaseLocation + '\'' +
                ", conferenceName='" + conferenceName + '\'' +
                ", FK_author='" + FK_author + '\'' +
                ", FK_Magazine='" + FK_Magazine + '\'' +
                '}';
    }
}
