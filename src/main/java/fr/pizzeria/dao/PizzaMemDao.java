/**
 * 
 */
package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe de DAO pour les pizzas
 * 
 * @author Patrice
 *
 */
public class PizzaMemDao implements IPizzaDao {
	/**
	 * Création d'un logger de débug
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	// Création de la liste des pizzas
	private ArrayList<Pizza> alpizza;

	@Override
	public List<Pizza> findAllPizzas() {
		// Récupération de l'ensemble des pizzas
		return alpizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		// Enregistrement de nouvelle pizza
		// Si la pizza n'est pas nulle
		if (pizza != null) {
			LOG.debug("Ajout d'une nouvelle pizza");
			alpizza.add(pizza);
			return true;
		} else
			return false;

	}

	/**
	 * Constructeur
	 * 
	 */
	public PizzaMemDao() {
		// Création de la liste des pizzas
		this.alpizza = new ArrayList<>();
		// Ajout des pizzas par défaut
		LOG.debug("Ajout d'une liste de nouvelles pizzas par défaut");
		alpizza.add(new Pizza(0, "PEP", "Pépéroni", 12.5, CategoriePizza.VIANDE));
		alpizza.add(new Pizza(1, "MAR", "Margherita", 14.0, CategoriePizza.SANS_VIANDE));
		alpizza.add(new Pizza(2, "REIN", "La Reine", 11.5, CategoriePizza.VIANDE));
		alpizza.add(new Pizza(2, "FRO", "La 4 fromages", 12.0, CategoriePizza.POISSON));
		alpizza.add(new Pizza(3, "CAN", "La cannibale", 12.5, CategoriePizza.VIANDE));
		alpizza.add(new Pizza(4, "SAV", "La savoyarde", 13.0, CategoriePizza.POISSON));
		alpizza.add(new Pizza(5, "ORI", "L’orientale", 13.5, CategoriePizza.SANS_VIANDE));
		alpizza.add(new Pizza(6, "IND", "L’indienne", 14.0, CategoriePizza.POISSON));
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		// Mise à jour des infos de pizza
		LOG.debug("Mise à jour de pizza");
		if (pizza != null) {
			Pizza pizzaTmp = findPizzaByCode(codePizza);
			pizzaTmp.setCode(pizza.getCode());
			pizzaTmp.setLibelle(pizza.getLibelle());
			pizzaTmp.setPrix(pizza.getPrix());
			return true;
		} else
			return false;
	}

	@Override
	public void deletePizza(String codePizza) {
		/*
		 * Recherche de l'élement à supprimer
		 */
		if (pizzaExists(codePizza)) {
			// Si le code est trouvé
			//
			LOG.debug("Suppression de pizza");
			alpizza.remove(findPizzaByCode(codePizza));
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// Recherche de la pizza correspondante
		for (int i = 0; i < alpizza.size(); i++) {
			if (codePizza.equals(alpizza.get(i).getCode())) {
				return alpizza.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// Recherche si la pizza existe
		if (findPizzaByCode(codePizza) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Getter de liste de pizzas
	 * 
	 * @return the alpizza
	 */
	public ArrayList<Pizza> getAlpizza() {
		return alpizza;
	}

	/**
	 * Setter de liste de pizzas
	 * 
	 * @param alpizza
	 *            the alpizza to set
	 */
	public void setAlpizza(ArrayList<Pizza> alpizza) {
		this.alpizza = alpizza;
	}

}
