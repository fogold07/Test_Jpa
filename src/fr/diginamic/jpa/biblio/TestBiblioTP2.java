package fr.diginamic.jpa.biblio;

import javax.persistence.EntityManagerFactory;

import fr.diginamic.jpa.biblio.dao.LivreDao;
import fr.diginamic.jpa.biblio.dao.impl.LivreDaoImpl;
import fr.diginamic.jpa.connexion.ConnexionBddJpa;

public class TestBiblioTP2 {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		
		try {
			efm = ConnexionBddJpa.getConnexionJpa();
			
			
			LivreDao ls = new LivreDaoImpl();
			
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


