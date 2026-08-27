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
    
    private static final List<Utilisateur> usersList = new ArrayList<>();
    
    private Set<Responsabilite> responsabilites = new HashSet<>();
    
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

    public static boolean identification(String identifiant) {
        for (Utilisateur user : usersList) {
    	    if (user.getIdentifiant().equals(identifiant)) {
    	    	return true;
    	    }
    	}
		return false;
    }

    public static boolean authentification(String identifiant, String motDePasse) {
    	for (Utilisateur user : usersList) {
    	    if (user.getIdentifiant().equals(identifiant) && user.getMotDePasse().equals(motDePasse)) {
    	    	return true;
    	    }    	    
    	}
    	return false;
    }
    
    public void ajouterResponsabilite(Responsabilite responsabilite) {
        responsabilites.add(responsabilite);
    }

    public Utilisateur autorisation(String identifiant, String motDePasse) {
        // On récupère l'utilisateur correspondant au login et au mot de passe
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
    
    
}
