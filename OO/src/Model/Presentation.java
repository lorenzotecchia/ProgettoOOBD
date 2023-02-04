package Model;

public class Presentation {
    private String title;
    private String firstName;
    private String lastName;
    private String presentationName;

    private String releasLocation;
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPresentationName() {
        return presentationName;
    }

    public String getReleasLocation() {
        return releasLocation;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Presentation(String title, String firstName, String lastName, String presentationName, String releasLocation, String releaseDate) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.presentationName = presentationName;
        this.releasLocation = releasLocation;
        this.releaseDate = releaseDate;
    }
}
