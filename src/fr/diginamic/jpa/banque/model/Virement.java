package fr.diginamic.jpa.banque.model;

import javax.persistence.*;

@Entity
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;
	
	public Virement() {
		// TODO Auto-generated constructor stub
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
