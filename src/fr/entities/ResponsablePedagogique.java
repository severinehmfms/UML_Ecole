import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ResponsablePedagogique extends Personnel
        implements InterfaceResponsable {

    private static final List<ResponsablePedagogique> responsables =
            new ArrayList<>();

    private int idRespPedag;
    private final List<Enseignant> enseignants = new ArrayList<>();
    private final List<Formation> formations = new ArrayList<>();

    //Constante qui permet de récupérer le menu
    public final String[] MENU_RESPONSABLE = { "Gestion des élèves", "Ajouter un élève à un cours"};


    public ResponsablePedagogique(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public ResponsablePedagogique(String identifiant,
                                  String nom,
                                  String prenom,
                                  String motDePasse,
                                  Date dateNaissance,
                                  Adresse adresse,
                                  int idRespPedag) {

        super(identifiant, nom, prenom, motDePasse, dateNaissance, adresse);

        this.idRespPedag = idRespPedag;
        //this.enseignants = new ArrayList<>();
        //this.formations = new ArrayList<>();

        responsables.add(this);
    }

    public static List<ResponsablePedagogique> getResponsables() {
        return responsables;
    }

    public static ResponsablePedagogique findRespPedagById(int id) {
        for (ResponsablePedagogique responsable : responsables) {
            if (responsable.getIdRespPedag() == id) {
                return responsable;
            }
        }
        return null;
    }

    public int getIdRespPedag() {
        return idRespPedag;
    }

    public void setIdRespPedag(int idRespPedag) {
        this.idRespPedag = idRespPedag;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    //Fonction qui retourne le menu correspondant au rôle Administrateur
    public String[] getMenu(){
        String[] menu = new String[MENU_RESPONSABLE.length +1];
        int index = 0;

        menu[index++] = "Quitter";

        for (int i = 0; i < MENU_RESPONSABLE.length; i++) {
            menu[i+1] = MENU_RESPONSABLE[i];
        }
        return menu;
    }

    public void getMenuAction(int choiceMenuUser){
        switch(choiceMenuUser){
            case 1:
                if (this.autorisation(Responsabilite.GERER_ELEVES)) {
                    System.out.println("Gestion des élèves");
                    //TODO Ici appeler la méthode de gestion des élèves

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
            case 2 :
                if (this.autorisation(Responsabilite.AJOUTER_ELEVE_FORMATION)) {
                    System.out.println("Ajouter des élèves à une formation");
                    //TODO Ici appeler la méthode pour ajouter des élèves à une formation

                }else{
                    System.out.println(Utilisateur.MSG_ERREUR_DROITS);
                }
                break;
        }
    }


    @Override
    public void ajouterFormation(int idFormation) {
        Formation formation = Formation.findById(idFormation);

        if (formation == null) {
            System.out.println("Formation introuvable : " + idFormation);
            return;
        }

        if (!formations.contains(formation)) {
            formations.add(formation);
        }
    }

    @Override
    public void modifierFormation(int idFormation) {
        Formation formation = Formation.findById(idFormation);

        if (formation == null) {
            System.out.println("Formation introuvable : " + idFormation);
            return;
        }

        // Modification à définir selon les besoins.
    }

    @Override
    public void retirerFormation(int idFormation) {
        Formation formation = Formation.findById(idFormation);

        if (formation == null) {
            System.out.println("Formation introuvable : " + idFormation);
            return;
        }

        formations.remove(formation);
    }

    @Override
    public void consulterFormations() {
        for (Formation formation : formations) {
            System.out.println(
                formation.getId() + " - " + formation.getNom()
            );
        }
    }

    @Override
    public void ajouterEnseignant(int idEnseignant) {
        Enseignant enseignant = Enseignant.findEnseignantById(idEnseignant);

        if (enseignant == null) {
            System.out.println("Enseignant introuvable : " + idEnseignant);
            return;
        }

        if (!enseignants.contains(enseignant)) {
            enseignants.add(enseignant);
        }
    }

    @Override
    public void modifierEnseignant(int idEnseignant) {
        Enseignant enseignant = Enseignant.findEnseignantById(idEnseignant);

        if (enseignant == null) {
            System.out.println("Enseignant introuvable : " + idEnseignant);
            return;
        }

        // Modification à définir selon les besoins.
    }

    @Override
    public void retirerEnseignant(int idEnseignant) {
        Enseignant enseignant = Enseignant.findEnseignantById(idEnseignant);

        if (enseignant == null) {
            System.out.println("Enseignant introuvable : " + idEnseignant);
            return;
        }

        enseignants.remove(enseignant);
    }

    @Override
    public void consulterEnseignants() {
        for (Enseignant enseignant : enseignants) {
            System.out.println(
                enseignant.getIdEnseignant() + " - " +
                enseignant.getNom() + " " +
                enseignant.getPrenom()
            );
        }
    }
}
