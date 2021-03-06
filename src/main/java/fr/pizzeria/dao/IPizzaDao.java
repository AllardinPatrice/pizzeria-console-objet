/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * Interface de DAO des pizzas
 * 
 * @author Patrice
 *
 */
public interface IPizzaDao {
	/**
	 * Permet de récupérer la liste des pizzas de la DAO
	 * 
	 * @return la liste des pizzas
	 */
	List<Pizza> findAllPizzas();

	/**
	 * Sauvegarde une nouvelle pizza dans la DAO
	 * 
	 * @param une
	 *            pizza
	 * @return vrai si non null
	 * 
	 */
	boolean saveNewPizza(Pizza pizza);

	/**
	 * Met à jour une pizza en DAO
	 * 
	 * @param codePizza
	 *            code de la pizza
	 * @param une
	 *            pizza
	 */
	boolean updatePizza(String codePizza, Pizza pizza);

	/**
	 * Suppression de pizza en DAO
	 * 
	 * @param codePizza
	 *            code de la pizza
	 */
	void deletePizza(String codePizza);

	/**
	 * Recherche de pizza par code en DAO
	 * 
	 * @param codePizza
	 *            code de la pizza
	 * @return une pizza
	 */
	Pizza findPizzaByCode(String codePizza);

	/**
	 * Recherche si une pizza existe en DAO
	 * 
	 * @param codePizza
	 *            code de pizza
	 * @return vrai ou faux
	 */
	boolean pizzaExists(String codePizza);
}
