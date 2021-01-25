# 6. Query Methods

## Abgeleitet vom Methodennamen

In diesem Kapitel möchten wir gerne zeigen, welche Möglichkeiten Spring Data JPA einem bietet, Queries bzw. Datenbankabfragen auf Entitäten zu definieren. Beginnen möchten wir mit dem Beispiel aus Kapitel 5.4. Mit Hilfe von Schlüsselwörtern und Klassenattributen *companyName* und *wkn* war es uns möglich, im Repository genau die Methoden *findByWkn* und *findByCompanyName* zu definieren. Spring Data JPA übersetzt dann diese Methodennamen in die Java eigene Persist Query Language JPQL und liefert uns das gewünschte Ergebnis zurück, hier war es jeweils ein Objekt vom Typ *Stock*.
Die folgende Tabelle zeigt einige weitere Beispiele, wie schnell und einfach es ist, solche Methoden im Repository-Interface zu implementieren:

Schlüsselwort | Beispiele für Methodennamen | JPQL Auszug
-|-|-
Distinct|findDistinctByCompanyNameAndWkn | select distinct …​ where x.companyName = ?1 and x.wkn = ?2
And|findByCompanyNameAndWkn|… where x.companyName = ?1 and x.wkn = ?2
Or|findByCompanyNameOrWkn|… where x.companyName = ?1 or x.wkn = ?2
Is, Equals|findByFirstname,findByFirstnameIs,findByFirstnameEquals|… where x.firstname = ?1
Between|findByStartDateBetween|… where x.startDate between ?1 and ?2
LessThan|findByAgeLessThan|… where x.age < ?1
LessThanEqual|findByAgeLessThanEqual|… where x.age <= ?1
OrderBy|findByAgeOrderByLastnameDesc|… where x.age = ?1 order by x.lastname desc

Tabelle 6-1 *Schlüsselwörter innerhalb des Methodennamens* [23]



## @NamedQuery

Ebenfalls ist es möglich, über Annotation eine so genannte NamedQuery zu definieren. Diese NamedQuery beinhaltet ein beliebiges JPQL-Statement und lässt sich dann im Repositoy mit genau dem gleichen Methodennamen implementieren.

```java
@Entity
@Table(name = "STOCK")
@NamedQuery(name = "Stock.findByCompanyNameUseNamedQuery",
query = "select s from Stock s where s.companyName = ?1")
public class Stock implements Serializable {

}
```
**NamedQuery Deklaration im Repository**

```Java
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	Stock findByCompanyNameUseNamedQuery(String companyName);
}
```

## @Query

Sehr einfach lassen sich JPQL-Statements mit Hilfe der Annotation @Query wie folgt umsetzen.

```Java
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	@Query("select s from Stock s where s.companyName = ?1")
	Stock findByXXX(String companyName);
}
```

Die Methode heißt zwar in diesem Beispiel *findByXXX*, aber sie führt exakt den gleichen JPQL-Statement aus wie im obigen Beispiel die Repository-Methode *finyByCompanyName*


## Named Parameters

"*Standardmäßig verwendet Spring Data JPA die positionsbasierte Parameterbindung, wie in allen vorhergehenden Beispielen beschrieben. Dies macht Abfragemethoden beim Refactoring bezüglich der Parameterposition etwas fehleranfällig. Um dieses Problem zu beheben, können Sie die Annotation @Param verwenden, um einem Methodenparameter einen konkreten Namen zu geben und den Namen in der Abfrage zu binden, wie im folgenden Beispiel gezeigt*"[21]:
```java

public interface StockRepository extends JpaRepository<Stock, Long> {

  @Query("select s from Stock s where s.companyName = :companyName or s.wkn = :wkn")
  User findByLastnameOrFirstname(@Param("wkn") String wkn,
                                 @Param("companyName") String companyName);
}
```
