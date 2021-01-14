# Object Relational Mapping
Viele moderne Business-Anwendungen verwenden objektorientierte Programmiersprachen in Verbindung mit relationalen Datenbanken. Objekte aus der Anwendung werden hierbei über die Laufzeit des Programms hinaus in einer Datenbank abgelegt, um diese für einen späteren Zugriff verfügbar zu machen. Dieser Vorgang wird Persistieren genannt. Die Java Persistence API (JPA) ist eine Schnittstelle, um die Übertragung von Objekten zu Tabellen zu vereinfachen und zu standardisieren.

Diese Schnittstelle ist notwendig, da Objekte und Relationen grundsätzlich verschiedene Paradigmen besitzen und von Natur aus nicht gut miteinander vereinbar sind. Es müssen so genannte "Mappings" eingesetzt werden, um Objekte auf Relationen abzubilden und umgekehrt. Um die objektrelationalen Mapper bereitzustellen, existieren für Java mehrere Frameworks und Bibliotheken, wie beispielsweise Hibernate und EclipseLink. Diese Frameworks implementieren die von der Spezifikation JPA vorgegebenen Richtlinien und Regeln [9].

## Die objektrelationale Unverträglichkeit
Objektorientierte Programmiersprachen basieren auf Konzepten des Software Engineerings und bilden Daten in Form von Objekten ab, welche miteinander verbunden sind. Relationale Datenbanken wiederum basieren auf mathematischen Prinzipien, mithilfe der relationalen Algebra werden die Daten in Tabellenform repräsentiert. Dieser grundlegende Unterschied beider Konzepte wird allgemein als objektrelationale Unverträglichkeit (engl. "Object-Relational Impedance Mismatch") bezeichnet.

Bereits am Beispiel von Datentypen werden die Unterschiede beider Konzepte deutlich:  

| Java       | Oracle     |
| :------------- | :----------: |
| String | varchar   |
| int   | smallint |
| Collections | Tabellen   |
| Objekte   | BLOBs |

Während einfache Datentypen wie *String* und *varchar* sehr einfach zu konvertieren sind, so sind beispielsweise *Collections/Tabellen* weniger eindeutig wandelbar.  

Bei genauerer Betrachtung ergeben sich 5 Probleme durch die konzeptionellen Unterschiede:  
**Granularität:** Stellt man dieselbe Datenstruktur dar, so kann es passieren, dass im Objekt-Modell mehr Klassen existieren als Tabellen im Relationen-Modell. Man sagt, das Objekt-Modell ist feinkörniger.    
**Vererbung:**  Das Objekt-typische Vererbungsmodell existiert in der Tabellenform nicht.  
**Identität:**  In einer Tabelle definiert allein der Primärschlüssel die Identität. Das Objekt-Modell definiert jedoch sowohl *Identität (foo==bar)* als auch *Gleichheit* (foo.equals(bar)).  
**Assoziation:** Tabellen nutzen Fremdschlüssel, während Assoziationen zwischen Objekten mit Referenzen (uni- oder bidirektional) gearbeitet wird.  
**Daten-Navigation:** Um an bestimmte Daten zu gelangen, wird innerhalb von Objekten und deren Beziehungen zum gewünschten Objekt navigiert. In Relationen wird mit Joins gearbeitet, um Tabellen zu verknüpfen und die gewünschte Information aus der neuen Tabelle ausgelesen.  

Die folgende Abbildung verdeutlicht die Unterschiede beider Paradigmen auf andere Weise, und zwar auf verschiedenen Ebenen: der konzeptuellen, sprachlichen, schematischen und der Instanz-Ebene:  

![](Abbildungsverzeichnis/mismatch.png) [5]

Um all diesen Widersprüchen entgegen zu wirken, existieren verschiedene Lösungsansätze, beispielsweise können die Objekte und Klassen der Programmiersprache in einer *objektorientierten* statt relationalen Datenbank abgelegt werden. Dieser Ansatz ist einfach und direkt, kann aber zu Performance-Einbußen bei komplexen Datenabfragen führen. Weitere Möglichkeiten sind die Verwendung eines objektrelationalen Datenbanksystems (ORDBRMS) oder die Erweiterung der Programmiersprache um relationale Funktionen, was jedoch die Programmierung einschränken kann.  

