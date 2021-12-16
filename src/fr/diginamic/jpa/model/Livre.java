package fr.diginamic.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "TITRE")
	private String titre; 
	
	@Column(name = "AUTEUR", length = 50)
	private String auteur;
	
	public Livre() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id= " + id + ", titre= " + titre + ", auteur= " + auteur + "]";
	}

	
}
