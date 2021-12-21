package fr.diginamic.jpa.banque.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;

public interface AssuranceVieService {

	
	void creerAssuranceVie(EntityManager em, int idClient, String num, Double solde, Double tx, LocalDate dateFin);
}
