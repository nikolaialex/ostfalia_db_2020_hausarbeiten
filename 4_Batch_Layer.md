## Batch-Layer

Der Batch-Layer verwaltet den Stammdatensatz und führt Berechnungen auf den Stammdaten durch, um gewünschte Abfragen auf die Daten mit verringertem Ressourcenaufwand zur Laufzeit zu ermöglichen. Die Verarbeitung erfolgt typischerweise parallelisiert und verteilt. Es können daher auch aufwändige Analysen mit Querverweisen auf andere Daten durchgeführt werden. Damit ist der Batch-Layer oft der Kern der Lambda-Architektur.

Insbesondere besteht die Funktionalität des Batch-Layers darin, sogenannte Batch-Views per Batch Processing regelmäßig zu berechnen, die auf die zu erwartenden Anfragen angepasst sind. Diese Batch-Views werden dann durch den Serving Layer indiziert und verarbeitet, um Abfragen mit geringem Aufwand durchzuführen. Da die Batch-Views nur mit hoher Latenz aktualisiert werden können, muss es einen Sonderweg für kürzlich hinzugekommene Daten geben. Dieser findet sich in der Lambda-Architektur im Speed-Layer und dessen Live-Views.

### Verwaltung der Stammdaten

Typischerweise wird der Stammdatensatz in der Lambda-Architektur innerhalb des Batch-Layers lokalisiert. Neue Daten, die in das System eingefügt werden sollen, werden im Batch Layer zum Stammdatensatz zusammengeführt. Ebenso können Korrekturen an den Stammdaten erfolgen. Die Lokalisierung der Stammdaten und die Zusammenführung mit neuen Daten innerhalb des Batch Layers hilft insbesondere dabei, bei Bedarf eine inkrementelle Verarbeitung neuer Daten zu ermöglichen.

Es erfolgt in der Regel kein wahlfreier Zugriff auf die Stammdaten, sodass die Daten in einem verteilten, redundanten Dateisystem wie beispielsweise HDFS abgelegt werden können, was ein hohes Maß an Skalierbarkeit sichert.

### Berechnungen der Batch-Views

Der Batch-Layer führt Berechnungen mit den Stammdaten durch und erzeugt damit neue Views der Daten, die sogenannten Batch-Views. Hierfür können prinzipiell beliebige Funktionen in beliebigen Programmiersprachen angewendet werden. Es ist auch möglich, externe Ressourcen einzubinden, beispielsweise um Vorhersagen mittels eines Machine-Learning-Modells durchzuführen.

Typische Anwendungen für Batch-Views sind Aggregationsoperationen, also die Erstellung von Mittelwerten, Summen und anderen statistischen Erhebungen. Diese Erhebungen erfordern oft alle Datensätze eines Datenmodells als Eingabe und erstellen daraus erheblich kleinere, aggregierte Batch-Views. Aber auch andere typische Datenbankoperationen wie Joins sind mit Batch-Views umsetzbar und beliebig kombinierbar.

Eine Aggregation ist beispielsweise ein Zugriffszähler: Wenn die Stammdaten alle Zugriffe auf eine Website beinhalten, könnte eine Verarbeitungsfunkion die Anzahl der Aufrufe für jede Stunde zusammenzählen und in einem Batch-View ablegen. Anfragen zu den Zugriffszahlen lassen sich damit in Folge enorm beschleunigen, ohne alle Stammdaten zu lesen.

Oft ist es nicht möglich, *alle* Daten vorher zu berechnen, da der mögliche Speicherplatz begrenzt ist. Daher ist es in der Praxis nötig, einen Kompromiss zu finden, sodass Daten teilweise in Batch-Views vorberechnet werden und teilweise innerhalb des Serving-Layers durch Echtzeitberechnungen zu den erwünschten Abfrageergebnissen ergänzt werden.

#### Neuberechnung oder inkrementelle Berechnung

