package fr.diginamic.jpa.banque.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.dao.ClientDao;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;

/**
 * Classe qui implémente la methode de creation de l'entité Client.
 * 
 * @author Christian Ingold
 *
 */
public class ClientDaoImpl implements ClientDao {

// REFECTORING TP 04
	/**
	 * Methode qui affecte cree un client dans une banque.
	 * 
	 * @param efm    as EntityManagerFactory
	 * @param client as Client
	 * @param banque as Banque
	 * @return Client
	 */
	@Override
	public Client creerClientDansBanque(EntityManagerFactory efm, Client client, Banque banque) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();
			Banque b = em.find(Banque.class, banque.getId());
			if (b != null) {
				client.setBanqueClient(b);
				em.persist(client);
				em.getTransaction().commit();
				return client;
			} else {
				System.err.println("Banque non trouvée!");
				em.getTransaction().rollback();
				return null;
			}

		} finally {
			if (em != null)
				em.close();
		}
	}

}
