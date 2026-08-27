import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Utilisateur {

    private String identifiant;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Date dateNaissance;
    private Adresse adresse;

    //Liste des utilisateurs créés dans notre exercice, qui sert de base de référence des utilisateurs
    private static final List<Utilisateur> usersList = new ArrayList<>();

    //Responsabilités (=droits) pour cet Utilisateur
    private Set<Responsabilite> responsabilites = new HashSet<>();

    //Enum pour les responsabilités existantes
    public enum Responsabilite {
        CONSULTER_FORMATIONS,
        VOIR_SES_COURS,

        VOIR_COURS_A_DONNER,
        VOIR_LISTE_ELEVES,

        AJOUTER_ELEVE_FORMATION,
        GERER_ELEVES,

        GERER_COURS,
        GERER_ENSEIGNANTS,
        GERER_RESPONSABLES,

        GERER_DROITS_UTILISATEURS,
        GERER_COMPTES_UTILISATEURS
    }

    /**
     * Constructeur
     * @param identifiant
     * @param motDePasse
     */
    public Utilisateur(String identifiant, String motDePasse) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        usersList.add(this);
    }

    /**
     * Constructeur plus complet quand on souhaite mettre à jour toutes les informations
     * @param identifiant
     * @param nom
     * @param prenom
     * @param motDePasse
     * @param dateNaissance
     * @param adresse
     */
    public Utilisateur(String identifiant,
                          String nom,
                          String prenom,
                          String motDePasse,
                          Date dateNaissance,
                          Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        usersList.add(this);
    }

    /**
     * Fonction qui gère l'identification à savoir vérifier l'existence de l'identifiant
     * @param identifiant
     * @return true ou false
     */
    public static boolean identification(String identifiant) {
        for (Utilisateur user : usersList) {
    	    if (user.getIdentifiant().equals(identifiant)) {
    	    	return true;
    	    }
    	}
		return false;
    }

    /**
     * Fonction qui gère l'authentification c'est à dire vérifier que le combo identifiant et motDePasse correspond bien à un utilisateur,
     * Cette fonction va ensuite mettre à jour l'Utilisateur avec les responsabilités associées
     * @param identifiant
     * @param motDePasse
     * @return Utilisateur ou null
     */
    public static Utilisateur authentification(String identifiant, String motDePasse) {
    	for (Utilisateur user : usersList) {
    	    if (user.getIdentifiant().equals(identifiant) && user.getMotDePasse().equals(motDePasse)) {
                // Attribution des responsabilités suivant le type d'utilisateur
                if (user instanceof Eleve) {
                    user.ajouterResponsabilite(Responsabilite.VOIR_SES_COURS);
                }

                else if (user instanceof Enseignant) {
                    user.ajouterResponsabilite(Responsabilite.VOIR_COURS_A_DONNER);
                    user.ajouterResponsabilite(Responsabilite.VOIR_LISTE_ELEVES);
                }

                else if (user instanceof ResponsablePedagogique) {
                    user.ajouterResponsabilite(Responsabilite.GERER_ELEVES);
                    user.ajouterResponsabilite(Responsabilite.AJOUTER_ELEVE_FORMATION);
                }

                else if (user instanceof Directeur) {
                    user.ajouterResponsabilite(Responsabilite.GERER_COURS);
                    user.ajouterResponsabilite(Responsabilite.GERER_ENSEIGNANTS);
                    user.ajouterResponsabilite(Responsabilite.GERER_RESPONSABLES);
                }

                else if (user instanceof Administrateur) {
                    user.ajouterResponsabilite(Responsabilite.GERER_DROITS_UTILISATEURS);
                    user.ajouterResponsabilite(Responsabilite.GERER_COMPTES_UTILISATEURS);
                }
                return user;
    	    }    	    
    	}
    	return null;
    }

    /**
     * Fonction qui va permettre d'ajouter une responsabilité à un Utilisateur
     * @param responsabilite
     */
    public void ajouterResponsabilite(Responsabilite responsabilite) {
        responsabilites.add(responsabilite);
    }

    /**
     * Pour une responsabilité donnée, on vérifie si l'Utilisateur a les droits pour y accéder
     * @param responsabilite
     * @return
     */
    public boolean autorisation(Responsabilite responsabilite) {
        return responsabilites.contains(responsabilite);
    }

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

    public Set<Responsabilite> getResponsabilites() {
        return responsabilites;
    }
}