Eine wichtige Designentscheidung bei der Implementierung der Berechnungen besteht darin, zu wählen, ob die Daten in jedem Durchlauf komplett neu erstellt, oder ob sie inkrementell durch die neuen Daten erweitert werden sollen. Auf den ersten Blick erscheint eine inkrementelle Berechnung in jedem Fall besser, da die Performance prinzipiell höher ist. Aber inkrementelle Berechnungen sind nicht in jedem Falle vorteilhaft oder überhaupt möglich. Hierbei gilt es, mehrere Aspekte zu beachten:

* Allgemeine Anwendbarkeit

  Es ergibt nicht in allen Fällen Sinn, eine Berechnung inkrementell durchzuführen, weil ggf. zusätzliche Daten für eine inkrementelle Erweiterung des Batch-Views notwendig werden, die die Größe des Views ansteigen lassen. Zudem ist die Komplexität von inkrementellen Berechnungen oft höher. Zuguterletzt muss man beachten, dass neben einer inkrementellen Berechnung auch (für den Fehlerfall o.ä.) immer die Möglichkeit bestehen muss, die Daten komplett neu zu erstellen, weshalb man daher auch immer ein Verfahren für Neuberechnung benötigt. Dadurch erhöht sich der Entwicklungsaufwand.

* Fehlertoleranz

  Neuberechnungen sind fehlertolerant: Wenn Fehler in den Stammdaten vorliegen, werden Korrekturen bei jeder Neuberechnung berücksichtigt. Zudem können beliebige Änderungen an den Berechnungen leicht umgesetzt werden. Bei inkrementeller Berechnung gestaltet sich dies oft schwierig oder unmöglich. Im Zweifelsfall muss eine Fehlerkorrektur bei inkrementeller Berechnung manuell eingepflegt, oder eine komplette Neuberechnung angestoßen werden.

* Performance

  Inkrementelle Berechnungen bieten grundsätzlich bessere Performance, da nur Berechnungen für neue Daten durchgeführt werden müssen. Allerdings kann die Größe der Batch-Views ansteigen, da zusätzliche Daten mitgeführt werden müssen, um die inkrementellen Berechnungen überhaupt erst zu ermöglichen.

Insgesamt ist eine Neuberechnung mit geringer Komplexität verbunden und robuster gegenüber Änderungen in den Verarbeitungsfunktionen oder Fehlern, erfordert aber einen hohen Rechenaufwand und temporär hohen Speicherbedarf. Inkrementelle Berechnungen sollten als Optimierung aufgefasst und bedarfsweise eingesetzt werden.

### Skalierbarkeit und das MapReduce-Paradigma

Ein wichtiger Aspekt bei der Konzeption eines Systems auf Basis der Lambda-Architektur ist die Skalierbarkeit. Genau wie eine verteilte und ggf. redundante Vorhaltung der Stammdaten muss auch die Verarbeitung der Daten zu Batch-Views verteilt und fehlertolerant durchgeführt werden.

Es gibt hier verschiedene Möglichkeiten, Frameworks und Verfahren, aber als wichtiger Baustein auf niedrigster Ebene hat sich das MapReduce-Berechnungsmodell etabliert. MapReduce ist ein einfaches Berechnungsmodell, das auf zwei Funktionen zur Umformung und Aggregation von Daten setzt. MapReduce wurde von Google für die Indizierung der Google-Suchmaschine konzipiert und war eins der ersten Systeme für verteilte Berechnungen im Petabyte-Bereich. Das Funktionsmodell von MapReduce setzt sich folgendermaßen zusammen:

* Die Stammdaten werden für eine Parallelisierung und Verteilung in Blöcke aufgeteilt.

* Eine *Map*-Funktion wird auf die Blöcke der Stammdaten angewendet und erzeugt aus ihnen beliebige Key-Value-Paare von neuen Daten. Hierbei können prinzipiell beliebige Datenverarbeitungsschritte – beispielsweise die o.g. Machine-Learning-Modelle – angewendet werden.

* In der sogenannten *Shuffle*-Phase werden die resultierenden Datensätze entsprechend ihrer Keys sortiert und wieder in Blöcke aufgeteilt.

