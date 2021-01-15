# 5 Repository und Queries

## 5.1.Einleitung
Die nächsten zwei folgenden Kapitel befassen sich mit den Themen Repository und Queries in der Spring Data JPA - Umgebung. Um ein besseres Verständnis zu erlangen, was diese abstrakten Begriffe darstellen, sollen deren wichtigsten Eigenschaften  vorgestellt und ihre Verwendung und Implementierung anhand von Code-Snippets verdeutlich werden, um einen besseren Bezug zu bekommen.

Das Ziel der Spring Data Repository-Abstraktion besteht darin, die Menge an Boilerplate-Code, die zum Implementieren von Datenzugriffsschichten für verschiedene Persistenzspeicher erforderlich ist, erheblich zu reduzieren[1]. Diese Aussage ist absolut zutreffend, was Spring Data JPA und ihr Repository so besonders machen. Im Vergleich zum Data Access Object Pattern, das auch sehr gerne zur Persistierung von Entitäten genutzt wird, hat man mit Hilfe des Repository-Patterns sprichwörtlich ein viel leichteres Spiel. Spring Data JPA Repositories erleichtern nämlich dem Entwickler die Arbeit sehr. Mit der Implementierung des Repository sind es deutlich weniger Schritte, die er zu erfüllen hat, um das gleiche Ergebnis zu erlangen wie beim DAO-Pattern.
In Kapitel 5.2 soll auf die Implementierung zur Persisitierung mittels des DAO-Patterns eingegangen werden, da es in der Vergangenheit große Verwendung fand. Danach soll im nächsten Kapitel 5.3 das gleiche Ergebnis mittels Spring Data JPA Repository erzielt werden. Ziel ist es, zu verdeutlichen, wo genau die Unterschiede aber auch Gemeinsamkeiten liegen, die in Kapitel 5.4 genauer beschrieben werden, und im Besonderen wieviel weniger Code man schreiben muss, weil die Arbeit jetzt zum größten Teil von Spring Data JPA (im Hintergrund) übernommen wird. Spring Data JPA findet immer mehr Anklang und wir möchten gerne zeigen, warum dies so ist.
Das Kapitel 5.5 "JPARepository" befasst sich dann ausführlich mit dem Thema Repository in Spring Data JPA und benennt dessen Bestandteile. Kapitel 5.6 befasst sich dann ausführlich mit dem Thema Queries.


## 5.2 DAO Pattern

Als erstes brauchen wir eine Entity-Klasse, sie bildet die Modelschicht. In unserem Beispiel besitzt die Entity-Klasse Stock neben ihrem Primärschlüssel *id* noch die Attribute *wkn*, das für die Wertpapierkennnummer der Aktie steht und der Firmenname.

***Entity-Class Stock***

```Java
@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * wkn Wertpapierkennnummer
     */
	private String wkn;
	private String companyName;

	public Stock(){

	};

	public Stock(String wkn, String companyName) {
		this .wkn = wkn;
		this.companyName = companyName;
	}

	public String getWkn() {
		return wkn;
	}

	public void setWkn(String wkn) {
		this.wkn = wkn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
  ```
#### DAO-Pattern


Das Interface StockDAO bildet die Verbindungsstelle zwischen Persistenz- und Modelschicht. Dadurch werden Entities, hier Objekte der Klasse Stock von der Persistenzschicht entkoppelt. Sie beinhaltet nur CRUD-Methoden(CREATE, READ, UPDATE and DELETE).

Hier ist die DAO-API:


***The DAO API***
  ```Java
  public interface StockDao<T> {

      Optional<T> get(long id);

      List<T> getAll();

      void save(T t);

      void update(T t, String[] params);

      void delete(T t);
  }
  ```
  ***The JpaStockDao Class***
  ```Java
  public class StockDAOImpl implements StockDAO<Stock> {

    private EntityManager em;

    // standard constructors

    public  StockDAOImpl() {
		// TODO Auto-generated constructor stub
    	EntityManagerFactory emfactory = Persistence.
    		      createEntityManagerFactory( "myJPA" );
    		      em = emfactory.
    		      createEntityManager( );
	}

    @Override
    public Stock get(long id) {
        return em.find(Stock.class, id);
    }

    @Override
    public List<Stock> getAll() {
        Query query = em.createQuery("SELECT a FROM Stock a");
        return query.getResultList();
    }

    @Override
    public void save(Stock stock) {
        execute(em -> em.persist(stock));
    }

    @Override
    public void update(Stock stock, String[] params) {
    	stock.setCompanyName(Objects.requireNonNull(params[0], "Companyname can not be null"));
        execute(em -> em.merge(stock));
    }

    @Override
    public void delete(Stock stock) {
        execute(em -> em.remove(stock));
    }

	@Override
	public List<Stock> findByWkn(@PathVariable("wkn") String wkn) {
		 Query query = em.createQuery("SELECT c FROM Stock c WHERE c.wkn='"+wkn+"'");
		 List<Stock> list =query.getResultList();
	     return list;
	}

	@Override
	public List<Stock> findByCompanyName(String companyName) {
		Query query = em.createQuery("SELECT c FROM Stock c WHERE c.wkn='"+companyName+"'");
		List<Stock> list =query.getResultList();
		return list;
	}

    private void execute(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
  ```
