package fr.diginamic.jpa.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.jpa.banque.model.Adresse;
import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;
import fr.diginamic.jpa.banque.model.Operation;
import fr.diginamic.jpa.banque.model.Virement;


/**
 * Classe qui execute le TP5
 * @author Christian Ingold
 *
 */
public class TestBanqueTP5Draft {

	public static void main(String[] args) {
		
		EntityManagerFactory efm = null;
		EntityManager em = null;
		try {
			efm = Persistence.createEntityManagerFactory("banque");
			em = efm.createEntityManager();
			
			/*
			 * Insertion d'un compte associ� � 2 clients 
			 **/
			
						
			// Creation client 2
			String nom ="GIDE-MARIE";
			String prenom = "Fabienne";
			LocalDate dateNaissance = LocalDate.of(1986, Month.SEPTEMBER, 25);
			
			//Cr�ation adresse
			int num = 15;
			String rue ="Pierre Marie Curry";
			int cp = 75000;
			String ville = "Paris";
			Adresse adr = creerAdresse(num, rue, cp, ville);
			
			//creerClient(em, nom, prenom, dateNaissance, adr);

			
			// Creation compte associ� � 2 clients
			/*
			Compte cp = new Compte();
			Client c = em.find(Client.class, 3);
			Client c2 = em.find(Client.class, 4);
			if(c!=null && c2!=null) {
				cp.getCpteClients().add(c);
				cp.getCpteClients().add(c2);
				cp.setNumero("0011223344");
				cp.setSolde(4500.50);
				em.persist(cp);
			}
			*/
			
			/*
			 * Ins�rer un client avec plusieurs comptes
			 **/
			
			String numLA ="55667788LA";
			Double solde = 2500.00;
			Double tx = 0.01;
			
			String numAV = "55667788AV";
			Double soldeAV = 7000.00;
			Double txAV = 0.05;		
			LocalDate dateFin = LocalDate.of(2045, Month.JUNE, 30);
			
			int idClient = 2;
			
			//creerLivretA(em, idClient, numLA, solde, tx);
			//creerAssuranceVie(em, idClient, numAV, soldeAV, txAV, dateFin);
			
			/*
			 * Insertion op�ration de type virement
			 */
			int idCpt = 5;
			LocalDateTime date = LocalDateTime.now();
			Double montant = 5500.00;
			String motif = "Prime Risque";
			String benef = "Toto";
			//creerVirement(em, idCpt, date, montant, motif, benef);
			
			/*
			 * Insertion op�ration de type op�ration
			 */
			
			int idCpt2 = 5;
			LocalDateTime date2 = LocalDateTime.now();
			Double montant2 = 5500.00;
			String motif2 = "Prime Risque";
			
			//creerOperation(em, idCpt2, date2, montant2, motif2);

			em.close();
		}

		
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
		

	}

	
	/**
	 * M�thode qui cr�� une op�ration sur un compte.
	 * - type d�bit = solde n�gatif;
	 * - type cr�dit = solde positif.
	 * @param em
	 * @param idCpt
	 * @param date
	 * @param montant
	 * @param motif
	 */
	//new Operation(date, montant, motif) --> fait sauter op.setter stdr
	//creerOperation(em, idCpt, new operation(date, montant, motif))
	private static void creerOperation(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif) {
		em.getTransaction().begin();
		Compte cp = em.find(Compte.class, idCpt);
		if(cp!=null) {
			//Verification solde 
			if(cp.getSolde() + montant > 0) {
				//creation op�ration
				Operation op = new Operation();
				op.setOpCompte(cp);
				op.setDate(date);
				op.setMontant(montant);
				op.setMotif(motif);
				em.persist(op);
				
				//mise � jour solde
				Double nvSolde = cp.getSolde() + montant;
				cp.setSolde(nvSolde);
				
				em.merge(cp);
				
			} else {
				System.out.println("Solde insuffisant : " + cp.getSolde() + " � !");
			}
		} else {
			System.out.println("Compte non trouv�!");
		}
		em.getTransaction().commit();
		
	}

	/**
	 * M�thode qui cr�� une op�ration de type virement sur un compte.
	 * @param em
	 * @param idCpt
	 * @param date
	 * @param montant
	 * @param motif
	 * @param benef
	 */
	/*
	private static void creerVirement(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif, String benef) {
		em.getTransaction().begin();
		Compte cp = em.find(Compte.class, idCpt);
		if(cp!=null) {
			//Verification solde
			if(cp.getSolde() - montant > 0) {
				//creation virement
				Virement v = new Virement();
				v.setOpCompte(cp);
				v.setDate(date);
				v.setMontant(montant);
				v.setMotif(motif);
				v.setBeneficiaire(benef);
				em.persist(v);
				
				//mise � jour solde
				Double nvSolde = cp.getSolde() - montant;
				cp.setSolde(nvSolde);
				
				em.merge(cp);
				
			} else {
				System.out.println("Solde insuffisant : " + cp.getSolde() + " � !");
			}
		} else {
			System.out.println("Compte non trouv�!");
		}
		em.getTransaction().commit();
	}
*/

	/**
	 * M�thode qui cr�� une assurance vie pour un client.
	 * @param em
	 * @param idClient
	 * @param num
	 * @param solde
	 * @param tx
	 * @param dateFin
	 */
	/*
	private static void creerAssuranceVie(EntityManager em, int idClient, String num, Double solde, Double tx, LocalDate dateFin) {
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
			System.out.println("Client non trouv�!");
		}
		em.getTransaction().commit();
		
	}
*/

	/**
	 * M�thode qui cr�� un compte de type livret A pour un client.
	 * @param em
	 * @param idClient
	 * @param num
	 * @param solde
	 * @param tx
	 */
	/*
	private static void creerLivretA(EntityManager em,int idClient, String num, Double solde, Double tx) {
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
			System.out.println("Client non trouv�!");
		}
		em.getTransaction().commit();
		
	}
*/

	/**
	 * M�thode qui cr�e un client, apr�s avoir cr�� au pr�alable la banque.
	 * @param em
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adr
	 *//*	private static void creerClient(EntityManager em, String nom, String prenom, LocalDate dateNaissance, Adresse adr) {
		em.getTransaction().begin();
		//Get Banque
		Banque bq = em.find(Banque.class, 1);
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
*/
	/**
	 * M�thode qui cr�e un Embadded de l'adresse
	 * @param num
	 * @param rue
	 * @param cp
	 * @param ville
	 * @return adresse
	 */
	/*
	private static Adresse creerAdresse(int num, String rue, int cp, String ville) {
		Adresse adresse = new Adresse();
		adresse.setNumero(num);
		adresse.setRue(rue);
		adresse.setCodePostal(cp);
		adresse.setVille(ville);
		return adresse;
	}
*/
	/**
	 * M�thode qui cr�e une banque
	 * @param em
	 * @param nom
	 */
	/*
	private static void creerBanqueUnique(EntityManager em, String nom) {
		em.getTransaction().begin();
		Banque bq = new Banque();
		bq.setNom(nom);
		em.persist(bq);
		em.getTransaction().commit();
	}
*/
}
