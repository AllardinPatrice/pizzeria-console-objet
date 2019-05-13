package fr.pizzeria.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;

public class AjouterPizzaServiceTest {
	/**
	 * Création d'une "Rule" qui va permettre de substituer le System.in utilisé
	 * par le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUCVrai() {
		// Stockage des lignes de scanner à jouer
		systemInMock.provideLines("ARG", "Argentine", "12.3", "Viande");
		// Création d'une DAO pour la pizzeria
		IPizzaDao pmd = new PizzaMemDao();
		// Création de service d'ajout de pizza
		AjouterPizzaService aps = new AjouterPizzaService();
		// Exécution de Use Case d'ajout
		try {
			aps.executeUC(new Scanner(System.in), pmd);
		} catch (SavePizzaException e) {
			// Affichage du message
			System.out.println(e.getMessage());
		}
		// Vérification que cela s'est bien passé en vérifiant que la pizza
		// existe
		assertTrue(pmd.pizzaExists("ARG"));
	}

	@Test
	public void testExecuteUCFaux() {
		// Stockage des lignes de scanner à jouer
		systemInMock.provideLines("ALB", "Albanaise", "12.3", "Viande");
		// Création d'une DAO pour la pizzeria
		IPizzaDao pmd = new PizzaMemDao();
		// Création de service d'ajout de pizza
		AjouterPizzaService aps = new AjouterPizzaService();
		// Exécution de Use Case d'ajout
		try {
			aps.executeUC(new Scanner(System.in), pmd);
		} catch (SavePizzaException e) {
			// Affichage du message
			System.out.println(e.getMessage());
		}
		// Vérification que la pizza non réelle n'est pas ajoutée
		assertFalse(pmd.pizzaExists("ARG"));
	}

}
