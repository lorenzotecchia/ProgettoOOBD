package Model;

public class Author {
    private String authorID;
    private String fName;
    private String lName;


    public Author(String authorID, String fName, String lName) {
        this.authorID = authorID;
        this.fName = fName;
        this.lName = lName;

    }

    public String getAuthorID() {
        return authorID;
    }

    public void setEmail(String authorID) {
        this.authorID = authorID;
    }
    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID='" + authorID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
