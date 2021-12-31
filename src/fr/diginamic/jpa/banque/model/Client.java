package fr.diginamic.jpa.banque.model;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * Classe qui définit les attributs de l'entité Client.
 * 
 * @author Christian Ingold
 *
 */
@Entity
@Table(name="CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom; 
	
	@Column(name="DATE_NAISSANCE")
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banqueClient;
	
	// MappedBy dangereux!!!

	
	public Client() {

	}

	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	

	public Client(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}


	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}


	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banqueClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banqueClient = banqueClient;
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

	public Banque getBanqueClient() {
		return banqueClient;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
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


	public void setBanqueClient(Banque banqueClient) {
		this.banqueClient = banqueClient;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
