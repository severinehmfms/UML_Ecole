import java.util.Date;

public class Personnel extends Utilisateur {

    public Personnel(String id, String nom, String prenom,
                     String motDePasse, Date dateNaissance,
                     Adresse adresse) {
        super(id, nom, prenom, motDePasse, dateNaissance, adresse);
    }
}
