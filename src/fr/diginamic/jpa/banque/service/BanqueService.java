package fr.diginamic.jpa.banque.service;

import javax.persistence.EntityManager;

public interface BanqueService {

	int creerBanqueUnique(EntityManager em, String nom);
}
