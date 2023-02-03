package Model;

public class Series {

    private String ISSN_S;
    private String Curator;
    private int Edition;
    private String NameS;
    private String Code;

    public Series(String ISSN_S, String Curator, int Edition, String NameS, String Code) {
        this.ISSN_S = ISSN_S;
        this.Curator = Curator;
        this.Edition = Edition;
        this.NameS = NameS;
        this.Code = Code;
    }

    public String getISSN_S() {
        return ISSN_S;
    }


    public String getCurator() {
        return Curator;
    }


    public int getEdition() {
        return Edition;
    }


    public String getNameS() {
        return NameS;
    }


    public String getCode() {
        return Code;
    }


    @Override
    public String toString() {
        return "Series{" +
                "ISSN_S='" + ISSN_S + '\'' +
                ", Curator='" + Curator + '\'' +
                ", Edition='" + Edition + '\'' +
                ", NameS='" + NameS + '\'' +
                ", Code='" + Code + '\'' +
                '}';
    }
}
