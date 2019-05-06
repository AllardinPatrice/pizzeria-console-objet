package fr.pizzeria.service;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Classe de service pour lister les pizzas
 * 
 * @author Patrice
 *
 */
public class ListerPizzasService extends MenuService {
	/**
	 * Création d'un logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ListerPizzasService.class);

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) {
		LOG.info("Affichage de la liste des pizzas");
		System.out.println("Liste des pizzas");
		/*
		 * Affichage des pizzas
		 */
		for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
			System.out.println(pmd.findAllPizzas().get(i).toString());
		}

	}

}