***persistence.xml***

Die Datei persistence.xml ist eine Konfigurationsdatei und hält unter anderem folgende Daten bereit:

- Name der Persistence-Unit --> myJPA
- Klassen, die in die Datenbank gemappt werden sollen -->  Class Stock
- DB- Verbindungsparameter --> Embedded-DB vom Typ H2
- etc.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
	xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
    http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	<persistence-unit name="myJPA"
		transaction-type="RESOURCE_LOCAL">
		<class>de.volkan.brokerage.service.dao.Stock</class>
		<properties>
			<property name="javax.persistence.jdbc.url"
				value="jdbc:h2:file:./database2" />
			<property name="javax.persistence.jdbc.user" value="sa" />
			<property name="javax.persistence.jdbc.password" value="" />
			<property name="javax.persistence.jdbc.driver"
				value="org.h2.Driver" />
			<property name="hibernate.hbm2ddl.auto" value="create" />
		</properties>
	</persistence-unit>
</persistence>

```

### Operationen Ausführen
```java
public class DAOApp {

    private static StockDAO<Stock> jpaStockDao = new StockDAOImpl();

    public static void main(String[] args) {

    	jpaStockDao.save(new Stock("Infineon", "623100"));
    	Stock stock1 = jpaStockDao.findByCompanyName("Infineon").get(0);
        System.out.println(stock1);
        stock1.setCompanyName("Royal Dutch");
        stock1.setWkn( "A01ESR");
        jpaStockDao.update(stock1);
        jpaStockDao.save(new Stock("Deutsche Bank", "514000"));
        jpaStockDao.delete(jpaStockDao.get(2));
        jpaStockDao.getAll().forEach(stock -> System.out.println("Stockname:"+stock.getCompanyName()+ ", WKN: " + stock.getWkn()));
        if(jpaStockDao.findByWkn("623100")!=null) {
        	System.out.println("Company Deutsche Bank gefunden");
        }
    }
}

```




## JpaRepository


### Interface StockRepository
```Java
@Repository
@Service
public interface StockRepository extends JpaRepository<Stock, Long>{

	Stock findByWkn(String wkn);
	Stock findByCompanyName(String companyName);
}

```
<br>
<br>

***application.properties***


Die Datei application.properties ist eine Konfigurationsdatei in der Spring Umgebung und hält ebenfalls wie die persistence.xml DB-Daten bereit:

- ~~Name der Persistence-Unit --> myJPA~~
- ~~Klassen, die in die Datenbank gemappt werden sollen -->  Class Stock~~
- DB- Verbindungsparameter --> Embedded-DB vom Typ H2
- etc.

```java
#H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:file:./database2
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

```java
@SpringBootApplication
public class SpringRepositoryApp {

  private static final Logger log = LoggerFactory.getLogger(SpringRepositoryApp.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringRepositoryApp.class);
  }

  @Bean
  public CommandLineRunner demo(StockRepository repository) {
    return (args) -> {
    	repository.save(new Stock("Infineon", "623100"));
    	Stock stock1 = repository.findByCompanyName("Infineon");
        stock1.setCompanyName("Royal Dutch");
        stock1.setWkn( "A01ESR");
        repository.save(stock1);
        repository.save(new Stock("Deutsche Bank", "514000"));
        repository.delete(repository.findByCompanyName("Deutsche Bank"));
        repository.findAll().forEach(stock -> System.out.println("Stockname:"+stock.getCompanyName()+ ", WKN: " + stock.getWkn()));
        if(repository.findByWkn("623100")!=null) {
        	System.out.println("Company Deutsche Bank gefunden");
        }
    };
  }

}
```