Das **objektrelationale Mapping bzw. Abbildung** beschreibt den letzten Lösungsansatz: Hier wird eine weitere Schicht zwischen den Daten und der Anwendung hergestellt, welche Objekte und Tabellen miteinander kompatibel macht und verknüpft. Dadurch können sowohl die Programmiersprache als auch die Datenbank in ihrer Form bestehen bleiben.  

## Objektrelationale Abbildung
Die einfachste Abbildung einer Klasse zu einer Tabelle wäre eine direkte *eins-zu-eins-Abbildung*, das heißt, eine Klasse bzw. Objekt wird auf genau eine Tabelle im Datenbankschema gemappt, und jedes Attribut der Klasse wird durch eine Reihe in der Tabelle repräsentiert. Diese sehr einfache Abbildung ist jedoch, außer bei sehr simplen Datenbanken, selten zu erreichen.  
Nachfolgend ist eine einfache Datenstruktur abgebildet, um die strukturellen Unterschiede zu verdeutlichen:  

![](Abbildungsverzeichnis/2models.png)

Die Objekt-Attribute Vorname und Nachname können wie oben beschrieben eins zu eins als Tabellenreihe abgebildet werden. Jedoch sind im Tabellenschema Primärschlüssel vonnöten, um jede Reihe/jeden Datensatz in der Tabelle eindeutig identifizieren zu können. Um Verweise auf andere Tabellen herstellen zu können und damit Relationen auszudrücken, sind Fremdschlüssel vorgesehen.

### Shadow Information
Da Primärschlüssel per se im objektorientierten Schema nicht existieren, müssen diese Informationen hinzugefügt werden, um die Eindeutigkeit von Objekten auf Persistenz-Ebene sicher zu stellen. Zusätzlich müssen noch Timestamps oder Increment Counters hinzugefügt werden, um gleichzeitige Zugriffe auf das selbe Objekt zu verhindern (Zugriffssteuerung), oder Versionsnummern. All diese Informationen, welche über die regulären Daten des Objektes hinausgehen, werden **Schatteninformationen** genannt. Diese sind zwingend notwendig, um ein Objekt erfolgreich persistieren zu können.

### Mapping von Vererbung
Das Konzept der Vererbung ist prinzipiell nicht in relationalen Datenbanken vorhanden. Um diese Strukturen erfolgreich abzubilden, gibt es mehrere Möglichkeiten:

**Abbildung der gesamten Klassenhierarchie auf eine Einzeltabelle:** Alle Attribute und Klassen werden in einer einzelnen Tabelle abgebildet. Simpelstes Verfahren. Schneller Datenzugriff, neue Klassen können schnell hinzugefügt werden, da nur neue Spalten erzeugt werden müssen. Für simple Klassenhierarchien zu empfehlen.  
**Abbildung jeder konkreten Klasse in eine eigene Tabelle:** Es werden nur Tabellen für die Unterklassen angelegt. Die Attribute der Basisklasse werden in jede Tabelle übernommen. Zu empfehlen, wenn Objekte nur selten geändert werden, oder wenig Überlappung existiert.  
**Abbildung jeder Klasse in eine eigene Tabelle:** Die Basisklasse sowie Unterklassen werden je in einzelnen Tabellen abgebildet. Wenn viel Überlappung zwischen den Typen existiert oder diese häufig geändert werden.  
**Abbildung der Klassen in eine generische Tabellen:** Es werden genau 5 Tabellen angelegt: Attribute, Instanzen, Klassen, Beziehungen, Attributwerte. Für sehr komplexe Anwendungen mit wenig Daten.  

### Mapping von Beziehungen
Es gibt 3 grundlegend verschiedene Beziehungen, welche beim Mapping berücksichtigt werden müssen. Diese werden im Relationen-Modell anders implementiert als im Objekt-Modell. Ein prinzipieller Unterschied ist, dass das Relationen-Modell keine unidirektionalen Assoziationen kennt, all Beziehungen dort sind von Natur aus bidirektional [3].

