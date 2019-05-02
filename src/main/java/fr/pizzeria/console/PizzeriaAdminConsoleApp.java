package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

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
		/*
		 * Création de la liste des pizzas
		 */
		ArrayList<Pizza> alpizza = new ArrayList<>();
		/*
		 * Remplissage de la liste des pizzas
		 */
		alpizza.add(new Pizza(0, "PEP", "Pépéroni", 12.5));
		alpizza.add(new Pizza(0, "MAR", "Margherita", 14.0));
		alpizza.add(new Pizza(0, "REIN", "La Reine", 11.5));
		alpizza.add(new Pizza(0, "FRO", "La 4 fromages", 12.0));
		alpizza.add(new Pizza(0, "CAN", "La cannibale", 12.5));
		alpizza.add(new Pizza(0, "SAV", "La savoyarde", 13.0));
		alpizza.add(new Pizza(0, "ORI", "L’orientale", 13.5));
		alpizza.add(new Pizza(0, "IND", "L’indienne", 14.0));

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
				for (int i = 0; i < alpizza.size(); i++) {
					System.out.println(alpizza.get(i).getCode() + " -> " + alpizza.get(i).getLibelle() + " ("
							+ alpizza.get(i).getPrix() + " €)");
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
				alpizza.add(new Pizza(valeurCode, valeurNom, valeurPrixDouble));
			} else if (valeur.equals("3")) {
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Liste des pizzas");
				/*
				 * Affichage des pizzas
				 */
				for (int i = 0; i < alpizza.size(); i++) {
					System.out.println(alpizza.get(i).getCode() + " -> " + alpizza.get(i).getLibelle() + " ("
							+ alpizza.get(i).getPrix() + " €)");
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
				Integer indexCodeAModifier = Integer.MIN_VALUE;
				for (int i = 0; i < alpizza.size(); i++) {
					if (alpizza.get(i).getCode().equals(valeurCodeAncien)) {
						indexCodeAModifier = i;
					}
				}
				// Si la valeur est trouvée
				if (indexCodeAModifier != Integer.MIN_VALUE) {
					// Demande des valeurs pour modification de code, nom et
					// prix
					System.out.println("Veuillez saisir le nouveau code : ");
					valeurCodeNouveau = scanner.nextLine();
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					valeurNomNouveau = scanner.nextLine();
					System.out.println("Veuillez saisir le nouveau prix :");
					valeurPrixNouveau = scanner.nextLine();
					// Modification des valeurs
					alpizza.get(indexCodeAModifier).setCode(valeurCodeNouveau);
					alpizza.get(indexCodeAModifier).setLibelle(valeurNomNouveau);
					Double valeurNouveauPrixDouble = Double.parseDouble(valeurPrixNouveau);
					alpizza.get(indexCodeAModifier).setPrix(valeurNouveauPrixDouble);
				}
			} else if (valeur.equals("4")) {
				System.out.println("Suppression d'une pizza");
				System.out.println("Liste des pizzas");
				/*
				 * Affichage des pizzas
				 */
				for (int i = 0; i < alpizza.size(); i++) {
					System.out.println(alpizza.get(i).getCode() + " -> " + alpizza.get(i).getLibelle() + " ("
							+ alpizza.get(i).getPrix() + " €)");
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
				int indexCodeASupprimer = Integer.MIN_VALUE;
				for (int i = 0; i < alpizza.size(); i++) {
					if (alpizza.get(i).getCode().equals(valeurCodeSuppression)) {
						indexCodeASupprimer = i;
					}
				}
				// Si le code est trouvé
				if (indexCodeASupprimer != Integer.MIN_VALUE) {
					System.out.println("Suppression de la pizza : Code : " + alpizza.get(indexCodeASupprimer).getCode()
							+ " index : " + indexCodeASupprimer);
					alpizza.remove(indexCodeASupprimer);
				}

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
