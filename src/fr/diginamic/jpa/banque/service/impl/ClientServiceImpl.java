package fr.diginamic.jpa.banque.service.impl;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.service.ClientService;

public class ClientServiceImpl implements ClientService {

	/**
	 * M�thode qui cr�e un Embadded de l'adresse
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

	/**
	 * M�thode qui cr�e un client, apr�s avoir cr�� au pr�alable la banque.
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
		//remplace 1 par id client
		Banque bq = em.find(Banque.class, idBanque);
		if(bq!=null) {
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setDateNaissance(dateNaissance);
		client.setAdresse(adr);
		client.setBanqueClient(bq);
		em.persist(client);
		} else {
			System.out.println("Banque non trouv�e!");
		}
		em.getTransaction().commit();
		
	}



}
