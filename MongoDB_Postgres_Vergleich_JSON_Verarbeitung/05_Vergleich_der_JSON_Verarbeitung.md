[Zurück](04_Ueber_MongoDB.md)

## 5. Vergleich der JSON Verarbeitung

Wir haben in den vorhergehenden Kapiteln einen allgemeinen Eindruck von JSON, MongoDB und Postgres bekommen. Hier soll es nun darum gehen, wie diese Technologien zusammenspielen. Zuerst geht es darum, wie MongoDB und Postgres jeweils konkret mit JSON arbeiten. Anschließend werden bestehende Tests, sowie Erfahrungsberichte analysiert, die beschreiben, wie sich die beiden Datenbanken in der Praxis im Umgang mit JSON schlagen.



### Verarbeitung von JSON in Postgres

Wenn es um die Verarbeitung von JSON in Postgres geht, kommt man nicht um die Differenzierung zwischen JSON und JSONB in Postgres herum. Wie im Kapitel über Postgres schon kurz beschrieben, wurde mit PostgreSQL-9.2 zuerst das reine JSON-Format in Postgres eingeführt. Das bedeutet die native Unterstützung für das eigentliche JSON Format. Allerdings sind die damit verbundenen formatierten Textdateien für leistungsintensive Abfragen, wie sie in Datenbanken oft benötigt werden, nicht besonders gut geeignet. [9] Suchvorgänge und damit Indexierung sind dabei wichtige Themen, die uns hier noch weiter begleiten werden. Das reine JSON-Format unterstützt nur die klassische B-Tree Indexierung, was heute für schnelle und effiziente Suchvorgänge nicht mehr das Optimum ist. [9]
Mit PostgreSQL-9.4 wurde deshalb JSONB eingeführt. Es ist eine Erweiterung des JSON Datentyps, die die JSON Daten im Binärformat speichert. JSONB erweitert die Möglichkeiten zur Arbeit mit JSON-Daten und Suche in den JSON-Daten. Die initiale Eingabe ist aufgrund der nötigen Konvertierung etwas langsamer als bei reinem JSON, aber ab dann ist die Verarbeitung deutlich schneller, da die Dateien nicht jedes Mal wieder geparst werden müssen. [11] Damit ist JSONB klar die präferierte Methode zur Arbeit mit JSON in Postgres.



#### Funktionsumfang JSON- und JSONB-Format

JSON|JSONB
---|---
JSON-Dokumente werden wie TEXT-Daten gespeichert. Es wird auf gültiges JSON geprüft.|JSON-Dokumente werden im Binärformat gespeichert.
JSON-Dokumente werden unverändert gespeichert, einschließlich Leerzeichen.|Leerzeichen abgetrimmt. Speichert in einem Format, das für eine schnellere und effiziente Suche förderlich ist.
Unterstützt keine breite Palette von JSON-Funktionen und Operatoren|Unterstützt alle JSON-Funktionen und -Operatoren
Unterstützt keine FULL-TEXT-SEARCH-Indexierung|Unterstützt FULL-TEXT-SEARCH Indexing
[9]



Ein Beispiel: Volltextsuche erfolgt in JSON über Operatoren, wie “@>” oder “#>”Versucht man dies in Postgres auf einer Tabelle mit Daten im JSON Format, wird ein Fehler zurückgegeben:




[Weiter](06_Fazit.md)