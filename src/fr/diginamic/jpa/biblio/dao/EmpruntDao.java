package fr.diginamic.jpa.biblio.dao;

import javax.persistence.EntityManagerFactory;

/**
 * Interface qui definit les differentes methodes CRUD de l'entite Emprunt.
 * 
 * @author Christian Ingold
 *
 */
public interface EmpruntDao {

	void extraireEmpruntLivres(EntityManagerFactory efm, int id);
	
	void extraireEmpruntsClient(EntityManagerFactory efm, int id);
	
}
