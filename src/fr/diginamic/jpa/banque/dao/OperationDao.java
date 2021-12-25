package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.Operation;
import fr.diginamic.jpa.banque.model.Virement;

public interface OperationDao {
		
	Operation creerOperation(EntityManagerFactory efm, Compte compte, Operation operation);
	
	Virement creerVirement(EntityManagerFactory efm, Compte cpt, Virement virement);

}
