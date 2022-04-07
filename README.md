JPA - Hibernate
----------------------------------------------------------------------
                            
                            ORM - Object Relatonal Mapping

            OOAD                    OOP                             RDBMS
        ---------------------------------------------------------------------------------------------------
        Entity Definition           class                           table
        Entity                      object                          record / row / tuple
        Properties                  field / data member             attribute / column / field
        Behaviours                  method / member function        --------

        Relationships
         Is A                       class Employee{                 Single Table
                                        Long empId;                     all_emps    eid,fnm,sal,hra,ta,dur,etype
                                        String fullName;
                                        Double salary;              Join Table
                                    }                                   emps        eid,fnm,sal
                                                                        mgrs        eid,hra,ta
                                    class Manager extends Employee{     cemps       eid,dur
                                        Double hra;
                                        Double ta;                  Table Per Class
                                    }                                   emps_only   eid,fnm,sal
                                                                        mgrs_only   eid,fnm,sal,hra,ta
                                                                        cemps_only  eid,fnm,sal,dur
                                    class ContractEmployee extends Employee{
                                        Integer contractDuartion;
                                    }
         Has A (Assosiaton)
          Composition               class Address {                 emps        eid,fnm,sal,dno,street,city,dist,state,ctry
                                        String doorNum;             custs       ccode,fnm,dno,street,city,dist,state,ctry
                                        String street;
                                        String city;
                                        String district;
                                        String state;
                                        String country;
                                    }

                                    class Employee {
                                        Long empId;
                                        String fullName;
                                        Double salary;
                                        Address address;
                                    }

                                    class Customer {
                                        Long custCode;
                                        String fullName;
                                        Address address;
                                    }
          Aggregation
            OneToOne                class Employee {                emps        eid,fnm,sal
                                        Long empId;                 accounts    accnum,bank,branch,ifsc,eid
                                        String fullName;
                                        Double salary;              emps        eid,fnm,sal,accnum
                                        BankAccount salAccount;     accounts    accnum,bank,branch,ifsc
                                    }

                                    class BankAccount {
                                        String accNum;
                                        String bank;
                                        String branch;
                                        String ifsc;
                                        Employee accountHolder;
                                    }

            OneToMany               class Department {              depts       did,dname
            ManyToOne                   Long deptId;                emps        eid,fnm,sal,did
                                        String deptName;
                                        Set<Employee> emps;
                                    }

                                    class Employee {
                                        Long empId;
                                        String fullName;
                                        Double salary;
                                        Department dept;
                                    }

            ManyToMany              class Employee {                emps    eid,fnm,sal
                                        Long empId;                 prjs    pcode,title,budget
                                        String fullName;            prjsemp pcode,eid
                                        Double salary;
                                        Set<Project> projects;
                                    }

                                    class Project {
                                        Long prjCode;
                                        String title;
                                        Double budget;
                                        Set<Employee> team;
                                    }


                                    class Employee {                emps    eid,fnm,sal
                                        Long empId;                 prjs    pcode,title,budget
                                        String fullName;            conts   pcode,eid,role,startDate,endDate
                                        Double salary;
                                        Set<Contributions> contributions;
                                    }

                                    class Project {
                                        Long prjCode;
                                        String title;
                                        Double budget;
                                        Set<Contributions> contributions;
                                    }

                                    class Contribution {
                                        Project project;
                                        Employee contributor;
                                        String role;
                                        LocalDate startDate;
                                        LocalDate endDate;
                                    }

    JPA?
        Java Persistence API 
        is a ORM specification .


        MySQL         <---> connector driver                      toplink
        Oracle        <---> thin driver         <----> JDBC <---> hibernate <---> JPA <----> APP
        MsSQL Server  <---> jet driver                            ibates


        JPA Annotations

            @Entity                 class level
            @Table                  class level

            @Embadable              class level
            @NamedQueries           class level

            @Inheretence            class level
            @DiscriminatorColumn    class level
            @DiscriminatorValue     class level

            @Column                 Field level
            @Transiant              Field level

            @Id                     Field level
            @EmbededId              Field level
            @GeneratedValue         Field level

            @Enumarated             Field level
            @Embeded                Field level
            @OneToOne               Field level
            @OneToMany              Field level
            @ManyToOne              Field level
            @ManyToMany             Field level

            @JoinColumn             Field level

        JPA Configuaration

            project-root/META-INF/persistence.xml
                <persistence-unit>
                    ......
                </persistence-unit>

        JPA API

            Persistence 
                createEntityManagerFactory(String persistenceUnitName)
                    EntityManagerFactory
                        createEntityManager()
                            EntityManager
                                persist(entity)                     insertion
                                merge(entity)                       updation
                                remove(entity)                      deletion
                                find(Entity.class,idValue)          retrival
                                getTransaction()
                                    EntityTransaction
                                        begin()
                                        commit()
                                        rollback()
                                createQuery(String jpql)        
                                    Query
                                        setParameter(String paramName,Object value);
                                        getResultList()
                                        getResultStream()
                                createQuery(String jpql,Entity.class)        
                                    TypedQuery
                                        setParameter(String paramName,Object value);
                                        getResultList()
                                        getResultStream()

        JPQL - Java Persistence Query Language

            SQL                                                 JPQL

            select * from students;                             select s from Student s

            select btitle,zonar from books                      SELECT b.title,b.zonar FROM Book b

            select title,adressLine1 from vendors;              SELECT v.title,v.address.adressLine1 FROM Vendor v

            select e.fullName,d.deptName                        SELECT e.fullName,e.dept.deptName FROM Employee e
            from emps e cross join depts d 
            where e.dept_deptId=d.deptId;

            select e.fullName,d.deptName                        SELECT e.fullName,d.deptName 
            from emps e inner join depts d                      FROM Employee e INNER JOIN Department d
            on e.dept_deptId=d.deptId;                          on e.dept=d

            select d.deptName,count(*)                          SELECT d.deptName,COUNT(e)
            from emps e inner join depts d                      FROM Employee e inner join Department d
            on e.dept_deptId=d.deptId                           ON e.dept=d
            group by d.deptName;                                GROUP BY d.deptName

            select d.deptName,count(e.fullName)
            from emps e right outer join depts d
            on e.dept_deptId=d.deptId
            group by d.deptName;

