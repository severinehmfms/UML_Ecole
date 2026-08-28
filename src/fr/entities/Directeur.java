import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Date;

public class Directeur extends Personnel
        implements InterfaceDirecteur {

    private static final List<Directeur> directeurs = new ArrayList<>();

    private int idDirecteur;
    private final List<ResponsablePedagogique> responsablesPedagogiques = new ArrayList<>();

    //Constante qui permet de récupérer le menu
    public final String[] MENU_DIRECTEUR = { "Gestion des cours", "Gestion des enseignants", "Gestion des responsables pédagogiques"};


    public Directeur(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public Directeur(String identifiant,
                     String nom,
                     String prenom,
                     String motDePasse,
                     Date dateNaissance,
                     Adresse adresse,
                     int idDirecteur) {

        super(identifiant, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idDirecteur = idDirecteur;
        //this.responsablesPedagogiques = new ArrayList<>();

        directeurs.add(this);
    }

    public static List<Directeur> getDirecteurs() {
        return directeurs;
    }

    public static Directeur findDirecteurById(int id) {
        for (Directeur directeur : directeurs) {
            if (directeur.getIdDirecteur() == id) {
                return directeur;
            }
        }
        return null;
    }

    //Fonction qui retourne le menu correspondant au rôle Administrateur
    public String[] getMenu(){
        String[] menu = new String[MENU_DIRECTEUR.length +1];
        int index = 0;

        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_DIRECTEUR.length; i++) {
            menu[i+1] = MENU_DIRECTEUR[i];
        }
        return menu;
    }

    public void getMenuAction(int choiceMenuUser, Scanner scanner){
        switch(choiceMenuUser){
            case 1:
                if (this.autorisation(Responsabilite.GERER_COURS)) {
                    System.out.println("Gestion des cours");
                    //TODO Ici appeler la méthode de gestion des cours

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
            case 2 :
                if (this.autorisation(Responsabilite.GERER_ENSEIGNANTS)) {
                    System.out.println("Gestion des enseignants");
                    //TODO Ici appeler la méthode de gestion des enseignants

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
            case 3 :
                if (this.autorisation(Responsabilite.GERER_RESPONSABLES)) {
                    System.out.println("Gestion des responsables pédagogiques");
                    //TODO Ici appeler la méthode de gestion des responsables pédagogiques

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
        }
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
                ResponsablePedagogique.findRespPedagById(idRespPedag);

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
                ResponsablePedagogique.findRespPedagById(idRespPedag);

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
                ResponsablePedagogique.findRespPedagById(idRespPedag);

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
                responsable.getIdRespPedag() + " - " +
                responsable.getNom() + " " +
                responsable.getPrenom()
            );
        }
    }
}
