## Batch-Layer

Der Batch-Layer verwaltet den Stammdatensatz und führt Berechnungen auf den Stammdaten durch, um gewünschte Abfragen auf die Daten mit verringertem Ressourcenaufwand zur Laufzeit zu ermöglichen. Die Verarbeitung erfolgt typischerweise parallelisiertund verteilt. Es können daher auch aufwändige Analysen mit Querverweisen auf andere Daten durchgeführt werden. Damit ist der Batch-Layer oft der Kern der Lambda-Architektur.

Insbesondere besteht die Funktionalität des Batch-Layers darin, sogenannte Batch-Views regelmäßig zu berechnen, die auf die zu erwartenden Anfragen angepasst sind. Diese Batch-Views werden dann durch den Serving Layer indiziert und verarbeitet, um Abfragen mit geringem Aufwand durchzuführen. Da die Batch-Views nur mit hoher Latenz aktualisiert werden können, muss es einen Sonderweg für kürzlich hinzugekommene Daten geben. Dieser findet sich in der Lambda-Architektur im Speed-Layer und dessen Live-Views.

### Verwaltung der Stammdatensatzes

Typischerweise wird der Stammdatensatz in der Lambda-Architektur innerhalb des Batch-Layers lokalisiert. Neue Daten, die in das System eingefügt werden sollen, werden im Batch Layer zum Stammdatensatz zusammengeführt. Ebenso können Korrekturen an den Stammdaten erfolgen. Die Lokalisierung der Stammdaten und die Zusammenführung mit neuen Daten innerhalb des Batch Layers hilft insbesondere dabei, bei Bedarf eine inkrementelle Verarbeitung neuer Daten zu ermöglichen.

Es erfolgt in der Regel kein wahlfreier Zugriff auf die Stammdaten, sodass die Daten in einem verteilten, redundanten Dateisystem wie beispielsweise HDFS abgelegt werden können, was ein hohes Maß an Skalierbarkeit sichert.

### Berechnungen der Batch-Views

Der Batch-Layer führt Berechnungen mit den Stammdaten durch und erzeugt damit neue Views der Daten, die sogenannten Batch-Views. Hierfür können prinzipiell beliebige Funktionen in beliebigen Programmiersprachen angewendet werden. Es ist auch möglich, externe Ressourcen einzubinden, beispielsweise um Vorhersagen mittels eines Machine-Learning-Modells durchzuführen.

Typische Anwendungen für Batch-Views sind Aggregationsoperationen, also die Erstellung von Mittelwerten, Summen und anderen statistischen Erhebungen. Diese Erhebungen erfordern oft alle Datensätze eines Datenmodells als Eingabe und erstellen daraus erheblich kleinere, aggregierte Batch-Views. Aber auch andere typische Datenbankoperationen wie Joins sind mit Batch-Views umsetzbar und beliebig kombinierbar.

Eine Aggregation ist beispielsweise ein Zugriffszähler: wenn die Stammdaten alle Zugriffe auf eine Website beinhalten, könnte eine Verarbeitungsfunkion die Anzahl der Aufrufe für jede Stunde zusammenzählen und in einem Batch-View ablegen. Anfragen zu den Zugriffszahle lassen sich damit in Folge enorm beschleunigen, ohne alle Stammdaten zu lesen.

Oft ist es nicht möglich, *alle* Daten vorherzuberechnen, da der mögliche Speicherplatz begrenzt ist. Daher ist es in der Praxis nötig, einen Kompromiss zu finden, sodass Daten teilweise in Batch-Views vorberechnet werden und teilweise innerhalb des Serving-Layers durch Echtzeitberechnungen zu den erwünschten Abfrageergebnissen ergänzt werden.

#### Neuberechnungen oder inkrementelle Berechnungen

Eine wichtige Designentscheidung bei der Implementierung der Berechnungen besteht darin, zu wählen, ob die Daten in jedem Durchlauf der Berechnungen komplett neu erstellt werden sollen, oder ob sie inkrementell erweitert werden sollen. Auf den ersten Blick erscheint eine inkrementelle Berechnung in jedem Falle besser, da die Performance höher ist. Aber inkrementelle Berechnungen sind nicht in jedem Falle vorteilhaft oder überhaupt möglich. Hierbei gilt es mehrere Aspekte zu beachten:

