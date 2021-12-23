package fr.diginamic.jpa.banque;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.service.BanqueService;
import fr.diginamic.jpa.banque.service.ClientService;
import fr.diginamic.jpa.banque.service.CompteService;
import fr.diginamic.jpa.banque.service.impl.BanqueServiceImpl;
import fr.diginamic.jpa.banque.service.impl.ClientServiceImpl;
import fr.diginamic.jpa.banque.service.impl.CompteServiceImpl;
import fr.diginamic.jpa.connexion.ConnexionBddJpa;


/**
 * Classe d'execution du TP4.
 * @author Christian Ingold
 *
 */
public class TestBanqueTP4Draft {

	public static void main(String[] args) {
		
		EntityManagerFactory efm = null;

		try {
			efm = ConnexionBddJpa.getConnexionJpa("banqueTest");
			
			BanqueService bq = new BanqueServiceImpl();
			ClientService cs = new ClientServiceImpl();
			CompteService cps = new CompteServiceImpl();
			
	
			//CREATE BANQUE
			Banque b = bq.creerBanque(efm, new Banque("CLC"));
			System.out.println(b);
			
			//CREATE CLIENT 
			Adresse adr = new Adresse(35, "Rue André Breton", 78360, "Buc");
			Client c = new Client("Bertrand", "Xavier", LocalDate.of(1956, Month.OCTOBER, 10), adr);
			Client cl = cs.creerClient(efm, c);
			System.out.println(cl);
			
			//AFFECTER BANQUE AU CLIENT
			Client cl2 = cs.affecterBanque(efm, cl, b.getId());
			System.out.println("id: "+cl2.getId()+" & " + cl2.getBanqueClient());

			
			//CREATE COMPTE
			Compte cp = cps.creerCompte(efm,new Compte("CC12345678", 3500.00));
			System.out.println(cp.getCpteClients());
			
			//AFFECTER COMPTE AU CLIENT
			Compte cpt = cps.affecterClient(efm, cl2, cp);
			System.out.println(cpt + " & " + cpt.getCpteClients());
//			if(c!=null) {
//				cp.getCpteClients().add(c);
//				cp.setNumero("00124589");
//				cp.setSolde(2500.50);
//				em.persist(cp);
//			}
//				
//			em.getTransaction().commit();
			
			// CREATE OPERATION

		}

		
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
		
	

	}



}
