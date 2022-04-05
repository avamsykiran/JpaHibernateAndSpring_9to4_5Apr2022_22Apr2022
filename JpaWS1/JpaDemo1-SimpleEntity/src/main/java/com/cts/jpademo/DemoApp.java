package com.cts.jpademo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Book;
import com.cts.jpademo.entities.Zonar;

public class DemoApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Book(null, "Let US C", LocalDate.now(), 234.0, Zonar.SCIENCE));
		em.persist(new Book(null, "The Hounds Of Baservelli", LocalDate.now(), 1234.0, Zonar.NOVEL));
		em.persist(new Book(null, "Java - Complet eReference", LocalDate.now(), 834.0, Zonar.SCIENCE));
		em.persist(new Book(null, "The Moonstone", LocalDate.now(), 934.0, Zonar.NOVEL));
		txn.commit();
		
		em.close();
		emf.close();
	}

}
