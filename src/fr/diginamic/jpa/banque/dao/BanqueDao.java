package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;

/**
 * Interface qui définit la methode de creation de l'entité Banque.
 * 
 * @author Christian Ingold
 *
 */
public interface BanqueDao {
	Banque creerBanque(EntityManagerFactory efm, Banque b);
}
