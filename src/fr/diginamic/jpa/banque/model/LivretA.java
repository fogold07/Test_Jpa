package fr.diginamic.jpa.banque.model;

import javax.persistence.*;

@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {

	@Column(name="TAUX", nullable=false)
	private Double taux; 
	
	public LivretA() {
		// TODO Auto-generated constructor stub
	}

	public LivretA(Double taux) {
		super();
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		String cptInfo = "n°: "+ getNumero() +", solde: "+getSolde()+" €";
		return "LivretA ["+ cptInfo +", taux:" + taux + "]";
	}

}
