package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) {
		System.out.println("Suppression d'une pizza");
		System.out.println("Liste des pizzas");
		/*
		 * Affichage des pizzas
		 */
		for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
			System.out.println(pmd.findAllPizzas().get(i).toString());
		}
		/*
		 * Demande du code de la pizza à supprimer
		 */
		System.out.println("Veuillez choisir le code de la pizza à supprimer.");
		String valeurCodeSuppression = null;
		valeurCodeSuppression = scanner.nextLine();
		/*
		 * Recherche de l'élement à supprimer
		 */
		// Suppression de la pizza
		pmd.deletePizza(valeurCodeSuppression);

	}

}