**0/1...0/1 (Null oder eins zu Null oder eins):** In Tabellen werden diese mithilfe von Fremdschlüsselverweisen in beiden Tabellen und ggf. Not-Null Bestimmungen realisiert. Wird im Objekt-Modell mit Referenzen zu Objekten sowie *Getter*- und *Setter*-Methoden implementiert.  
**0/1...n (Null oder eins zu N):** Werden in Java mit Arrays oder HashSets implementiert. Mit Methoden wie *add()*, *set()*, *remove()* etc., werden die Arrays dynamisch geändert. In Tabellen genügt ein Fremdschlüssel in jener Tabelle, welche beliebig oft genannt werden soll, ggf. mit einer Not-Null Bestimmung.  
**n...n (N zu N):** In Tabellenform wird eine zusätzliche assoziative Tabelle benötigt, beispielsweise *meldet_an*. Mit gekreuzten Fremdschlüssel-Verweisen wird hierdurch eine *n...n*-Beziehung hergestellt. In Objektform werden hier ebenfalls Collections verwendet, hier jedoch beidseitig.  

Vorsicht ist zu genießen bei **Ordered Collections**, beispielsweise in einer Beziehung zwischen einer *Order* und *OrderItem* Klasse, in welcher die Reihenfolge der Elemente von Bedeutung ist: Soll eine solche Beziehung in Relationen-Form überführt werden, so muss eine extra Spalte erzeugt werden, welche diese Information trägt [3]. Zusätzlich müssen hierbei weitere Dinge beim Mapping beachtet werden, beispielsweise dass die Sequenz-Nummer nicht im Schlüssel abgelegt werden sollte, und dass eine zusätzliche *ORDER BY*-Anweisung im SQL Statement hinzugefügt werden muss, um die Daten auch in korrekter Reihenfolge anzuzeigen.

Weiterführende Themen beim Mapping stellen die Abbildung von **Class-Scopes** (Geltungsbereichen von Klassen), **rekursiven Beziehungen** (Objekte, welche beliebig viele Referenzen auf Objekte desselben Typs besitzen können), sowie **Performance-Tuning** dar.  

## Frameworks für Objektrelationale Abbildungen  
Da die JPA nur eine Spezifikation ist, kann diese Objekte nicht von sich aus persistieren. Die von der Spezifikation vorgegebenen Regeln müssen implementiert werden. Für Java existieren viele solcher Frameworks, an dieser Stelle soll eine kurze Übersicht und Vergleich der populärsten Frameworks **Hibernate** und **EclipseLink** erläutert werden [9].  

Grundsätzlich muss ein ORM-Framework folgende Leistungen zur Verfügung stellen:  
- eine API für CRUD-Operationen auf persistierten Objekten  
- eine API oder Sprache für Queries, welche sich auf Klassen und deren Attribute anwenden lässt
- ein Mapping der Metadaten zur Verfügung stellen

Es sollten außerdem weitere Optimierungsmechanismen vorhanden sein, wie beispielsweise **Lazy Loading** (welches entscheidet, ob auch zusätzlich die Subklasse zur Oberklasse geladen wird) und **Dirty Checking** (Wodurch Änderungen an einem Objekt automatisch in der DB gespeichert werden, wenn die Transaktion commited wird). [7]

### Hibernate  
Das 2001 erschienene Framework sitzt als zusätzliche Schicht zwischen Java und dem RDBMS und unterstützt eine Vielzahl von Datenbanksystemen, darunter *Oracle, PostgreSQL und MySQL*.  
Zusätzlich unterstützt Hibernate gängige Java-Technologien wie *Maven und XDoclet Spring* [8].  
Die Hauptaufgabe von Hibernate besteht im Abbilden/Mappen von Java-Objekten zu Relationen, dessen genereller Prozess oben ausführlich beschrieben wurde. Durch den Einsatz von Hibernate fällt für den Programmierer etwa 95% des Aufwandes von Persistenz-Aufgaben weg [8].

Ein Vorteil von Hibernate ist, dass das Mapping mit *XML-Dateien* konfiguriert wird, ohne zusätzlichen Code schreiben zu müssen. Weiterhin wird kein Applikationsserver benötigt (wie es etwa bei *JSP* der Fall war), und dass eine API bereitgestellt wird, welche die einfache Übertragung von Java-Objekten von und zur Datenbank vereinheitlicht.

JPA nutzt die *javax.persistence* Klassen, um zu definieren, welche Klassen persistiert werden sollen. Hibernate implementiert all diese Klassen, welche ansonsten vom Programmierer selbst implementiert werden müssten. Zusätzlich bietet Hibernate Funktionalitäten wie *Hibernate Tools, Validator*, und *Search*. Außerdem sind folgende Funktionen vorhanden:

