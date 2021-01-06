# MapReduce

### Ausarbeitung des Themas MapReduce für das Modul Datenbanktechnologien

### Autoren

| Name               | Matrikelnummer | Hochschule |
| :----------------- | :------------- | :--------- |
| Corinna Schnögl     |          | Beuth Hochschule für Technik Berlin  |
| Susanne Mitschke |         |   |


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



## Fazit



## Literaturverzeichnis

Luber, S., & Litzel, N. (14. Juli 2017). Bigdata Insider. Abgerufen am 03. Januar 2021 von https://www.bigdata-insider.de/was-ist-mapreduce-a-624936/

Talend. (2021). Abgerufen am 04. Januar 2021 von https://www.talend.com/de/resources/what-is-mapreduce/

Technische Hochschule Mittelhessen. (05. Oktober 2015). Abgerufen am 04. Januar 2021 von http://wi-wiki.de/doku.php?id=bigdata:mapreduce

Wuttke, L. (2020). Datasolut. Abgerufen am 04. Januar 2021 von https://datasolut.com/apache-hadoop-einfuehrung/#Was-ist-MapReduce






