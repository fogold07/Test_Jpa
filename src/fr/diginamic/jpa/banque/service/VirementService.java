package fr.diginamic.jpa.banque.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

public interface VirementService {

	void creerVirement(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif, String benef);

}
