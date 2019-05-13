package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	/**
	 * Constrcteur
	 *
	 */
	public UpdatePizzaException() {

	}

	/**
	 * Constructeur appelant la classe mère
	 * 
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}