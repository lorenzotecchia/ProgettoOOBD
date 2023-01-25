package Model;

import java.sql.Timestamp;

public class Article {
    private String doi_A;
    private String title;
    private String accessMode;
    private Timestamp yearRelease;
    private String editor;
    private String author;
    private String FK_Magazine;

    public Article(String doi_A, String title, String accessMode, Timestamp yearRelease, String editor, String author, String FK_Magazine) {
        this.doi_A = doi_A;
        this.title = title;
        this.accessMode = accessMode;
        this.yearRelease = yearRelease;
        this.editor = editor;
        this.author = author;
        this.FK_Magazine = FK_Magazine;
    }

    public String getDoi_A() {
        return doi_A;
    }

    public void setDoi_A(String doi_A) {
        this.doi_A = doi_A;
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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


}
