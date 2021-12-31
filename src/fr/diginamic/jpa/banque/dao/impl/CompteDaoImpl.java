package fr.diginamic.jpa.banque.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.dao.CompteDao;
import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;

/**
 * Classe qui implémente la methode de creation de l'entité Compte.
 * 
 * @author Christian Ingold
 *
 */
public class CompteDaoImpl implements CompteDao {

//************** RELATIF AU TP4 **********************************

	/**
	 * Methode qui cree un compte de type compte.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param cl  as Client
	 * @param cpt as Compte
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

//******* RELATIF TP 5 **********************
	/**
	 * Methode qui cree un compte de type Assurance Vie.
	 * 
	 * @param efm       as EntityManagerFactory
	 * @param client    as Client
	 * @param assurance as AssuranceVie
	 * @return AssuranceVie
	 */
	@Override
	public AssuranceVie creerAssuranceVie(EntityManagerFactory efm, Client client, AssuranceVie assurance) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

			assurance.getCpteClients().add(client);
			;
			em.persist(assurance);
			em.getTransaction().commit();
			return assurance;

		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * Methode qui cree un compte de type Livret A.
	 * 
	 * @param efm    as EntityManagerFactory
	 * @param client as Client
	 * @param livret as LivretA
	 * @return LivretA
	 */
	@Override
	public LivretA creerLivretA(EntityManagerFactory efm, Client client, LivretA livret) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

			livret.getCpteClients().add(client);
			em.persist(livret);
			em.getTransaction().commit();
			return livret;

		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * Methode qui cree un compte joint de type compte. Cette methode permet de
	 * creer un compte joint (deux titulaires).
	 * 
	 * 
	 * @param efm     as EntityManagerFactory
	 * @param clientA as Client (titulaire)
	 * @param clientB as Client (co-titulaire)
	 * @param compte  as Compte
	 * @return Compte
	 */
	@Override
	public Compte creerAffecterCompteJoint(EntityManagerFactory efm, Client clientA, Client clientB, Compte compte) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

			compte.getCpteClients().add(clientA);
			compte.getCpteClients().add(clientB);
			em.persist(compte);
			em.getTransaction().commit();
			return compte;

		} finally {
			if (em != null)
				em.close();
		}

	}

}
