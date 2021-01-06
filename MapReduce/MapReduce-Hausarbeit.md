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

## Einsatzfelder



## Beispiele für MapReduce

## Vor- und Nachteile

## Hadoop



## Fazit



## Literaturverzeichnis


