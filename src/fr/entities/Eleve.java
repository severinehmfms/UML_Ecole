import java.util.ArrayList;
import java.util.List;

public class Eleve extends Utilisateur {
    
    private int numeroEleve;
    private List<Cours> coursSuivis = new ArrayList<>();

    private static final List<Eleve> eleves =
            new ArrayList<>();
    
    public Eleve(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public Eleve(String id,
                 String nom,
                 String prenom,
                 String motDePasse,
                 java.util.Date dateNaissance,
                 Adresse adresse,
                 int numeroEleve) {

        super(id, nom, prenom, motDePasse, dateNaissance, adresse);

        this.numeroEleve = numeroEleve;
        this.coursSuivis = new ArrayList<>();

        eleves.add(this);
    }

    public static List<Eleve> getEleves() {
        return eleves;
    }

    public static Eleve trouverParNumero(int numeroEleve) {
        for (Eleve eleve : eleves) {
            if (eleve.getNumeroEleve() == numeroEleve) {
                return eleve;
            }
        }
        return null;
    }

    public int getNumeroEleve() {
        return numeroEleve;
    }

    public void setNumeroEleve(int numeroEleve) {
        this.numeroEleve = numeroEleve;
    }

    public List<Cours> getCoursSuivis() {
        return coursSuivis;
    }

    public void sInscrireAuCours(int idCours) {
        // À implémenter
    }

    public void seDesinscrireDuCours(int idCours) {
        // À implémenter
    }

    public Cours voirCours(int idCours) {
        // À implémenter
        return null;
    }
}
