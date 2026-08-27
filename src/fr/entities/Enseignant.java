import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Enseignant extends Utilisateur
        implements InterfaceEnseignant {

    private static final List<Enseignant> enseignants = new ArrayList<>();

    private int idEnseignant;
    private final List<Cours> coursSuivis = new ArrayList<>();

    public Enseignant(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public Enseignant(String identifiant,
                      String nom,
                      String prenom,
                      String motDePasse,
                      Date dateNaissance,
                      Adresse adresse,
                      int idEnseignant) {

        super(identifiant, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idEnseignant = idEnseignant;
         //this.coursSuivis = new ArrayList<>();

        enseignants.add(this);
    }

    public static List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public static Enseignant findEnseignantById(int id) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getIdEnseignant() == id) {
                return enseignant;
            }
        }
        return null;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public List<Cours> getCoursSuivis() {
        return coursSuivis;
    }

    @Override
    public void ajouterCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        if (!coursSuivis.contains(cours)) {
            coursSuivis.add(cours);
            cours.setEnseignant(this);
        }
    }

    @Override
    public void modifierCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        // Modification à définir selon les besoins.
    }

    @Override
    public void retirerCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        coursSuivis.remove(cours);

        if (cours.getEnseignant() == this) {
            cours.setEnseignant(null);
        }
    }

    @Override
    public void consulterCoursSuivis() {
        for (Cours cours : coursSuivis) {
            System.out.println(cours.getId() + " - " + cours.getNom());
        }
    }
}
