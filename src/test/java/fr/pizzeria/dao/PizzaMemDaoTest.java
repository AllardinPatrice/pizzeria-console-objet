package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	@Test
	public void testFindAllPizzas() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Vérification qu'une pizza par défaut existe
		assertTrue(pmd.pizzaExists("PEP"));
	}

	@Test
	public void testSaveNewPizza() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Ajout d'une pizza
		pmd.saveNewPizza(new Pizza("ARG", "Argentine", 12.3, CategoriePizza.VIANDE));
		// Vérification qu'elle existe
		assertTrue(pmd.pizzaExists("ARG"));

	}

	@Test
	public void testSaveNewPizzaNulle() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Ajout d'une pizza nulle et vérification de sa prise en compte
		assertFalse(pmd.saveNewPizza(null));

	}

	@Test
	public void testPizzaMemDao() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Vérification qu'elle n'est pas nulle
		assertNotNull(pmd);
		// Vérification qu'il y a bien une pizza
		assertTrue(pmd.pizzaExists("PEP"));
	}

	@Test
	public void testUpdatePizza() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Modification d'une pizza
		pmd.updatePizza("PEP", new Pizza("ARG", "Argentine", 12.3, CategoriePizza.VIANDE));
		// Vérification qu'elle existe
		assertTrue(pmd.pizzaExists("ARG"));
	}

	@Test
	public void testUpdatePizzaNulle() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Modification d'une pizza nulle
		// Vérification qu'elle n'est pas ajoutée
		assertFalse(pmd.updatePizza("PEP", null));
	}

	@Test
	public void testDeletePizza() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Suppression de pizza
		pmd.deletePizza("PEP");
		// Vérification qu'elle n'existe plus
		assertFalse(pmd.pizzaExists("PEP"));
	}

	@Test
	public void testFindPizzaByCode() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Création des pizzas de test
		Pizza pizzaRetour = new Pizza(0, "PEP", "Pépéroni", 12.5, CategoriePizza.VIANDE);
		Pizza pizzaRetourFausse = new Pizza(1, "MAR", "Margherita", 14.0, CategoriePizza.SANS_VIANDE);
		// Vérification d'égalité sur la PEP
		assertEquals(pizzaRetour, pmd.findPizzaByCode("PEP"));
		// Vérification de non égalité sur la PEP et la MAR
		assertNotEquals(pizzaRetourFausse, pmd.findPizzaByCode("PEP"));
	}

	@Test
	public void testPizzaExists() {
		// Création d'une DAO de pizzeria
		PizzaMemDao pmd = new PizzaMemDao();
		// Vérification qu'il y a bien une pizza PEP
		assertTrue(pmd.pizzaExists("PEP"));
		// Vérification qu'il n'y a pas de pizza PE
		assertFalse(pmd.pizzaExists("PE"));
	}

}
