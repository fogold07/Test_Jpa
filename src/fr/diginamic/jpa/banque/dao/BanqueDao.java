package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;

/**
 * Interface qui d�finit la methode de creation de l'entit� Banque.
 * 
 * @author Christian Ingold
 *
 */
public interface BanqueDao {
	Banque creerBanque(EntityManagerFactory efm, Banque b);
}
