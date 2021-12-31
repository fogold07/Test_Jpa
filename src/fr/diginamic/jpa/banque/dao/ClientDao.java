package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Banque;
import fr.diginamic.jpa.banque.model.Client;

/**
 * Interface qui définit la methode de creation de l'entité Client.
 * 
 * @author Christian Ingold
 *
 */
public interface ClientDao {

	Client creerClientDansBanque(EntityManagerFactory efm, Client client, Banque banque);

}
