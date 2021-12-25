package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;

public interface CompteDao {

	// RELATIF TP 4
	Compte creerAffecterCompte(EntityManagerFactory efm, Client cl, Compte cpt);
	
	
	AssuranceVie creerAssuranceVie(EntityManagerFactory efm, Client cl, AssuranceVie av);
	
	LivretA creerLivretA(EntityManagerFactory efm, Client cl, LivretA la);
	
	
	
	//LivretA affecterLivretA(EntityManagerFactory efm, int idClient, LivretA la);
	
}
