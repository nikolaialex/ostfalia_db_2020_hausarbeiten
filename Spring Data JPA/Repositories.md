  # Repositories und Queries

  Die nächsten zwei folgenden Kapitel befassen sich mit den Themen Repositories und Queries in der Spring Data JPA - Umgebung. Um ein besseres Verständnis zu erlangen, was diese abstrakten Begriffe darstellen, sollen zuerst deren wichtigsten Eigenschaften allgemein vorgestellt werden. Parallel zu diesen Eigenschaften soll immer wieder ihre Verwendung und Implementierung anhand von Code-Snippets verdeutlich werden, um einen besseren Bezug zu bekommen.


  ## Funktion von Repositories

  Das Ziel der Spring Data Repository-Abstraktion besteht darin, die Menge an Boilerplate-Code, die zum Implementieren von Datenzugriffsschichten für verschiedene Persistenzspeicher erforderlich ist, erheblich zu reduzieren[1]. Dies ist eine Aussage, die Spring Data JPA und ihr Repository so besonders machen. Im Vergleich zum DAO-Pattern zur Persistierung von Entitäten, wird einem mittels des Repository-Musters quasi die Arbeit abgenommen. Spring Data JPA erleichtert dem Entwickler die Arbeit sehr. Hält er sich an die Implementierung des Repository nach den Spring JPA Regeln,sind es deutlich weniger Schritte, die er zu erfüllen hat, um das gleiche Ergebnis zu erlangen wie beim DAO-Pattern.
  Im ersten Schritt soll kurz die Implementierung mittels DAO-Klassen erfolgen, danach per Spring Data JPA Repository. Dabei wird klar, wieviel mehr Code man schreiben muss und diese Arbeit von Spring Data JPA übernommenw wird.


  **DAO-Pattern**

  ***Entity-Class Stock***

  ```Java

  @Entity
  @Table(name = "stocks")
  public class Stock {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private long id;

  	private String wkn;

      // standard constructors / setters / getters
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

      private EntityManager entityManager;

      // standard constructors

      @Override
      public Optional<Stock> get(long id) {
          return Optional.ofNullable(entityManager.find(Stock.class, id));
      }

      @Override
      public List<Stock> getAll() {
          Query query = entityManager.createQuery("SELECT e FROM Stock e");
          return query.getResultList();
      }

      @Override
      public void save(Stock stock) {
          executeInsideTransaction(entityManager -> entityManager.persist(stock));
      }

      @Override
      public void update(Stock stock, String[] params) {
          stock.setWkn(Objects.requireNonNull(params[0], "WKN cannot be null"));
          executeInsideTransaction(entityManager -> entityManager.merge(stock));
      }

      @Override
      public void delete(Stock stock) {
          executeInsideTransaction(entityManager -> entityManager.remove(stock));
      }

      private void executeInsideTransaction(Consumer<EntityManager> action) {
          EntityTransaction tx = entityManager.getTransaction();
          try {
              tx.begin();
              action.accept(entityManager);
              tx.commit();
          }
          catch (RuntimeException e) {
              tx.rollback();
              throw e;
          }
      }
  }


  ```
