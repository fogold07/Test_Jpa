package fr.diginamic.jpa.banque.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.model.Adresse;

public interface ClientService {
	
	Adresse creerAdresse(int num, String rue, int cp, String ville);
	
	void creerClient(EntityManager em, int idBanque , String nom, String prenom, LocalDate dateNaissance, Adresse adr);
	//obj type client et obj banque
	
}
