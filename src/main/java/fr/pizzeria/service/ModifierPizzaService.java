package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {
	/**
	 * Création d'un logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaService.class);

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) throws UpdatePizzaException {
		LOG.info("Modification d'une pizza");
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
		String valeurCodeAncien = null, valeurCodeNouveau = null, valeurNomNouveau = null, valeurPrixNouveau = null,
				valeurCategoriePizza;
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
			System.out.println("Veuillez saisir la catégorie de pizza :");
			valeurCategoriePizza = scanner.nextLine();
			CategoriePizza catPizza = CategoriePizza.getValeurCategorie(valeurCategoriePizza);
			// Conversion en double
			Double valeurPrixNouveauDouble = Double.parseDouble(valeurPrixNouveau);

			// Gestion des exceptions
			// Si l'ancien code est à blanc
			if (valeurCodeAncien.equals("")) {
				// Lancement d'exception
				throw new UpdatePizzaException("Ancien code incorrect");
			} else if (valeurCodeNouveau.equals("")) {
				// Si le nouveau code est blanc
				// Lancement d'exception
				throw new UpdatePizzaException("Nouveau code incorrect");
			} else if (valeurNomNouveau.equals("")) {
				// Si le libellé est blanc
				// Lancement d'exception
				throw new UpdatePizzaException("Libellé incorrect");
			} else if (valeurPrixNouveauDouble == 0.0) {
				// Si le prix est à 0
				// Lancement d'exception
				throw new UpdatePizzaException("Prix à 0");
			} else {

				// Modification des valeurs
				pmd.updatePizza(valeurCodeAncien,
						new Pizza(valeurCodeNouveau, valeurNomNouveau, valeurPrixNouveauDouble, catPizza));
				LOG.info("Ancien code : " + valeurCodeAncien + " Code : " + valeurCodeNouveau + " Nom : "
						+ valeurNomNouveau + " Prix : " + valeurPrixNouveauDouble + " Cat. : " + catPizza);
			}
		}

	}

}
