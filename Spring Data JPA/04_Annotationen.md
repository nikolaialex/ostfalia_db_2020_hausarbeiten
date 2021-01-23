# 4. Annotationen

Spring Data erlaubt es durch seine Abstraktionsschicht mithilfe von Annotationen die Business-Logik von der unterliegenden Art der Persistierung zu trennen.
Annotationen können sowohl auf der Klassenebene als auch auf der Methoden-, Feld- oder Parameterebene angewendet werden.
Die wichtigsten Annotationen werden an dieser Stelle vorgestellt und knapp erläutert.

## 4.1 Wichtige Annotationen

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
  
[22]

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
[22]

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
[24]

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
[16]  


### @Repository und @NoRepositoryBean

```java
@Repository
interface MyChildRepository extends MyBaseRepository<Thing, Long>{}

@NoRepositoryBean
interface MyBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Optional<T> findById(ID id);
}
```
Durch die `@Repository` Annotation wird aus einem Interface zur Laufzeit ein RepositoryBean generiert.  
Die `@NoRepositoryBean` Annotation sorgt dafür, dass auf Basis des annotierten Interfaces, welches ein Spring Data Repository erweitert, kein Bean erstellt wird.
Dies ist besonders dann nützlich, wenn alle eigenen Repositories auf einem `BaseRepository` basieren sollen: Nur für die Repositories, die auf dem `BaseRepository` basieren, werden Beans erzeugt.  
[16]

### @Query und @Param
```java
@Repository
public class UserRepository extends MyBaseRepository{
    @Query("SELECT * FROM User u")
    Collection<User> getUsers();
}
```
Mit der `@Query` Annotation lassen sich Repository Methoden JPQL (Java Persistence Query Language) Aufrufen zuweisen.
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
[16]

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
[16]

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
[16]

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
[16]

### @EnableJpaRepositories
```java
@Configuration
@EnableJpaRepositories
public class JPAConfig {
    
}
```
Um JPA Repositories nutzen zu können, muss eine Konfigurationsklasse mit der `@EnabledJpaRepositories` Annotation annotiert werden.
Ausgehend von der annotierten Konfigurationsklasse wird Spring nach Repositories suchen. Durch den Parameter `basePackage`lässt sich dieses Verhalten jedoch anpassen.  
[16]

## 4.2 Model Annotationen

Spring Data bietet neben den bereits vorgestellten Annotationen, die sich hauptsächlich auf die Konfiguration der Anwendung beziehen, ebenfalls eine Reihe von hilfreichen Annotationen an, die es erlauben
Modellklassen zu konfigurieren, sodass diese unabhängig von der unterliegenden Implementierung sind.  

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
Durch die `@Entity` Annotation lässt sich eine JPA Entity erzeugen, die in der Datenbank gespeichert werden kann. Eine Klasse, die mit `@Entity` annotiert wurde, stellt eine Tabelle innerhalb der Datenbank dar, wobei jede Instanz der Klasse einen Eintrag innerhalb dieser Tabelle widerspiegelt.  
Von der Struktur her ist eine Entity-Klasse mit einem POJO zu vergleichen, wobei die Entity-Klasse durch die nachfolgend erklärten Annotationen erweitert werden kann.
JPA benötigt einen leeren Constructor, weshalb jede mit `@Entity` annotierte Klasse einen leeren Default-Constructor vorweisen muss.  
[17]

### @Id und @GeneratedValue
```java
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    protected User(){}
}
```
Die `@Id` Annotation sorgt dafür, dass das annotierte Feld als Primärschlüssel gespeichert wird. Die `@Id` Annotation wird von der `@Entity` Annotation zwingend vorausgesetzt.  
Durch Verwendung der `@GeneratedValue` Annotation kann bestimmt werden nach welcher Strategie der Primärschlüssel automatisch generiert wird.
Zu diesem Zweck gibt es vier Möglichkeiten:
- GenerationType.AUTO (Default) lässt die Persistenzschicht automatisch eine Strategie wählen. Für die meistverbreiteten Datenbanken wird GenerationType.SEQUENCE gewählt
- GenerationType.IDENTITY verwendet ein automatisches Inkrement einer Spalte, um eine eindeutige ID zu erzeugen.
- GenerationType.SEQUENCE nutzt eine Datenbanksequenz, um einen neuen Wert für das Feld zu ermitteln
- GenerationType.TABLE simuliert eine Datenbanksequenz, bremst allerdings durch pessimistisches Sperren das System aus  
  
[17]

### @Table
```java
@Entity
@Table(name="UserData")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    protected User(){}
}
```
Für den Fall, dass der Name der mit `@Entity` annotierten Klasse nicht mit dem Namen der repräsentierten Tabelle übereinstimmt, lässt sich die Klasse zusätzlich mit der `@Table` Annotation versehen, die eine erweiterte Konfiguration des Mappings erlaubt. Durch den Parameter `name` lässt sich ein beliebiger Tabellenname für die Entity verwenden und der Parameter `schema` erlaubt eine weitere Spezifikation, um problemlos mehrere Schemata verwenden zu können.  
[17]

### @Column
```java
@Entity
@Table(name="UserData")
public class User {
    @Id
    @GeneratedValue
    @Column(name="User_ID")
    private Long id;

    protected User(){}
}
```
Ähnlich wie die `@Table` Annotation erlaubt es die `@Column` Annotation weitere Informationen über die referenzierte Spalte bereitzustellen. Neben dem `name` Parameter, der den Namen der Spalte in der Tabelle auf der Datenbank angibt, lassen sich durch die weiteren Parameter `length`, `nullable` oder `unique` die entsprechenden Spalteneigenschaften bestimmen.  
[17]

### @Transient

```java
@Entity
@Table(name = "UserData")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "User_ID")
    private Long id;

    protected User() {
    }

    @Transient
    private int randomField; 
}
```
Durch Verwendung der `@Transient` Annotation wird das annotierte Feld weder aus der Datenbank gelesen, noch in diese geschrieben. Das Feld wird dementsprechend nicht persistiert. Diese Annotation ist besonders hilfreich, wenn eine Entity-Klasse um weitere Funktionen erweitert werden soll, die für die Erweiterungen verwendeten Felder jedoch nicht in der Datenbanktabelle vorhanden sind.  
[17]

### @CreatedBy, @CreatedDate, @LastModifiedBy und @LastModifiedDate

Die Annotationen `@CreatedBy`, `@LastModifiedBy`, `@CreatedDate` und `@LastModifiedDate` ermöglichen es, die annotierten Felder automatisch durch Spring mit den korrekten Werten füllen zu lassen.
```java
@Entity
@Table(name = "UserData")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "User_ID")
    private Long id;

    protected User() {
    }

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
[16]