package fr.diginamic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.jpa.model.Client;
import fr.diginamic.jpa.model.Emprunt;

/**
 * Classe qui permet de tester les requêtes de la BdD biblio
 * 
 * @author Christian I
 *
 */
public class TestBiblio {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;
		EntityManager em = null;

		try {
			efm = Persistence.createEntityManagerFactory("bddBIBLIO");
			em = efm.createEntityManager();
			
			extraireEmpruntLivres(em,4);
			extraireEmpruntsClient(em,1);
			
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}

	}



	/** Méthode qui permet d'extraire un emprunt et tous ses livres associés.
	 * @param em as EntityManager
	 * @param idEmprunt as int
	 */
	private static void extraireEmpruntLivres(EntityManager em, int idEmprunt) {
		Emprunt empr = em.find(Emprunt.class, idEmprunt);
		if(empr != null) {
			empr.getEmpLivres().stream().forEach(l -> System.out.println(l));
			/*
			for (Livre li : empr.getEmpLivres()) {
				System.out.println(li);
			}
			*/
		}
		else System.out.println("Emprunt non trouvé !");
	}
	

	/** Méthode qui permet d'extraire tous les emprunts d'un client donné.
	 * @param em as EntityManager
	 * @param idClient as int
	 */
	private static void extraireEmpruntsClient(EntityManager em, int idClient) {
		Client cl = em.find(Client.class,idClient);
		if (cl != null) {
			cl.getEmprunts().stream().forEach(e -> System.out.println(e));
			/*
			for (Emprunt empr : cl.getEmprunts()) {
				System.out.println(empr);
			}
			*/
		}	
		else System.out.println("Client non trouvé !");
	}


}
