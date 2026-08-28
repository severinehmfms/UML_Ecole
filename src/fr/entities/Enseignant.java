import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Enseignant extends Personnel
        implements InterfaceEnseignant {

    private static final List<Enseignant> enseignants = new ArrayList<>();

    private int idEnseignant;
    private final List<Cours> coursSuivis = new ArrayList<>();

    public Enseignant(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    //Constante qui permet de récupérer le menu
    public final String[] MENU_ENSEIGNANT = { "Voir les cours à donner", "Voir la liste des élèves"};

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

    //Fonction qui retourne le menu correspondant au rôle Administrateur
    public String[] getMenu(){
        String[] menu = new String[MENU_ENSEIGNANT.length +1];
        int index = 0;

        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_ENSEIGNANT.length; i++) {
            menu[i+1] = MENU_ENSEIGNANT[i];
        }
        return menu;
    }

    public void getMenuAction(int choiceMenuUser){
        switch(choiceMenuUser){
            case 1:
                if (this.autorisation(Responsabilite.VOIR_COURS_A_DONNER)) {
                    System.out.println("Voir les cours à donner");
                    //TODO Ici appeler la méthode d'affichage des cours à donner pour cet enseignant

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
            case 2 :
                if (this.autorisation(Responsabilite.VOIR_LISTE_ELEVES)) {
                    System.out.println("Voir la liste des élèves");
                    //TODO Ici appeler la méthode d'affichage de la liste des élèves'

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }

                break;
        }
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
	public void creerCours(String nom, Formation formation) {
        Cours cours = new Cours(nom, formation, this);

        coursSuivis.add(cours);
    }
    
    @Override
    public void creerCours(String nom) {

        Cours cours = new Cours(nom, null, this);

        coursSuivis.add(cours);
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
