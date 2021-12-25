package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.Operation;

public interface OperationDao {
		
	Operation creerOperation(EntityManagerFactory efm, Compte compte, Operation operation);
}
