package Model;

public class Conference {

    private String title;
    private String firstName;
    private String lastName;
    private String conferenceName;

    private String releasLocation;
    private String releaseDate;

    public Conference(String title, String firstName, String lastName, String conferenceName, String releasLocation, String releaseDate) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.conferenceName = conferenceName;
        this.releasLocation = releasLocation;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public String getReleasLocation() {
        return releasLocation;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
