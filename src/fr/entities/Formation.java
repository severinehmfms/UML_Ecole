import java.util.ArrayList;
import java.util.List;

public class Formation {

    private int id;
    private String nom;
    private List<Cours> lesCours = new ArrayList<>();

    public void ajouterCours(Cours cours) {
        lesCours.add(cours);
    }

    public void modifierCours(int idCours) {
        // À implémenter
    }

    public void retirerCours(int idCours) {
        // À implémenter
    }

    public void consulterCoursSuivis() {
        // À implémenter
    }
}
