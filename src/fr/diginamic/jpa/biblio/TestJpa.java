package fr.diginamic.jpa.biblio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe qui permet de créer une instance EntityManagerFactory et EntityManager.
 * @author Christian Ingold
 *
 */
public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		EntityManager em = null;
		try {
			efm = Persistence.createEntityManagerFactory("bddBIBLIO");
			em = efm.createEntityManager();
			em.close();
		}     	catch(Exception e) {e.printStackTrace();}
    	finally {
			if (efm != null)
				efm.close();
		}

	}

}
