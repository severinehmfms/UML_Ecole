import java.util.ArrayList;
import java.util.List;

public class Directeur extends Personnel
        implements InterfaceDirecteur {

    private int idDirecteur;
    private List<ResponsablePedagogique> responsablesPedagogiques =
            new ArrayList<>();

    @Override
    public void ajouterRespPedag(int idRespPedag) {
        // À implémenter
    }

    @Override
    public void modifierRespPedag(int idRespPedag) {
        // À implémenter
    }

    @Override
    public void retirerRespPedag(int idRespPedag) {
        // À implémenter
    }

    @Override
    public void consulterCoursSuivis() {
        // À implémenter
    }
}
