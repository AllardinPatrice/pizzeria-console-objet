package fr.pizzeria.exception;

/**
 * Exception de suppression de pizza <<<<<<< HEAD
 * 
 * ======= >>>>>>> 02dec94525be25fed4ec848a23edd840b260112a
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