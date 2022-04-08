package com.cts.jpademo;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpademo.entities.Department;
import com.cts.jpademo.entities.Employee;

public class DemoApp {

	public static void main(String[] args) {
		
		Department d1 = new Department(null,"Accounts",new TreeSet<>());
		Department d2 = new Department(null,"Operations",new TreeSet<>());
		Department d3 = new Department(null,"Sales",new TreeSet<>());
		
		Employee e1 = new Employee(null, "Vamsy", 567800.0, d1);
		Employee e2 = new Employee(null, "Sagar", 67800.0, d1);
		Employee e3 = new Employee(null, "Suseela", 97800.0, d1);
		Employee e4 = new Employee(null, "Indhikaa", 107800.0, d2);
		Employee e5 = new Employee(null, "Srinu", 67800.0, d2);
		
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d1.getEmps().add(e3);
		d2.getEmps().add(e4);
		d2.getEmps().add(e5);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		txn.commit();
		
		em.close();
		emf.close();
	}

}
