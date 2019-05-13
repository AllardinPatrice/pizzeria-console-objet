package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaService extends MenuService {
	/**
	 * Création d'un logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzaService.class);

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) throws DeletePizzaException {
		LOG.info("Suppression de pizza : ");
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

		// Gestion des exceptions
		if (valeurCodeSuppression.equals("")) {
			// Si la valeur de code est vide
			// Lancement de l'exception
			throw new DeletePizzaException("Code incorrect");
		} else {
			// Suppression de la pizza
			pmd.deletePizza(valeurCodeSuppression);
			LOG.info("Code de suppression : " + valeurCodeSuppression);
		}
	}

}
