import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Administrateur extends Utilisateur {

    private static final List<Administrateur> administrateurs =
            new ArrayList<>();

    private int idAdministrateur;

    public Administrateur(int id,
                          String nom,
                          String prenom,
                          String motDePasse,
                          Date dateNaissance,
                          Adresse adresse,
                          int idAdministrateur) {

        super(id, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idAdministrateur = idAdministrateur;

        administrateurs.add(this);
    }

    public static List<Administrateur> getAdministrateurs() {
        return administrateurs;
    }

    public static Administrateur findById(int id) {
        for (Administrateur administrateur : administrateurs) {
            if (administrateur.getId() == id ||
                administrateur.getIdAdministrateur() == id) {
                return administrateur;
            }
        }
        return null;
    }

    public int getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(int idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }
}
