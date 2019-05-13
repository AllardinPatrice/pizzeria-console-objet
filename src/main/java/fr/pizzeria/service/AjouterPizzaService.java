package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {
	/**
	 * Création d'un logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaService.class);

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) throws SavePizzaException {
		LOG.info("Ajout d'une nouvelle pizza");
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

		// Gestion des exceptions
		// Si le code est à blanc
		if (valeurCode.equals("")) {
			// Lancement d'exception
			throw new SavePizzaException("Code incorrect");
		} else if (valeurNom.equals("")) {
			// Si le libellé est blanc
			// Lancement d'exception
			throw new SavePizzaException("Libellé incorrect");
		} else if (valeurPrixDouble == 0.0) {
			// Si le prix est à 0
			// Lancement d'exception
			throw new SavePizzaException("Prix à 0");
		} else {
			/*
			 * Ajout de la pizza à la liste
			 */
			pmd.saveNewPizza(new Pizza(valeurCode, valeurNom, valeurPrixDouble, catPizza));
			LOG.info("Code : " + valeurCode + " Nom : " + valeurNom + " Prix : " + valeurPrixDouble + " Cat. : "
					+ catPizza);
		}
	}

}
