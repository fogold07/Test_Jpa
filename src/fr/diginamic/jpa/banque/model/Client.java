package fr.diginamic.jpa.banque.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banqueClient;
	
	@ManyToMany(mappedBy= "cpteClients")
	private Set<Compte> clientCptes;
	
	public Client() {
		clientCptes = new HashSet<>();
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public Banque getBanqueClient() {
		return banqueClient;
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

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setBanqueClient(Banque banqueClient) {
		this.banqueClient = banqueClient;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Compte> getClientCptes() {
		return clientCptes;
	}

	public void setClientCptes(Set<Compte> clientCptes) {
		this.clientCptes = clientCptes;
	}

}
