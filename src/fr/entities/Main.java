import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//On initialise le scanner
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

	    //On initialise les utilisateurs pour l'exercice
		new Eleve("eleve1", "1234");
		new Eleve("eleve2", "5678");
		new Eleve("eleve3", "1212");
		new Administrateur("root","root");
		new Enseignant("enseignant", "abcd");
		new Enseignant("enseignant2", "efgh");
		new ResponsablePedagogique("responsable1", "azerty");
		new ResponsablePedagogique("responsable2", "qwerty");
		new Directeur("directeur", "admin");


		Utilisateur userConnecte = null;

		//Menu de base en tant que Visiteur
		String[] menu = {
				"Quitter",
				"Me connecter",
				"Voir les formations proposées par l'école"
		};

		int choice_user = -1;
		while (choice_user != 0) {
			//On demande à l'utilisateur son choix par rapport au menu proposé
			choice_user = Functions.ask_user_choice(scanner, menu);

			switch(choice_user) {
				case 1:
					//Choix des produits
					userConnecte = connexion();


					/*if (userConnecte != null && userConnecte.autorisation(Utilisateur.Responsabilite.GERER_COMPTES_UTILISATEURS)) {
						System.out.println("Accès autorisé");
					} else {
						System.out.println("Accès refusé");
					}*/


					break;
				case 2:
					//Affichage des formations proposées par l'école
					System.out.println("Affichage des formations proposées par l'école");
					break;
				case 0:
					System.out.println("Au-revoir et à bientôt !");
					break;
			}

		}





		//On referme le scanner
		scanner.close();
	}

	public static Utilisateur connexion() {
		Utilisateur user = null;
		//On va demander à l'utilisateur de saisir son login, puis son mot de passe
		String loginTest = Functions.input_string(scanner, "Entrez votre identifiant");
		String mdpTest = Functions.input_string(scanner, "Entrez votre mot de passe");

		if (Utilisateur.identification(loginTest)) {
			user = Utilisateur.authentification(loginTest, mdpTest);
			if (user != null) {

				System.out.println(user.getClass().getSimpleName());
				//On affiche les informations sur l'Utilisateur, et surtout ses droits (pour test)
				System.out.println(user.getResponsabilites());


			} else {
				System.out.println("Erreur d'identifiant ou de mot de passe, merci de recommencer !");
			}
		} else {
			System.out.println("Erreur d'identifiant ou de mot de passe, merci de recommencer !");
		}
		return user;
	}



}
