import java.util.List;
import java.util.Scanner;

public class Main {
	//On initialise le scanner
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		//On initialise les utilisateurs pour l'exercice
		Eleve eleve = new Eleve("eleve1", "1234");
		eleve.setNom("Alice Dupont");
		new Eleve("eleve2", "5678");
		new Eleve("eleve3", "1212");
		new Administrateur("root","root");
		Enseignant enseignant = new Enseignant("enseignant", "abcd");
		Enseignant enseignant2 = new Enseignant("enseignant2", "efgh");
		new ResponsablePedagogique("responsable1", "azerty");
		new ResponsablePedagogique("responsable2", "qwerty");
		new Directeur("directeur", "admin");

		//On initialise les formations pour l'exercice
		Formation formation1 = new Formation(1, "Formation CDA");
		new Formation(2, "BUT Réseaux et télécommunication");
		new Formation(3, "Diplôme d’ingénieur informatique");

		//On initialise les cours pour l'exercice
		Cours cours1 = new Cours("UML", formation1, enseignant);
		Cours cours2 = new Cours("JAVA", formation1, enseignant2);



		Utilisateur userConnecte = null;

		//Menu de base en tant que Visiteur
		String[] menu = {
				"Quitter",
				"Me connecter",
				"Voir les formations proposées par l'école"
		};

		int choice_user = -1;
		//tant que l'utilisateur n'a pas demandé à quitter le programme
		while (choice_user != 0) {
			//On demande à l'utilisateur son choix par rapport au menu proposé
			choice_user = InputUtiles.ask_user_choice(scanner, menu);

			//Si l'utilisateur est à null (=visiteur), on travaille sur le menu de base de non connexion
			if (userConnecte == null) {
				switch (choice_user) {
					case 1:
						//Demande d'identification
						userConnecte = ihm_demande_connexion();
						if (userConnecte != null) {
							//Si user connecté ok, On récupère le menu associé à ce type d'utilisateur
							System.out.println("Vous avez les droits de : " + userConnecte.getClass().getSimpleName());
							menu = userConnecte.getMenu();
						}
						break;
					case 2:
						//Affichage des formations proposées par l'école
						System.out.println("Affichage des formations proposées par l'école");
						//Affichage des formations proposées par l'école
						List<Formation> formations = Formation.getFormations();
						for (Formation f : formations) {
							System.out.println(" - " + f.getNom());
						}
						break;
					case 0:
						System.out.println("Au-revoir et à bientôt !");
						break;
				}
			}else{
				if (choice_user == 0){
					System.out.println("Au-revoir et à bientôt !");
				}else{
					//On appelle l'action correspondant au menu de l'utilisateur pour ce type d'utilisateur
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
	public static Utilisateur ihm_demande_connexion() {
		Utilisateur user = null;
		//On va demander à l'utilisateur de saisir son login, puis son mot de passe
		String loginTest = InputUtiles.input_string(scanner, "Entrez votre identifiant");
		String mdpTest = InputUtiles.input_string(scanner, "Entrez votre mot de passe");

		if (Utilisateur.identification(loginTest)) {
			user = Utilisateur.authentification(loginTest, mdpTest);
			if (user != null) {
				if (user.getNom() != null && user.getNom() != "" ) System.out.println("Bienvenue " + user.getNom() );
			} else {
				System.out.println(Utilisateur.MSG_ERREUR_AUTHENTIFICATION);
			}
		} else {
			System.out.println(Utilisateur.MSG_ERREUR_AUTHENTIFICATION);
		}
		return user;
	}

}
