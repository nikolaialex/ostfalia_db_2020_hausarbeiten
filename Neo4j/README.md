# Neo4j

### Ausarbeitung für das Modul Datenbanktechnologien

### Autoren

| Name               | Matrikelnummer | Hochschule |
| :----------------- | :------------- | :--------- |
| Florian Jeger      | 270885         | TH Lübeck  |
| Christoph Jeger    | 270898         | TH Lübeck  |


## Inhaltsverzeichnis
1. [Einleitung](#1-einleitung)
  <br/>1.1. [Neo4j](#11-neo4j)
  <br/>1.2. [Was bringt eine Graph-Basierung?](#12-was-bringt-eine-graph-basierung)
  <br/>1.3. [Vorteile von Graphendatenbanken](#13-vorteile-von-graphendatenbanken)
  <br/>1.4. [Nachteile von Graphendatenbanken](#14-nachteile-von-graphendatenbanken)
  <br/>1.5. [Wofür eignet sich Neo4j?](#15-wofür-eignet-sich-neo4j)  
2. [Installation und Start](#2-installation-und-start)  
3. [Grundlagen](#3-grundlagen)
  <br/>3.1. [Datenmodell](#31-datenmodell)
  <br/>3.2. [Datenintegrität](#32-datenintegrität)
4. [Fazit](#4-fazit)
5. [Literaturverzeichnis](#5-literaturverzeichnis)


## 1. Einleitung
Nach heutigem Stand reicht es nicht mehr aus große Mengen an Daten zu sammeln und zu speichern. Die Daten sollen einen Mehrwert erzielen und eine Grundlage schaffen um Entscheidungen zu treffen, dafür müssen die Daten innerhalb von Sekunden auswertbar sein. Recht schnell sammeln sich Terabytes an Daten zusammen, die nicht unbedingt sauber strukturiert sind, sondern als E-Mails, Dokumente, Fotos oder Videos vorhanden sind. Mit diesen Anforderungen muss die Datenbank dann zurechtkommen. Für die Entwickler stellt sich dann die Frage, welche Datenbank die richtige für das Projekt ist. Dabei beantworten viele Entwickler diese Frage nach Gefühl oder nach Gewohnheit und vernachlässigen dabei, sich Gedanken um den Anwendungszeck zu machen. [1]

Die folgenden Punkte können für die Wahl einer Datenbank berücksichtigt werden:
- **Anwendungsfall:** Der wichtigste Faktor für die Entscheidung, welche Datenbanktechnologie verwendet werden soll, ist der Anwendungszweck. Werden beispielsweise in einer Anwendung im Frontend viele Interaktionen ausgeführt mit einem hohen Datenvolumen und wichtig dabei sind kurze Reaktionszeiten, dann fällt die Wahl auf NoSQL-Datenbanken. Diese bieten den Vorteil, dass NoSQL-Datenbanken sich über Nodes skalieren und in Clustern organisiert sind. Das ermöglicht eine fast unendliche Flexibilität. Die klassische relationale Datenbank mit ihren festen Tabellenstrukturen kommen nur über Umwege und Problemumgehungen mit diesen Anforderungen zurecht, dadurch steigen bei der relationalen Datenbank die Kosten und das Leistungsverhalten der Datenbank sinkt. Daher sollte der Anwendungsfall genau betrachtet werden und sich dann für einen Datenbanktyp entschieden werden. [1]
- **Anforderungen für die Verfügbarkeit:** Ebenfalls zu beachten sind die Anforderungen in der Verfügbarkeit. Muss eine Anwendung immer verfügbar sein, auch bei steigender Anzahl an Arbeitslasten und paralleler Benutzernutzung, dann muss die Datenbank skalierbar sein um die Arbeitslasten zu schaffen. [1]
- **Datenbanktechnologie für die Zukunft:** Die ausgewählte Datenbank sollte nicht nur die aktuellen Anforderungen erfüllen, sondern die Eigenschaften der Datenbank sollte auch zukünftige Arbeitsbelastung und Einsatzszenarien abdecken. [1]
- **Kosten der Datenbank:** Bei Big Data werden große teure Server benötigt um die Abfragen und Analysen ausreichend performant auszuführen zu können. Bei steigendem Datenvolumen wird auch ein leistungsstärkerer Server benötigt. Bei den NoSQL-Datenbanken können die Server problemlos nach oben skaliert werden. [1]

Unterschiedliche Punkte sind für die Wahl der Datenbank entscheidet. Daher sollten die Entwickler eines Systems verschiedene Datenbanktechnologien kennen, damit die richtige Datenbanktechnologie gewählt wird und nicht später eine böse und teure Überraschung entsteht, den Wechsel der Datenbanktechnologie. Daher wird hier die Datenbanktechnologie Neo4j näher betrachtet und vorgestellt.


### 1.1 Neo4j
Neo4j ist eine quelloffene Graphdatenbank zur Speicherung vernetzter Informationen. Sie gehört zu den weit verbreiteten und bekanntesten Graphdatenbanken. Mit dieser Datenbank ist es möglich eine effiziente Verarbeitung unterschiedlicher Anwendungsfälle umzusetzen, die in relationalen Datenbanken mit anderen Datenmodellen eher aufwendig wären. [2] [3]

Neo4j wurde 2010 mit der ersten Version veröffentlicht und gehört zu den NoSQL-Datenbanken. Mittlerweile steht die Version 4.1.3 (stand Oktober 2020) zur Verfügung. Entwickelt wurde Neo4j mit der Programmiersprache Java. Allerdings werden Daten in einer Graphenstruktur aufgebaut und verwertet. Weiterhin ist Neo4j ein hochskalierbares System, das kostenlos und lizenzfrei in der Community Edition zur Verfügung steht. Außerdem gibt es einen Enterprise Bereich, dieser bietet umfangreiche Zusatzfunktionen. Dieser Enterprise Bereich benötigt aber eine kommerzielle Lizenz. [3] [4]


### 1.2. Was bringt eine Graph-Basierung?
Allgemein besteht ein Graph aus einer Menge von Knoten und Kanten. Diese Knoten und Kanten werden auch Beziehung genannt. Hierbei werden zwei Knoten jeweils durch eine Kante verbunden. In einer Graphdatenbank werden die Daten im Graph gespeichert. Außerdem sind in der Graphdatenbank die Knoten und Kanten quasi die primitive erste Ordnung. [2]

Die Graphdatenbank Neo4j besitzt wohl überlegte Strategien für die Verwaltung von riesigen und beliebig verknüpften Datenmengen. Hierfür verwendet Neo4j Mechanismen, die es ermöglichen Indizes auf Knoten und Beziehungen zu definieren. Mit Neo4j ist es möglich mehr als 1 Mio. Beziehungen pro Sekunde auf einer Standard-Hardware zu traversieren. Damit problematische bzw. nicht einfache Abfragen über einen Graphen formulieren zu können, besitzt Neo4j eine Vielzahl von Mechanismen. [2]

Heutzutage sind viele allgemeine Graph-Algorithmen in der Mathematik bzw. in der Informatik bekannt. Eine Implementierung von bekannten Graph-Algorithmen ist in Neo4j bereits vorhanden, z.B. sind die Algorithmen für die Suche von den kürzesten Wegen sowie der A*- Algorithmus und der Dijkstras Algorithmus bereits implementiert. [2]


### 1.3. Vorteile von Graphendatenbanken
Graphdatenbanken besitzen allgemein einen Vorteil gegenüber Relationalen Datenbanken (RDBMS) und anderen NoSQL-Datenbanken, wenn es um komplizierte Beziehungen innerhalb einer riesigen Datenmenge geht. [5]

Relationale Datenbanken eignen sich nicht dafür, aus dem Grund, dass sie für das Darstellen und Finden von Verbindungen viele zeitintensive JOINs benötigen. Je mehr Datensätze entstehen bzw. hinzugefügt werden und je tiefer diese Verbindungen gehen, desto mehr Zeit wird benötigt. Die Lösung für dieses Problem sind Graphdatenbanken, weil sie für dieses Problem entwickelt und optimiert wurden. Sie besitzen dementsprechend die nötigen Algorithmen. [5] 

Nach einer allgemeinen Beschreibung von den Vorteilen einer Graphdatenbank folgt eine explizite Aufzählung der Vorteile der Graphendatenbank Neo4j: 

- **Zuverlässig und schnell:** Bei Neo4j können Daten vollständig schnell geschrieben und gelesen werden. [6]
- **Einfach zu bedienen:** Neo4j bietet ein leicht verständliches User-Interfaces und es gibt erprobte Lernmaterialien, die den Einstieg erleichtern. [6]
- **Gutes Preis-Leistungs-Verhältnis:** Die Enterprise-Version von Neo4j wird zu einem fairen Preis angeboten. [6]
- **Skalierbar:** Neo4j garantiert hohe Geschwindigkeiten und passt sich dem Datenvolumen an. [6]
- **ACID Optimierung:** Durch Atomarität, Konsistenz, Isolation und Dauerhaftigkeit wird die Verknüpfung von Daten optimiert. [6]
- **Benutzerfreundlich:** Neo4j bietet ein einfaches User-Interfaces, Cypher und Java für Anwendungen. [6]
- **Open Source:** Neo4j ist ein Open Source Projekt. Die Community unterstützt das Open Source Projekt von Neo4j, diese Unterstützung fließt auch in die Enterprise-Version mit ein. [6]
- **Erprobt & bewährt:** Von Analysten wird Neo4J als zuverlässig genug für kritische Anwendungen eingestuft. [6]
- **Community:** Neo4j besitzt die größte Community aller Graph-Datenbanken. [6]

### 1.4. Nachteile von Graphendatenbanken
Die NoSQL-Datenbanken verteilen ihre Daten hauptsächlich nach ihrem Primärschlüssel. Die Graphdatenbanken hingegen müssen ihr Beziehungsgeflecht aufbrechen, damit das System auf einer verteilten Architektur skalierbar ist. Dafür stellen Graphdatenbanken entsprechende Operationen bereit. Sharding (bezeichnet die Aufteilung einer Datenbank auf mehrere physikalische Datenbankserver) ist bei Graphdatenbanken kein einfacher Prozess wie bei anderen Systemen. Der Sharing Prozess führt eher zu Performanceverlust als zu Performancegewinn, weil diese Systeme eher für Ein-Server-Architekturen konzipiert wurden. Bei diesen Ein-Server-Architekturen geschieht das traversieren schneller als auf einem verteilten System. Soll eine Graphdatenbank verteil werden und die Kapazität des Servers ist nicht ausreichend, dann ist es notwendig, dass der Graph in Teilgraphen partitioniert (aufgeteilt) wird. Dabei kann es schwierig werden eine geeignete Stelle für das partitionieren im Graphen zu finden. [5]


### 1.5. Wofür eignet sich Neo4j?
Für ein System, wo die Daten zahlreich vernetzt und kaum strukturiert sind, eignet sich besonders Neo4j. Besitzt ein System zahlreiche zusammenhängende strukturierte Daten, die verwaltet werden müssen, dann eignet sich Neo4j nicht besonders und es wäre besser eine relationale Datenbank zu wählen. Besitzt das System allerdings vernetze Daten, wo die Beziehungen zwischen den Daten abgefragt werden müssen, dann ist Neo4j als Graphdatenbank die passende Wahl. Die folgende Abbildung 2-1 zeigt einen Überblick von den Bestandteilen von Neo4j die ein Anwender benötigt. [2]

<p align="center"><img src="images/Neo4j-Überblick.jpg" title="Neo4j-Überblick" width="100%" height="auto"><b>Abbildung 1-1: Neo4j-Überblick [2]</b></p>


## 2. Installation und Start
Diese Schritte sind nötig um Neo4j unter Windows zu installieren und zu starten:
- Java muss auf dem PC (Personal Computer) installiert sein. [7]
- Nun ist es nötig die neuste Version von Neo4j zu downloaden. Hierfür besucht man die neo4j-Website und downloadet die "Neo4j Community Edition". [7]
- Der nächste Schritt, ist die heruntergeladene ZIP-Datei zu entpacken. [7]
- Nun navigiert man über die Konsole in den Bin Ordner und führt „bin\neo4j console“ aus. Jetzt können Neo4j-Abfragen im Terminal ausführt werden. [7]
- Im gleichen Verzeichnis führt man den Befehl „bin/neo4j start“ aus in der Konsole, um den Webserver zu starten. Damit der Webserver gestoppt wird gibt man den Befehl „bin/neo4j stop“ in der Konsole ein. [7] [8]
- Nun ruft man im Browser seiner Wahl den localhost unter http://localhost:7474 auf. [9]
- Der Benutzername und das Passwort sind bei Neo4j ab der Community-Version 3.0.3 standardmäßig „neo4j“ (siehe Abbildung 2-1). Nachdem das Passwort eingegeben wurde, kann das Passwort geändert werden. [9] [8]

<p align="center"><img src="images/neo4j-login.png" title="Neo4j Login" width="100%" height="auto"><b>Abbildung 2-1: Neo4j Login</b></p>

## 3. Grundlagen


### 3.1. Datenmodell
Leonard Euler legte mit der Graphentheorie die Grundlage für das Datenmodell der Graphdatenbanken [5]. Anders als in relationale Datenbanken, wo die Übertragung eines Graphenmodells mit den Knoten und Kanten nur in der Form einer Datenbanktabelle möglich ist, nutzt Neo4j die unveränderte Form der Graphenelemente. Das hat den Effekt, dass die Problemfelder, die sonst entstehen, deutlich vereinfacht werden. Die wichtigsten Bestandteile des Datenmodells von Neo4j werden nachfolgend beschrieben: [10]

**Knoten (Nodes):** Das Grundelement in jeden Graphen ist der Knoten. In Neo4j enthält jeder Knoten eine eindeutige ID, die fortlaufend für alle Knoten verteilt wird. Die Knoten in Neo4j können Eigenschaften zugewiesen werden, die auch Properties genannt werden. Diese Attribute enthalten einfache Schlüssel oder Werte-Paare. Diese Eigenschaften müssen kein vorgegebenes Schema folgen, das heißt, die Attribute können sich von Knoten zu Knoten unterscheiden. Dies ermöglicht eine größere Flexibilität im Vergleich zu relationalen Datenbanken, wo für jeden Knotentyp eine eigene Tabelle erforderlich ist. [10]

Die folgenden Wertetypen können für Properties vergeben werden:

| Typ                               | Beschreibung                                                                               |
| :-------------------------------- | :----------------------------------------------------------------------------------------- | 
| boolean                           | true oder false		                                                                     | 
| byte                              | 8-bit integer (Ganzzahl)                                                                   | 
| short                             | 16-bit integer (Ganzzahl)                                                                  | 
| int                               | 32-bit integer (Ganzzahl)                                                                  | 
| long                              | 64-bit integer (Ganzzahl)                                                                  | 
| float                             | 32-Bit IEEE 754 Gleitkommazahl                                                             | 
| double                            | 64-Bit IEEE 754 Gleitkommazahl                                                             | 
| char                              | 16-Bit-Ganzzahlen ohne Vorzeichen, die Unicode-Zeichen darstellen                          | 
| String                            | Sequenz von Unicode-Zeichen                                                                | 
| org.neo4j.graphdb.spatial.Point   | Ein 2D- oder 3D-Punktobjekt in einem bestimmten Koordinatensystem.                         | 
| java.time.LocalDate               | Eine sofortige Erfassung des Datums, aber nicht der Zeit oder der Zeitzone.                | 
| java.time.OffsetTime              | Eine sofortige Erfassung der Tageszeit und des Zeitzonenversatzes, jedoch nicht das Datum. | 
| java.time.LocalTime               | Ein Augenblick, der die Tageszeit erfasst, aber nicht das Datum und nicht die Zeitzone.    | 
| java.time.ZonedDateTime           | Eine sofortige Erfassung des Datums, der Uhrzeit und der Zeitzone.                         | 
| java.time.LocalDateTime           | Eine sofortige Erfassung des Datums und der Uhrzeit, aber nicht der Zeitzone.              | 
| java.time.temporal.TemporalAmount | Ein zeitlicher Betrag. Dadurch wird der Zeitunterschied zwischen zwei Momenten erfasst.    | 

<p align="center"><b>Tabelle 3-1: Wertetypen für Properties in Neo4j [11]</b></p>

In Neo4j existiert außerdem ein spezieller Knoten, den sogenannten Referenzknoten. Dieser existiert in jeder neu angelegten Neo4j Datenbank, weil dieser Knoten den allgemein bekannten Einstiegspunkt für jeden Graphen darstellt. Dieser Knoten sollte zu mindestens indirekt mit allen Knoten verbunden sein, damit jeder Knoten von dem Referenzknoten erreichbar ist. [10]

**Kanten (Relationships):** Die Verbindungen zwischen den Knoten werden als Kanten oder Relationships bezeichnet und stellen eine Auffindbarkeit des Knotens in der Datenbank sicher. Dabei kann ein Knoten keine, eine oder mehrere Beziehungen zu anderen Knoten haben. Auch die Kanten können mit einer eindeutigen ID identifiziert werden, die fortlaufend für alle vergeben werden. Eine Kante kann nur durch einen Start- und Endknoten mit einem Typbezeichner entstehen. Dabei sind die Kanten immer gerichtet, das heißt eine Kante ist immer nur mit zwei Knoten verbunden. Die Richtung der Kante kann ebenfalls entscheidend sein, denn wenn X Follower von Y ist, heißt das nicht das Y auch Follower von X ist. Sollte die Richtung der Verbindung der Knoten egal sein, kann diese beim traversieren auch ignoriert werden. Kanten können ebenfalls wie Knoten Attribute enthalten in der Form von Schlüssel oder Werte-Paare. [10].

**Pfade:** Pfade sind eine Aufreihung von einem oder mehreren Knoten über Kanten und stellen das Ergebnis einer Suchanfrage dar. [10].

**Indizes durch Labels:** Die Knoten können mit zusätzlichen Eigenschaften versehen werden, die Labels genannt werden. Labels ermöglichen eine Teilmenge an Knoten auszuzeichnen und zu indizieren, damit können die Knoten gruppiert und bei Suchanfragen schneller gefunden werden. Wichtig ist, dass Knoten jederzeit mit weiteren Attributen und Labels ergänzt werden können. Knoten können mehr als ein Label enthalten. [3]

Die Abbildung 3-1 zeigt ein Beispiel für das Datenmodell von Neo4j. Der Knoten John und Jane haben unter anderem die Attribute von Kundendaten, wie Name, Nachname, Ort und E-Mail. Jedoch müssen die Knoten nicht alle die gleichen Eigenschaften mit unterschiedlichen Werten besitzen. So hat der Knoten Jane in diesem Beispiel nicht das Attribut von einer E-Mail-Adresse. Außerdem wurde der Knoten John und Jane mit dem Label Kunden versehen. Damit kann über das Label Kunden John und Jane leichter und schneller über eine Suchanfrage in der Datenbank gefunden werden. Das Beispiel verdeutlicht ebenfalls, dass die Knoten unterschiedliche Beziehungen (Kanten) zueinander haben können. 

<p align="center"><img src="images/nodes_neoj4_graphdatenbanken.jpg" title="Veranschaulichung des Datenmodells in Neo4j" width="100%" height="auto"><b>Abbildung 3-1: Veranschaulichung des Datenmodells in Neo4j [3]</b></p>


### 3.2. Datenintegrität



## 4. Fazit



## 5. Literaturverzeichnis

- [1] IT Verlag für Informationstechnik GmbH, „Fünf Tipps für die Wahl der richtigen Datenbank,“ 01 April 2020. [Online]. Available: https://www.it-daily.net/it-management/big-data-analytics/23876-fuenf-tipps-fuer-die-wahl-der-richtigen-datenbank. [Zugriff am 25 Oktober 2020].
- [2] P. Ghadir, „innoq.com,“ 24 Oktober 2020. [Online]. Available: https://www.innoq.com/de/articles/2012/09/neo4j-rockt/.
- [3] „datenbanken-verstehen.de,“ Begerow Beratungsgesellschaft mbH & Co. KG, [Online]. Available: https://www.datenbanken-verstehen.de/lexikon/neo4j/. [Zugriff am 24 Oktober 2020].
- [4] „neo4j.com,“ Neo4j, Inc., [Online]. Available: https://neo4j.com/release-notes/. [Zugriff am 24 Oktober 2020].
- [5] „wi-wiki.de,“ Technische Hochschule Mittelhessen, [Online]. Available: http://wi-wiki.de/doku.php?id=bigdata:graphdb. [Zugriff am 26 Oktober 2020].
- [6] „aoe.com,“ AOE GmbH, [Online]. Available: https://www.aoe.com/de/produkte/datenbanken-storage/neo4j.html. [Zugriff am 26 Oktober 2020].
- [7] „neo4j.com,“ Neo4j, Inc., [Online]. Available: https://neo4j.com/docs/operations-manual/current/installation/windows/#windows-installation. [Zugriff am 27 Oktober 2020].
- [8] „riptutorial.com,“ [Online]. Available: https://riptutorial.com/de/neo4j. [Zugriff am 27 Oktober 2020].
- [9] skyridetim, „geeksforgeeks.org,“ [Online]. Available: https://www.geeksforgeeks.org/neo4j-installation/. [Zugriff am 27 Oktober 2020].
- [10] S. Schönung, „Graphendatenbanken,“ 2012. [Online]. Available: https://www.christianbaun.de/SEM12/Dokumente/CLCP_SEM_SS2012_Graphendatenbanken_Ausarbeitung.pdf. [Zugriff am 26 Oktober 2020].
- [11] Neo4j, Inc., „Property values,“ [Online]. Available: https://neo4j.com/docs/java-reference/current/java-embedded/property-values/index.html. [Zugriff am 27 Oktober 2020].


