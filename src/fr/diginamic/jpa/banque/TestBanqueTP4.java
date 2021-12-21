package fr.diginamic.jpa.banque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;


public class TestBanqueTP4 {

	public static void main(String[] args) {
		
		EntityManagerFactory efm = null;
		EntityManager em = null;
		try {
			efm = Persistence.createEntityManagerFactory("banque");
			em = efm.createEntityManager();
			
			em.getTransaction().begin();
			/* CREATE CLIENT - ADRESSE - BANQUE
			Client cl1 = new Client();
			Adresse adr1 = new Adresse();
			Banque bq1 = new Banque();
			
			// pour la création de la date
			//LocalDate.of(1987, Month.APRIL,01));
			GregorianCalendar d = new GregorianCalendar(1978, Calendar.MAY, 11);
			Date dob = d.getTime();
			
			adr1.setNumero(24);
			adr1.setRue("Pierre Breton");
			adr1.setCodePostal(78000);
			adr1.setVille("Versailles");
			
			bq1.setNom("CLC");
			cl.setDateNaissance(dob);			
			cl1.setNom("Osborn");
			cl1.setPrenom("Damien");
			cl1.setAdresse(adr1);
			cl1.setBanqueClient(bq1);
			
			em.persist(bq1);
			
			em.persist(cl1);
			*/
			
			//CREATE COMPTE
			
			Compte cp = new Compte();
			Client c = em.find(Client.class, 1);
			if(c!=null) {
				cp.getCpteClients().add(c);
				cp.setNumero("00124589");
				cp.setSolde(2500.50);
				em.persist(cp);
			}
				
			em.getTransaction().commit();
			em.close();
		}

		
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
		
		//Adresse adr = new Adresse();

	}

}
