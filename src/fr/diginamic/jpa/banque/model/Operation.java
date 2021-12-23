package fr.diginamic.jpa.banque.model;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name="OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column(name="DATE")
	private LocalDateTime date;
	
	@Column(name="MONTANT")
	private Double montant;
	
	@Column(name="MOTIF", length = 25)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte opCompte;
	
		
	public Operation() {
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Double getMontant() {
		return montant;
	}

	public String getMotif() {
		return motif;
	}

	public Compte getOpCompte() {
		return opCompte;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public void setOpCompte(Compte opCompte) {
		this.opCompte = opCompte;
	}

	

}
