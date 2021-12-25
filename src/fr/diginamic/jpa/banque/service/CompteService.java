package fr.diginamic.jpa.banque.service;

public interface CompteService {

	void createCompte(Double solde);
	
	void createCompteJoint(Double solde);
	
	void createLivretA(Double solde);
	
	void createAssuranceVie(Double solde);
	
}
