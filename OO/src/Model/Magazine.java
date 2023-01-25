package Model;

public class Magazine {

    private String doi_M;
    private String title;
    private String accessMode;
    private String yearRelease;
    private String editor;
    private String author;
    private String FK_Magazine;

    public Magazine(String doi_M, String title, String accessMode, String yearRelease, String editor, String author, String FK_Magazine) {
        this.doi_M = doi_M;
        this.title = title;
        this.accessMode = accessMode;
        this.yearRelease = yearRelease;
        this.editor = editor;
        this.author = author;
        this.FK_Magazine = FK_Magazine;
    }

    public String getDoi_M() {
        return doi_M;
    }

    public void setDoi_M(String doi_M) {
        this.doi_M = doi_M;
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