- Die *org.hibernate.annotations.Entity* Klasse erlaubt Feintuning von Entitäten durch zusätzliche Metadaten
- Die *@Table* Annotation erlaubt es, den Relationen benutzerdefinierte Namen zu geben  
- Die *@SQLInsert*, *@SQLUpate* und  *@SQLDelete* Annotationen ermöglichen anpassbare CRUD Statements
- Die *@Immutable* Annotation erlaubt unveränderliche Entitäten  

### EclipseLink
Wie auch Hibernate implementiert EclipseLink die notwendigen JPA-Regeln. Zusätzlich dazu untersützt aber auch weitere Persitenz-Standards wie *Java Architecture for XML Binding (JAXB)*,
*Java Connector Architecture (JCA)* und *Service Data Objects (SDO)*.  

Beispielsweise werden mit der JAXB-Unterstützung die Objekte in eine XML-Repräsentation überführt.  
Weiterhin sind beispielsweise mit der *@ReadOnly* Annotation Entitäten möglich, welche nur gelesen werden können. *@Struct* wiederum bildet das Objekt innerhalb der Datenbank als *struct*-Typ ab. Beide Optionen werden von Hibernate nicht untersützt [9].  

Sollte Performanz im Vordergrund stehen, so lohnt sich ein Vergleich der beiden Frameworks, in welchen Hibernate in mehreren Punkten besser abschneidet als EclipseLink:  

**Performance-Vergleich von Hibernate und EclipseLink (mit MySQL):**

| Operation       | Hibernate     | EclipseLink     |
| :------------- | :----------: | :----------: |
| Persistieren | geringfügig besser   |    |
| Retrieval   |  | geringfügig besser |
| Query ausführen   | sehr viel besser |  |
| Update | äquivalent   | äquivalent   |
| Remove   | geringfügig besser |  |
| JPA DB Operationen   | geringfügig besser |  |

[11]

## Anbindung von JDBC und Unterschiede zu ORM Frameworks

Wird auf ein ORM-Framework verzichtet, so ist der Programmierer in der Verantwortung, das Mapping der Klassen und Objete hin zur relationalen Datenbank selber herzustellen bzw. zu verwalten. Nachfolgend soll eine "klassische" Anbindung einer Datenbank mit **JDBC** und deren interne Verdrahtung mit der von **Hibernate** verglichen werden:

### Java Database Connectivity (JDBC)
Die Schnittstelle/API JDBC bietet eine schnelle und einfache Anbindung an eine Datenbank und die Möglichkeit, Queries auf dieser auszuführen. JDBC ist in der JavaSE integriert und muss lediglich über

````java
import java.sql.*;
````

importiert werden. Die Schnittstelle sitzt zwischen der Applikation und dem jeweiligen Treiber-Manager, dem Datenbanktreiber und letztendlich dem eigentlichen DB-System.

Je nach DB-System muss der jeweilige DB-Treiber über `Class.forName` geladen werden (hier am Beispiel PostgreSQL zu sehen). Im nächsten Schritt bauen wir eine Verbindung über die `.getConnection`-Methode auf und verbinden uns mit dem Port 5432:

````java
Connection c = null;
Statement stmt = null;
try {
    Class.forName("org.postgresql.Driver");
    c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/miniwelt_hochschule",
                    "postgres", "postgres");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");
  }
````  

Damit ist die Verbindung hergestellt. JDBC stellt nun die Möglichkeit bereit, Queries direkt auf der Datenbank auszuführen. Hierfür wird zunächst ein Query in SQL als String definiert. Dieses wird dann über die `.prepareStatement`-Methode der Connection in ein Prepared Statement gepackt, um SQL-Injections vorzubeugen:

````java
  String query = "SELECT * FROM studi WHERE name LIKE '%' ";
  PreparedStatement pstmt = c.prepareStatement( query );
````
Der User-Input wird in unserem Beispiel über einen *InputStreamReader* direkt aus `System.in` geladen:

````java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Suchbegriff: ");
String userinput = "%" + br.readLine() + "%";
````

und dann in das vorher definierte *Prepared Statement* eingesetzt. Über `.executeQuery` wird die Query sodann auf der Datenbank ausgeführt und die jeweiligen Ergebnisse in ein *ResultSet* geladen, aus denen wir dann die Daten auslesen können und beispielsweise auf der Konsole ausgeben können:
````java
pstmt.setString( 1, userinput);
ResultSet rs = pstmt.executeQuery();
while ( rs.next() ) {
    int matrnr = rs.getInt("matrnr");
    String name = rs.getString("name");
    System.out.println("MatrNr = " + matrnr);
    System.out.println("Name = " + name);
    System.out.println("\n");
  }
