package fr.diginamic.jpa.banque.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.dao.CompteDao;
import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;

public class CompteDaoImpl implements CompteDao {

//	@Override
//	public LivretA affecterLivretA(EntityManager em, int idClient, LivretA la) {
//		em.getTransaction().begin();
//		Client cl = em.find(Client.class, idClient);
//		if (cl != null) {
//			la.getCpteClients().add(cl);
//			em.persist(la);
//			em.getTransaction().commit();
//			return la;
//
//		} else {
//			System.err.println("Client non trouv�!");
//			return null;
//		}
//
//	}

//************** RELATIF AU TP4 **********************************

	/**
	 * Methode qui cree un compte de type compte.
	 * 
	 * @param efm      as EntityManagerFactory
	 * @param cl as Client
	 * @param cpt      as Compte
	 * @return Compte
	 */
	@Override
	public Compte creerAffecterCompte(EntityManagerFactory efm, Client cl, Compte cpt) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

				cpt.getCpteClients().add(cl);
				em.persist(cpt);
				em.getTransaction().commit();
				return cpt;

		} finally {
			if (em != null)
				em.close();
		}

	}

	/**
	 * Methode qui cree un compte de type Assurance Vie.
	 * 
	 * @param efm      as EntityManagerFactory
	 * @param idClient as Client
	 * @param av       as AssuranceVie
	 * @return AssuranceVie
	 */
	@Override
	public AssuranceVie creerAssuranceVie(EntityManagerFactory efm, Client cl, AssuranceVie av) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode qui cree un compte de type Livret A.
	 * 
	 * @param efm      as EntityManagerFactory
	 * @param idClient as Client
	 * @param la       as LivretA
	 * @return LivretA
	 */
	@Override
	public LivretA creerLivretA(EntityManagerFactory efm, Client cl, LivretA la) {
		// TODO Auto-generated method stub
		return null;
	}

}