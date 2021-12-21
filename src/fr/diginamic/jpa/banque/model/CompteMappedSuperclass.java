package fr.diginamic.jpa.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/*
 * Relatif au TP04
 * 
@Entity
@Table(name="COMPTE")
*/

@MappedSuperclass
public class CompteMappedSuperclass {

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
	
	public CompteMappedSuperclass() {

		cpteClients = new HashSet<>();
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

	
}
