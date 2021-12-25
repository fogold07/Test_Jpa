package fr.diginamic.jpa.banque.dao.impl;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import fr.diginamic.jpa.banque.dao.VirementDao;
import fr.diginamic.jpa.banque.model.Compte;
import fr.diginamic.jpa.banque.model.Virement;

public class VirementDaoImpl implements VirementDao {

	/**
	 * Méthode qui créé une opération de type virement sur un compte.
	 * 
	 * @param em
	 * @param idCpt
	 * @param date
	 * @param montant
	 * @param motif
	 * @param benef
	 */
	@Override
	public void creerVirement(EntityManager em, int idCpt, LocalDateTime date, Double montant, String motif,
			String benef) {
		em.getTransaction().begin();
		Compte cp = em.find(Compte.class, idCpt);
		if (cp != null) {
			// Verification solde
			if (cp.getSolde() - montant > 0) {
				// creation virement
				Virement v = new Virement();
				v.setOpCompte(cp);
				v.setDate(date);
				v.setMontant(montant);
				v.setMotif(motif);
				v.setBeneficiaire(benef);
				em.persist(v);

				// mise à jour solde
				Double nvSolde = cp.getSolde() - montant;
				cp.setSolde(nvSolde);

				em.merge(cp);

			} else {
				System.out.println("Solde insuffisant : " + cp.getSolde() + " € !");
			}
		} else {
			System.out.println("Compte non trouvé!");
		}
		em.getTransaction().commit();
	}

}
