package fr.pizzeria.exception;

/**
 * Exception de suppression de pizza
 * 
 * @author Patrice
 *
 */
public class DeletePizzaException extends StockageException {

	/**
	 * Consturcteur
	 *
	 */
	public DeletePizzaException() {

	}

	/**
	 * Constructeur appelant la classe mère
	 * 
	 * @param message
	 */
	public DeletePizzaException(String message) {
		super(message);

	}

}