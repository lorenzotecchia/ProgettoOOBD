package Model;

public class Series {

    private String doi_S;
    private String title;
    private String accessMode;
    private String yearRelease;
    private String editor;
    private String author;
    private String FK_Magazine;

    public Series(String doi_S, String title, String accessMode, String yearRelease, String editor, String author, String FK_Magazine) {
        this.doi_S = doi_S;
        this.title = title;
        this.accessMode = accessMode;
        this.yearRelease = yearRelease;
        this.editor = editor;
        this.author = author;
        this.FK_Magazine = FK_Magazine;
    }

    public String getDoi_S() {
        return doi_S;
    }

    public void setDoi_S(String doi_S) {
        this.doi_S = doi_S;
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

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
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
