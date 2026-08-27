import java.util.ArrayList;
import java.util.List;

public class Adresse {

    private static final List<Adresse> adresses = new ArrayList<>();

    private String rue;
    private String ville;
    private int codePostal;

    public Adresse(String rue, String ville, int codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;

        adresses.add(this);
    }

    public static List<Adresse> getAdresses() {
        return adresses;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
}
