# Big Data Anwendungen mit der Lambda-Architektur

| Name               | Matrikelnummer | Hochschule  |
| :----------------- | :------------- | :---------  |
| Maike Naumann      | xxxxxxxx       | HS Emden/Leer |
| Hanns-Peter Lucht  | 195782         | TH Lübeck   |


## Inhaltsverzeichnis

1. Einleitung
2. Architektur
3. Grundlagen
* Immutable Data
* Stream Processing
* Echtzeitdaten
4. [Batch-Layer](4_Batch_Layer.md)
5. [Serving-Layer](5_Serving_Layer.md)
6. [Speed-Layer](6_Speed_Layer.md)
7. [Query-Layer](7_Query_Layer.md)
8. (Praktische Anwendungen/Vorteile) Gegenüberstellung mit inkrementellen Ansatz / Beispiele
9. Literaturverzeichnis

* Sensordaten zur Steuerung von Raketen (SpaceX) 
* Incident Monitoring im eCommerce
* Analyse von Bilddaten 


## Einleitung 
Zunächst erklären, was das ist, was das kann usw. ---> https://www.datenbanken-verstehen.de/lexikon/lambda-architektur/ Gut für Info Einleitung
Beispiel, warum für große Datenmengen diese Technologie von Vorteil ist. Warum würde z.B. keine relationale Datenbank reichen?

Ein wichtiges Anwendungsgebiet für die Lambda Architektur ist Big Data. Häufig stoßen relationale Datenbanken –oder auch allgemeiner ausgedrückt – herkömmliche Datenbanktechnologien bei sehr großen Datenmengen an ihre Grenzen. Probleme ergeben sich dabei aufgrund der Skalierbarkeit, aber auch aufgrund der Komplexität. 
Wird beispielsweise eine relationale Datenbank plötzlich um ein Vielfaches stärker genutzt als üblicherweise, kann sie möglicherweise nicht mehr so viele Anfragen (Requests) bearbeiten und gibt Zeitüberschreitungsfehler aus. Ein Workaround wäre hier, für die Anfragen eine Warteschlange zu eröffnen und diese dann mithilfe eines Worker-Prozesses gebündelt bearbeiten zu lassen. Dieser nimmt beispielweise 100 Ereignisse aus der Warteschlange heraus und fasst diese zu einer einzigen Datenbankaktualisierung zusammen. Wird die Datenbank nun noch stärker genutzt, kann der Worker nicht so schnell arbeiten wie die Schreibvorgänge stattfinden, mehrere Worker zusammen lösen das Problem nur kurzfristig. Eine weitere Möglichkeit, die relationale Datenbank an die veränderte Anzahl der Anfragen anzupassen, wäre das Sharding. Dies ist eine sogenannte horizontale Partitionierung. Datensätze, in denen die Werte innerhalb einer Tabellenspalte gleich sind, werden gemeinsam abgespeichert. Die Arbeitslast beim Schreiben wird durch dieses Verfahren auf mehrere Maschinen verteilt. Hierzu ist ein Script erforderlich, das die Datensätze auf mehrere Datenbanken verteilt. 
Wegen der Skripte und der unterschiedlichen Datenbanken, von denen möglicherweise immer mehr benötigt werden, steigt die Komplexität. Im Falle eines Hardwareausfalls oder einer nötigen Anpassung der Skripte, können Folgefehler entstehen oder es kann sogar zu Datenverlust kommen. Ein Beispiel wäre der Ausfall einer Festplatte: Auch wenn es ein Backup gibt, können Anfragen bis zur Behebung des Ausfalls verloren gehen.  NoSQL  wäre auch keine Patentlösung, weil wegen der begrenzten Datenmodelle sehr viele eigene Modifikationen notwendig werden können, wodurch die Datenbanken wiederum fehleranfällig werden können. 

### Lambda Architektur und Big Data

Die folgende Tabelle soll erklären, welche Anforderungen an Big Data-Systeme mittels der Eigenschaften der Lambda-Architektur gut erfüllt werden können.

Eigenschaft | Beschreibung
------------|-------------
Belastbarkeit und Fehlertoleranz	|Handling von Maschinenausfällen, Semantik/Konsistenz verteilter Datenbanken, Datendopplungen, paralleler Ausführungen
Lesen und Aktualisieren mit geringen Latenzzeiten |	Geringe Latenzzeiten können implementiert werden: siehe Speedlayer
Skalierbarkeit|	Bei der Lambda-Architektur sind alle drei Layer horizontal skalierbar, indem weitere Maschinen hinzugefügt werden
Allgemeingültigkeit |	Funktionen sind allgemeingültig anwendbar
Erweiterbarkeit |	Migrationen sollen schnell und einfach durchführbar sein
Ad-hoc-Abfragen|	Beliebige Abfragen sollen möglich sein
Minimaler Wartungsaufwand	|Dies wird erreicht, indem Komplexität aus den Kernkomponenten ausgelagert wird. Die Ausgaben von komplexen Komponenten sollten nach einiger Zeit ausgesondert werden
Fehlerbehebung	| Wird ermöglicht, indem die Nachverfolgung jedes einzelnen Wertes möglich ist

# 9 Literaturverzeichnis
 Schlüssel     | Veröffentlichung 
 ------------- | --- 
 **[Mar16]** | Nathan Marz und James Warren. _Big Data: Entwicklung und Programmierung von Systemen für große Datenmengen und Einsatz der Lambda-Architektur_. Frechen: mitp-Verlag, 2016 | 
  **[Mar11]** | Nathan Marz. _[How to beat the CAP theorem](http://nathanmarz.com/blog/how-to-beat-the-cap-theorem.html)_. Abgerufen am 12.01.2021 | 

------------
