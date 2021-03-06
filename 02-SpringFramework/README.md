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
        private String mailId;
        private Double salary;
        private LocalDate joinDate;

        .......
    }

    interface EmployeeRepository extends JpaRepository<Employee,Long> {
        boolean existsByEname(String ename);
        List<Employee> findAllByEname(String ename);
        Employee findByMailId(String mailId);
        List<Employee> findAllByJoinDate(LocalDate joinDate);

        @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :lbound AND :ubound")
        List<Employee> getAllWithingSalaryRange(double lbound,double ubound);
    }


Spring Web
-------------------------------------------------------------------------------------

    Multi-Layer Archetecture

        Repo <-entities-> Service <-models-> UI

    Model-View-Controller Archetecture

        Repo <-entities-> Service <-models-> Controller <-----REQ
                                                |
                                                model
                                                |
                                                ???
                                                View  ------Resp--->

    MVC 2 / Single Front Controller Archetecture

                                             Controller1
        Repo <-entities-> Service <-models-> Controller2 <-model-> FrontController <-----REQ
                                             Controller3                | 
                                                                        |
                                                                        model
                                                                        |
                                                                        ???
                                                                        View  ------Resp--->

        FrontController     DispatcherServlet (springframework)

                                1. it recieves any and all requests from the cleint
                                2. it is going to read the url and according to the url,
                                        the req is forwarded to an underlying controller.
                                        this is called url-mapping is done using SimpleUrlHandler class.
                                3. the controller once done with the req will get back to the DispatcherServlet with
                                    a viewName and a model.
                                4. the DispatcherServlet will use InternalResourceViewResolver to find out
                                 a view matching the viewName, and the model if any is supplied to that view and
                                 the view is sent as a response.

        Conmtroller         Is any POJO class that
                                1. must be marked with @Controller 
                                2. must have methods that are called action to handle the
                                    requests.
                                3. each of these methods are marked with @RequestMapping
                                4. each of these methods must return viewName as String or
                                    viewName and model as ModelAndView object.

        SimpleUrlkHandler   is a class implmented from UrlHandler interface
                            it creates a map of urls and controller::actionMethods
                            and each time a req is received by the DispatcherServlet, according to the url
                            of the req, a controller and its method is choosen.

        InternalResourceViewResolver
                            is a class implemented from ViewResolver.
                            it has to properties prefix and suffix.
                            when a view name is given to it, it returns the actual view file
                            as prefix+viewName+suffix

                                prefix=/pages/
                                suffix=.jsp

                                viewName=home
                                
                                viewPath = /pages/home.jsp

        Annotations
            @Controller
            @RequestMapping(value="",method=..)
                @GetMapping
                @PostMapping ....
            @RequestParam("txnId")                       http://localhost:9999/delTxn?txnId=1
            @ModelAttribute("")
            @ControllerAdvice
            @ExceptionHandler

        javax.validation.constraints Annotations
            @NotNull
            @NotBlank
            @Size
            @Min
            @Max
            @Pattern
            ....etc

    REST - api
                                 Web App
                                 React App
      Repo <---> BL  <---data--> Andriod App
                                 Angular App

        SOAP Web Services 

            SOAP - Simple Object Access Protocol

            xml as a meidum of communication

            Web Service is the mehtod that has the bussiness logic and
            is hosted centrally on a SOAP server.

            - xml is not suitable to share binary data like images/files ..etc
            - soap web service had no standard way of sharing error-some situations.

        RESTful Web Service 

            REpresentational State Transfer

            accessed via http protocol.

            HTTP suports a variety of media like xml,json,images,files ..etc.,

            HTTP STATUS CODEs

                1xx     indicate that a req is received by the server and is under process.
                3xx     indicate that a response is being redirected to a different resource

                2xx     indicate that the req is process successfully and came back with a resp.
                        200     OK              use this code to indicate that a  RETRIVAL is success.
                        201     CREATED         use this code to indicate that an INSERTION is success.
                        203     ACCEPTED        use this code to indicate that an UPDATION is success.
                        204     NO CONTENT      use this code to indicate that a  DELETION is success.

                4xx     indicate that the req could not be processed due to a client side fault.
                        400     BAD REQUEST     use this code to indicate that any valdiation related problems ...etc.
                        401     UNAUTHORIZED
                        404     NOT FOUND       use this code to indicate that a RETRIVAL fails.

                5xx     indicate that the req could not be processed due to a server side fault.
                        500     INTERNAL SERVER ERROR
            
            HTTP METHODS
            
                Employee        /emps
                Txn             /txns
                AccountHolders  /accounts

                GET         retrive     /emps       retrive all employees
                                        /emps/1     retrive single employee having employeeId 1
                POST        insert
                PUT         update
                PATCH       update
                DELETE      delete      /emps/1 

            @RestController         = @Controller + @ResponseBody
            @RestControllerAdvice   = @ControllerAdvice + @ResponseBody

BudgetTrackerApplication - CaseStudy - Monolithic Approach
---------------------------------------------------------------------------

    1. On the home-page , the list of existing account holders must be displayed
        and each accountholder record must have a 'View Statement' link.
        AccountHolder
            ahId
            fullName
            mobile
            mailId
            totalCredit
            totalDebit
            currentBalance
    2. A new AccountHolder can be added using accountholder-form-page.
    3. statement-page must display the list of transactions made by a particular
        accountholder as and when the 'View Statement' link is clicked.
    4. new transactions for each accountholder must be added using txn-form-page.
    5. on the statement-page, 'DELETE' and 'EDIT' options for each txn are needed.
    6. On the statement-page, we have to display the total credit, total debit and
        the current balance

BudgetTracker - REST api
-------------------------------------------------------------------------------------------
    /accountHolders                 GET     return List<AccountHolder>
    /accountHolders                 POST    accept AccoutnHolder and return the smae after inserting
    /accountHolders/{ahId}          GET     return AccountHolder
    /accountHolders/{ahId}/txns     GET     return List<Txn> related to the given accoutnHolder

    /txns                           POST    accept a Txn and return the same after insertion
    /txns                           PUT     accept a Txn and return the same after updation
    /txns/{txnId}                   GET     return Txn
    /txns/{txnId}                   DELETE  delete the txn as per the givne id

