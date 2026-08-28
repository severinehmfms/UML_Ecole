import java.util.ArrayList;
import java.util.List;

public class Cours {

    private static final List<Cours> cours = new ArrayList<>();
    
    private static int prochainId = 1;

    private int id;
    private String nom;
    private Formation formation;
    private Enseignant enseignant;
    private final List<Eleve> eleves;

    public Cours(String nom,
                 Formation formation,
                 Enseignant enseignant) {
    	
    	this.id = prochainId++;
        this.nom = nom;

        this.formation = formation;
        //On rajoute le cours à la listes des cours de la formation
        formation.ajouterCours(this);

        this.enseignant = enseignant;
        this.eleves = new ArrayList<>();

        cours.add(this);
    }

    public static List<Cours> getCours() {
        return cours;
    }

    public static Cours findById(int id) {
        for (Cours cours : cours) {
            if (cours.getId() == id) {
                return cours;
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

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }
}
