package fr.diginamic.jpa.banque.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

public interface VirementDao {

	void creerVirement(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif, String benef);

}
