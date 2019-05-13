package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

/**
 * Programme de gestion centrale de la pizzeria
 * 
 * @author Patrice
 *
 */
public class PizzeriaAdminConsoleApp {
	// Création du logger
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	// Déclaration du scanner
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Création de la DAO pour la gestion des pizzas
		IPizzaDao pmd = new PizzaMemDao();

		// Valeur de scanner de clavier
		String valeur = "";
		// Tant que l'on n'a pas demandé de sortir
		while (!valeur.equals("99")) {
			// Menu de la pizzeria
			LOG.info("Affichage du menu de la pizzeria");
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			// Saisie de menu
			valeur = scanner.nextLine();

			if (valeur.equals("1")) {
				// Listage des pizzas
				ListerPizzasService lps = new ListerPizzasService();
				lps.executeUC(scanner, pmd);

			} else if (valeur.equals("2")) {
				// Ajout de nouvelle pizza
				AjouterPizzaService aps = new AjouterPizzaService();
				try {
					aps.executeUC(scanner, pmd);
				} catch (SavePizzaException e) {
					System.out.println(e.getMessage());
				}

			} else if (valeur.equals("3")) {
				// Modification de pizza existante
				ModifierPizzaService mps = new ModifierPizzaService();
				try {
					mps.executeUC(scanner, pmd);
				} catch (UpdatePizzaException e) {
					System.out.println(e.getMessage());
				}
			} else if (valeur.equals("4")) {
				// Suppression de pizza
				SupprimerPizzaService sps = new SupprimerPizzaService();
				try {
					sps.executeUC(scanner, pmd);
				} catch (DeletePizzaException e) {
					System.out.println(e.getMessage());
				}

			} else if (valeur.equals("99")) {
				// Sortie
				System.out.println("Au revoir ☹");
			}
		}
		// Fermeture de scanner de clavier
		scanner.close();
	}

}
