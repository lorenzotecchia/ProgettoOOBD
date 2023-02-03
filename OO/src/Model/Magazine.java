package Model;

import java.sql.Timestamp;

public class Magazine {

    private String ISSN_M;
    private String name_M;
    private String argument;
    private String manager;
    private Timestamp yearRelease;
    private String publicationPeriod;
    private String publishingHouse;
    private String accessMode;
    private String FK_author;

    public Magazine(String ISSN_M, String name_M, String argument, String manager,
                    Timestamp yearRelease, String publicationPeriod, String publishingHouse, String accessMode) {
        this.ISSN_M = ISSN_M;
        this.name_M = name_M;
        this.argument = argument;
        this.manager = manager;
        this.yearRelease = yearRelease;
        this.publicationPeriod = publicationPeriod;
        this.publishingHouse = publishingHouse;
        this.accessMode = accessMode;
    }

    public String getISSN_M() {
        return ISSN_M;
    }


    public String getName() {
        return name_M;
    }


    public String getArgument() {
        return argument;
    }


    public String getManager() {
        return manager;
    }


    public Timestamp getYearRelease() {
        return yearRelease;
    }


    public String getPublicationPeriod() {
        return publicationPeriod;
    }


    public String getPublishingHouse() {
        return publishingHouse;
    }


    public String getAccessMode() {
        return accessMode;
    }


    @Override
    public String toString() {
        return "Series{" +
                "ISSN_S='" + ISSN_M + '\'' +
                ", name_M='" + name_M + '\'' +
                ", argument='" + argument + '\'' +
                ", manager='" + manager + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                ", publicationPeriod='" + publicationPeriod + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", accessMode='" + accessMode + '\'' +
                '}';
    }
}
