package fr.diginamic.jpa.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/*
 * Relatif au TP04
 * 
 * */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="COMPTE")
public class Compte {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NUMERO", length = 10)
	private String numero;
	
	@Column(name="SOLDE")
	private Double solde;
	

	//mapping @ManyToMany avec client
	@ManyToMany
	@JoinTable(name="COMPO",
				joinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName ="ID")
			)
	private Set<Client> cpteClients;
	
	public Compte() {
		cpteClients = new HashSet<>();
	}

	public Compte(String numero, Double solde) {
		this();
		this.numero = numero;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public Double getSolde() {
		return solde;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}


	public Set<Client> getCpteClients() {
		return cpteClients;
	}

	public void setCpteClients(Set<Client> cpteClients) {
		this.cpteClients = cpteClients;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}
	
}