````

Außerdem müssen wir noch die Connection und alles Weitere schließen, um eventuelle *Memory Leaks* zu verhindern:
````java
rs.close();
pstmt.close();
c.close();
````

Diese Methode einer einfachen READ-Operation ist simpel, ohne große Aufwände umzusetzen und hat den Vorteil, dass die Datenbank in ihrer Form und Struktur bestehen bleiben kann. Außerdem ist keine weitere Konfiguration erforderlich und wir müssen uns **um kein Mapping kümmern**, da wir über standardmäßige SQL-Queries auf die Daten zugreifen und diese auslesen.  
Die Nachteile hierbei sind, dass bei größeren Projekten ein großer Overhead produziert wird, da jedes Query einzeln geschrieben und integriert werden muss und damit ein größerer Programmieraufwand vonnöten ist. Die Transaktionen müssen außerdem "hart kodiert" werden, was zu Problemen bei späteren Datenbankänderungen und Refactoring führen kann. Das entstehende `ResultSet` ist außerdem nicht serialisierbar, sodass es nicht über ein Netzwerk transportiert werden kann. Die Notwendigkeit, `Connections` manuell aufzubauen und auch wieder schließen zu müssen, birgt zusätzlich Fehlerpotenzial.  

Somit ist festzuhalten: wenn es sich lediglich um ein kleineres Projekt handelt und nur einige wenige Abfragen an die Datenbank getätigt werden müssen, so kann eine Anbindung über JDBC die richtige Wahl sein.  

### Hibernate-Anbindung
Ist das Projekt allerdings von größerem Umfang, so lohnt sich die Verwendung eines ORM-Mappers wie Hibernate. Der Service übernimmt dann die Konvertierung von Java Klassen/Datentypen zu Tabellen/SQL Datentypen und stellt Query-Hilfsmittel zur Verfügung, welche die manuelle Einbindung eines Query-Befehls (wie es bei JDBC notwendig ist) vereinfachen. Hierbei werden die Anweisungen je nach verwendetem SQL-Dialekt von Hibernate automatisch generiert.  

Hibernate fungiert hierbei als **zusätzliche Schicht oberhalb von JDBC** und macht damit die Implementierung einer **Datenbank-unabhängigen Persistenz-Schicht** möglich. [11]

**Konfiguration:** Je nach Build-Management-Tool müssen in jedem Fall das `javax.persistence` Bibliotheken eingebunden werden, dies geschieht über den `hibernate-core`, sowie in unserem Fall der `postgresql`-Treiber. Wir haben diese über *Maven* eingebunden.

Um die Konnektivität herzstellen muss zunächst ein *persistence.xml*-File angelegt werden, dieses wird in das *META-INF*-Verzeichnis abgelegt. Diese Datei ist für JPA die zentrale Konfigurations-Einheit. Hier wird die zu persistierende Einheit definiert, welche die Daten enthalten wird. Hier würden nun alle Klassen definiert, welche persistiert werden sollen. Stattdessen konfigurieren wir an dieser Stelle jedoch `<exclude-unlisted-classes>false</exclude-unlisted-classes>`, was Hibernate dazu bewegt, alle verfügbaren Klassen Deployment-Unit zu scannen und zu inkludieren:

````xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="miniwelt_hochschule" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>

````

 Wie in JDBC müssen außerdem die DB-Treiber und zusätzlich der SQL-Dialekt spezifiziert werden. Dem obigen Beispiel folgend verbinden wir uns mit dem Port 5432 auf eine PostgreSQL-Datenbank:

````xml
<properties>
    <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL94Dialect"/>
    <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/miniwelt_hochschule"/>
    <property name="javax.persistence.jdbc.user" value="postgres"/>
    <property name="javax.persistence.jdbc.password" value="postgres"/>
</properties>
</persistence-unit>
</persistence>
````

Um nun eine Klasse mit einer Relation zu verdrahten, benötigt es natürlich ein *Plain Old Java Objekt/POJO*. Wir erstellen, um das JDBC-Beispiel nachzuempfinden, eine Studi-Klasse mit entsprechenden Attributen sowie *Getters* und *Setters*. Diese verdrahten wir durch entsprechende Annotationen (hier: `@Table` und `@Column`) auf die Tabellen und Spalten von unserer Datenbank:

