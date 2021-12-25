package fr.diginamic.jpa.banque.dao.impl;

import javax.persistence.*;

import fr.diginamic.jpa.banque.dao.BanqueDao;
import fr.diginamic.jpa.banque.model.Banque;

public class BanqueDaoImpl implements BanqueDao {

	/**
	 * Méthode qui crée une banque
	 * 
	 * @param em
	 * @param nom
	 * @return
	 */
	@Override
	public int creerBanqueUnique(EntityManagerFactory efm, String nom) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();

			em.getTransaction().begin();
			Banque bq = new Banque();
			bq.setNom(nom);
			em.persist(bq);
			em.getTransaction().commit();

			int id = bq.getId();
			return id;

		} finally {
			if (em != null)
				em.close();
		}

	}

	/**
	 * Methode qui cree une banque en base de donnees.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param b as Banque
	 * @return Banque
	 */
	@Override
	public Banque creerBanque(EntityManagerFactory efm, Banque b) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();

			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();

			return b;

		} finally {
			if (em != null)
				em.close();
		}
	}

}
