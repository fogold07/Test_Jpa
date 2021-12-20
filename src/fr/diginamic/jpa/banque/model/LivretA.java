package fr.diginamic.jpa.banque.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte {

	@Column(name="TAUX")
	private Double taux; 
	
	public LivretA() {
		// TODO Auto-generated constructor stub
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}

}
