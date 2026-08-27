import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personnel implements InterfaceEnseignant {

    private int idEnseignant;
    private List<Cours> coursSuivis = new ArrayList<>();

    @Override
    public void ajouterCours(int idCours) {
        // À implémenter
    }

    @Override
    public void modifierCours(int idCours) {
        // À implémenter
    }

    @Override
    public void retirerCours(int idCours) {
        // À implémenter
    }

    @Override
    public void consulterCoursSuivis() {
        // À implémenter
    }
}
