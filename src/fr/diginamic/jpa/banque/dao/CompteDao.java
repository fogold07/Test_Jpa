package fr.diginamic.jpa.banque.dao;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.banque.model.AssuranceVie;
import fr.diginamic.jpa.banque.model.Client;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.LivretA;

/**
 * Interface qui définit la methode de creation de l'entité Compte.
 * 
 * @author Christian Ingold
 *
 */
public interface CompteDao {

	// RELATIF TP 4
	Compte creerAffecterCompte(EntityManagerFactory efm, Client cl, Compte cpt);

	// RELATIF AU TP5
	Compte creerAffecterCompteJoint(EntityManagerFactory efm, Client clientA, Client clientB, Compte compte);

	AssuranceVie creerAssuranceVie(EntityManagerFactory efm, Client client, AssuranceVie assurance);

	LivretA creerLivretA(EntityManagerFactory efm, Client client, LivretA livret);

}
