package fr.diginamic.jpa.biblio.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.biblio.dao.LivreDao;
import fr.diginamic.jpa.biblio.model.Livre;

/**
 * Classe qui definit les differentes methodes CRUD de l'entite Livre.
 * 
 * @author Christian Ingold
 *
 */
public class LivreServiceDao implements LivreDao {

	/**
	 * Méthode qui permet d'afficher le titre et l'auteur d'un livre en fonction de
	 * son id.
	 * 
	 * @param efm     as EntityManagerFactory
	 * @param idLivre as int
	 */
	@Override
	public void findLivreById(EntityManagerFactory efm, int idLivre) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			Livre li = em.find(Livre.class, idLivre);
			if (li != null) {
				System.out.println("Titre: " + li.getTitre() + " / Auteur: " + li.getAuteur());
			} else
				System.out.println("NOT FOUND !");

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * Méthode qui met à jour le titre d'un livre en base de données.
	 * 
	 * @param efm      as EntityManagerFactory
	 * @param idLivre  as int
	 * @param newLivre as Livre
	 */

	@Override
	public void updateLivre(EntityManagerFactory efm, int idLivre, Livre newLivre) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

			Livre liMod = em.find(Livre.class, idLivre);

			if (liMod != null) {
				liMod.setTitre(newLivre.getTitre());
				em.merge(liMod);
				System.out.println("Update livre id:" + liMod.getId());

			} else {
				em.getTransaction().rollback();
			}

			em.getTransaction().commit();

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * Méthode qui permet d'insérer un nouveau livre en base de données.
	 * 
	 * @param efm      as EntityManagerFactory
	 * @param newLivre as Livre
	 */
	@Override
	public Livre insertLivre(EntityManagerFactory efm, Livre livre) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();

			em.persist(livre);

			em.getTransaction().commit();
			System.out.println("Add Livre with id: " + livre.getId());
			return livre;

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * Méthode qui utlise une requete JPQL pour extraire de la Bdd un livre en
	 * fonction de son titre
	 * 
	 * @param efm as EntityManagerFactory
	 * @param t   as String (titre a rechercher)
	 */
	@Override
	public void findLivreByTitle(EntityManagerFactory efm, String t) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre = :titre", Livre.class);
			Livre li = query.setParameter("titre", t).getSingleResult();
			System.out.println(li);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * Méthode qui utilise une requete JPQL pour extraire de la Bdd un livre en
	 * fonction de son auteur
	 * 
	 * @param efm as EntityManagerFactory
	 * @param a   as String (auteur a rechercher)
	 */
	@Override
	public void findLivreByAuthor(EntityManagerFactory efm, String a) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.auteur = :auteur", Livre.class);
			query.setParameter("auteur", a);
			Livre li = query.getSingleResult();
			System.out.println(li);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	/**
	 * Méthode qui utilise une requete JPQL pour afficher la paire titre-auteur de
	 * tous les livres
	 * 
	 * @param efm as EntityManagerFactory
	 */
	@Override
	public void findAllLivres(EntityManagerFactory efm) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();

			TypedQuery<Livre> query = em.createQuery("select l from Livre l", Livre.class);
			List<Livre> livres = query.getResultList();
			livres.stream().forEach(livre -> System.out.println("Titre: " + livre.getTitre() + " / Auteur: " + livre.getAuteur()));

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	/**
	 * Méthode qui supprime un livre de la BdD.
	 * 
	 * @param efm as EntityManagerFactory
	 */
	@Override
	public void deleteLivre(EntityManagerFactory efm, int id) {
		EntityManager em = null;
		try {
			em = efm.createEntityManager();
			em.getTransaction().begin();
			Livre l = em.find(Livre.class, id);
			if (l != null) {
				em.remove(l);
				em.getTransaction().commit();
				System.out.println("Delete livre id:" + id);
			} else {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