````java
@Entity
@Table(name = "studi")
public class Studi {

    @Id
    @Column(name = "matrnr", updatable = false, nullable = false)
    private int matrnr;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studi() {
    }

    public Studi(int matrnr) {
        this.matrnr = matrnr;
    }

    public int getMatrnr() {
        return matrnr;
    }

    public void setMatrnr(int matrnr) {
        this.matrnr = matrnr;
    }
}
````

Um nun das Query von oben nachzubauen, erstellen wir den `EntityManager`, der sich um Persistierungen von Einheiten kümmert. Das Query-Kriterium übergeben wir mit dem `CriteriaBuilder`, um die entsprechende "LIKE"-Anweisung aus dem Beispiel ausführen zu können:  

````java
public void testFindByCriteria(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miniwelt_hochschule");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Studi> criteria = cb.createQuery(Studi.class);
    Root<Studi> root = criteria.from(Studi.class);
    criteria.where(cb.equal(root.get("name"), "Meier"));
    List<Studi> topics = em.createQuery(criteria).getResultList();

    em.getTransaction().commit();
    em.close();
    emf.close();
}
````

Die `List<Study> topics` enthält danach alle Einträge aus der Datenbank aus der Tabelle "studi", welche den Namen "Meier" besitzen. Aus der Konsole lesen wir den von Hibernate erzeugten SQL-Befehl aus:

````
Hibernate: select studi0_.matrnr as matrnr1_0_, studi0_.name as name2_0_ from studi studi0_ where studi0_.name=?
````

*Anmerkung:* Wir hätten dieses Beispiel auch einfacher halten und stattdessen die in Hibernate integrierte **HQL-Language** nutzen können. Damit hätten wir aber im Kern keine wirkliche Änderung zum JDBC-Beispiel erreicht. Die Stärke dieser aufwändigeren Methode ist die Entfernung von SQL-internen Konstrukten und die reine Verwendung von Java-Facilities. Dadurch wird sauberer Java-Code erzeugt, in denen der Programmierer keine eigenen Querys erzeugen und pflegen muss.  

****
[1] Thorben Janssen (Hrsg.): Getting Started With Hibernate. https://thorben-janssen.com/hibernate-getting-started/, Abruf: 14.01.2021

[2] Hibernate (Hrsg.): What is Object/Relational Mapping? https://hibernate.org/orm/what-is-an-orm/, Abruf: 10.01.2021

[3] Ambysoft Inc (Hrsg.): Mapping Objects to Relational Databases: O/R Mapping In Detail. http://www.agiledata.org/essays/mappingObjects.html, Abruf: 10.01.2021

[4] Ambysoft Inc (Hrsg.): The Object-Relational Impedance Mismatch. http://www.agiledata.org/essays/impedanceMismatch.html, Abruf: 10.01.2021

[5] Chris Ireland (Hrsg.): Impedance Mismatch? http://impedancemismatch.com/page1/page1.html, Abruf: 10.01.2021

[6] Walking Techie (Hrsg.): Object Relational Impedance Mismatch. https://walkingtechie.blogspot.com/2017/12/object-relational-impedance-mismatch.html, Abruf: 10.01.2021

[7] Tutorials Point (Hrsg.): Hibernate - ORM Overview. https://www.tutorialspoint.com/hibernate/orm_overview.htm, Abruf: 12.01.2021

[8] Tutorials Point (Hrsg.): Hibernate - Overview. https://www.tutorialspoint.com/hibernate/hibernate_overview.htm, Abruf: 12.01.2021

[9] Baeldung (Hrsg.): The Difference Between JPA, Hibernate and EclipseLink. https://www.baeldung.com/jpa-hibernate-difference, Abruf: 12.01.2021

[10] Baeldung (Hrsg.): Spring Persistence Tutorial. https://www.baeldung.com/persistence-with-spring-series, Abruf: 12.01.2021

[11] JPA Performance Benchmark (Hrsg.): Comparison of Hibernate with MySQL server vs EclipseLink with MySQL server https://www.jpab.org/Hibernate/MySQL/server/EclipseLink/MySQL/server.html, Abruf: 12.01.2021
