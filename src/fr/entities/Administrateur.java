import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Administrateur extends Utilisateur {

    private static final List<Administrateur> administrateurs =
            new ArrayList<>();

    private int idAdministrateur;

    //Constante qui permet de récupérer le menu
    public final String[] MENU_ADMINISTRATEUR = { "Gestion des droits des utilisateurs", "Gestion des comptes utilisateurs"};

    public Administrateur(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
        administrateurs.add(this);
    }

    public Administrateur(String identifiant,
                          String nom,
                          String prenom,
                          String motDePasse,
                          Date dateNaissance,
                          Adresse adresse,
                          int idAdministrateur) {

        super(identifiant, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idAdministrateur = idAdministrateur;

        administrateurs.add(this);
    }

    public static List<Administrateur> getAdministrateurs() {
        return administrateurs;
    }

    public static Administrateur findAdminById(int id) {
        for (Administrateur administrateur : administrateurs) {
            if (administrateur.getIdAdministrateur() == id) {
                return administrateur;
            }
        }
        return null;
    }

    //Fonction qui retourne le menu correspondant au rôle Administrateur
    public String[] getMenu(){
        String[] menu = new String[MENU_ADMINISTRATEUR.length +1];
        int index = 0;

        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_ADMINISTRATEUR.length; i++) {
            menu[i+1] = MENU_ADMINISTRATEUR[i];
        }
        return menu;
    }

    public void getMenuAction(int choiceMenuUser, Scanner scanner){
       switch(choiceMenuUser){
           case 1:
               if (this.autorisation(Responsabilite.GERER_DROITS_UTILISATEURS)) {
                   System.out.println("Gestion des droits des utilisateurs");
                   //TODO Ici appeler la méthode de gestion des droits des utilisateurs

               }else{
                   System.out.println(Utilisateur.MSG_ERREUR_DROITS);
               }
               break;
           case 2 :
               if (this.autorisation(Responsabilite.GERER_COMPTES_UTILISATEURS)) {
                   System.out.println("Gestion des comptes utilisateurs");
                   //TODO Ici appeler la méthode de gestion des utilisateurs
                   
                   gestionComptesUtilisateurs(scanner);

               }else{
                   System.out.println(Utilisateur.MSG_ERREUR_DROITS);
               }
               break;
       }
    }

    public int getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(int idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }
    
    private void gestionComptesUtilisateurs(Scanner scanner) {

        String[] menu = {
            "Retour",
            "Créer un élève",
            "Créer un enseignant",
            "Créer un responsable pédagogique"
        };

        int choix = InputUtiles.ask_user_choice(scanner, menu);

        switch (choix) {

            case 1:
                creerEleve(scanner);
                break;

            case 2:
                // TODO créer enseignant
                break;

            case 3:
                // TODO créer responsable pédagogique
                break;
        }
    }
    
    private void creerEleve(Scanner scanner) {

        String identifiant = InputUtiles.input_string(
            scanner,
            "Identifiant :"
        );

        String motDePasse = InputUtiles.input_string(
            scanner,
            "Mot de passe :"
        );

        String nom = InputUtiles.input_string(
            scanner,
            "Nom :"
        );

        String prenom = InputUtiles.input_string(
            scanner,
            "Prénom :"
        );

        Eleve eleve = new Eleve(
            identifiant,
            nom,
            prenom,
            motDePasse,
            null,
            null
        );

        System.out.println(
            "Élève créé avec l'id numéro : "
            + eleve.getNumeroEleve()
        );
    }
    
}
