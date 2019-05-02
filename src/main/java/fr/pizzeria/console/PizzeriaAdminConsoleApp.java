package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

/**
 * Programme de gestion centrale de la pizzeria
 * 
 * @author Patrice
 *
 */
public class PizzeriaAdminConsoleApp {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Création de la DAO pour la gestion des pizzas
		PizzaMemDao pmd = new PizzaMemDao();

		/*
		 * Menu de la pizzeria
		 */
		String valeur = "";
		while (!valeur.equals("99")) {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			/*
			 * Saisie de menu
			 */
			valeur = scanner.nextLine();

			if (valeur.equals("1")) {
				System.out.println("Liste des pizzas");
				/*
				 * Affichage des pizzas
				 */
				for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
					System.out.println(pmd.findAllPizzas().get(i).toString());
				}

			} else if (valeur.equals("2")) {
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
			} else if (valeur.equals("3")) {
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Liste des pizzas");
				/*
				 * Affichage des pizzas
				 */
				for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
					System.out.println(pmd.findAllPizzas().get(i).toString());
				}

				/*
				 * Demande de l'ancien code
				 */
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String valeurCodeAncien = null, valeurCodeNouveau = null, valeurNomNouveau = null,
						valeurPrixNouveau = null;
				valeurCodeAncien = scanner.nextLine();
				/*
				 * Recherche de l'élement à modifier
				 */
				// Si la pizza est trouvée
				if (pmd.pizzaExists(valeurCodeAncien)) {
					// Demande des valeurs pour modification de code, nom et
					// prix
					System.out.println("Veuillez saisir le nouveau code : ");
					valeurCodeNouveau = scanner.nextLine();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					valeurNomNouveau = scanner.nextLine();
					System.out.println("Veuillez saisir le nouveau prix :");
					valeurPrixNouveau = scanner.nextLine();
					Double valeurPrixNouveauDouble = Double.parseDouble(valeurPrixNouveau);
					// Modification des valeurs
					pmd.updatePizza(valeurCodeAncien,
							new Pizza(valeurCodeNouveau, valeurNomNouveau, valeurPrixNouveauDouble));
				}
			} else if (valeur.equals("4")) {
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

			} else if (valeur.equals("99")) {
				System.out.println("Au revoir ☹");
			}
		}

		/*
		 * Fermeture de scanner
		 */
		scanner.close();

	}

}
