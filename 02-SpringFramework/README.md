Spring Framework
-----------------------------------------------

    Dependency Injection

        Functional Dependency: that a component can execute an operation if and only if its dependent component is
        available.

        repo  <---->  service <-----> ui

        ui is dependent on service and service is dependent on repo.

        interface EmployeeRepo {
            
        }

        class EmployeeRepoJdbcImpl implements EmployeeRepo {

        }

        class EmployeeRepoJpaImpl implements EmployeeRepo {

        }

        interface EmployeeService {

        }

        /*class EmployeeServiceImpl implements EmployeeService {
            private EmployeeRepo empRepo;

            public EmployeeServiceImpl(){
                //this.empRepo = new EmployeeRepoJdbcImpl();
                this.empRepo = new EmployeeRepoJpaImpl();
            }
        }*/

        class EmployeeServiceImpl implements EmployeeService {
            private EmployeeRepo empRepo;

            public EmployeeServiceImpl(EmployeeRepo empRepo){
                this.empRepo = empRepo;
            }

        }

        class UI{
            public static void main(String[] args){
                //EmployeeService empService = new EmployeeService(new EmployeeRepoJdbcImpl());
                EmployeeService empService = new EmployeeService(new EmployeeRepoJpaImpl()); //constructor injection (DI)
            }
        }
       
    IoC - Inversion of Control

        is a concept that proposes the automation of DI.

        Container   -   is a software that create, manage and destroy the software component objects.
                        will detect the dependencies between the components and wires them automatically.

        Bean        -   is a software component objects being managed by a container.

    Spring Framework

        is a dev-platform that offers IoC and is modularized where each spring module
        offers a different framework.


        Spring Core                 core functionalities and IoC api
        Spring Context              ApplicationContext and autowiring
        Spring AOP                  Aspect Orieinted Programming
        Spring Web                  Web MVC / REST api
        Spring Boot                 RAD - Rapid Application Development by auto - configuaration
        Spring Data                 Auto-implemented repositories
        Spring Test                 Testing framework for the spring applciations
        Spring Security             Authorization and Authentication 
        ....etc

    Lab Setup

        JDK 1.8
        STS as IDE
        MySQL

Spring Core and Spring Context
-----------------------------------------------------------------------
    
    These offer IoC/DI .

    Configuaration is where, the lsit of components and their dependencies are declared.
    Using this information the sprign container will create, manage and destroy the beans.

    1. Xml Based Configuaration

            beans.xml
                <beans>
                    <bean id="erjdbc" class="com.cts.hrm.repo.EmployeeRepoJdbcImpl" />
                    <bean id="erjpa" class="com.cts.hrm.repo.EmployeeRepoJpaImpl" />

                    <bean id="eserv1" class="com.cts.hrm.service.EmployeeServiceImpl">
                        <constructor-arg index="0" ref="erjdbc"/>
                    </bean>                    
                    
                    <bean id="eserv2" class="com.cts.hrm.service.EmployeeServiceImpl">
                        <property name="empRepo" ref="erjpa" />
                    </bean>
                </beans>

    2. Annotation Based Configuaration

        @Configuaration
        @ComponentScan("pakage-name-list")

        @Component("myObj")
        class MyClass{

        }

        @Component
            @Repository
            @Service
            @Controller
            @ControllerAdvice
            @RestController
            @RestControllerAdvice ....etc
        
        @Scope                      singleton | prototype | request | session | global-session
        
        @Value                      inject values into primitve fields or string fields
                                    from a properties.
        
        @Autowired
        @Qualifier
        
            constructor injecton    @Autowired
                                    public EmployeeService(EmployeeRepo empRepo){
                                        //......
                                    }

            setter injection        @Autowired
                                    public void setEmpRepo(EmployeeRepo empRepo){
                                        //......
                                    }

            field injection         @Autowired
                                    private EmployeeRepo empRepo;

            autowiring by type
                    if a bean's data type matches with
                    an awaiting field, then they are autowired.

            autowiring by name
                    one can specify the name of the bean we want to inject using
                    @Qualifier   
        
    3. Java Based Configuaration

        is a complimantory setup for Annotation based config.,

        @Configuration
        public class MyConfig {

            @Bean
            public LocalDate today(){
                return LocalDate.now();
            }
        }

Spring Boot
---------------------------------------------------------------------------------

    is a spring module that offers RAD - Rapid Application Development

    application = configuarations + code base.

        spring web      configure the view engine, dispatcher servlet, validation engine, iin8..etc
        spring security configure the type of authentication, roles, access rules ..etc.,
        spring orm      configure the jpa provider, database related proeprties ..etc.,

        ....

    spring boot offers auto-configuaration, thats how the RAD is possible.

    spring boot have multiple supportive modules for each spring module and these
    supportive module are called starter packages

    spring-web          spring-boot-starter-web
    spring-security     spring-boot-starter-security
    ...etc

    these starter modules contian the basic spring module and default configs.

    @SpringBootApplication  =   @AutoConfiguaration 
                                @Configuaration
                                @ComponentScan
                                @PropertySource

    Spring boot offers Runners.
    These runners will help the developer to constamize the application
    execution if needed.

    Spring boot also offer inbuilt servers (embeded servers), if incase the
    application is a server based application.

    Applciation that are capable of executing themselve with an embeded server are called
    server-less applications.

    These server-less applciation are very good for contianarization like Docker or for
    hosting on clouds like AWS.

    A spring boot project can be created ..
     a. using the STS ide
     b. using Spring boot CLI
     c. using Spring Initializer (https://start.spring.io)

Spring Data JPA
----------------------------------------------------------------------------------

    is a spring boot based module that offers auto-implemented repositories.

    CrudRepository
        |
        |- JpaRepository

    @Entity
    @Table(name="emps")
    class Employee {

        @Id
        @GeenratedValue
        private Long empId;
        private String ename;
        private Double salary;
        private LocalDate joinDate;

        .......
    }

    interface EmployeeRepository extends JpaRepository<Employee,Long> {

    }






