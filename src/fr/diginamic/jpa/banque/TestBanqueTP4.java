package fr.diginamic.jpa.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

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
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.Operation;
import fr.diginamic.jpa.connexion.ConnexionBddJpa;

/**
 * Classe qui insere en base de donnees des instances des differents objets du TP4.
 * 
 * @author Christian Ingold
 *
 */
public class TestBanqueTP4 {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;

		try {
			efm = ConnexionBddJpa.getConnexionJpa("banqueTest");

			BanqueDao bq = new BanqueDaoImpl();
			ClientDao cs = new ClientDaoImpl();
			CompteDao cps = new CompteDaoImpl();
			OperationDao ops = new OperationDaoImpl();

			// CREATE BANQUE
			Banque banque = bq.creerBanque(efm, new Banque("CLC"));
			System.out.println(banque);

			// CREATE CLIENT
			Adresse adrB = new Adresse(4, "Rue Pégoud", 75000, "Paris");
			Client clientB = cs.creerClientDansBanque(efm, new Client("FOGOLD", "Christian", LocalDate.of(1986, Month.DECEMBER, 7), adrB), banque);
			System.out.println(clientB);

			// CREATE COMPTE
			Compte cptB = cps.creerAffecterCompte(efm, clientB, new Compte("CC00112233", 500.00));
			System.out.println(cptB + " rattaché au " + cptB.getCpteClients());

			// CREATE OPERATION
			Operation op = ops.creerOperation(efm, cptB, new Operation(LocalDateTime.now(), 1000.00, "Prime fin annee"));
			System.out.println(op);
			System.out.println("Solde après operation (" + op.getMotif() + ") : "+ cptB.getSolde() + " €");
			
			Operation op2 = ops.creerOperation(efm, cptB, new Operation(LocalDateTime.now(), -1200.00, "AMAZON"));
			System.out.println(op2);
			System.out.println("Solde après operation (" + op2.getMotif() + ") : "+ cptB.getSolde() + " €");
			
			Operation op3 = ops.creerOperation(efm, cptB, new Operation(LocalDateTime.now(), -400.00, "BUT"));
			System.out.println(op3);
			System.out.println("Solde après operation (" + op3.getMotif() + ") : "+ cptB.getSolde() + " €");
		
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}

	}

}
