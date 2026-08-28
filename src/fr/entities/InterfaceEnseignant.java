public interface InterfaceEnseignant {
	
	void create_Cours(String nom, Formation formation);

    void ajouterCours(int idCours);

    void modifierCours(int idCours);

    void retirerCours(int idCours);

    void consulterCoursSuivis();
}
