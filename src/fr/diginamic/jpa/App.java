package fr.diginamic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.model.Livre;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;
		EntityManager em = null;
		try {
			efm = Persistence.createEntityManagerFactory("bddBIBLIO");
			em = efm.createEntityManager();
			
			//tp02Read(em);
			//tp02Insert(em);
			//tp02Update(em);
			//tp02RqtJpqlTitre(em);
			//String titreFind = "Guerre et paix";
			//tp02RqtJpqlTitre(em, titreFind);
			//String auteurFind = "Emile Zola";
			//tp02RqtJpqlAuteur(em, auteurFind);
			//tp02Delete(em);
			//tp02FindAll(em);

			em.close();
		}     	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}

	}

	/** M�thode qui met � jour un livre en base de donn�es.
	 * @param em as EntityManager
	 */
	private static void tp02Update(EntityManager em) {
		//UPDATE merge()
		System.out.println("TP 02 - UPDATE :");
		em.getTransaction().begin();
		
		Livre liMod = em.find(Livre.class, 5);
		
		if (liMod != null) {
			liMod.setTitre("Du plaisir dans la cuisine");
			em.merge(liMod);
		} else {
			em.getTransaction().rollback();
		}
		
		em.getTransaction().commit();
		
	}

	/** M�thode qui insert un nouveau livre en base de donn�es.
	 * @param em as EntityManager
	 */
	private static void tp02Insert(EntityManager em) {
		//INSERT persist()
		System.out.println("TP 02 - INSERT :");
		em.getTransaction().begin();
		
		Livre liCree = new Livre();
		liCree.setTitre("L'audace de servir");
		liCree.setAuteur("Guy Lartheguy");
		
		em.persist(liCree);
		
		em.getTransaction().commit();
	}

	/** M�thode qui renvoie le titre et l'auteur d'un livre en base de donn�es.
	 * @param em as EntityManager
	 */
	private static void tp02Read(EntityManager em) {
		//READ find()
		System.out.println("TP 02 - READ :");
		Livre li = em.find(Livre.class, 8);
		if(li != null) System.out.println("Titre: " + li.getTitre() + " de " +  li.getAuteur());
		else System.out.println("NOT FOUND !");
		
	}
	
	/** M�thode qui utlise une requete JPQL pour extraire de la Bdd un livre en fonction de son titre
	 * @param em as EntityManager
	 * @param titreFind as String (titre � rechercher)
	 */
	private static void tp02RqtJpqlTitre(EntityManager em, String titreFind) {
		//Requete JPQL : 
		System.out.println("TP 02 - JPQL Titre :");
		
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre = :titreFind",Livre.class);
		
		Livre li = query.setParameter("titreFind",titreFind).getSingleResult();
		System.out.println(li);
	}

	/** M�thode qui utilise une requete JPQL pour extraire de la Bdd un livre en fonction de son auteur
	 * @param em as EntityManager
	 * @param auteurFind as String (auteur � rechercher)
	 */
	private static void tp02RqtJpqlAuteur(EntityManager em, String auteurFind) {
		System.out.println("TP 02 - JPQL Auteur :");
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.auteur = :auteurFind",Livre.class);
		query.setParameter("auteurFind",auteurFind);
		Livre li = query.getSingleResult();
		System.out.println(li);
	}
	
	
	/** M�thode qui supprime un livre de la BdD.
	 * @param em as EntityManager
	 */
	private static void tp02Delete(EntityManager em) {
		//DELETE = remove()
		System.out.println("TP 02 - DELETE :");
		em.getTransaction().begin();
		Livre liDel = em.find(Livre.class, 6);
		if(liDel != null) {
			em.remove(liDel);
			em.getTransaction().commit();
		} else {
			em.getTransaction().rollback();
		}
		
	}
	
	/** M�thode qui utilise une requete JPQL pour afficher la paire titre-auteur de tous les livres
	 * @param em as EntityManager
	 */
	private static void tp02FindAll(EntityManager em) {
		//
		System.out.println("TP 02 - FIND ALL :");
		TypedQuery<Livre> query = em.createQuery("select l from Livre l", Livre.class);
		
		List<Livre> livres = query.getResultList();
		
		livres.stream().forEach(livre -> System.out.println(livre.getTitre() + " - " + livre.getAuteur()));
		/*
		for (Livre livre : livres) {
			System.out.println(livre.getTitre() + " - " + livre.getAuteur() );
		}
		*/
	}

	
	/** M�thode qui impl�mente le TP01 sur les bases du CRUD en JPA.
	 * 
	 */
	public static void tp01() {
		/*
		Fournisseur fo = em.find(Fournisseur.class, 1);
		if(fo != null) System.out.println(fo.getNom());
		*/
		
		/*
		Article art = em.find(Article.class, 1);
		if(art != null) System.out.println(art.getDesignation());
		*/
		
		//CREATTION : INSERT = PERSIST()
		/*
		em.getTransaction().begin();
		Article art = new Article();
		art.setRef("C01");
		art.setDesignation("Perforeuse universelle");
		art.setPrix(19.99);
		art.setId_fou(2);
		em.persist(art);
		em.getTransaction().commit();
		*/
		
		//MODIFICATION : UPDATE = MERGE()
		/*
		int id = art.getId();
		em.getTransaction().begin();
		Article artUpt = em.find(Article.class, id);
		artUpt.setPrix(29.99);
		em.merge(artUpt);
		em.getTransaction().commit();
		//System.out.println("id cr��: "+ id);
		*/
	}
}
