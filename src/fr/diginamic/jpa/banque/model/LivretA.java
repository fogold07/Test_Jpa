package fr.diginamic.jpa.banque.model;

import javax.persistence.*;

/**
 * Classe qui d�finit les attributs de l'entit� Livret A.
 * 
 * @author Christian Ingold
 *
 */
@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {

	@Column(name="TAUX", nullable=false)
	private Double taux; 
	
	public LivretA() {
		// TODO Auto-generated constructor stub
	}


	public LivretA(String numero, Double solde, Double taux) {
		super(numero, solde);
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
		String cptInfo = "n�: "+ getNumero() +", solde: "+getSolde()+" �";
		return "LivretA ["+ cptInfo +", taux:" + taux + "]";
	}

}
