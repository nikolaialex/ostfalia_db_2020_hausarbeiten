# Annotationen

Spring Data erlaubt es durch seine Abstraktionsschicht mithilfe von Annotationen die Business-Logik von der unterliegenden Art der Persistierung zu trennen.
Annotationen können sowohl auf der Klassenebene als auch auf der Methoden-, Feld- oder Parameterebene angewendet werden.
Die wichtigsten Annotationen werden an dieser Stelle vorgestellt und knapp erläutert.

## Grundlegende Spring Data Annotationen

### @SpringBootApplication  

```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args){
        SpringApplication.run(MyApplication.class, args);
    }
}
```

Die `@SpringBootApplication` Annotation kapselt die drei Annotationen `@Configuration`, `@EnableAutoConfiguration` und `@ComponentScan` und 
kommt bei der zugrundeliegenden Anwendungsklasse zum Einsatz.  
- Die `@Configuration` Annotation legt die annotierte Klasse als Quelle für Bean-Definitionen innerhalb des Anwendungskontextes fest.
- Die `@EnableAutoConfiguration` Annotation sorgt dafür, dass anhand von bestimmten Einstellungen automatisch Beans erzeugt werden.
- Die `@ComponentScan` Annotation bewirkt, dass Spring ausgehend von dem Package der Anwendungsklasse nach weiteren Komponenten, Konfigurationen und Services sucht.

### @Bean

```java
@SpringBootApplication
public class MyApplication {

    private static final Logger log = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(TestRepository repository) {
        return (args) -> {
            repository.save(new TestData(1));
            repository.save(new TestData(2));
            repository.save(new TestData(3));
            //print all test data
            for (TestData data : repository.findAll()) {
                log.info(data.toString());
            }
        };
    }
}
```

Die `@Bean` Annotation wird auf Methodenebene verwendet, um Beans anhand von der annotierten Methode zu erzeugen. 
Während die `JavaConfig` durchgeführt wird, wird die annotierte Methode ausgeführt und der return-Wert als Bean im Anwendungskontext registriert.

### @EnableTransactionManagement

```java
@Configuration
@EnableTransactionManagement
public class MyConfiduration {
    //Configuration Beans
}
```
Die `@EnableTransactionManagement` Annotation stellt die Voraussetzung für die nachfolgende `@Transactional` Annotation dar.
Sie wird auf Klassenebene an einer Konfigurationsklasse angewandt und sorgt dafür, dass das manuelle Steuern von Transaktionen möglich wird.

### @Transactional
```java
@Transactional
void doTransaction(){};

//oder

@Transactional
public class MyClass {
    public void doTransaction(){};
}
```
Die `@Transactional` Annotation erlaubt es, das transaktionale Verhalten einer Methode oder - sofern die Annotation auf Klassenebene angewandt wird - aller Methoden einer Klasse zu konfigurieren.
Die Annotation verfügt über weitere Konfigurationsmöglichkeiten, um das Verhalten zu beeinflussen. Neben dem `Propagation Type` lässt sich auch das `Isolation Level` der Transaktion definieren. 
Außerdem lässt sich ein Timeout für die durchzuführende Operation bestimmen, `Rollback`-Regeln festlegen sowie eine `readOnly`-Flag setzen.


### @NoRepositoryBean und @Repository

```java
@NoRepositoryBean
interface MyBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Optional<T> findById(ID id);
}

@Repository
interface MyChildRepository extends MyBaseRepository<Thing, Long>{}
```
Die `@NoRepositoryBean` Annotation sorgt dafür, dass auf Basis des annotierten Interfaces, welches ein Spring Data Repository erweitert, kein Bean erstellt wird.
Dies ist besonders dann nützlich, wenn alle eigenen Repositories auf einem `BaseRepository` basieren sollen: Nur für die Repositories, die auf dem `BaseRepository` basieren, werden Beans erzeugt.
Durch die `@Repository` Annotation wird aus einem Interface zur Laufzeit ein RepositoryBean generiert.

## Model Annotationen

Spring Data bietet neben den bereits vorgestellten Annotationen, die sich hauptsächlich auf die Konfiguration der Anwendung beziehen, ebenfalls ein Reihe von hilfreichen Annotationen, die es erlauben
Modellklassen zu konfigurieren, dass sie unabhängig von der unterliegenden Implementierung sind.

### @Id
```java
public class TestData {
    @Id
    Long id;
}
```
Die `@Id` Annotation sorgt dafür, dass das annotierte Feld als Primärschlüssel gespeichert wird.

### @Transient
```java
public class TestData {
    @Transient
    int randomField;
}
```
Durch Verwendung der `@Transient` Annotation wird das annotierte Feld weder aus der Datenbank gelesen, noch in diese geschrieben. 

