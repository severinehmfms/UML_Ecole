import java.util.ArrayList;
import java.util.List;

public class Eleve extends Utilisateur {

    private static final List<Eleve> eleves = new ArrayList<>();

    private int numeroEleve;
    private final List<Cours> coursSuivis;

    public Eleve(int id,
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

    public static Eleve findById(int id) {
        for (Eleve eleve : eleves) {
            if (eleve.getId() == id) {
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
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        if (!coursSuivis.contains(cours)) {
            coursSuivis.add(cours);

            if (!cours.getEleves().contains(this)) {
                cours.getEleves().add(this);
            }
        }
    }

    public void seDesinscrireDuCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            System.out.println("Cours introuvable : " + idCours);
            return;
        }

        coursSuivis.remove(cours);
        cours.getEleves().remove(this);
    }

    public Cours voirCours(int idCours) {
        Cours cours = Cours.findById(idCours);

        if (cours == null) {
            return null;
        }

        return coursSuivis.contains(cours) ? cours : null;
    }
}
