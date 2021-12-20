package fr.diginamic.jpa.banque;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;


public class TestBanqueTP4 {

	public static void main(String[] args) {
		
		EntityManagerFactory efm = null;
		EntityManager em = null;
		try {
			efm = Persistence.createEntityManagerFactory("banque");
			em = efm.createEntityManager();
			
			em.getTransaction().begin();
			/*
			Client cl1 = new Client();
			Adresse adr1 = new Adresse();
			Banque bq1 = new Banque();
			
			adr1.setNumero(24);
			adr1.setRue("Pierre Breton");
			adr1.setCodePostal(78000);
			adr1.setVille("Versailles");
			
			bq1.setNom("CLC");
						
			cl1.setNom("Osborn");
			cl1.setPrenom("Damien");
			cl1.setAdresse(adr1);
			cl1.setBanqueClient(bq1);
			
			em.persist(bq1);
			
			em.persist(cl1);
			*/
			Client cl = em.find(Client.class, 1);
			
			GregorianCalendar d = new GregorianCalendar(1986, Calendar.FEBRUARY, 18);
			
			Date dob = d.getTime();
			
			//System.out.println(dob);		
			cl.setDateNaissance(dob);
			em.merge(cl);
			
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
