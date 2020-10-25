# Neo4j

### Ausarbeitung für das Modul Datenbanktechnologien

### Autoren

| Name               | Matrikelnummer | Hochschule |
| :----------------- | :------------- | :--------- |
| Florian Jeger      | 270885         | TH Lübeck  |
| Christoph Jeger    | 270898         | TH Lübeck  |


## Inhaltsverzeichnis
1. [Einleitung](#1-einleitung)
2. [Neo4j](#2-neo4j)
  <br />2.1. [Was bringt eine Graph-Basierung?](#21-was-bringt-eine-graph-basierung)
  <br />2.2. [Wofür eignet sich Neo4j?](#22-wofür-eignet-sich-neo4j)
3. [Fazit](#3-fazit)
4. [Literaturverzeichnis](#4-literaturverzeichnis)


## 1. Einleitung
Nach heutigem Stand reicht es nicht mehr aus große Mengen an Daten zu sammeln und zu speichern. Die Daten sollen einen Mehrwert erzielen und eine Grundlage schaffen um Entscheidungen zu treffen, dafür müssen die Daten innerhalb von Sekunden auswertbar sein. Recht schnell sammeln sich Terabytes an Daten zusammen, die nicht unbedingt sauber strukturiert sind, sondern als E-Mails, Dokumente, Fotos oder Videos vorhanden sind. Mit diesen Anforderungen muss die Datenbank dann zurechtkommen. Für die Entwickler stellt sich dann die Frage, welche Datenbank die richtige für das Projekt ist. Dabei beantworten viele Entwickler diese Frage nach Gefühl oder nach Gewohnheit und vernachlässigen dabei, sich Gedanken um den Anwendungszeck zu machen. [1]

Die folgenden Punkte können für die Wahl einer Datenbank berücksichtigt werden:
- **Anwendungsfall:** Der wichtigste Faktor für die Entscheidung, welche Datenbanktechnologie verwendet werden soll, ist der Anwendungszweck. Werden beispielsweise in einer Anwendung im Frontend viele Interaktionen ausgeführt mit einem hohen Datenvolumen und wichtig dabei sind kurze Reaktionszeiten, dann fällt die Wahl auf NoSQL-Datenbanken. Diese bieten den Vorteil, dass NoSQL-Datenbanken sich über Nodes skalieren und in Clustern organisiert sind. Das ermöglicht eine fast unendliche Flexibilität. Die klassische relationale Datenbank mit ihren festen Tabellenstrukturen kommen nur über Umwege und Problemumgehungen mit diesen Anforderungen zurecht, dadurch steigen bei der relationalen Datenbank die Kosten und das Leistungsverhalten der Datenbank sinkt. Daher sollte der Anwendungsfall genau betrachtet werden und sich dann für einen Datenbanktyp entschieden werden. [1]
- **Anforderungen für die Verfügbarkeit:** Ebenfalls zu beachten sind die Anforderungen in der Verfügbarkeit. Muss eine Anwendung immer verfügbar sein, auch bei steigender Anzahl an Arbeitslasten und paralleler Benutzernutzung, dann muss die Datenbank skalierbar sein um die Arbeitslasten zu schaffen. [1]
- **Zukunftsorientierte Datenbanktechnologie:** Die ausgewählte Datenbank sollte nicht nur die aktuellen Anforderungen erfüllen, sondern die Eigenschaften der Datenbank sollte auch zukünftige Arbeitsbelastung und Einsatzszenarien abdecken. [1]
- **Betriebskosten der Datenbank:** Bei Big Data werden große teure Server benötigt um die Abfragen und Analysen ausreichend performant auszuführen zu können. Bei steigendem Datenvolumen wird auch ein leistungsstärkerer Server benötigt. Bei den NoSQL-Datenbanken können die Server problemlos nach oben skaliert werden. [1]

Unterschiedliche Punkte sind für die Wahl der Datenbank entscheidet. Daher sollten die Entwickler eines Systems verschiedene Datenbanktechnologien kennen, damit die richtige Datenbanktechnologie gewählt wird und nicht später eine böse und teure Überraschung entsteht, den Wechsel der Datenbanktechnologie. Daher wird hier die Datenbanktechnologie Neo4j näher betrachtet und vorgestellt.


## 2. Neo4j
Neo4j ist eine quelloffene Graphdatenbank zur Speicherung vernetzter Informationen. Sie gehört zu den weit verbreiteten und bekanntesten Graphdatenbanken. Mit dieser Datenbank ist es möglich eine effiziente Verarbeitung unterschiedlicher Anwendungsfälle umzusetzen, die in relationalen Datenbanken mit anderen Datenmodellen eher aufwendig wären. [2] [3]

Neo4j wurde 2010 mit der ersten Version veröffentlicht und gehört zu den NoSQL-Datenbanken. Mittlerweile steht die Version 4.1.3 (stand Oktober 2020) zur Verfügung. Entwickelt wurde Neo4j mit der Programmiersprache Java. Allerdings werden Daten in einer Graphenstruktur aufgebaut und verwertet. Weiterhin ist Neo4j ein hochskalierbares System, das kostenlos und lizenzfrei in der Community Edition zur Verfügung steht. Außerdem gibt es einen Enterprise Bereich, dieser bietet umfangreiche Zusatzfunktionen. Dieser Enterprise Bereich benötigt aber eine kommerzielle Lizenz. [3] [4]


### 2.1. Was bringt eine Graph-Basierung?
Allgemein besteht ein Graph aus einer Menge von Knoten und Kanten. Diese Knoten und Kanten werden auch Beziehung genannt. Hierbei werden zwei Knoten jeweils durch eine Kante verbunden. In einer Graphdatenbank werden die Daten im Graph gespeichert. Außerdem sind in der Graphdatenbank die Knoten und Kanten quasi die primitive erste Ordnung. [2]

Die Graphdatenbank Neo4j besitzt wohl überlegte Strategien für die Verwaltung von riesigen und beliebig verknüpften Datenmengen. Hierfür verwendet Neo4j Mechanismen, die es ermöglichen Indizes auf Knoten und Beziehungen zu definieren. Mit Neo4j ist es möglich mehr als 1 Mio. Beziehungen pro Sekunde auf einer Standard-Hardware zu traversieren. Damit problematische bzw. nicht einfache Abfragen über einen Graphen formulieren zu können, besitzt Neo4j eine Vielzahl von Mechanismen. [2]

Heutzutage sind viele allgemeine Graph-Algorithmen in der Mathematik bzw. in der Informatik bekannt. Eine Implementierung von bekannten Graph-Algorithmen ist in Neo4j bereits vorhanden, z.B. sind die Algorithmen für die Suche von den kürzesten Wegen sowie der A*- Algorithmus und der Dijkstras Algorithmus bereits implementiert. [2]


### 2.2. Wofür eignet sich Neo4j?
Für ein System, wo die Daten zahlreich vernetzt und kaum strukturiert sind, eignet sich besonders Neo4j. Besitzt ein System zahlreiche zusammenhängende strukturierte Daten, die verwaltet werden müssen, dann eignet sich Neo4j nicht besonders und es wäre besser eine relationale Datenbank zu wählen. Besitzt das System allerdings vernetze Daten, wo die Beziehungen zwischen den Daten abgefragt werden müssen, dann ist Neo4j als Graphdatenbank die passende Wahl. Die folgende Abbildung zeigt einen Überblick von den Bestandteilen von Neo4j die ein Anwender benötigt. [2]

<center><img src="images/Neo4j-Überblick.jpg" title="Neo4j-Überblick" width="100%" height="auto"></center>


## 3. Fazit



## 4. Literaturverzeichnis

- [1] IT Verlag für Informationstechnik GmbH, „Fünf Tipps für die Wahl der richtigen Datenbank,“ 01 April 2020. [Online]. Available: https://www.it-daily.net/it-management/big-data-analytics/23876-fuenf-tipps-fuer-die-wahl-der-richtigen-datenbank. [Zugriff am 25 Oktober 2020].
- [2] P. Ghadir, „innoq.com,“ 24 Oktober 2020. [Online]. Available: https://www.innoq.com/de/articles/2012/09/neo4j-rockt/.
- [3] „datenbanken-verstehen.de,“ Begerow Beratungsgesellschaft mbH & Co. KG, [Online]. Available: https://www.datenbanken-verstehen.de/lexikon/neo4j/. [Zugriff am 24 Oktober 2020].
- [4] „neo4j.com,“ Neo4j, Inc., [Online]. Available: https://neo4j.com/release-notes/. [Zugriff am 24 Oktober 2020].

