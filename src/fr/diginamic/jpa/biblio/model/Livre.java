package fr.diginamic.jpa.biblio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
* Classe qui fait le lien avec la table Livre dans la BdD.
 * 
 * @author Christian Ingold
 *
 */
@Entity
@Table(name = "LIVRE")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "AUTEUR", length = 50)
	private String auteur;

	@ManyToMany(mappedBy = "empLivres")
	private Set<Emprunt> livEmprunts;

	public Livre() {
		livEmprunts = new HashSet<>();
	}

	
	
	public Livre(String titre) {
		super();
		this.titre = titre;
	}



	public Livre(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}


	public Set<Emprunt> getLivEmprunts() {
		return livEmprunts;
	}

	public void setLivEmprunts(Set<Emprunt> livEmprunts) {
		this.livEmprunts = livEmprunts;
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
