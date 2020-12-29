## Philipp



#Annotationen

TODO: Einleitender Text für Annotationen


##Grundlegende Spring Data Annotationen

###@SpringBootApplication  

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

###@Bean

```java
import java.util.logging.Logger;
import java.util.logging.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

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






#Common Spring Data Annotations

###@EnableTransactionManagement

```java
@Configuration
@EnableTransactionManagement
public class MyConfiduration {
    //Configuration Beans
}
```
Die `@EnableTransactionManagement` Annotation stellt die Voraussetzung für die nachfolgende `@Transactional` Annotation dar.
Sie wird auf Klassenebene an einer Konfigurationsklasse angewandt und sorgt dafür, dass das manuelle Steuern von Transaktionen möglich wird.

###@Transactional
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


###@NoRepositoryBean

```java
import java.util.Optional;

@NoRepositoryBean
interface MyBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    Optional<T> findById(ID id);
}

@Repository
interface MyChildRepository extends MyBaseRepository<Thing, Long>{}
```
Die `@NoRepositoryBean` Annotation sorgt dafür, dass auf Basis des annotierten Interfaces, welches ein Spring Data Repository erweitert, kein Bean erstellt wird.
Dies ist besonders dann nützlich, wenn alle eigenen Repositories auf einem `BaseRepository` basieren sollen: Nur für die Repositories, die auf dem `BaseRepository` basieren, werden Beans erzeugt. 

###@Param
```java

```

@Id

@Transient

@CreatedBy

@LastModifiedBy

@CreatedDate

@LastModifiedDate

#Most common Spring Data JPA annotations:

@Entity

@GeneratedValue

@Query

@Procedure

@Lock

@Modifiying

@EnableJpaRepositories

