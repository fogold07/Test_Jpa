package fr.diginamic.jpa.banque.dao.impl;

import javax.persistence.*;

import fr.diginamic.jpa.banque.dao.BanqueDao;
import fr.diginamic.jpa.banque.model.Banque;

/**
 * Classe qui implémente la methode de creation de l'entité Banque.
 * 
 * @author Christian Ingold
 *
 */
public class BanqueDaoImpl implements BanqueDao {

	/**
	 * Methode qui cree une banque en base de donnees.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param b   as Banque
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
