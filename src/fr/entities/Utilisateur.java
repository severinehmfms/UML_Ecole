import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Utilisateur {

    private static final List<Utilisateur> utilisateurs = new ArrayList<>();

    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Date dateNaissance;
    private Adresse adresse;

    public Utilisateur(int id, String nom, String prenom,
                       String motDePasse, Date dateNaissance,
                       Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;

        utilisateurs.add(this);
    }

    public static List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static Utilisateur findById(int id) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                return utilisateur;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void identification(String identifiant) {
        // À implémenter selon les règles métier
    }

    public void authentification(String motDePasse) {
        // À implémenter selon les règles métier
    }

    public boolean autorisation() {
        return false;
    }
}
