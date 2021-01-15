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


## Spring
## Übersicht
## Zusammenfassung
