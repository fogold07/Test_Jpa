package fr.diginamic.jpa.banque.service.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.service.ClientService;

public class ClientServiceImpl implements ClientService {

	// ISSU TP5
	/**
	 * Méthode qui crée un Embadded de l'adresse
	 * 
	 * @param num
	 * @param rue
	 * @param cp
	 * @param ville
	 * @return adresse
	 */
	@Override
	public Adresse creerAdresse(int num, String rue, int cp, String ville) {
		Adresse adresse = new Adresse();
		adresse.setNumero(num);
		adresse.setRue(rue);
		adresse.setCodePostal(cp);
		adresse.setVille(ville);
		return adresse;
	}

	// ISSU TP5
	/**
	 * Méthode qui crée un client, après avoir créé au préalable la banque.
	 * 
	 * @param em
	 * @param idBanque
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adr
	 */
	@Override
	public void creerClient(EntityManager em, int idBanque, String nom, String prenom, LocalDate dateNaissance,
			Adresse adr) {
		em.getTransaction().begin();
		// remplace 1 par id client
		Banque bq = em.find(Banque.class, idBanque);
		if (bq != null) {
			Client client = new Client();
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setDateNaissance(dateNaissance);
			client.setAdresse(adr);
			client.setBanqueClient(bq);
			em.persist(client);
			em.getTransaction().commit();
		} else {
			System.out.println("Banque non trouvée!");
			em.getTransaction().rollback();
		}

	}

	/**
	 * Methode qui cree un client.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param c   as Client
	 * @return Client
	 */
	@Override
	public Client creerClient(EntityManagerFactory efm, Client c) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return c;
		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * Methode qui affecte une banque a un client.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param c   as Client
	 * @param id  as int
	 * @return Client
	 * 
	 */
	@Override
	public Client affecterBanque(EntityManagerFactory efm, Client c, int id) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();
			Banque b = em.find(Banque.class, id);
			if (b != null) {
				c.setBanqueClient(b);
				em.merge(c);
				em.getTransaction().commit();
				return c;
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
