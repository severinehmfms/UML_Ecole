public interface InterfaceEnseignant {

    void creerCours(String nom, Formation formation);
    void creerCours(String nom);

    void ajouterCours(int idCours);

    void modifierCours(int idCours);

    void retirerCours(int idCours);

    void consulterCoursSuivis();
}
