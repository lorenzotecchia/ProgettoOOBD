package Model;

public class Author {
    private String name;
    private String surname;
    private String email;
    private String affiliation;
    private String doi_A;

    public Author(String name, String surname, String email, String affiliation, String doi_A) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.affiliation = affiliation;
        this.doi_A = doi_A;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getDoi_A() {
        return doi_A;
    }

    public void setDoi_A(String doi_A) {
        this.doi_A = doi_A;
    }
}
