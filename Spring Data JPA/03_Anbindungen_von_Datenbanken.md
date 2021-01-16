# Anbindung von JDBC im Vergleich zu ORM Frameworks

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

Um nun das Query von oben nachzubauen, erstellen wir den `EntityManager`, der sich um Persistierungen von Einheiten kümmert. Das Query-Kriterium übergeben wir mit dem `CriteriaBuilder`, um die entsprechende "LIKE"-Anweisung aus dem Beispiel ausführen zu können. Beide Klassen sind Teil der *JPA Boostrapping API*, welche von Hibernate implementiert sind und daher genutzt werden können:

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

*Anmerkung:* Wir hätten dieses Beispiel auch einfacher halten und stattdessen die in Hibernate integrierte **HQL-Language** nutzen können. Damit hätten wir aber im Kern keine wirkliche Änderung zum JDBC-Beispiel erreicht. Die Stärke dieser aufwändigeren Methode ist die Entfernung von SQL-internen Konstrukten und die reine Verwendung von Java-Facilities. Dadurch wird sauberer Java-Code erzeugt, in denen der Programmierer keine Queries selbst erzeugen und pflegen muss.

**Fazit:** Im direkten Vergleich der Datenbank-Anbindungen konnten wir feststellen, dass eine einfache Anbindung mit JDBC wesentlich weniger Aufwand erfordert und schnell zu Ergebnissen führt, insbesondere, wenn es sich um einige wenige, bereits bekannte SQL-Queries handelt.
Mit einem ORM-Framework ist von Seiten des Programmierers mehr Konfiguration und auch Implementierungsarbeit zu leisten. Eine der größten Vorteile ist jedoch die komplette Entbindung von der SQL-Syntax innerhalb des objektorientierten Codes: es könnten auf diese Weise **Queries dynamisch zusammengesetzt werden**, außerdem werden **Fehler oft bereits zur Kompilierungszeit erkannt**, und nicht erst zur Laufzeit. [12]
Ob die Überführung des relationalen Modells in ein Objektmodell und die Nutzung eines ORM-Mappers sinnvoll ist, hängt also in erster Linie mit der Komplexität des Projektes zusammen und muss individuell entschieden werden. Es ist hierbei vor Allem entscheidend, beide Paradigmen zu verstehen, um eine sichere und performante Software gewährleisten zu können.

****
[11] JPA Performance Benchmark (Hrsg.): Comparison of Hibernate with MySQL server vs EclipseLink with MySQL server. https://www.jpab.org/Hibernate/MySQL/server/EclipseLink/MySQL/server.html, Abruf: 12.01.2021

[12] ObjectDB Software (Hrsg.): JPA Criteria API Queries. https://www.objectdb.com/java/jpa/query/criteria, Abruf: 15.01.2021
