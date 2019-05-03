package fr.pizzeria.model;

/**
 * Classe de catégorie de Pizza pour énumération
 * 
 * @author Patrice
 *
 */
public enum CategoriePizza {
	// Enumération des catégories de pizzas
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	// Catégorie de pizza enregistrée
	private String chaineCategoriePizza;

	/**
	 * Constructeur d'énumération de catégorie de pizza
	 * 
	 * @param s
	 */
	private CategoriePizza(String s) {
		chaineCategoriePizza = s;
	}

	/**
	 * Getter de chaine de catégorie de pizza
	 * 
	 * @return the chaineCategoriePizza
	 */
	public String getChaineCategoriePizza() {
		return chaineCategoriePizza;
	}

	/**
	 * Setter de chaine de catégorie de pizza
	 * 
	 * @param chaineCategoriePizza
	 *            the chaineCategoriePizza to set
	 */
	public void setChaineCategoriePizza(String chaineCategoriePizza) {
		this.chaineCategoriePizza = chaineCategoriePizza;
	}

	/**
	 * Recherche une valeur par un code
	 * 
	 * @param valeurCodeCherche
	 *            code recherché
	 * @return chaine de valeur d'énumération
	 */
	public static CategoriePizza getValeurCategorie(String valeurCodeCherche) {
		// Passage par un tableau temporaire
		CategoriePizza[] tab = CategoriePizza.values();
		// Boucle de recherche
		for (int i = 0; i < tab.length; i++) {
			if (valeurCodeCherche.equals(tab[i].getChaineCategoriePizza())) {
				// Récupération de la valeur si trouvée
				return tab[i];
			}
		}
		return null;
	}

}
