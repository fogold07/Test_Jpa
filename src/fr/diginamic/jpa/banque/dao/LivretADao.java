package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManager;

public interface LivretADao {

	void creerLivretA(EntityManager em,int idClient, String num, Double solde, Double tx);
}
