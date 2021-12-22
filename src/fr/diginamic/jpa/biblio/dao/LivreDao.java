package fr.diginamic.jpa.biblio.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.biblio.model.Livre;

/**
 * Interface qui definit les differentes methodes CRUD de l'entite Livre.
 * 
 * @author Christian Ingold
 *
 */
public interface LivreDao {
	
	void updateLivre(EntityManagerFactory efm, int idLivre, Livre livre);
	
	Livre insertLivre(EntityManagerFactory efm, Livre livre);

	
	void findLivreByTitle (EntityManagerFactory efm, String titreFind);
	
	void findLivreByAuthor(EntityManagerFactory efm, String auteurFind);
	
	void deleteLivre(EntityManagerFactory efm, int id);
	
	void findAllLivres(EntityManagerFactory efm);

	void findLivreById(EntityManagerFactory efm, int idLivre);
}
