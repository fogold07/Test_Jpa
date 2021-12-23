package fr.diginamic.jpa.banque.model;

import javax.persistence.*;

@Entity
@Table(name="VIREMENT")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE", length = 25)
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
