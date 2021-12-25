package fr.diginamic.jpa.banque.dao.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.dao.AssuranceVieDao;
import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Client;

public class AssuranceVieDaoImpl implements AssuranceVieDao {

	/**
	 * Méthode qui créé une assurance vie pour un client.
	 * @param em
	 * @param idClient
	 * @param num
	 * @param solde
	 * @param tx
	 * @param dateFin
	 */
	@Override
	public void creerAssuranceVie(EntityManager em, int idClient, String num, Double solde, Double tx,
			LocalDate dateFin) {
		
		em.getTransaction().begin();
		Client cl = em.find(Client.class, idClient);
		if(cl!=null) {
			AssuranceVie av = new AssuranceVie();
			av.setNumero(num);
			av.setSolde(solde);
			av.setTaux(tx);
			av.setDateFin(dateFin);
			av.getCpteClients().add(cl);
			em.persist(av);
		} else {
			System.out.println("Client non trouvé!");
		}
		em.getTransaction().commit();
		
	}

}
