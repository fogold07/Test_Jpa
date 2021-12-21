package fr.diginamic.jpa.banque.model;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name="ASSURANCE_VIE")
public class AssuranceVie extends Compte {

	/*
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN", nullable=false)
	private Date dateFin;
	*/
	
	@Column(name="DATE_FIN", nullable=false)
	private LocalDate dateFin;
	
	@Column(name="TAUX", nullable=false)
	private Double taux;
	
	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public Double getTaux() {
		return taux;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public void setTaux(Double taux) {
		this.taux = taux;
	}


	@Override
	public String toString() {
		String cptInfo = "n°: "+ getNumero() +", solde: "+getSolde()+" €";
		return "AssuranceVie ["+cptInfo+", date_Fin: " + dateFin + ", taux: " + taux+ "]";
	}

}
