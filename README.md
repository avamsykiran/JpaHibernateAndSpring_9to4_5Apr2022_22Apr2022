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