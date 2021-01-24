## Serving-Layer

Die Ausgaben des Batch-Layers sind typischerweise rohe Datensätze, im einfachsten Fall eine reguläre Datei, die keinen wahlfreien Zugriff auf einzelne Datensätze erlaubt. Die vorab berechneten Views des Batch-Layers sind aber erst dann nützlich, wenn auf diese schnell zugegriffen werden kann. Es ist Aufgabe des Serving-Layers, dies zu ermöglichen. 

Wie auch der Batch-Layer ist der Serving-Layer auf mehrere Maschinen verteilt um Skalierbarkeit und Verfügbarkeit zu gewährleisten. 

### Einfachheit
Eine wichtige Eigenschaft des Serving-Layers ist seine Einfachheit. Die Einfachheit wird hauptsächlich dadurch erreicht, dass der Serving-Layer wahlfreies Schreiben nicht unterstützen muss. Das Schreiben in eine Datenbank ist komplex, bei verteilten Datenbanken steigt diese Komplexität um ein Vielfaches. Die Aufgabe des Serving-Layers ist es, Daten auszuliefern, und somit entfällt diese Komplexität, was dazu führt, dass auch sehr einfache Datenbanken, die sich leicht auf mehrere Maschinen verteilen lassen, benutzt werden können. 

### Normalisierung und Denormalisierung
Um einen Datenbestand konsistent und möglichst frei von Redundanzen zu halten, werden Daten häufig normalisiert, so dass diese auf mehrere Tabellen verteilt und nicht redundant vorhanden sind. Für viele Abfragen müssen die Daten wieder vereint werden, was zeitaufwändig ist. 
Der gegensätzliche Ansatz ist die Denormalisierung, bei der Daten in einer Tabelle zusammengefasst werden. Die Daten sind somit bereits zusammengefasst und stehen bei einer Abfrage schnell zur Verfügung. Andererseits müssen Änderungen, falls die Daten in mehreren Tabellen vorhanden sind, konsistent durchgeführt werden, um Inkonsistenzen zu vermeiden.

Diese gegensätzlichen Ansätze führen in ein Dilemma: es muss immer ein Kompromiss zwischen Konsistenz und Performanz gemacht werden. Durch die Aufteilung in mehrere Layer bietet die Lambda-Architektur einen Vorteil. Während der Batch-Layer den Stammdatensatz normalisiert verwalten kann, kann der Serving-Layer auf hohe Ausführungsgeschwindigkeiten optimiert werden und denormalisierten Daten verwenden. 

### Indizierung der Batch-Views
Die Wahl einer geeigneten Indizierungsstragie ist für einen hohen Durchsatz und eine niedrige Latenz entscheidend. Da die Datenbank des Serving-Layers verteilt ist, muss darauf geachtet werden, dass für die Auslieferung zusammengehöriger Daten nicht auf unterschiedliche Server zugegriffen werden muss. Sind bei der Beantwortung einer Client-Abfrage mehrere Server involviert, dann wird die Antwortzeit an den Client durch die Antwortzeit des langsamsten Servers bestimmt.

Die Möglichkeit den Serving-Layer genau an die Anforderungen der gestellten Abfragen anzupassen ist einer der Gründe für die hohe Effizienz der Lambda-Architektur.

### Unveränderbare Daten und Fehlertoleranz
Sind für den Serving-Layer neue Batch-Views verfügbar, so werden diese im Hintergrund geladen. Sobald der Ladevorgang abgeschlossen ist, wechseln die Datenbankserver des Serving-Layer zur neuen Version und löschen die alte.

Durch die Verteilung des Serving-Layer auf mehrere Maschinen und die unveränderbaren Daten ist der Serving-Layer fehlertolerant. Sollte es dennoch zu Fehlern kommen, so kann aus den Stammdaten des Batch-Layers der Datenbestand des Serving-Layers neuberechnet und unkompliziert ersetzt werden. 

### Umsetzung des Serving-Layers

Der Serving-Layer kann in der Praxis auf vielfältige Weise umgesetzt werden. Es lassen sich hierfür grundsätzlich viele NoSQL-Datenbanksysteme verwenden, die auf Verteilung ausgelegt sind. Hierzu gehören insbesondere dokumentbasierte Datenbanken oder verteilte Key-Value-Stores. Die herkömmliche Datenbank kann hierbei entweder komplett als Serving Layer dienen, oder durch eigene Softwarekomponenten ergänzt werden, um beispielsweise eine Denormalisierung zu ermöglichen [Cou15].