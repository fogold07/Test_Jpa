package fr.diginamic.jpa.banque.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Client;

public interface ClientService {
	// A SUPPR
	Adresse creerAdresse(int num, String rue, int cp, String ville);
	
	// A SUPPR
	void creerClient(EntityManager em, int idBanque , String nom, String prenom, LocalDate dateNaissance, Adresse adr);
	
	
	Client creerClient(EntityManagerFactory efm, Client c);
	
	Client affecterBanque(EntityManagerFactory efm, Client c, int id);
	
}