* Eine *Reduce*-Funktion erhält als Eingabe jeweils die von der *Map*-Funktion erstellten Values mit gleichem Key und kann auf diese Value-Listen Aggregationsschritte anwenden, um wiederum neue Datensätze zu erstellen.

* Die Ausgaben der *Reduce*-Durchläufe werden zusammengefasst und abgespeichert.

Diese Struktur erlaubt eine Skalierung ohne besondere Hürden. Eine Fehlertoleranz ist ebenfalls einfach umsetzbar, beispielsweise für den Fall von Serverausfällen oder abgebrochenen Berechnungen wegen Ressourcenknappheit. Trotz dieser offensichtlichen Einfachheit des Berechnungsmodells hat sich herausgestellt, dass sich damit fast alle möglichen Verarbeitungs- und Umformungsmöglichkeiten von Daten effizient modellieren lassen.

Übertragen auf unser Beispiel der Aggregation der Zugriffszahlen pro Stunde für Web-Analytics könnte mit MapReduce eine mögliche Implementierung folgendermaßen aussehen:

* Die *Map*-Funktion rundet den Zeitstempel eines Zugriffs auf jede Stunde und generiert für jeden Eingabedatensatz einen neuen Datensatz, wobei der Key die gerundete Uhrzeit ist. Das Value des Key-Value-Paares kann einfach ein konstanter Wert sein.
* Die *Reduce*-Funktion zählt die Anzahl der Values für jeden Key und speichert die Summe für jeden Key als neuen Datensatz.

Damit erhält man als Ausgabe die gewünschten Zugriffszahlen in einem neuen Datenbank-View.

Ein Nachteil des MapReduce-Ansatzes ist eine schlechte praktische Umsetzbarkeit für komplexe Datenverarbeitungsabläufe. MapReduce ist eine Low-Level-Primitive, die es nicht erlaubt, komplexe Verarbeitungsschritte und Verarbeitungsketten, wie beispielsweise für Joins nötig, sauber und elegant zu formulieren. Daher haben sich in der Praxis domänenspezifische Sprachen und Abstraktionen etabliert, um die Datenverarbeitung zur Erzeugung von Batch-Views zu formulieren.

### Abstraktion von MapReduce-Programmen

Es existieren einige Abstraktionsmodelle und viele verschiedene konkrete Implementierungen von Berechnungsmodellen auf Basis von MapReduce. Ein populäres Abstraktionsmodell ist hierbei das Pipe-Diagramm. Hierbei wird die Datenverarbeitung als eine Abfolge von abstrakten Operationen aufgefasst, beispielsweise Funktionsanwendung, Aggregation, Filterung, Joins und so weiter. Die Verarbeitungsschritte basieren hierbei jeweils auf Tupeln an Daten, die als Eingabe verwendet werden und auch ausgegeben werden. Durch Kombination dieser Schritte lassen sich komplexe Berechnungen einerseits elegant formulieren und andererseits auf eine Abfolge an konkreten MapReduce-Schritten übersetzen.

Ein typisches Beispiel für den Nutzen dieser Abstraktion ist ein Join. Wenn mittels MapReduce zwei Tabellen zusammengefügt werden sollen, ist viel manuelle Arbeit nötig: Die Eingabe-Tabellen müssen in der *Map*-Funktion identifiziert und separat behandelt und in der *Reduce*-Funktion müssen die Spalten passend kombiniert werden. Hierbei können bei manueller Implementierung auf MapReduce-Ebene leicht Fehler passieren. Eine Abstraktion erlaubt die Ausführung mittels eines einzigen vordefinierten Join-Verarbeitungsschritts, ganz ähnlich wie in SQL bei relationalen Datenbanken.

Typische Beispiele für Abstraktionsschichten sind domänenspezifische Sprachen wie *Pig Latin* (in Hadoop integriert) oder *Cascalog* (auf Hadoop aufsetzend). Andere Systeme wie *Apache Hive* setzen sogar auf einen SQL-Dialekt, womit die Daten weitgehend wie mit einer relationalen Datenbank verarbeitet werden können.
