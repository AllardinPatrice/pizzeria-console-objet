package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	/**
	 * Consturcteur
	 *
	 */
	public SavePizzaException() {

	}

	/**
	 * Constructeur appelant la classe mère
	 * 
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}

}
