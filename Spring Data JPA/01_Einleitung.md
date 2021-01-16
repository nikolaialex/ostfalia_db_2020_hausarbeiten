# Einführung in Spring Data JPA
## Allgemeines
Im Laufe der letzten Jahre erfreut sich das Spring Framework immer größerer Beliebtheit. Das Framework wird besonders häufig bei der Erstellung von umfangreichen Unternehmensanwendungen benutzt, in welchen eine Vielzahl von Daten verarbeitet (abgefragt, gespeichert und aktualisiert) werden. Insbesondere die Arbeit an der Persistenzsschicht gestaltet sich ohne die Unterstützung von Frameworks äußerst schwierig. In dieser Ausarbeitung geht es um eine Bibliothek, die hierbei Abhilfe schafft. Die Rede ist von der "Spring Data JPA". 

Spring Data JPA ist einer der Hauptbestandteile des Springframeworks und bietet eine abstrakte Datenzugriffsschicht, welche einige generische Methoden zum Zugriff auf die Daten hat. Nimmt man den namensgebenden Titel auseinander, besteht er aus drei Teilen:

- Spring (Spring Data JPA ist ein Hauptbestandteil des Springframeworks)
- Data 
- JPA (Es baut auf die Java-Persistance-API auf)

Doch was ist Spring und die Java Persistance API(JPA) eigentlich?

## JPA
Innerhalb von Java-Enterprise-Applikationen werden massenhaft Operationen auf Datenbanken durchgeführt und gleichzeitig große Mengen an Daten bearbeitet. Um solch eine Datenbankanbindung zu schreiben, benötigt man viele Zeilen Code, wenn man die Anbindung selbst entwickeln möchte. Es gibt allerdings auch die Möglichkeit sich der Funktionen des berühmten Frameworks "Spring" zu bedienen". Spring stellt beispielsweise die Java Persistance API (JPA) zur Verfügung. Hierbei handelt es sich um ein Interface, welches den Aufwand reduziert, der für die Kommunikation mit der Datenbank anfällt. 

Die Objekte des Java Programms werden hierbei mit den relationalen Modellen verbunden und hier wird die eigentliche Herausforderung sichtbar. Während die relationalen Objekte der Datenbank in Tabellenform daherkommen, wird das Objekt im Java Code mit etlichen Attributen dargestellt. 

Zusammenfassend lässt sich sagen, dass die Java Persistance API eine Sammlung von Klassen und Methoden ist, mit dem Ziel die Daten in die Datenbank zu speichern/persistieren. Für diese Datenbankdienste gibt es verschiedene Anbieter wie zum Beispiel:
- Oracle
- Redhat
- Eclipse.

Produkte dieser Firmen sind:
- Hibernate 
- EclipseLink 
- Spring-Data-JPA

Bei diesem Produkten handelt es sich um ORM-Frameworks für Java, welche in Kapitel 2 ausführlich erklärt werden.

Die Idee hinter JPA ist es also, ein ganz normales Java Objekt (POJO (Plaing Old Java Object) als relationales Datenbankobjekt zu speichern. 
Wichtige Objekte der JPA sind:
- EntityManagerFactory: Erstellt Instanzen vom Entity Manager
- EntityManager: Erstellt Instanzen von Querys
- Querys: Wird von den JPA-Providern zur Verfügung gestellt, um auf die Daten zuzugreifen.

## Spring
Das Spring-Framework ist ein sehr schlankes und quelloffenes Framework für Java. Das Framework soll den Programmierer bei der Java/JavaE - Entwicklung mittels Techniken wie der Dependency Injection, Templates und der aspektorientierten Programmierung unterstützen und somit leichteren und besser wartbaren Programmcode ermöglichen. Das Spring-Framework wird am häufigsten bei der Entwicklung von Web-Anwendungen genutzt, es kann allerdings für jede Art von Anwendungen genutzt werden. 

Spring wird typischerweise als "Lightweigt" - Framework für Java-Anwendungen betitelt, da keinerlei Anpassungen am Quellcode notwendig sind, um von den vielzählien Vorteilen zu profitieren. Durch den Einsatz des Frameworks erhält man eine leistungsstarke Grundstruktur, die kaum verändert werden muss, dies macht es möglich das die Entwickler sich komplett auf die eigentliche Business-Logik konzentrieren können. 

### Vorteile des Spring-Frameworks
- Dependency Injection: Mittels der Dependency Injection wird jegliche Konfiguration aller Abhängigkeiten aus dem eigentlichen "Business"-Quellcode ferngehalten. Dadurch wird der Code schlanker und ist leichter zu warten.

- Aspektorientierte Programmierung: AOP erlaubt die Strukturierung von Zusammenhängen, die komponentenübergreifend bestehen. Dadurch lässt sich der eigentliche Programmablauf sauberer von anderen Aspekten (z.B. Validierung, Fehlerbehandlung) trennen und das Projekt kann modularer aufgebaut werden.

- Templates: Templates sind Klassen, die für Programmschnittstellen genutzt werden können, sie bieten Komfortfunktionen wie eine einheitliche Fehlerbehandlung, automatisches Ressourcenmanagement und andere Hilfestellungen.

Spring bietet insgesamt 20 Module an, die individuell in das Projekt integriert werden können. Diese Module sind in 6 Kategorien eingeteilt.

- Core Container: Der Core-Container beinhaltet die elementaren Module, die beispielsweise die Dependency-Injection-Funktionen sowie den Pojo-Support bieten. Ebenfalls gibt es im Core Container Module, durch die Bibliotheken von Drittanbietern in Spring eingebunden werden und Ressourcenn geladen werden können.

- AOP und Instrumentation: Damit die aspektorientierte Programmierung möglich wird, ernhält das Spring Framework das AOP-Modul und die Instrument-Komponente, die es erlaubt Bytecode zur Laufzeit zu verändern. 

- Messaging: Spring unterstützt ebenfalls nachrichtenbasierte Anwendungen.

- Data Access/Integration: Ebenfalls werden Module angeboten, die Java-Applikationen die Fähigkeit zur Interaktion mit anderen Anwendungen verleihen und den Datenzugriff zur regeln. Beispielsweise stellt das Modul spring-jdbc eine Abstraktionsschicht zur Verfügung, in welcher definiert wird, wie ein Client auf die Datenbank zugreift. Die aufwendige JDBC-typische Codierung bleibt dem Entwickler dadurch erspart. 

- Web: Hier bietet Spring spezfische Module für Webanwendungen an, die beispielsweise Upload-Funktionen anbieten oder auch einen HTTP-Client hinzufügen. 

- Test: Abschließend beinhaltet Spring noch die Test-Kategorie. Die Module stellen die Funktionalität der Komponenten der gecodeten Java-Anwendung sicher. 

Einer der größten Vorteile des Spring-Frameworks ist der Verzicht auf plattformspezfische und nicht standardisierte Komponenten. Dadurch ist Spring im hohen Maße portabel und unabhängig von Applikationsservern. Es lässt sich somit problemlos als Meta-Framework einsetzen, in das sich weitere externe Komponenten oder Frameworks eingliedern lassen. 

## Spring-Data-JPA
Nachdem nun das Spring-Framework und die JPA kurz vorgestellt wurde, geht es nun um die Hauptthematik - die Spring Data JPA.

<img src="Abbildungen/SpringDataJPAARchi.png" width="350">

ToDo
- Architekturbeschreibung
- Geschichte wann wie von wem

## Zusammenfassung
