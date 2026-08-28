import java.util.ArrayList;
import java.util.List;

public class Eleve extends Personnel {
    private int numeroEleve;

    //Liste des formations suivies par l'élève
    private List<Formation> formationsSuivies = new ArrayList<>();

    //Liste des élèves (qui ont été instanciés)
    private static final List<Eleve> eleves = new ArrayList<>();

    //Constante qui permet de récupérer le menu
    public final String[] MENU_ELEVE = { "Voir mes cours"};

    public Eleve(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public Eleve(String id,
                 String nom,
                 String prenom,
                 String motDePasse,
                 java.util.Date dateNaissance,
                 Adresse adresse,
                 int numeroEleve) {

        super(id, nom, prenom, motDePasse, dateNaissance, adresse);

        this.numeroEleve = numeroEleve;
        //this.formationsSuivies = new ArrayList<>();

        eleves.add(this);
    }

    public static List<Eleve> getEleves() {
        return eleves;
    }

    public static Eleve trouverParNumero(int numeroEleve) {
        for (Eleve eleve : eleves) {
            if (eleve.getNumeroEleve() == numeroEleve) {
                return eleve;
            }
        }
        return null;
    }

    /**
     * Fonction qui retourne le menu correspondant au rôle Administrateur
     * @return String[]
     */
    public String[] getMenu(){
        String[] menu = new String[MENU_ELEVE.length +1];
        int index = 0;
        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_ELEVE.length; i++) {
            menu[i+1] = MENU_ELEVE[i];
        }
        return menu;
    }

    /**
     * Fonction associée à la méthode getMenu, qui permet d'effectuer l'action demandée par l'utilisateur
     * @param choiceMenuUser
     */
    public void getMenuAction(int choiceMenuUser){
        switch(choiceMenuUser){
            case 1:
                if (this.autorisation(Responsabilite.VOIR_SES_COURS)) {
                    System.out.println("Mes cours");

                    List<Formation> formationsSuivies = this.getFormationsSuivies();
                    //On parcoure la liste des formations suivies par l'élève
                    for (Formation f : formationsSuivies) {
                        System.out.println("Formation " + f.getNom());
                        //Pour chaque formation on récupère la liste des cours correspondant
                        List<Cours> coursSuivis = f.getLesCours();
                        //On parcoure la liste des cours et on les affiche
                        for (Cours c : coursSuivis) {
                            System.out.print(" - " + c.getNom());
                            if (c.getEnseignant() != null)
                                System.out.print(" Professeur : " + c.getEnseignant().toString());
                            System.out.println();
                        }
                    }
                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
        }
    }

    public int getNumeroEleve() {
        return numeroEleve;
    }

    public void setNumeroEleve(int numeroEleve) {
        this.numeroEleve = numeroEleve;
    }

    public List<Formation> getFormationsSuivies() {
        return formationsSuivies;
    }

    /**
     * Fonction qui permet d'inscrire un élève à une formation
     * @param formation
     */
    public void inscrireEleveAFormation(Formation formation) {
        this.formationsSuivies.add(formation);
    }

    /**
     * Fonction qui permet de désinscrire l'élève à une formation
     * @param formation
     */
    public void desinscrireEleveFormation(Formation formation) {
        //TODO À implémenter
        //Voir si on utilise objet formation ou id ?
    }

    public Cours voirCours(int idCours) {
        // À implémenter
        return null;
    }
}
