import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
	    //ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		new Eleve("eleve1", "1234");
		new Eleve("eleve2", "1234");
		new Eleve("eleve3", "1234");
		new Administrateur("root","root");
		new Enseignant("enseignant", "abcd");
		new ResponsablePedagogique("responsable", "azerty");
		new Directeur("directeur", "admin");
		
	   /* utilisateurs.add(new Eleve("eleve1", "1234"));
	    utilisateurs.add(new Eleve("eleve2", "1234"));
	    utilisateurs.add(new Eleve("eleve3", "1234"));
	    //utilisateurs.add(new Enseignant("enseignant", "abcd"));
	    //utilisateurs.add(new ResponsablePedagogique("responsable", "azerty"));
	    //utilisateurs.add(new Directeur("directeur", "admin"));	    
	    utilisateurs.add(new Administrateur("root","root"));*/
	    
	    
	    String loginTest = "root";
	    String mdpTest = "root";
	    
	    if (Utilisateur.identification(loginTest)) {
	    	System.out.println("Identification ok, merci de rentrer votre mot de passe");
	    	
	    	if (Utilisateur.authentification(loginTest, mdpTest)) {
		    	System.out.println("Mot de passe ok");
		    	
		    	//On va récupérer les informations concernant la personne
		    	
		    	
	    	}else {
	    		System.out.println("Erreur de mot de passe, merci de recommencer !");
	    	}
	    	
	    	
	    }else {
	    	System.out.println("Cet identifiant n'est pas présent dans le système !");
	    }
	    
	    
	    
	    
	}

}
