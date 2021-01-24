## Architektur

Die Lambda-Architektur führt zwei Datenflusspfade ein: Der eine Pfad ermöglicht eine genaue, aber langsame Verarbeitung; der zweite Pfad ist schneller, analysiert Daten in Echtzeit, opfert dafür aber ggfs. die Genauigkeit der Ergebnisse. (!todo ZoinerTejada o. J.)

Die generelle Architektur ist in Abb. !todo dargestellt. Aus einer Rohdatenquelle werden die Daten auf die zwei Datenflusspfade aufgeteilt. Während der schnelle Pfad die Daten fast in Echtzeit aufbereitet und zur Verfügung stellt, kann der langsame Pfad eine genaue Berechnung vornehmen, bevor die Ergebnisse verfügbar gemacht werden.

Die Ergebnisse beider Pfade werden anschließend zusammengeführt, wodurch sowohl sehr alte Daten als auch sehr aktuelle Daten abgefragt werden können.

[< 1. Einleitung](1_Einleitung.md) | [3. Grundlagen >](3_Grundlagen.md)