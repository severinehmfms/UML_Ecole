import java.util.ArrayList;
import java.util.List;

public class Formation {

    //Liste des formations instanciées
    private static final List<Formation> formations = new ArrayList<>();

    private static int prochainId = 1;

    private int id;
    private String nom;
    private final List<Cours> lesCours;

    public Formation(String nom) {
        this.id = prochainId++;
        this.nom = nom;
        this.lesCours = new ArrayList<>();

        formations.add(this);
    }

    public static List<Formation> getFormations() {
        return formations;
    }

    public static Formation findById(int id) {
        for (Formation formation : formations) {
            if (formation.getId() == id) {
                return formation;
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

    public List<Cours> getLesCours() {
        return lesCours;
    }

    public void ajouterCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        if (cours != null && !lesCours.contains(cours)) {
            lesCours.add(cours);
            cours.setFormation(this);
        }
    }

    public void modifierCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        // Modification à définir selon les besoins.
    }

    public void retirerCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        lesCours.remove(cours);

        if (cours.getFormation() == this) {
            cours.setFormation(null);
        }
    }

    public void consulterCoursSuivis() {
        for (Cours cours : lesCours) {
            System.out.println(cours.getId() + " - " + cours.getNom());
        }
    }
}
