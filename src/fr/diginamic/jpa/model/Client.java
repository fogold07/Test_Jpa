package fr.diginamic.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	
	@Column(name = "PRENOM", length = 50)
	private String prenom;
	
	public Client() {
		
	}

	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}



	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	
}
