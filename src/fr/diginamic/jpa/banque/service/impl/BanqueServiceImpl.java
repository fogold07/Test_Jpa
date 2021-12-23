package fr.diginamic.jpa.banque.service.impl;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.service.BanqueService;

public class BanqueServiceImpl implements BanqueService {

	/**
	 * Méthode qui crée une banque
	 * @param em
	 * @param nom
	 * @return 
	 */
	@Override
	public int creerBanqueUnique(EntityManager em, String nom) {
		em.getTransaction().begin();
		Banque bq = new Banque();
		bq.setNom(nom);
		em.persist(bq);
		em.getTransaction().commit();
		int id = bq.getId();
		return id;
	}

}
