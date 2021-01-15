# Einführung in Spring Data JPA
## Allgemeines
Im Laufe der letzten Jahre erfreut sich das Spring Framework immer größerer Beliebtheit. Das Framework wird besonders häufig bei der Erstellung von umfangreichen Unternehmensanwendungen benutzt, in welchen eine Vielzahl von Daten verarbeitet (abgefragt, gespeichert und aktualisiert) werden. Insbesondere die Arbeit an der Persistenzsschicht gestaltet sich ohne die Unterstützung von Frameworks sehr schwierig. In dieser Ausarbeitung geht es um eine Bibliothek, die hierbei Abhilfe schafft. Die Rede ist von "Spring Data JPA". 

Spring Data JPA ist einer der Hauptbestandteile des Springframeworks und bietet eine abstrakte Datenzugriffsschicht, welche einige generische Methoden zum Zugriff auf die Daten hat. Nimmt man den namensgebenden Titel auseinander, entdecken wir drei Fachwörter:

- Spring (Spring Data JPA ist ein Hauptbestandteil des Springframeworks)
- Data (es hat auf jeden Fall etwas mit Daten zu tun)
- JPA (Es baut auf die Java-Persistance-API auf)

Doch was ist Spring und die Java Persistance API(JPA) eigentlich?

## JPA
Innerhalb von Java-Enterprise-Applikationen werden massenhaft Operationen auf Datenbanken durchgeführt und gleichzeitig große Mengen an Daten bearbeitet. Um solch eine Datenbankanbindung zu schreiben, benötigt man viele Zeilen Code, wenn man die Anbindung selbst entwickeln möchte. Es gibt allerdings auch die Möglichkeit sich der Funktionen des berühmten Frameworks "Spring" zu bedienen". Spring stellt beispielsweise die Java Persistance API (JPA) zur Verfügung. Hierbei handelt es sich um ein Interface, welches den Aufwand reduziert, der für die Kommunikation mit der Datenbank anfällt. 

Die Objekte des Java Programms werden hierbei mit den relationalen Modellen verbunden. Hier wird die eigentliche Herausforderung sichtbar, während die relationalen Objekte der Datenbank in Tabellenform daherkommen, wird das Objekt im Java Code mit etlichen Attributen dargestellt. 

Zusammenfassend lässt sich sagen, dass die Java Persistance API eine Sammlung von Klassen und Methoden ist, mit dem Ziel die Daten in die Datenbank zu speichern/persistieren. Für diese Datenbankdienste gibt es verschiedene Anbieter wie zum Beispiel:
- Oracle
- Redhat
- Eclipse.

Produkte dieser Firmen sind:
- Hibernate
- EclipseLink
- Spring-Data-JPA

Die Idee hinter JPA ist es also, ein ganz normales Java Objekt (POJO (Plaing Old Java Object) als relationales Datenbankobjekt zu speichern. 
Wichtige Objekte der JPA sind:
- EntityManagerFactory: Erstellt Instanzen vom Entity Manager
- EntityManager: Erstellt Instanzen von Querys
- Querys: Wird von den JPA-Providern zur Verfügung gestellt, um auf die Daten zuzugreifen.

Das folgende Beispiel zeigt nun eine einfache Transaktion via JPA.
Als Beispiel soll ein Spielfilm in einer Videothek als relationales Objekt definiert werden. 

Der Film selbst ist ein einfaches POJO.
Als Eigenschaften werden zur Übersichtlichkeit lediglich eine ID, der Titel und die Spieldauer angegeben. 

***Entity "Film"***
  ```Java
@Entity
@Table
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String titel;
	private int spieldauer;
	
	public Film(int id, String title, int spieldauer) {
		super();
		this.id = id;
		this.titel = title;
		this.spieldauer = spieldauer;
	}

	//Getter & Setter	
}

  ```
  
Für die Definition der Entity ist die Annotation "@Entity" notwendig, mit der Annotation "@Table" wird gesagt, welche Tabelle mit dieser Entität erstellt werden soll.
Mit der Annotation "@ID" wird festgelegt, dass die Spalte der ID als Primärschlüssel dienen soll. Der Zusatz "GeneratedValue(strategy = GenerationType.AUTO) gibt an, dass der Primärschlüssel automatisch generiert und hochgezählt werden soll. 

Die kommende Klasse zeigt, wie solch ein "Film-Objekt" aus Java heraus in eine relationale Datenbank gespeichert wird.

*** Persistierung eines Java-Objekts in eine relationale Datenbank ***
  ```Java
public class SpeichereFilm {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPADemo");
		
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Film film = new Film();
		film.setTitel("Der Herr der Biere");
		film.setSpieldauer(130);
		
		entityManager.persist(film);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	}
}
  ```

## Spring
## Übersicht
## Zusammenfassung
