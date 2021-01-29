[Zurück](03_Ueber_PostgreSQL.md)

## 4. Über MongoDB

<p align="center">
<img width="500" src="img/MongoDB_Logo.png">
</p>
<p align="center">
Abbildung 4: Logo von MongoDB<br>
(Quelle:  https://www.mongodb.com/brand-resources)
</p>

### Überblick

MongoDB ist eine populäre dokumentenorientierte NoSQL-Datenbankplattform. [14] Die Datenbank zeichnet sich durch Flexibilität, einfache Handhabung und Skalierbarkeit aus. Die Daten werden in einem JSON-ähnlichen Dokumentformat gespeichert, welches MongoDB (laut den Entwicklern) leistungsfähiger und aussagekräftiger macht als herkömmliche Zeilen/Spalten-Modelle. [13] MongoDB ist schemalos, eine Indexierung von Feldern wird allerdings unterstützt. Der Zugriff erfolgt in einer simplen JavaScript basierten Zugriffssyntax. Ein JavaScript Interpreter ist integriert, um auch komplexere Funktionen abbilden zu können. Dadurch wird auch ermöglicht, Skripte in der Datenbank zu hinterlegen und auszuführen. Durch sogenanntes Sharding ist MongoDB in der Lage den Datenbestand und die Arbeitslast auf mehrere Server zu verteilen. [14]

MongoDB stammt vom englischen Wort “humongous” und bedeutet “gigantisch”. Der Name soll verdeutlichen, dass mit MongoDB eine Datenbank entwickelt wurde, die auf die Bedürfnisse großer digitaler Unternehmen mit Skalierungswunsch eingeht. Und das mit Erfolg. Seit mehr als 10 Jahren findet MongoDB großen Absatz in der digitalen Gesellschaft. [13] 

### Entstehung

2007 taten sich die Entwickler Dwight Merriman, Kevin Ryan und Elliot Horowitz zusammen, um einen Weg zu finden übermäßig große, oft halb leere Datenbanken effizienter zu gestalten. In vielen modernen Applikationen mussten sich Entwickler der Herausforderung stellen, sich für eine Vielzahl an Daten ein geeignetes tabellarisches Datenschema zu überlegen. Das führte in der Regel dazu, dass entweder eine Datenbank eine Vielzahl an Spalten benötigte, die nur unregelmäßig befüllt waren oder dass aus einer großen Datenbank mehrere kleinere Datenbanken wurden. [13] 

Ein Beispiel: In einer Praxis sollen die Patientenakten digitalisiert werden. Jeder Patient hat eine Patienten-ID, eine Adresse, eine Telefonnummer und einen Namen. Dies ließe sich in einer relationalen Datenbank einfach lösen. Nun kommt in der heutigen Zeit jedoch noch eine Arbeitsnummer hinzu, eine Zweitadresse, eine Notfallnummer und weitere Attribute, die nur auf einige der Patienten zutreffen. Die relationale Datenbank erweitert sich um viele Spalten, jedoch mit einer großen Anzahl an leeren Feldern. Eine mögliche Lösung hierfür wäre das Aufteilen der Datenbank in mehrere. So entsteht eine Datenbank für Telefonnummern, die zusammen mit der Patienten-ID gespeichert werden, eine Datenbank für Adressen, eine für Namen. An dieser Stelle existieren bereits drei Datenbanken einzig für die Kontaktdaten des Patienten. Medizinischen Aspekte der Akte, die dem Patienten zugeordnet werden müssen, sind hierbei noch völlig außer Acht gelassen. [13] 

Eine effizientere Methode, die den modernen Applikationen von Nutzen sein soll, ist MongoDB. Horowitz, Ryan und Merriman entwickelten eine Datenbank, die kein einheitliches Schema benötigt, sondern die Daten in einem Dokument ablegt, welches unterschiedlich viele Datenfelder beinhalten kann. Die Erstveröffentlichung der MongoDB fand 2009 statt und schlug große Wellen in der Technologiebranche. [10] Mittlerweile hat MongoDB 17.000 Kunden in über 100 Ländern und die Datenplattform wurde über 90 Millionen Mal heruntergeladen (Stand Oktober 2020). [13] 

Bis zum 15. Oktober 2018 wurde MongoDB als OpenSource veröffentlicht und wird seitdem unter einer Server Side Public License vertrieben. [12]

MongoDB ist in mehreren Varianten verfügbar:

- MongoDB Atlas - Datenbank als Service
- Community Server - Kostenlos für die Community der Entwickler
- MongoDB Enterprise Edition - kommerzielle Lösung mit zusätzlichen Funktionen [12]

Jede dieser Varianten ist mit jedem Betriebssystem vollständig kompatibel. MongoDB kann damit sowohl auf Windows, Mac OS oder Linux genutzt werden. [12]

### Wichtige Features

- Unterstützung von flexiblen und dynamischen Schemas
- akzeptiert Werte in Form von Arrays und verschachtelten Objekten
- Filterung und Sortierung nach beliebigen Datenfeldern
- Unterstützung von Aggregation und weiteren modernen Anwendungsfällen (z.B. Textsuche oder geobasierter Suche)
- vollständige ACID-Transaktionen
- Unterstützung von JOINs in Abfragen
- es gibt zwei statt einem Beziehungstypen: verweisbasiert und eingebettet 

[12]

MongoDB skaliert horizontal unter der Verwendung von horizontaler Fragmentierung. Hierbei wird ein Fragmentierungsschlüssel festgelegt, der definiert, wie die Daten in der Ansammlung verteilt werden. So können die Daten in Bereiche aufgeteilt und über mehrere Instanzen verteilt werden. [14]

Wie eingangs erwähnt zeichnet sich MongoDB durch die hohe Flexibilität und Skalierbarkeit aus. Zudem ist MongoDB schnell und einfach implementiert, die Handhabung ist simpel und schnell erlernbar. [14] Unterschiede in den Betriebssystemen macht MongoDB nicht. Auch ist die Datenbank mit Treibern für C, C++, C#, Haskell, Java, JavaScript, Lisp, Perl, PHP, Python, Ruby und Scala ausgestattet, was die Datenbank vielseitig einsetzbar macht. [12]

### Einsatzgebiet und Verbreitung

MongoDB ist eine hervorragende Alternative zur strengen und strukturierten SQL-Welt. Gerade bei der Entwicklung von Prototypen ist diese Datenbank sehr beliebt. Durch die vielen Unsicherheiten in der Entwicklung von Prototypen ist die Schemafreiheit der MongoDB unverzichtbar. So bleibt die Entwicklung in jedem weiteren Entwicklungsschritt dynamisch und muss sich nicht durch ein im Vorfeld eventuell unzureichend definiertes Datenschema eingrenzen. 

Dies macht MongoDB auch beliebt bei vielen modernen Applikationen. Durch die schnelle und einfache Implementierung und die Freiheit des nicht definierten Schemas, wird die NoSQL-Datenbank besonders häufig dort eingesetzt, wo noch unbekannte Abhängigkeiten auftauchen können, agile Schnelllebigkeit den Alltag bestimmt oder sich Produkte im Aufbau befinden.

Das fehlende Datenschema birgt jedoch auch Risiken. Daten-Inkongruenz, tote Datenfelder, leere Felder, die nicht leer sein sollten und mehr sind möglich. Der Anwendungscode ist hier in der Pflicht eine große Verantwortung über die Aufrechterhaltung der Datenintegrität zu übernehmen. [10]

Auch beinhaltet die Standardinstallation keine Zugriffskontrolle, was dazu führen kann, dass MongoDB-Installationen von jedem lesbar und teilweise sogar beschreibbar sind. Diese Aspekte müssen vor der Nutzung von MongoDB bedacht und gelöst werden. [10]

Werden Sicherheitslücken geschlossen und die Datenintegrität bewahrt, bietet MongoDB Entwicklern eine dynamische Lösung, die sich ganz auf die Bedürfnisse der sich schnell verändernden digitalen Welt eingestellt hat.


[Weiter](05_Vergleich_der_JSON_Verarbeitung.md)

