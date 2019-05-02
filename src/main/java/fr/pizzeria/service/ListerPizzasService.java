package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Classe de service pour lister les pizzas
 * 
 * @author Patrice
 *
 */
public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao pmd) {
		System.out.println("Liste des pizzas");
		/*
		 * Affichage des pizzas
		 */
		for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
			System.out.println(pmd.findAllPizzas().get(i).toString());
		}

	}

}
