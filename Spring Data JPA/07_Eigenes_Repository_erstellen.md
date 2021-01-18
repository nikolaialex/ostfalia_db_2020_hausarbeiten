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
<a name="1"></a>
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

Außerdem wird eine eigene Implementierung eines Repository-Factory-Beans benötigt.

```java
public class MyRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {
    
}
```

---

- https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html