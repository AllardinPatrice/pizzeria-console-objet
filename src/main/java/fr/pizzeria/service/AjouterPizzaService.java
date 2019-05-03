package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) {
		System.out.println("Ajout d'une nouvelle pizza");
		/*
		 * Demande des 4 infos pour ajouter une pizza
		 */
		System.out.println("Veuillez saisir le code :");
		String valeurCode = null, valeurNom = null, valeurPrix = null, valeurCategorie = null;
		valeurCode = scanner.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		valeurNom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix :");
		valeurPrix = scanner.nextLine();
		System.out.println("Veuillez saisir la catégorie :");
		valeurCategorie = scanner.nextLine();
		CategoriePizza catPizza = CategoriePizza.getValeurCategorie(valeurCategorie);

		/*
		 * Conversion en double
		 */
		Double valeurPrixDouble = Double.parseDouble(valeurPrix);
		/*
		 * Ajout de la pizza à la liste
		 */
		pmd.saveNewPizza(new Pizza(valeurCode, valeurNom, valeurPrixDouble, catPizza));

	}

}
