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

			//Si l'utilisateur est à null (=visiteur), on travaille sur le menu de base de non connexion
			if (userConnecte == null) {
				switch (choice_user) {
					case 1:
						//Choix des produits
						userConnecte = connexion();

						//Si user connecté ok, On récupère le menu associé à ce type d'utilisateur
						System.out.println("Vous avez les droits de : " + userConnecte.getClass().getSimpleName());
						menu = userConnecte.getMenu();
						/*if (userConnecte != null && userConnecte.autorisation(Utilisateur.Responsabilite.GERER_COMPTES_UTILISATEURS)) {
							System.out.println("Accès autorisé");
						} */
						break;
					case 2:
						//Affichage des formations proposées par l'école
						System.out.println("Affichage des formations proposées par l'école");
						break;
					case 0:
						System.out.println("Au-revoir et à bientôt !");
						break;
				}
			}else{
				if (choice_user == 0){
					System.out.println("Au-revoir et à bientôt !");
				}else{
					//System.out.println("Partie en cours de développement ! ");
					//System.out.println("Menu pour " + userConnecte.getResponsabilites());

					//On appelle l'action correspondant au menu de l'utilisateur
					userConnecte.getMenuAction(choice_user);
				}
			}
		}

		//On referme le scanner
		scanner.close();
	}

	/**
	 * Méthode qui gère l'interaction avec l'utilisateur pour la connexion
	 * @return Utilisateur
	 */
	public static Utilisateur connexion() {
		Utilisateur user = null;
		//On va demander à l'utilisateur de saisir son login, puis son mot de passe
		String loginTest = Functions.input_string(scanner, "Entrez votre identifiant");
		String mdpTest = Functions.input_string(scanner, "Entrez votre mot de passe");

		if (Utilisateur.identification(loginTest)) {
			user = Utilisateur.authentification(loginTest, mdpTest);
			if (user != null) {
				System.out.println("Bienvenue " + user.getNom() );
				//System.out.println(user.getClass().getSimpleName());
				//On affiche les informations sur l'Utilisateur, et surtout ses droits (pour test)
				//System.out.println(user.getResponsabilites());
			} else {
				System.out.println("Erreur d'identifiant ou de mot de passe, merci de recommencer !");
			}
		} else {
			System.out.println("Erreur d'identifiant ou de mot de passe, merci de recommencer !");
		}
		return user;
	}



}
