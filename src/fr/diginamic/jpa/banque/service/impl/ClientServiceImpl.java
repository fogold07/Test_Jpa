package fr.diginamic.jpa.banque.service.impl;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.dao.BanqueDao;
import fr.diginamic.jpa.banque.dao.ClientDao;
import fr.diginamic.jpa.banque.dao.CompteDao;
import fr.diginamic.jpa.banque.dao.OperationDao;
import fr.diginamic.jpa.banque.dao.impl.BanqueDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.ClientDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.CompteDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.OperationDaoImpl;
import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.service.ClientService;

public class ClientServiceImpl implements ClientService {

	BanqueDao bq = new BanqueDaoImpl();
	ClientDao cs = new ClientDaoImpl();
	CompteDao cps = new CompteDaoImpl();
	OperationDao ops = new OperationDaoImpl();
	
	/**
	 * Methode qui cree une banque, un client
	 */
	@Override
	public void createClient(EntityManagerFactory efm) {
		// COMPTE ASSOCIE A DEUX CLIENTS
		// CREATE BANQUE
		Banque banque = bq.creerBanque(efm, new Banque("Crédit Mutuel"));
		System.out.println(banque);

		// CREATE CLIENT
		Adresse adr = new Adresse(4, "Rue Victor Hugo", 91000, "Evry");
		Client clientA = cs.creerClientDansBanque(efm,
				new Client("RICHARD", "Emmanuel", LocalDate.of(1996, Month.DECEMBER, 17), adr), banque);
		Client clientB = cs.creerClientDansBanque(efm,
				new Client("RICHARD-DUPONT", "Uranie", LocalDate.of(1998, Month.JANUARY, 27), adr), banque);

	}

}
