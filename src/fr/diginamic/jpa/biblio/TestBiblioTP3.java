package fr.diginamic.jpa.biblio;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.biblio.dao.EmpruntDao;
import fr.diginamic.jpa.biblio.dao.impl.EmpruntDaoImpl;
import fr.diginamic.jpa.connexion.ConnexionBddJpa;

/**
 * Classe qui permet d'extraire pour un emprunt la liste de tous ses livres associ?s, 
 * ainsi que la liste de tous les emprunts d'un client donn?.
 * 
 * @author Christian Iingold
 *
 */
public class TestBiblioTP3 {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;

		try {
			efm = ConnexionBddJpa.getConnexionJpa();

			EmpruntDao es = new EmpruntDaoImpl();

			es.extraireEmpruntLivres(efm, 4);
			es.extraireEmpruntsClient(efm, 1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}

	}

}
