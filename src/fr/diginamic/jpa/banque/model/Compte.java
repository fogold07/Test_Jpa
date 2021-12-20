package fr.diginamic.jpa.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="COMPTE")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE")
public class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NUMERO")
	private String numero;
	
	@Column(name="SOLDE")
	private Double solde;
	
	@OneToMany(mappedBy="opCompte")
	private Set<Operation> operations;
	
	//mapping @ManyToMany avec client
	@ManyToMany
	@JoinTable(name="COMPO",
				joinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName ="ID")
			)
	private Set<Client> cpteClients;
	
	public Compte() {
		operations = new HashSet<>();
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

	public Set<Operation> getOperations() {
		return operations;
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

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
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
