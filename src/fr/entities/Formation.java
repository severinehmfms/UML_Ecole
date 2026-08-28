import java.util.ArrayList;
import java.util.List;

public class Formation {

    //Liste des formations instanciées
    private static final List<Formation> formations = new ArrayList<>();

    private int id;
    private String nom;
    private final List<Cours> lesCours;

    public Formation(int id, String nom) {
        this.id = id;
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

    /**
     * Fonction qui permet d'ajouter un Cours passé en paramètre à une formation
     * @param cours
     */
    public void ajouterCours(Cours cours) {
        /*Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }*/

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

        // TODO Modification à définir selon les besoins.
    }

    public void retirerCours(Cours cours) {
        /*Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }*/

        if (cours != null && lesCours.contains(cours)) {
            lesCours.remove(cours);
        }
        if (cours.getFormation() == this) {
            cours.setFormation(null);
        }
    }

    public void afficherCoursInclus() {
        for (Cours cours : lesCours) {
            System.out.println(cours.getId() + " - " + cours.getNom());
        }
    }
}
