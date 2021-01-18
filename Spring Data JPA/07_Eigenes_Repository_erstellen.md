# Ein eigenes Repository erstellen

Unter bestimmten Bedingungen kann es sinnvoll sein, ein eigenes Verhalten für Repositories zu implementieren.
Um dieses Ziel zu erreichen, bietet Spring Data zwei Ansätze. Zum einen lässt sich das Verhalten eines einzelnen Repositories anpassen und 
zum anderen das Verhalten aller Repositories.

## Einzelnes Repository anpassen

Ein einzelnes Repository lässt sich durch die Definition von Methoden oder Feldern in Interfaces erweitern.

```java
public interface CustomRepository {
    
    void customMethod();
    
}
```

Ein solches Interface kann von dem eigentlichen Repository-Interface vererbt werden, um dieses um die gewünschten Funktionalitäten zu erweitern.
Alternativ ist es auch möglich, dass die Implementierung des Interfaces dieses implementiert.

```java
public interface MyRepository extends CrudRepository, CustomRepository {
    
}
//oder
public class MyRepository implements CustomRepository {
    void customMethod(){
        //custom stuff
    }
}

```

## Alle Repositories anpassen
Eine weitere Möglichkeit um ein Repository zu erweitern, liegt darin ein grundlegendes Repository-Interface zu definieren, auf dem alle verwendeten Repositories basieren.

```java
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    void customMethod();
}
```
Alle eigens definierten JpaRepositories müssen nun anstatt des normalen Repository-Interfaces die Implementierung des CustomRepository-Interfaces erweitern:

```java
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository {

    private EntityManager entityManager;
    
    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
    
    public void customMethod(){
        //Custom stuff
    }
}
```

Entsprechend dem normalen Verhalten von Spring wird für jedes Repository-Interface automatisch eine Implementierung erzeugt. Da das erstellt `CustomRepository`-Interface jedoch in diesem Fall kein 
eigenes Repository darstellt, sondern lediglich andere Repositories auf diesem Interface basieren sollen, muss durch die `@NoRepository` Annotation verhindert werden, dass Spring für dieses Interface
automatisch eine Implementierung erzeugt.  
  
Da das erstellte `CustomRepository`-Interface als Grundlage für alle weiteren erstellen Repositories dienen soll ist es notwendig, die standardmäßig verwendete Repository-Factory mit einer eigenen
Implementierung zu überschreiben. Zu diesem Zweck wird eine eigene `RepositoryFactoryBean`-Klasse erstellt:

```java
public class CustomRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {
    
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomRepositoryFactory(entityManager);
    }

    private static class CustomRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

        private EntityManager entityManager;

        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

        protected Object getTargetRepository(RepositoryMetadata metadata) {
            return new CustomRepositoryImpl<T, I>((Class<T>) metadata.getDomainClass(), entityManager);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepository.class;
        }
    }
}
```

Um die neue Repository-Factory zu verwenden, muss diese nun nur noch in der Konfigurationsklasse innerhalb der `@EnableJpaRepositores` Annotation referenziert werden:
```java
@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class ConfigurationClass{}
```



---

- https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html