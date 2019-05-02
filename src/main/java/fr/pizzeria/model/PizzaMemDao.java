/**
 * 
 */
package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de DAO pour les pizzas
 * 
 * @author Patrice
 *
 */
public class PizzaMemDao implements IPizzaDao {
	// Création de la liste des pizzas
	private ArrayList<Pizza> alpizza;

	@Override
	public List<Pizza> findAllPizzas() {
		// Récupération de l'ensemble des pizzas
		return alpizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// Enregistrement de nouvelle pizza
		alpizza.add(pizza);

	}

	/**
	 * Constructeur
	 * 
	 */
	public PizzaMemDao() {
		// Création de la liste des pizzas
		this.alpizza = new ArrayList<>();
		// Ajout des pizzas par défaut
		alpizza.add(new Pizza(0, "PEP", "Pépéroni", 12.5));
		alpizza.add(new Pizza(0, "MAR", "Margherita", 14.0));
		alpizza.add(new Pizza(0, "REIN", "La Reine", 11.5));
		alpizza.add(new Pizza(0, "FRO", "La 4 fromages", 12.0));
		alpizza.add(new Pizza(0, "CAN", "La cannibale", 12.5));
		alpizza.add(new Pizza(0, "SAV", "La savoyarde", 13.0));
		alpizza.add(new Pizza(0, "ORI", "L’orientale", 13.5));
		alpizza.add(new Pizza(0, "IND", "L’indienne", 14.0));
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// Mise à jour des infos de pizza
		Pizza pizzaTmp = findPizzaByCode(codePizza);
		pizzaTmp.setCode(pizza.getCode());
		pizzaTmp.setLibelle(pizza.getLibelle());
		pizzaTmp.setPrix(pizza.getPrix());
	}

	@Override
	public void deletePizza(String codePizza) {
		/*
		 * Recherche de l'élement à supprimer
		 */
		if (pizzaExists(codePizza)) {
			// Si le code est trouvé
			//
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
		Integer indexCodeAModifier = Integer.MIN_VALUE;
		for (int i = 0; i < alpizza.size(); i++) {
			if (alpizza.get(i).getCode().equals(codePizza)) {
				indexCodeAModifier = i;
			}
		}
		if (indexCodeAModifier != Integer.MIN_VALUE)
			return true;
		return false;
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
