import java.util.Date;

public abstract class Personnel extends Utilisateur {

    public Personnel(String identifiant, String motDePasse) {
        super(identifiant, motDePasse);
    }

    public Personnel(String identifiant, String nom, String prenom,
                     String motDePasse, Date dateNaissance,
                     Adresse adresse) {
        super(identifiant, nom, prenom, motDePasse, dateNaissance, adresse);
    }

}
