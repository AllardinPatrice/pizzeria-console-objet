package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

/**
 * Classe de couche de service pour la pizzeria
 * 
 * @author Patrice
 *
 */
public abstract class MenuService {
	/**
	 * Exécution de la couche de service
	 * 
	 * @param scanner
	 *            (scanner de clavier)
	 * @param pmd
	 *            (DAO)
	 */
	public abstract void executeUC(Scanner scanner, PizzaMemDao pmd);

}
