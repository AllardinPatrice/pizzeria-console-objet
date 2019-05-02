package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Classe de couche de service pour la pizzeria. Pour gérer l'affichage, ajout,
 * la modification et la suppression des pizzas
 * 
 * @author Patrice
 *
 */
public abstract class MenuService {
	/**
	 * Exécution de la couche de service (UC pour Use Case)
	 * 
	 * @param scanner
	 *            (scanner de clavier)
	 * @param pmd
	 *            (DAO)
	 */
	public abstract void executeUC(Scanner scanner, IPizzaDao pmd);

}
