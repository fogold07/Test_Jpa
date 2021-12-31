package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;

/**
 * Interface qui d�finit la methode de creation de l'entit� Client.
 * 
 * @author Christian Ingold
 *
 */
public interface ClientDao {

	Client creerClientDansBanque(EntityManagerFactory efm, Client client, Banque banque);

}
