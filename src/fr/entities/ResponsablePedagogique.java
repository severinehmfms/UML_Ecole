import java.util.ArrayList;
import java.util.List;

public class ResponsablePedagogique extends Personnel
        implements InterfaceResponsable {

    private int idRespPedag;
    private List<Enseignant> enseignants = new ArrayList<>();
    private List<Formation> formations = new ArrayList<>();

    @Override
    public void ajouterFormation(int idFormation) {
        // À implémenter
    }

    @Override
    public void modifierFormation(int idFormation) {
        // À implémenter
    }

    @Override
    public void retirerFormation(int idFormation) {
        // À implémenter
    }

    @Override
    public void consulterFormations() {
        // À implémenter
    }

    @Override
    public void ajouterEnseignant(int idEnseignant) {
        // À implémenter
    }

    @Override
    public void modifierEnseignant(int idEnseignant) {
        // À implémenter
    }

    @Override
    public void retirerEnseignant(int idEnseignant) {
        // À implémenter
    }

    @Override
    public void consulterEnseignants() {
        // À implémenter
    }
}
