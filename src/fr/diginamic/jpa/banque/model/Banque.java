package fr.diginamic.jpa.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="BANQUE")
public class Banque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM", length = 60, unique = true)
	private String nom;
	
	@OneToMany(mappedBy="banqueClient")
	private Set<Client> clients;
	
	public Banque() {
		clients = new HashSet<>();
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}



}
