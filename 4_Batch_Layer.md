## Batch-Layer

Der Batch-Layer führt Berechnungen auf den Stammdaten durch, um gewünschte Abfragen auf die Daten mit verringertem Ressourcenaufwand zur Laufzeit zu ermöglichen. Es können auch aufwändige Analysen mit Querverweisen auf andere Daten durchgeführt werden. Damit ist der Batch-Layer oft der Kern der Lambda-Architektur.

Insbesondere besteht die Funktionalität des Batch-Layers darin, sogenannte Batch-Views regelmäßig zu berechnen, die auf die zu erwartenden Anfragen angepasst sind. Diese Batch-Views werden dann durch den Serving Layer indiziert und verarbeitet, um Abfragen mit geringem Aufwand durchzuführen. Da die Batch-Views nur mit hoher Latenz aktualisiert werden können, muss es einen Sonderweg für kürzlich hinzugekommene Daten geben. Dieser findet sich in der Lambda-Architektur im Speed-Layer und dessen Live-Views.

### Berechnungen im Batch-Layer

- Beliebige Funktionen
- Neben Zugriff auf Stammdaten auch Anwendung von beliebigen Modellen oder Algorithmen u.ä. möglich
- Unterscheidung zwischen Neuberechnung und inkrementellen Verfahren
- Diskussion zu Anforderungen an Vorberechnungsverfahren
  
### Das MapReduce-Paradigma

- Vorstellung von MapReduce als skalierbares Datenverarbeitungsverfahren
- Definition und einfache Beispiele
- Diskussion von Nachteilen

### Abstraktion mittels Pipe-Diagrammen

- Abstraktionsebene für Batch-Berechnungen, die das Modellieren erleichtert
- Definition und Beispiele
- Ausführung mittels MapReduce

### Anwendung in der Praxis

- DSLs für Pipe-Verarbeitung wie z.B. Cascalog
- Alternative Verarbeitungsmodelle