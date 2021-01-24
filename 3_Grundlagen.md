## Grundlagen

Einige Begrifflichkeiten spielen bei der Lambda-Architektur eine besondere Rolle. Die wichtigsten Begriffe werden in Folge erklärt.

### Immutable Data

Ein grundlegender Ansatz ist die Verwendung von *unveränderlichen Daten* (immutable data) bzw. *nur anhängenden* (append only) Datenstrukturen. Dies erleichtert die Verteilung und Parallelisierung von Berechnungen, da keine Synchronisation und Koordination des Zugriffes notwendig ist. Der Ansatz ist angelehnt an die funktionale Programmierung. Immutable oder Append-Only Data findet prinzipiell bei der Lambda-Architektur in vielen Aspekten Anwendung.

### Stream Processing

Stream Processing bedeutet, dass Daten dann verarbeitet werden, wie sie aufgezeichnet werden. Aus Ereignissen und Datenpunkten resultierende Eingaben werden nahezu in Echtzeit verarbeitet. Die Motivation dahinter liegt darin begründet, dass häufig zeitnahe Analyseergebnisse erforderlich sind. Stream Processing findet im Speed-Layer der Lambda-Architektur Anwendung.

### Batch Processing

Batch Processing bedeutet im Kontrast zum Stream Processing eine Offline-Datenverarbeitung von großen Mengen an Daten auf einen Schlag. Typischerweise werden beispielsweise alle Stammdaten auf einmal verarbeitet. Diese Art der Datenverarbeitung besitzt eine hohe Latenz und kann keine zeitnahen Ergebnisse liefern, aber andererseits wird zur Anfragezeit wenig Rechenleistung benötigt, um verarbeitete Daten abzufragen. Batch Processing findet im Batch-Layer der Lambda-Architektur Anwendung.

### Echtzeitdaten

Unter Echtzeitdaten versteht man in der Lambda-Architektur eine geringe Latenzzeit von Rohdaten bis zu verarbeiteten Daten, die aus Anfragen an das System resultieren. Harte Echtzeitanforderungen sind hiermit explizit nicht gemeint.