package fr.diginamic.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DATE_DEBUT")
	private Date date_debut;
	
	@Column(name="DELAI", nullable = true)
	private int delai;
	
	@Column(name="DATE_FIN", nullable = true)
	private Date date_fin;
	
	@Column(name="ID_CLIENT")
	private int id_client;
	
	public Emprunt() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Emprunt(Date date_debut, int delai, Date date_fin, int id_client) {
		super();
		this.date_debut = date_debut;
		this.delai = delai;
		this.date_fin = date_fin;
		this.id_client = id_client;
	}




	public int getId() {
		return id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public int getDelai() {
		return delai;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

}
