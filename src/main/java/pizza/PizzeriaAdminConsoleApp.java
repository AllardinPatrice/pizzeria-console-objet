package pizza;

import java.util.Scanner;

/**
 * Programme de gestion centrale de la pizzeria
 * 
 * @author Patrice
 *
 */
public class PizzeriaAdminConsoleApp {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/**
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

			/**
			 * 
			 */
			valeur = scanner.nextLine();

			if (valeur.equals("1")) {
				System.out.println("Liste des pizzas");
			} else if (valeur.equals("2")) {
				System.out.println("Ajout d'une nouvelle pizza");
			} else if (valeur.equals("3")) {
				System.out.println("Mise à jour d'une pizza");
			} else if (valeur.equals("4")) {
				System.out.println("Suppresion d'une pizza");
			} else if (valeur.equals("99")) {
				System.out.println("Au revoir ☹");
			}
		}

		/**
		 * Fermeture de scanner
		 */
		scanner.close();

	}

}
