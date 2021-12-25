package fr.diginamic.jpa.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.*;

import fr.diginamic.jpa.banque.dao.BanqueDao;
import fr.diginamic.jpa.banque.dao.ClientDao;
import fr.diginamic.jpa.banque.dao.CompteDao;
import fr.diginamic.jpa.banque.dao.OperationDao;
import fr.diginamic.jpa.banque.dao.impl.BanqueDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.ClientDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.CompteDaoImpl;
import fr.diginamic.jpa.banque.dao.impl.OperationDaoImpl;
import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;
import fr.diginamic.jpa.banque.model.Operation;
import fr.diginamic.jpa.banque.model.Virement;
import fr.diginamic.jpa.connexion.ConnexionBddJpa;

/**
 * Classe qui execute le TP5
 * 
 * @author Christian Ingold
 *
 */
public class TestBanqueTP5 {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;

		BanqueDao bq = new BanqueDaoImpl();
		ClientDao cs = new ClientDaoImpl();
		CompteDao cps = new CompteDaoImpl();
		OperationDao ops = new OperationDaoImpl();

		try {
			efm = ConnexionBddJpa.getConnexionJpa("banqueTest");


			// COMPTE ASSOCIE A DEUX CLIENTS
			// CREATE BANQUE
			Banque banque = bq.creerBanque(efm, new Banque("Crédit Mutuel"));

			// CREATE CLIENT
			Adresse adr = new Adresse(4, "Rue Victor Hugo", 91000, "Evry");
			Client clientA = cs.creerClientDansBanque(efm, new Client("RICHARD", "Emmanuel", LocalDate.of(1996, Month.DECEMBER, 17), adr), banque);
			Client clientB = cs.creerClientDansBanque(efm, new Client("RICHARD-DUPONT", "Uranie", LocalDate.of(1998, Month.JANUARY, 27), adr), banque);

			Compte cptJoint = cps.creerAffecterCompteJoint(efm, clientA, clientB, new Compte("CJ11223344", 3500.00));

			// CREATE LIVRET A ET ASSURANCE VIE LIES A UN CLIENT
			Adresse adrC = new Adresse(485, "Rue Pierre et Marie Curry", 75000, "Paris");
			Client clientC = cs.creerClientDansBanque(efm, new Client("KONG", "King", LocalDate.of(1988, Month.JUNE, 4), adrC), banque);
			LivretA livret = cps.creerLivretA(efm, clientC, new LivretA("LA00011122", 5000.00, 0.01));
			AssuranceVie ass = cps.creerAssuranceVie(efm, clientC, new AssuranceVie("AV00000002", 3000.0, LocalDate.of(2045, Month.SEPTEMBER, 30), 0.05));

			// CREATE OPERATIONS DE TYPE VIREMENT
			Virement virA = ops.creerVirement(efm, cptJoint, new Virement(LocalDateTime.now(), 1000.00, "Achat TV", "DARTY"));
			
			Virement virB = ops.creerVirement(efm, livret, new Virement(LocalDateTime.now(), 5000.00, "Travaux isolation", "Martin SARL"));


			// CREATE OPERATIONS DE TYPE OPERATION
			// OPERATIONS CREDITEURS - DEBITEURS SUR ASSURANCE VIE

			Operation opAssA = ops.creerOperation(efm, ass, new Operation(LocalDateTime.now(), 1000.00, "Appro Assurance"));

			Operation opAssB = ops.creerOperation(efm, ass, new Operation(LocalDateTime.now(), -4000.00, "Debit Assurance"));

			// OPERATIONS CREDITEURS - DEBITEURS SUR LIVRET A
			Operation opLivA = ops.creerOperation(efm, livret, new Operation(LocalDateTime.now(), 2000.00, "Appro LivretA"));

			Operation opLivB = ops.creerOperation(efm, livret, new Operation(LocalDateTime.now(), -2000.00, "Appro LivretA"));


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}

	}

}