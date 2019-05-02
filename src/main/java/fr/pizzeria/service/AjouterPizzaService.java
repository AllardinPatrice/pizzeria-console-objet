package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) {
		System.out.println("Ajout d'une nouvelle pizza");
		/*
		 * Demande des 3 infos pour ajouter une pizza
		 */
		System.out.println("Veuillez saisir le code :");
		String valeurCode = null, valeurNom = null, valeurPrix = null;
		valeurCode = scanner.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		valeurNom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix :");
		valeurPrix = scanner.nextLine();
		/*
		 * Conversion en double
		 */
		Double valeurPrixDouble = Double.parseDouble(valeurPrix);
		/*
		 * Ajout de la pizza à la liste
		 */
		pmd.saveNewPizza(new Pizza(valeurCode, valeurNom, valeurPrixDouble));

	}

}
