package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;

public interface BanqueDao {

	int creerBanqueUnique(EntityManagerFactory efm, String nom);
	
	Banque creerBanque(EntityManagerFactory efm, Banque b);
}
