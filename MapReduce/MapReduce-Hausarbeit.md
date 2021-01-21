# MapReduce

### Ausarbeitung des Themas MapReduce für das Modul Datenbanktechnologien

### Autoren

| Name               | Matrikelnummer | Hochschule |
| :----------------- | :------------- | :--------- |
| Corinna Schnögl     | 897102 | Beuth Hochschule für Technik Berlin  |
| Susanne Mitschke |         |   |

### Betreut durch:

Prof. Dr.-Ing. Nils Jensen und Nicolai Alex

### Abgabedatum:

25.01.2021


## Inhalterverzeichnis
1. [Einleitung](#einleitung)
2. [Definition](#definition)
3. [Die Grundfunktionen](#die-Grundfunktionen)
4. [Einsatzfelder](#einsatzfelder)
5. [Beispiele für MapReduce](#beispiele-für-MapReduce)
6. [Vor- und Nachteile](#vor-und-Nachteile)
7. [Hadoop](#hadoop)
8. [Fazit](#fazit)
9. [Literaturverzeichnis](#literaturverzeichnis)


## Einleitung

„In einem datengetriebenen Markt sammeln Algorithmen und Anwendungen rund um die Uhr Informationen zu Personen, Prozessen, Systemen und Organisationen. Das Ergebnis ist eine gigantische Datenflut, die täglich zunimmt. Die Herausforderung besteht nun darin, diese massiven Datenmengen schnell und effizient zu verarbeiten, ohne dass wertvolle Erkenntnisse verlorengehen“ (Talend, 2021).
Für dieses Szenario kommt das Programmiermodell MapReduce ins Spiel, da es aufgrund seiner Fähigkeit Terabytes an Daten aufzuteilen und parallel zu verarbeiten, bekannt geworden ist. MapReduce ist eine Kernkomponente des Hadoop-Frameworks und wird für den Zugriff auf Big Data im Hadoop File System (HDFS) verwendet (Talend, 2021). Deshalb wird das Thema MapReduce in dieser Arbeit näher betrachtet.

In Kapitel 2 und 3 wird als erstes der Begriff MapReduce definiert und die Grundfunktionen dargestellt. Kapitel 4 und 5 gehen auf die Einsatzfelder und Beispiele für MapReduce ein…..


## Definition

MapReduce ist ein von Google im Jahr 2004 entwickeltes Verfahren, mit dem sich große strukturierte oder auch unstrukturierte Datenmengen mit hoher Geschwindigkeit verarbeiten lassen. MapReduce kann als Framework für Datenbanken genutzt werden und eignet sich für die Verarbeitung von großen Datenmengen, die im Big-Data-Umfeld auftreten und bis zu mehreren Petabytes groß sind. Es parallelisiert die Bearbeitung durch die Verteilung auf mehrere Tasks die gleichzeitig ausgeführt werden. Dabei verteilt das Framework die Aufgaben auf verschiedene Rechner oder Cluster und führt die Ergebnisse im Anschluss zusammen. Das Verfahren kann bei Problemen mit einzelnen Rechnern die Aufgaben neu verteilen, was dazu führt, dass Entwickler sich nicht mehr um die Fehlerbehandlung, die Aufgabenüberwachung die Cluster-Kommunikation kümmern müssen (Luber & Litzel, 2017).



## Die Grundfunktionen

Die Grundfunktionen von MapReduce basieren auf den zwei Funktionen Map und Reduce, die nacheinander ausgeführt werden. Im ersten Schritt werden die Input-Daten in einzelne Segmente unterteilt die anschließend auf verschiedene Rechner verteilt werden. Die Datensegmente werden zu Key-Value-Paaren verarbeitet und für die Map-Funktion als Input bereitgestellt (Technische Hochschule Mittelhessen, 2015). „Die Map-Funktion nimmt die Eingabedaten von der Festplatte als -Paare, verarbeitet sie und generiert einen weiteren Satz an -Zwischenpaaren als Ausgabe. Die Reduce-Funktion nimmt ebenfalls Eingabedaten als -Paare und generiert -Paare als Ausgabe“ (Talend, 2021). Dadurch werden die Aufgaben in kleine parallelisierte Arbeitspakete aufgeteilt und anschließend wieder zusammengeführt. Das bedeutet, dass die Berechnungen parallel und zur selben Zeit laufen können und die Arbeitslast auf mehrere Rechner verteilt wird. Bei der Verarbeitung kommt zu den Phasen Map und Reduce noch die Shuffle Phase hinzu was auch in der nachfolgenden Abbildung 1 deutlich wird (Talend, 2021).

<p align="left"><img src="images/Abbildung1_Funktionsweise_MapReduce.jpg" title="Funktionsweise_MapReduce" width="60%" height="auto">
<br>Abbildung 1: Funktionsweise MapReduce (Wuttke, 2020)</p>

In der Shuffling Phase werden die Ergebnisdaten der Mapper vom Reducer eingelesen und anschließend nach ihrem Schlüssel sortiert und gruppiert. „Der Reduce-Funktion werden dann nacheinander ein Schlüssel mit dem Satz seiner zugehörigen Werte zur Verarbeitung übergeben. Die Ausgabe wird dann an ein finales Output-File angehängt. Sind alle Map- und Reduce-Funktionen abgeschlossen, benachrichtigt der Master das Benutzerprogramm. Das Ergebnis liegt dann in den Output-Files der einzelnen Reducer vor“ (Technische Hochschule Mittelhessen, 2015). Optional kann zusätzlich die Combiner-Funktion genutzt werden, die die Ergebnismenge der Map-Funktion reduziert, um möglichst wenig Daten über das Netzwerk senden zu müssen. Die typischen Probleme, die relationale Datenbanken mit der Verarbeitung von großen unstrukturierten Datenmengen haben werden mit MapReduce beseitigt (Luber & Litzel, 2017).

## Einsatzfelder

MapReduce wird oft im Big-Data-Umfeld verwendet. Dazu gehören beispielsweise Finanzanalysen, wissenschaftliche Simulationen oder das Data Mining. Auch die Suchmaschinenanbieter Google und Yahoo nutzten das Verfahren für die Indexierung der Webseiten. Außerdem wird MapReduce von vielen E-Mail-Providern für die Erkennung von Spam E-Mails eingesetzt. Weiter Anwender sind Facebook und Amazon. Facebook nutzt das Verfahren für Data Mining, die Optimierung von Ads und die Spam-Erkennung. Amazon nutzt MapReduce unteranderem für das Clustering von Produkten (Luber & Litzel, 2017).


## Beispiele für MapReduce

## Vor- und Nachteile

## Hadoop

Apache Hadoop ist ein auf Java basierendes Software Framework welches auf dem Map-Reduce Algorithmus basiert. Mit Hilfe dieser verteilten Big Data Plattform lassen sich große Datenmengen auf verteilten Systemen in hoher Geschwindigkeit verarbeiten. Dabei ist Hadoop eins der ersten Open Source Big Data System, gilt als Vorreiter der Big Date Ära und wurde bereits 2008 als Top Level Open Source Projekt eingestuft. Das Framework ist in der Lage sehr große Datenmengen zu speichern und anschließend mit hoher Geschwindigkeit verarbeiten zu können. Dies ist durch die verteile Architektur und die Parallelisierung möglich. Ein Hadoop Cluster setzt sich aus folgenden Komponenten zusammen: HDFS, YARN, MapReduce und einigen Erweiterungen. Dies wird in der Abbildung 2 verdeutlicht (Wuttke, 2020).

<p align="left"><img src="images/Hadoop-Komponenten.jpg" title="Funktionsweise_MapReduce" width="60%" height="auto">
<br>Abbildung 2: Hadoop Komponenten  (Wuttke, 2020)</p>

Da MapReduce bereits in einem vorherigen Kapitel genauer betrachtet wurde, wird im nachfolgenden auf YARN und HDFS näher eingegangen. YARN steht für Yet Another Resource Negotiatior und ist der Ressource Manager von Hadoop. Er ist dafür zuständig die Ressourcen eines Hadoop Clusters zu verteilen.
HDFS ist die Abkürzung für Hadoop Distributed File System welches auf große Datenmengen ausgelegt ist und Dateisysteme bis zu mehreren Millionen Dateien erstellen kann. „HDFS ist ein hochverfügbares, verteiltes Dateisystem zur Speicherung von sehr großen Datenmengen, welches in Clustern von Servern organisiert ist. .Dabei werden die Daten auf mehreren Rechnern (Nodes) innerhalb eines Clusters abgespeichert, das passiert in dem die Dateien in Datenblöcken mit fester Länge zerlegt und redundant auf den Knoten verteilt“ (Wuttke, 2020). Im Gegensatz zu klassischen Datenbanken legt Hadoop einzelne Files in dem Dateisystem ab. Das System arbeitet zudem in Clustern auf Servern und verwendet Masternodes, welche auch NameNodes genannt werden, und Datanodes (Wuttke, 2020)



## Fazit



## Literaturverzeichnis

Luber, S., & Litzel, N. (14. Juli 2017). Bigdata Insider. Abgerufen am 03. Januar 2021 von https://www.bigdata-insider.de/was-ist-mapreduce-a-624936/

Talend. (2021). Abgerufen am 04. Januar 2021 von https://www.talend.com/de/resources/what-is-mapreduce/

Technische Hochschule Mittelhessen. (05. Oktober 2015). Abgerufen am 04. Januar 2021 von http://wi-wiki.de/doku.php?id=bigdata:mapreduce

Wuttke, L. (2020). Datasolut. Abgerufen am 04. Januar 2021 von https://datasolut.com/apache-hadoop-einfuehrung/#Was-ist-MapReduce






