package fr.diginamic.jpa.banque.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="OPERATION")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE")
	private Date date;
	
	@Column(name="MONTANT")
	private Double montant;
	
	@Column(name="MOTIF")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte opCompte;
		
	public Operation() {
	}

	public Date getDate() {
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

	public void setDate(Date date) {
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
