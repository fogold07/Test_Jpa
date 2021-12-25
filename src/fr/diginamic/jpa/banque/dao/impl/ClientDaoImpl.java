package fr.diginamic.jpa.banque.dao.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.dao.ClientDao;
import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;

public class ClientDaoImpl implements ClientDao {

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

// REFECTORING TP 04
	/**
	 * Methode qui affecte cree un client dans une banque.
	 * 
	 * @param efm as EntityManagerFactory
	 * @param client   as Client
	 * @param banque  as Banque
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
