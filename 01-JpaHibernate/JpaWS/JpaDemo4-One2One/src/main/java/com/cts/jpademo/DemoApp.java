package com.cts.jpademo;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Citizen;
import com.cts.jpademo.entities.Passport;

public class DemoApp {

	public static void main(String[] args) {
		
		Citizen c1 = new Citizen("12345678", "Vamsy Kiran", "Aripaka", null);
		Citizen c2 = new Citizen("78907788", "Indhikaa", "Aripaka", null);
		Citizen c3 = new Citizen("98809887", "Suseela", "Aripaka", null);
		
		Passport p1 = new Passport("W45T67", "Visakhapatnma", LocalDate.of(2020, Month.JANUARY, 25), c1);
		Passport p2 = new Passport("W45T77", "Visakhapatnma", LocalDate.of(2021, Month.JANUARY, 25), c2);
		Passport p3 = new Passport("W45T88", "Visakhapatnma", LocalDate.of(2022, Month.JANUARY, 25), c3);
		
		c1.setPassport(p1);
		c2.setPassport(p2);
		c3.setPassport(p3);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		txn.commit();
		
		em.close();
		emf.close();
	}

}
