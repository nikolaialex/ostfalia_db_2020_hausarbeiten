## Serving-Layer

Die vorab berechneten Views des Batch-Layers sind erst dann nützlich, wenn auf diese schnell zugegriffen werden kann. Es ist Aufgabe des Serving-Layers dies zu ermöglichen. 

Wie auch der Batch-Layer ist der Serving-Layer auf mehrere Maschinen verteilt um Skalierbarkeit und Verfügbarkeit zu gewährleisten. 

### Einfachheit
Eine wichtige Eigenschaft des Serving-Layers ist seine Einfachheit. Die Einfachheit wird hauptsächlich dadurch erreicht, dass der Serving-Layer wahlfreies Schreiben nicht unterstützen muss. Das Schreiben in eine Datenbank ist komplex, bei verteilten Datenbanken steigt diese Komplexität um ein Vielfaches. Die Aufgabe des Serving-Layers ist es Daten auszuliefern und somit entfällt diese Komplexität, was dazu führt, dass auch sehr einfache Datenbanken, die sich leicht auf mehrere Maschinen verteilen lassen, benutzt werden können. 

### Normalisierung und Denormalisierung
Um einen Datenbestand konsistent und möglichst frei von Redundanzen zu halten, werden Daten häufig normalisiert, so dass diese auf mehrere Tabellen verteilt sind. Für viele Abfragen müssen die Daten wieder vereint werden, was zeitaufwändig ist. 
Der gegensätzliche Ansatz ist die Denormalisierung, bei der Daten in einer Tabelle zusammengefasst werden. Die Daten sind somit bereits zusammengefasst und stehen bei einer Abfrage schnell zur Verfügung. 

Diese gegensätzlichen Ansätze führen in ein Dilemma: es muss immer ein Kompromiss zwischen Konsistenz und Performanz gemacht werden. Durch die Aufteilung in mehrere Layer bietet die Lambda-Architektur einen Vorteil. Während der Batch-Layer den Stammdatensatz normalisiert verwalten kann, kann der Serving-Layer auf hohe Ausführungsgeschwindigkeiten optimiert werden und denormalisierten Daten verwenden. 

### Indizierung der Batch-Views
Die Wahl einer geeigneten Indizierungsstragie ist für einen hohen Durchsatz und eine niedrige Latenz entscheidend. Da die Datenbank des Serving-Layers verteilt ist, muss darauf geachtet werden, dass für die Auslieferung zusammengehöriger Daten nicht auf unterschiedliche Server zugegriffen werden muss. Sind bei der Beantwortung einer Client-Abfrage mehrere Server involviert, dann wird die Antwortzeit an den Client durch die Antwortzeit des langsamsten Servers bestimmt.

Die Möglichkeit den Serving-Layer genau an die Anforderungen der gestellten Abfragen anzupassen ist einer der Gründe für die hohe Effizienz der Lambda-Architektur.

### Unveränderbare Daten und Fehlertoleranz
Sind für den Serving-Layer neue Batch-Views verfügbar, so werden diese im Hintergrund geladen. Sobald der Ladevorgang abgeschlossen ist, wechseln die Datenbankserver des Serving-Layer zur neuen Version und löschen die alte.

Durch die Verteilung des Serving-Layer auf mehrere Maschinen und die unveränderbaren Daten ist der Serving-Layer fehlertolerant. Sollte es dennoch zu Fehlern kommen, so kann aus den Stammdaten des Batch-Layers der Datenbestand des Serving-Layers neuberechnet und unkompliziert ersetzt werden. 