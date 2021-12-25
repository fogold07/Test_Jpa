package fr.diginamic.jpa.banque.dao.impl;

import java.time.LocalDateTime;

import javax.persistence.*;

import fr.diginamic.jpa.banque.dao.OperationDao;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.Operation;

public class OperationDaoImpl implements OperationDao {


	/**
	 * Methode qui cree une operation sur un compte. 
	 * Si le solde est superieur au montant demande, alors la transaction est validee.
	 * Sinon la transaction est annullee
	 * 
	 * @param efm as EntityManagerFactory
	 * @param compte as Compte sur lequel doit être fait la transaction
	 * @param operation as Operation relative a la transaction
	 * @return Operation
	 */
	@Override
	public Operation creerOperation(EntityManagerFactory efm, Compte compte, Operation operation) {
		EntityManager em = null;
		try {
			em =efm.createEntityManager();
			em.getTransaction().begin();
			if((compte.getSolde() + operation.getMontant()) > 0) {
				//CREATION OPERATION
				operation.setOpCompte(compte);
				em.persist(operation);
				
				//MISE A JOUR DU SOLDE
				Double newSolde = compte.getSolde() + operation.getMontant();
				compte.setSolde(newSolde);
				em.merge(compte);
				
				em.getTransaction().commit();
				return operation;
			} 
			else {
				System.err.println("Votre solde de  " + compte.getSolde() + " € insuffisant pour l'opération !");
				em.getTransaction().rollback();
//				return null;
				return operation;
			}
			
			
		} finally {
			if(em != null) {
				em.close();
			}
		}
	}

}
