package fr.diginamic.jpa.banque.service;

import javax.persistence.EntityManager;

public interface LivretAService {

	void creerLivretA(EntityManager em,int idClient, String num, Double solde, Double tx);
}
