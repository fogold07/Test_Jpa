package fr.diginamic.jpa.banque.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="VIREMENT")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE", length = 25)
	private String beneficiaire;
	
	public Virement() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Virement(LocalDateTime date, Double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}



	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}



	@Override
	public String toString() {
		return "Virement [id: "+ getId() + ", date: "+ getDate() +", montant: "+ getMontant() +" €, beneficiaire: "+ getBeneficiaire() +", motif: " + getMotif()+" ]";
	}





	
}
