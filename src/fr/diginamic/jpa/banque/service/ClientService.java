package fr.diginamic.jpa.banque.service;

import javax.persistence.EntityManagerFactory;


public interface ClientService {

	void createClient(EntityManagerFactory efm);
}