* Allgemeine Anwendbarkeit

  Es macht nicht in allen Fällen Sinn, eine Berechnung inkrementell durchzuführen, weil ggf. zusätzliche Daten für eine inkrementelle Erweiterung des Batch-Views notwendig werden, die die Größe des Views ansteigen lassen. Zudem ist die Komplexität von inkrementellen Berechnungen oft höher. Zuguterletzt muss man beachten, dass neben einer inkrementellen Berechnung auch (für den Fehlerfall o.ä.) immer die Möglichkeit bestehen muss, die Daten komplett neu zu erstellen, weshalb man daher auch immer ein Verfahren für Neuberechnung benötigt. Dadurch erhöht sich der Entwicklungsaufwand.

* Fehlertoleranz

  Neuberechnungen sind fehlertolerant: wenn Fehler in den Stammdaten vorliegen, werden diese bei jeder Neuberechnung berücksichtigt. Zudem können beliebige Änderungen an den Berechnungen leicht angewendet werden. Bei inkrementeller Berechnung gestaltet sich dies oft schwierig oder unmöglich. Im Zweifelsfall muss eine Fehlerkorrektur bei inkrementeller Berechnung manuell eingepflegt werden, oder eine komplette Neuberechnung angestoßen werden.

* Performance

  Inkrementelle Berechnungen bieten grundsätzlich bessere Performance, da nur Berechnungen für neue Daten durchgeführt werden müssen. Allerdings kann die Größe der Batch-Views ansteigen, da zusätzliche Daten mitgeführt werden müssen, um die inkrementellen Berechnungen überhaupt erst zu ermöglichen.

Insgesamt ist eine Neuberechnung mit geringer Komplexität verbunden und robuster gegenüber Änderungen in den Verarbeitungsfunktionen oder Fehlern, erfordert aber einen hohen Rechenaufwand und temporär hohen Speicherbedarf. Inkrementelle Berechnungen sollten als Optimierung aufgefasst werden und bedarfsweise eingesetzt werden.

### Skalierbarkeit und das MapReduce-Paradigma

Ein wichtiger Aspekt bei der Konzeption eines Systems auf Basis der Lambda-Architektur ist die Skalierbarkeit. Genau wie eine verteilte und ggf. redundante Vorhaltung der Stammdaten muss auch die Verarbeitung der Daten zu Batch-Views verteilt und fehlertolerant durchgeführt werden.

Es geht hier verschiedene Möglichkeiten, Frameworks und Verfahren, aber als wichtiger Baustein auf niedrigster Ebene hat sich hier das MapReduce-Berechnungsmodell etabliert. MapReduce ist ein einfacher Berechnungsmodell, das auf zwei Funktionen zur Umformung und Aggregation von Daten setzt.

* Die *Map*-Funktion wird auf jeden Datensatz der Stammdaten angewendet und erzeugt aus ihnen beliebige Key-Value-Paare von neuen Daten. Hierbei können prinzipiell beliebige Datenverarbeitungsschritte angewendet werden, beispielsweise die o.g. Machine-Learning-Modelle angewendet werden.

* Die *Reduce*-Funktion erhält als Eingabe jeweils alle von der *Map*-Funktion erstellten Values mit gleichen Key und kann auf diese Value-Listen Aggregationsschritte anwenden, um wiederum neue Datensätze zu erstellen.

Dabei können die Daten für die *Map*-Funktion beliebig verteilt werden und die Daten für die *Reduce*-Funktion anhand der Keys der Key-Value-Paare verteilt werden. Eine Fehlertoleranz ist ebenfalls einfach umsetzbar.

Übertragen auf unser Beispiel der Aggregation der Zugriffszahlen pro Stund für Web-Analytics könnte mit MapReduce eine mögliche Implementierung folgendermaßen aussehen:

* Die *Map*-Funktion rundet den Zeitstempel eines Zugriffs auf jede Stunde. Das Value des Key-Value-Paares kann einfach ein konstanter Wert sein.
* Die *Value*-Funktion zählt die Anzahl der Values für jeden Key zusammen und speichert die Summe als neuen Datensatz.

Ein Nachteil des MapReduce-Ansatzes ist eine schlechte praktische Umsetzbarkeit für komplexe Datenverarbeitunsabläufe. MapReduce ist eine Low-Level-Primitive, die es nicht erlaubt, komplexe Verarbeitungsschritte wie beispielsweise Joins, sauber und elegant zu formulieren. Daher haben sich in der Praxis domänenspezifische Sprachen und Abstraktionen etabliert, um die Datenverarbeitung zur Erzeugung von Batch-Views zu formulieren.

### Abstraktion mittels Pipe-Diagrammen

- Abstraktionsebene für Batch-Berechnungen, die das Modellieren erleichtert
- Definition und Beispiele
- Ausführung mittels MapReduce

### Anwendung in der Praxis

- DSLs für Pipe-Verarbeitung wie z.B. Cascalog
- Alternative Verarbeitungsmodelle