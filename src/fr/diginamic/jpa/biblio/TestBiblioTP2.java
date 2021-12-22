package fr.diginamic.jpa.biblio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.biblio.connexion.ConnexionBddJpa;
import fr.diginamic.jpa.biblio.dao.LivreDao;
import fr.diginamic.jpa.biblio.dao.impl.LivreServiceDao;
import fr.diginamic.jpa.biblio.model.Livre;

public class TestBiblioTP2 {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		
		try {
			efm = ConnexionBddJpa.getConnexionJpa();
			
			
			LivreDao ls = new LivreServiceDao();
			
			//FIND BY ID
			//ls.findLivreById(efm, 7);
			
			//UPDATE
			//ls.updateLivre(efm, 5, new Livre("1001 recettes de Cuisine"));
			
			//INSERT 
			//Livre l = ls.insertLivre(efm, new Livre("L'audace de vaincre", "Jean Latherguy"));
			//System.out.println(l.getId());
			
			//FIND DY TITLE
			//ls.findLivreByTitle(efm, "Guerre et paix");
			
			//FIND BY AUTHOR
			//ls.findLivreByAuthor(efm, "Emile Zola");
			
			//FIND ALL
			//ls.findAllLivres(efm);
			
			//DELETE
			//ls.deleteLivre(efm, 8);
		

		}     	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}

	}

	

	}


