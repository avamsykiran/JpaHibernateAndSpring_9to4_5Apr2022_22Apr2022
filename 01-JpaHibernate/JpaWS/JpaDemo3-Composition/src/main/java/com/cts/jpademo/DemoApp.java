package com.cts.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Address;
import com.cts.jpademo.entities.Vendor;

public class DemoApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Vendor(null, "BigBazaar", new Address("Dno#3-4/1,MG Road", "Banglore", "Karnataka", "INDIA")));
		em.persist(new Vendor(null, "Relieance Fresh", new Address("Dno#1-2/1,MG Road", "Banglore", "Karnataka", "INDIA")));
		em.persist(new Vendor(null, "Big Basket", new Address("Dno#2-4/1,MG Road", "Banglore", "Karnataka", "INDIA")));
		txn.commit();
		
		em.close();
		emf.close();
	}

}
