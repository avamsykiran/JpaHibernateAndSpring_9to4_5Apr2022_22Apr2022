package com.cts.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Student;
import com.cts.jpademo.entities.StudentId;

public class DemoApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(new Student(new StudentId(1L,"EY1","D"), "Indhikaa",56700.0));
		em.persist(new Student(new StudentId(1L,"Standard-1","A"), "Akshita",56700.0));
		em.persist(new Student(new StudentId(1L,"EY2","B"), "Malavika",56700.0));
		txn.commit();
		
		em.close();
		emf.close();
	}

}