### Kontrollieren der Modellklassen

Die Annotationen `@CreatedBy`, `@LastModifiedBy`, `@CreatedDate` und `@LastModifiedDate` ermöglichen es, die annotierten Felder automatisch durch Spring mit den korrekten Werten füllen zu lassen.
```java
public class TestData {
    @CreatedBy
    User createdBy;
    
    @LastModifiedBy
    User lastModifiedBy;
    
    @CreatedDate
    Date createdDate;
    
    @LastModifiedDate
    Date lastModifiedDate;
}
```

## Wichtige Spring Data JPA Annotationen

### @Entity
```java
@Entity
public class User {
    @Id
    private Long id;
    
    protected User(){}
    
    public User(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
```
Durch die `@Entity` Annotation lässt sich eine JPA Entität erzeugen, die in der Datenbank gespeichert werden kann. JPA benötigt einen leeren Constructor, weshalb jede mit `@Entity` annotierte Klasse einen leeren Default-Constructor vorweisen muss.

### @GeneratedValue
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    protected User(){}
    
    public User(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
}
```
Die `@GeneratedValue` Annotation kann genutzt werden, um zu bestimmen, nach welcher Strategie der Primärschlüssel generiert wird.
Zu diesem Zweck gibt es vier Möglichkeiten:
- GenerationType.AUTO (Default) lässt die Persistenzschicht automatisch eine Strategie wählen. Für die meistverbreiteten Datenbanken wird GenerationType.SEQUENCE gewählt 
- GenerationType.IDENTITY verwendet ein automatisches Inkrement einer Spalte, um eine eindeutige ID zu erzeugen.
- GenerationType.SEQUENCE nutzt eine Datenbanksequenz, um einen neuen Wert für das Feld zu ermitteln
- GenerationType.TABLE simuliert eine Datenbanksequenz, bremst allerdings durch pessimistisches Sperren das System aus

### @Query und @Param
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Query("SELECT * FROM User u")
    Collection<User> getUsers();
}
```
Mit der `@Query` Annotation lassen sich Repository Methoden JPQL (Java Persistence Query Language) Aufrufe zuweisen. 
In Kombination mit der `@Params` Annotation lassen sich auf diese Weise komplexe Queries aufbauen, die abhängig von den Parametern der 
annotierten Methode sind.

```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Query("SELECT * FROM User u")
    Collection<User> getUsers();
    
    @Query("SELECT * FROM User u WHERE u.name = :name")
    User getUserByName(@Param("name") String name);
}
```
Neben der JPQL lassen sich durch die Angabe des `nativeQuery` Parameters außerdem native SQL Queries verwenden.
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Query("SELECT * FROM User u")
    Collection<User> getUsers();
    
    @Query("SELECT * FROM User u WHERE u.name = :name")
    User getUserByName(@Param("name") String name);
    
    @Query(value="SELECT AVG(u.age) FROM User u", nativeQuery=true)
    int getAverageAge();
}
```

### @Procedure
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Procedure(name="CountByAge")
    int countByAge(@Param("age") int age);    
}
```
Durch die `@Procedure` Annotation lassen sich aus einem Repository heraus Stored Procedures aufrufen und gegebenenfalls Parameter übergeben.
Die Stored Procedure muss zuvor auf der `Entity`-Klasse mithilfe der `@NamedStoredProcedureQuery` Annotation definiert werden.

```java
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "CountByAge",
                procedureName = "user.count_by_age",
                parameters = {
                        @StoredProcedureParameter(
                                name = "age",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "count",
                                type = Integer.class,
                                mode = ParameterMode.OUT
                        ),
                }
        )
})
public class User {
    //...
}
```


### @Lock
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Lock(LockModeType.NONE)
    @Query("SELECT * FROM User u")
    Collection<User> getUsers();
}
```
Mit der `@Lock` Annotation lässt sich das Sperrverhalten beim Ausführen der annotierten Methode bestimmen.

### @Modifying
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    void setUsername(@Param("id") long id, @Param("name") String name);
}
```
Damit eine Repository-Methode Daten in der Datenbank modifizieren kann, muss diese mit der `@Modifying` Annotation versehen werden. 


### @EnableJpaRepositories
```java
@Configuration
@EnableJpaRepositories
public class JPAConfig {
    
}
```
Um JPA Repositories nutzen zu können, muss eine Konfigurationsklasse mit der `@EnabledJpaRepositories` Annotation annotiert werden.
Ausgehend von der annotierten Konfigurationsklasse wird Spring nach Repositories suchen. Durch den Parameter `basePackage`lässt sich dieses Verhalten jedoch anpassen.  
