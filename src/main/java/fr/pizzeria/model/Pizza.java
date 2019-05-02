package fr.pizzeria.model;

/**
 * Classe Pizza
 * 
 * @author Patrice
 *
 */
public class Pizza {
	private Integer id = 0;
	private String code;
	private String libelle;
	private Double prix;

	/**
	 * Constructeur d'une pizza
	 * 
	 * @param code
	 *            code de la pizza
	 * @param libelle
	 *            libellé de la pizza
	 * @param prix
	 *            prix de la pizza
	 */
	public Pizza(String code, String libelle, Double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		/**
		 * Incrémentation de l'id de la pizza
		 */
		this.id++;
	}

	/**
	 * Constructeur de pizza avec id
	 * 
	 * @param id
	 *            id de la pizza
	 * @param code
	 *            code de la pizza
	 * @param libelle
	 *            libellé de la pizza
	 * @param prix
	 *            prix de la pizza
	 */
	public Pizza(Integer id, String code, String libelle, Double prix) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.id = id;
	}

	/**
	 * Getter de l'Id de pizza
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de l'Id de pizza
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de code de pizza
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter de code de pizza
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter de libellé de pizza
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter de libellé de pizza
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter de prix de pizza
	 * 
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * Setter de prix de pizza
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}
}
