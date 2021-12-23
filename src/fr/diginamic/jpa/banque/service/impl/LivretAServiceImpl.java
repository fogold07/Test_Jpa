package fr.diginamic.jpa.banque.service.impl;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.LivretA;
import fr.diginamic.jpa.banque.service.LivretAService;

public class LivretAServiceImpl implements LivretAService {
	
	/**
	 * Méthode qui créé un compte de type livret A pour un client.
	 * @param em
	 * @param idClient
	 * @param num
	 * @param solde
	 * @param tx
	 */
	@Override
	public void creerLivretA(EntityManager em, int idClient, String num, Double solde, Double tx) {
		em.getTransaction().begin();
		Client cl = em.find(Client.class, idClient);
		if(cl!=null) {
			LivretA la = new LivretA();
			la.setNumero(num);
			la.setSolde(solde);
			la.setTaux(tx);
			la.getCpteClients().add(cl);
			em.persist(la);
		} else {
			System.out.println("Client non trouvé!");
		}
		em.getTransaction().commit();
		
	}

}
