package fr.diginamic.jpa.banque.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

public interface AssuranceVieDao {

	
	void creerAssuranceVie(EntityManager em, int idClient, String num, Double solde, Double tx, LocalDate dateFin);
}
