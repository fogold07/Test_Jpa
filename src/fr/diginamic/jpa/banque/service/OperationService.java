package fr.diginamic.jpa.banque.service;

public interface OperationService {

	void createOperation(Double montant);
	void createVirement(Double montant);
}
