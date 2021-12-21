package fr.diginamic.jpa.banque.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

public interface OperationService {
	void creerOperation(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif);
}
