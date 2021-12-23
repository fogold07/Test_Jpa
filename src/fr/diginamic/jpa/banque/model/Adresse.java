package fr.diginamic.jpa.banque.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Adresse implements Serializable {

	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="RUE")
	private String rue;
	
	@Column(name="CODE_POSTAL")
	private int codePostal;
	
	@Column(name="VILLE")
	private String ville;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	public int getNumero() {
		return numero;
	}

	public String getRue() {
		return rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
