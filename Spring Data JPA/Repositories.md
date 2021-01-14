# Repository und Queries

Die nächsten zwei folgenden Kapitel befassen sich mit den Themen Repository und Queries in der Spring Data JPA - Umgebung. Um ein besseres Verständnis zu erlangen, was diese abstrakten Begriffe darstellen, sollen zuerst deren wichtigsten Eigenschaften allgemein vorgestellt werden. Parallel zu diesen Eigenschaften soll dann immer wieder ihre Verwendung und Implementierung anhand von Code-Snippets verdeutlich werden, um einen besseren Bezug zu bekommen.


## Repository

Das Ziel der Spring Data Repository-Abstraktion besteht darin, die Menge an Boilerplate-Code, die zum Implementieren von Datenzugriffsschichten für verschiedene Persistenzspeicher erforderlich ist, erheblich zu reduzieren[1]. Dies ist eine Aussage, die Spring Data JPA und ihr Repository so besonders machen. Im Vergleich zum DAO-Pattern zur Persistierung von Entitäten, wird einem mit Hilfe des Repository-Musters die Arbeit sprichwörtlich abgenommen. Spring Data JPA erleichtert dem Entwickler die Arbeit sehr. Hält er sich an die Implementierung des Repository nach den Spring JPA Richtlinien, sind es deutlich weniger Schritte, die er zu erfüllen hat, um das gleiche Ergebnis zu erlangen wie beim DAO-Pattern.
Im ersten Schritt soll auf die Implementierung zur Persisitierung mittels DAO-Klassen eingegangen werden, um danach das gleiche Ergebnis mittels Spring Data JPA Repository. Dabei soll verdeutlicht werden, wieviel mehr Code man schreiben muss und wieviel von Spring Data JPA automatisch übernommen wird.


  **DAO-Pattern**

  ***Entity-Class Stock***

```Java
@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * wkn Wertpapierkennnummer
     */
	private String wkn;

	public String getWkn() {
		return wkn;
	}

	public void setWkn(String wkn) {
		this.wkn = wkn;
	}
}
  ```

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

    @Override
    public Optional<Stock> get(long id) {
        return Optional.ofNullable(em.find(Stock.class, id));
    }

    @Override
    public List<Stock> getAll() {
        Query query = em.createQuery("SELECT a FROM Stock a");
        return query.getResultList();
    }

    @Override
    public void save(Stock stock) {
        executeInsideTransaction(entityManager -> entityManager.persist(stock));
    }

    @Override
    public void update(Stock stock, String[] params) {
        stock.setWkn(Objects.requireNonNull(params[0], "WKN cannot be null"));
        executeInsideTransaction(action -> em.merge(stock));
    }

    @Override
    public void delete(Stock stock) {
        executeInsideTransaction(action -> em.remove(stock));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
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
