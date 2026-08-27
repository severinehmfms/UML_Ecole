import java.util.Date;

public abstract class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Date dateNaissance;
    private Adresse adresse;

    public void identification(String identifiant) {
        // À implémenter
    }

    public void authentification(String motDePasse) {
        // À implémenter
    }

    public boolean autorisation() {
        // À implémenter
        return false;
    }
}
