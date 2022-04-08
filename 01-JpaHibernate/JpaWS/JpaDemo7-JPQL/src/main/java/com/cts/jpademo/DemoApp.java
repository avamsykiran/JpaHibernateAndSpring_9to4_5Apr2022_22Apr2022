package com.cts.jpademo;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpademo.entities.Book;
import com.cts.jpademo.entities.Employee;
import com.cts.jpademo.entities.Student;
import com.cts.jpademo.entities.StudentId;
import com.cts.jpademo.models.DeptWiseEmpCount;

public class DemoApp {

	static final String seperator = "----------------------------------------------------------------------------------";

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		Book book = em.find(Book.class, 2L);
		System.out.println(book);
		System.out.println(seperator);
		
		Student student = em.find(Student.class, new StudentId(1L, "EY1", "D"));
		System.out.println(student);
		System.out.println(seperator);
		
		Query qry1 = em.createQuery("SELECT s FROM Student s");
		qry1.getResultStream().forEach(System.out::println);
		System.out.println(seperator);
		
		TypedQuery<Student> qry2 = em.createQuery("SELECT s FROM Student s",Student.class);
		qry2.getResultStream().forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry3 = em.createQuery("SELECT b.title,b.zonar FROM Book b");
		((Stream<Object[]>)qry3.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry4 = em.createQuery("SELECT v.title,v.address.adressLine1 FROM Vendor v");
		((Stream<Object[]>)qry4.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry5 = em.createQuery("SELECT e.fullName,e.dept.deptName FROM Employee e");
		((Stream<Object[]>)qry5.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry6 = em.createQuery("SELECT e.fullName,d.deptName FROM Employee e INNER JOIN Department d ON e.dept=d");
		((Stream<Object[]>)qry6.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry7 = em.createQuery("SELECT d.deptName,COUNT(e) FROM Employee e INNER JOIN Department d ON e.dept=d GROUP BY d.deptName");
		((Stream<Object[]>)qry7.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		Query qry8 = em.createQuery("SELECT d.deptName,COUNT(e) FROM Employee e RIGHT OUTER JOIN Department d ON e.dept=d GROUP BY d.deptName");
		((Stream<Object[]>)qry8.getResultStream())
			.map(rec -> String.format("%s\t%s", rec[0],rec[1]))
			.forEach(System.out::println);
		System.out.println(seperator);
		
		TypedQuery<DeptWiseEmpCount> qry9 = 
					em.createQuery(
							"SELECT new com.cts.jpademo.models.DeptWiseEmpCount(d.deptName,COUNT(e)) FROM Employee e RIGHT OUTER JOIN Department d ON e.dept=d GROUP BY d.deptName",
							DeptWiseEmpCount.class);
		qry9.getResultStream().forEach(System.out::println);
		System.out.println(seperator);
		
		TypedQuery<Employee> qry10 = em.createQuery("SELECT e FROM Employee e WHERE e.salary<=:sal", Employee.class);
		
		qry10.setParameter("sal", 70000.0);
		qry10.getResultStream().forEach(System.out::println);
		System.out.println(seperator);
		
		qry10.setParameter("sal", 100000.0);
		qry10.getResultStream().forEach(System.out::println);
		System.out.println(seperator);
		
		
		em.close();
		emf.close();
	}

}
