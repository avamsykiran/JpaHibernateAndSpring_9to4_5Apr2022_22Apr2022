package com.cts.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.HousingLoan;
import com.cts.jpademo.entities.Loan;
import com.cts.jpademo.entities.PersonalLoan;

public class DemoApp {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Loan(1L, 50000.0, 1, 0.12));
		em.persist(new HousingLoan(2L, 5500000.0, 13, 0.07,7500000.0));
		em.persist(new PersonalLoan(3L, 150000.0, 5, 0.23,"Foreign Vacation"));
		txn.commit();
		
		em.close();
		emf.close();
	}

}
