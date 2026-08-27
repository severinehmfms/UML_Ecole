import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Directeur extends Utilisateur
        implements InterfaceDirecteur {

    private static final List<Directeur> directeurs = new ArrayList<>();

    private int idDirecteur;
    private final List<ResponsablePedagogique> responsablesPedagogiques;

    public Directeur(int id,
                     String nom,
                     String prenom,
                     String motDePasse,
                     Date dateNaissance,
                     Adresse adresse,
                     int idDirecteur) {

        super(id, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idDirecteur = idDirecteur;
        this.responsablesPedagogiques = new ArrayList<>();

        directeurs.add(this);
    }

    public static List<Directeur> getDirecteurs() {
        return directeurs;
    }

    public static Directeur findById(int id) {
        for (Directeur directeur : directeurs) {
            if (directeur.getId() == id ||
                directeur.getIdDirecteur() == id) {
                return directeur;
            }
        }
        return null;
    }

    public int getIdDirecteur() {
        return idDirecteur;
    }

    public void setIdDirecteur(int idDirecteur) {
        this.idDirecteur = idDirecteur;
    }

    public List<ResponsablePedagogique> getResponsablesPedagogiques() {
        return responsablesPedagogiques;
    }

    @Override
    public void ajouterRespPedag(int idRespPedag) {
        ResponsablePedagogique responsable =
                ResponsablePedagogique.findById(idRespPedag);

        if (responsable == null) {
            System.out.println(
                "Responsable pédagogique introuvable : " + idRespPedag
            );
            return;
        }

        if (!responsablesPedagogiques.contains(responsable)) {
            responsablesPedagogiques.add(responsable);
        }
    }

    @Override
    public void modifierRespPedag(int idRespPedag) {
        ResponsablePedagogique responsable =
                ResponsablePedagogique.findById(idRespPedag);

        if (responsable == null) {
            System.out.println(
                "Responsable pédagogique introuvable : " + idRespPedag
            );
            return;
        }

        // Modification à définir selon les besoins.
    }

    @Override
    public void retirerRespPedag(int idRespPedag) {
        ResponsablePedagogique responsable =
                ResponsablePedagogique.findById(idRespPedag);

        if (responsable == null) {
            System.out.println(
                "Responsable pédagogique introuvable : " + idRespPedag
            );
            return;
        }

        responsablesPedagogiques.remove(responsable);
    }

    @Override
    public void consulterCoursSuivis() {
        for (ResponsablePedagogique responsable : responsablesPedagogiques) {
            System.out.println(
                responsable.getId() + " - " +
                responsable.getNom() + " " +
                responsable.getPrenom()
            );
        }
    }
}
