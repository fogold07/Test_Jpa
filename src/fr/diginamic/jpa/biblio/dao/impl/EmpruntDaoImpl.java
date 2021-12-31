package fr.diginamic.jpa.biblio.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.biblio.dao.EmpruntDao;
import fr.diginamic.jpa.biblio.model.Client;
import fr.diginamic.jpa.biblio.model.Emprunt;

/**
 * Classe qui definit les differentes methodes Read de l'entite Livre.
 * 
 * @author Christian Ingold
 *
 */
public class EmpruntDaoImpl implements EmpruntDao {

	/**
	 * Methode qui permet d'extraire un emprunt et tous ses livres associes.
	 * 
	 * @param em as EntityManagerFactory
	 * @param id as int (id de l'emprunt)
	 */
	@Override
	public void extraireEmpruntLivres(EntityManagerFactory efm, int id) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			Emprunt empr = em.find(Emprunt.class, id);
			if (empr != null) {
				empr.getEmpLivres().stream().forEach(l -> System.out.println(l));
			} else
				System.err.println("Emprunt non trouvé !");

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * Methode qui permet d'extraire tous les emprunts d'un client donne.
	 * 
	 * @param em as EntityManager
	 * @param id as int (id du client)
	 *
	 */
	@Override
	public void extraireEmpruntsClient(EntityManagerFactory efm, int id) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			Client cl = em.find(Client.class, id);
			if (cl != null) {
				cl.getEmprunts().stream().forEach(e -> System.out.println(e));
			} else
				System.err.println("CLIENT NOT FOUND !");

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
