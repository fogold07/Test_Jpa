package fr.diginamic.jpa.banque.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;

public interface ClientDao {
	// A SUPPR
	Adresse creerAdresse(int num, String rue, int cp, String ville);
	
	// A SUPPR
	void creerClient(EntityManager em, int idBanque , String nom, String prenom, LocalDate dateNaissance, Adresse adr);
		
	Client creerClientDansBanque(EntityManagerFactory efm, Client client, Banque banque);
	
}
