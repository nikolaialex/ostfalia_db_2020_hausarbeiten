# Query Methods

## Erzeugung von Query über Methodennamen

Wie bereits in Kapitel 5.x beschrieben, kann man über den Methodennamen, wenn die Konventionen richtig eingehalten Queries erzeugen ohnen zusätzlichen Sql-Code zu hinterlegen.




## JPA Named Queries

```java
@Entity
@NamedQuery(name = "Stock.findByCompanyName",
  query = "select s from Stock s where s.companyName = ?1")
public class Stock {

}
```

## Annotation @Query


Diese Queries haben Vorrang vor NamedQuery

```Java
public interface StockRepository extends JpaRepository<Stock, Long> {

  @Query("select s from Stock s where s.companyName = ?1")
  Stock findByCompanyName(String findByCompanyName);
}
```

## Named Parameters

```java

public interface StockRepository extends JpaRepository<Stock, Long> {

  @Query("select s from Stock s where s.companyName = :companyName or s.wkn = :wkn")
  User findByLastnameOrFirstname(@Param("wkn") String wkn,
                                 @Param("companyName") String companyName);
}

```
