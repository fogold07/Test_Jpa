package fr.diginamic.jpa.banque.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;

public interface BanqueService {

	int creerBanqueUnique(EntityManagerFactory efm, String nom);
	
	Banque creerBanque(EntityManagerFactory efm, Banque b);
}
