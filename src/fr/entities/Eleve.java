import java.util.ArrayList;
import java.util.List;

public class Eleve extends Personnel {

    public Eleve(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    private int numeroEleve;
    private List<Cours> coursSuivis = new ArrayList<>();

    private static final List<Eleve> eleves =
            new ArrayList<>();

    //Constante qui permet de récupérer le menu
    public final String[] MENU_ELEVE = { "Voir mes cours"};

    public Eleve(String id,
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

    public static Eleve trouverParNumero(int numeroEleve) {
        for (Eleve eleve : eleves) {
            if (eleve.getNumeroEleve() == numeroEleve) {
                return eleve;
            }
        }
        return null;
    }

    //Fonction qui retourne le menu correspondant au rôle Administrateur
    public String[] getMenu(){
        String[] menu = new String[MENU_ELEVE.length +1];
        int index = 0;
        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_ELEVE.length; i++) {
            menu[i+1] = MENU_ELEVE[i];
        }
        return menu;
    }

    public void getMenuAction(int choiceMenuUser){
        switch(choiceMenuUser){
            case 1:
                if (this.autorisation(Responsabilite.VOIR_SES_COURS)) {
                    System.out.println("Mes cours");
                    //TODO Ici appeler la méthode d'affichage des cours de l'élève

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

    public List<Cours> getCoursSuivis() {
        return coursSuivis;
    }

    public void sInscrireAuCours(int idCours) {
        // À implémenter
    }

    public void seDesinscrireDuCours(int idCours) {
        // À implémenter
    }

    public Cours voirCours(int idCours) {
        // À implémenter
        return null;
    }
}
