package fr.diginamic.jpa.banque.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte {

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@Column(name="TAUX")
	private Double taux;
	
	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	public Date getDateFin() {
		return dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + "]";
	}

}
