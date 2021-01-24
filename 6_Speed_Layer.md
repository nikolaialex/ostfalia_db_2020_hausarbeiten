## Speed-Layer
Mit dem Batch- und Serving-Layer werden die Anforderungen ... und wahlfreien lesenden Zugriff mit niedriger Latenz erfüllt. Die Anforderung des wahlfreien schreibenden Zugriffs, also Aktualisierungen mit niedriger Latenz, wird von den beiden Layern nicht erfüllt. Der Speed-Layer ist verantwortlich diese Anforderung an ein Datenhaltungssystem zu erfüllen. [Mar16, S. 245]

### Einführung
Die vom Batch-Layer erzeugten Views sind i.d.R. nicht aktuell sobald sie dem Serving-Layer verfügbar gemacht werden können. Die Berechnung der Views benötigt Zeit und während diese berechnet werden, gehen weiterhin Daten ein, die in der Berechnung nicht berücksichtigt werden können. Der Speed-Layer verarbeitet die eingehenden Daten, die in den Batch-Views fehlen. Batch-Layer und Serving-Layer sind also für den bestehenden Datenbestand zuständig und der Speed-Layer ergänzt dies, in dem er Echtzeitdaten verarbeitet und als View verfügbar macht bis diese Daten durch den Batch-Layer verfügbar gemacht werden. [Mar16, S. 245]

Unter Echtzeit verstehen wir hier wenige Millisekunden bis zu einigen Sekunden. Die Aufgabe des Speed-Layers diese Daten in Views zusammenzufassen und die Views aktuell zu halten stellt besondere Anforderungen an die Berechnung der Views. [Mar16, S. 246]

### Effizienz, inkrementelle Berechnungen
Da die Echtzeit-Views innerhalb von Millisekunden aktualisiert werden sollen, ist die Berechnung komplexer als die aus dem Batch-Layer bekannte Vorgehensweise die Views aus allen bekannten Daten neu zu berechnen. 
Bei neuen Daten wird das Ergebnis der vorhergehenden View-Erzeugung wiederverwendet und aktualisiert. Diese _inkrementelle Berechnung_ ist effizient, aber auch komplex, da wahlfreies Lesen und Schreiben erforderlich sind und weiterhin Skalierbarkeit und Fehlertoleranz umgesetzt werden müssen. [Mar16, S. 246 ff.]

### Wie sich Batch- und Speed-Layer ergänzen
Batch- und Echtzeit-Views bilden ihre Inhalte auf dieselbe Art ab. Jedoch werden die Inhalte nicht immer auf dieselbe Art hergeleitet. Für den Batch-View sind die vollständigen Daten für die Berechnung bekannt, der Speed-View muss mit unvollständigen Daten berechnet und dann inkrementell aktualisiert werden. Häufig werden die Inhalte der Echtzeit-Views angenähert, da dies effizienter umgesetzt werden kann und meistens ausreichend ist. 

Da alle Daten letztlich durch Batch- und Serving-Layer berechnet bzw. repräsentiert werden, werden die durch eine Näherung im Speed-Layer entstandenen Ungenauigkeiten fortlaufend korrigiert. Somit ist es möglich, Genauigkeit für schnellstmögliche Verfügbarkeit einzutauschen und dennoch akkurate Daten zu erhalten, nachdem diese durch den Batch-Layer verarbeitet wurden (Eventual Accuracy). [Mar16, S. 249]

Laut Nathan Marz ist die Verwendung inkrementeller Algorithmen, sowie veränderlicher Daten und Zustände die Hauptursache für Komplexität. [Mar11] Ein Vorteil der Lambda-Architektur ist die Isolation der nicht vermeidbaren Komplexität im Speed-Layer, ohne dass andere Komponenten des Systems davon beeinträchtigt werden.

### Paradigmen der Datenverarbeitung
Die Datenverarbeitung kann grundsätzlich in zwei Formen unterschieden werden: 

1. Synchrone Verarbeitung, eine Aktualisierungsanfrage an die Datenbank, das auslösende System wartet auf das Ergebnis und ist blockiert, bis dieses vorliegt. 
2. Asynchrone Verarbeitung, eine Aktualisierungsanfrage wird entgegen genommen, das auslösende System wartet nicht auf Antwort.[Ben14]

Nachfolgend wird kurz auf die Ansätze eine asynchrone Verarbeitung umzusetzen eingegangen. Das verarbeitende System muss in der Lage sein, viele Anfragen oder Ereignisse in kurzer Zeit entgegen zu nehmen und eine Verarbeitung sicherzustellen. Würde jedes Ereignis unmittelbar verarbeitet, würde dies nicht nur zu einer Überlastung des Systems führen, es könnte auch nicht sichergestellt werden, dass jedes Ereignis verarbeitet wurde. Tritt während der Verarbeitung ein Fehler auf, könnte die Verarbeitung nicht abgeschlossen werden, und die Information darüber, dass das Ereignis auftrat würde mit dem Abbruch der Verarbeitung verloren gehen. Der Eingang eines Ereignisses und dessen Verarbeitung wären stark miteinander gekoppelt.

Um das Entgegennehmen der Ereignisse und deren Verarbeitung voneinander zu entkoppeln werden Warteschlangen eingesetzt. In einer Warteschlange reihen sich die Ereignisse ein, bevor diese von einem Abnehmer bearbeitet werden.[Sta15] Somit ist die Anzahl der gleichzeitig stattfindenden Prozesse nicht von der Anzahl der Ereignisse abhängig, sondern von der Anzahl der eingesetzten Abnehmer. Ist die Verarbeitung eines Ereignisses durch einen Abnehmer abgeschlossen, kann dieser ein neues Ereignis aus der Warteschlange entnehmen und verarbeiten. 

In der Praxis werden Message-Queueing-Systeme oder auch Message-Broker verwendet, um die asynchrone Kommunikation mittels Nachrichten zu realisieren. Ein solches System übernimmt grundlegende Aufgaben wie die Validierung und Transformation von Ereignissen und bietet eine gemeinsame Schnittstelle um die Kommunikation zwischen den Komponenten des verteilten Systems (Produzenten, die Ereignisse erzeugen und Verbraucher, die Ereignisse verarbeiten) zu ermöglichen. Verbreitete Open-Source-Lösungen sind Apache Kafka, Apache ActiveMQ und RabbitMQ.[Rao19]
Aufgrund der Verarbeitung der Ereignisse durch ein Message-Queueing-System wird ein Ereignis auch als _Nachricht_ bezeichnet. 

#### Warteschlange mit einem Abnehmer
Die Idee einer Warteschlange mit einem Abnehmer ist es, dass eine Nachricht erst aus der Warteschlange entnommen wird, wenn der Abnehmer die erfolgreiche Verarbeitung gemeldet hat. Sollte ein Abnehmer während der Verarbeitung abstürzen, kann er keinen Erfolg melden und ein anderer Client kann die Verarbeitung beginnen. Somit ist es auch möglich, dass eine Nachricht durch mehrere Clients bearbeitet wird, es ist aber immer garantiert, dass eine Nachricht mindestens einmal verarbeitet wird. 

Sollen unterschiedliche Anwendungen eine Nachricht verwenden können, so muss ein einzelner Abnehmer die Logik für jede dieser Anwendungen implementieren. Die einzelnen Anwendungen sind somit nicht voneinander isoliert, da sie sich den Abnehmer teilen. Ein Fehler in der Berechnung für eine Anwendung könnte sich aufgrund der gemeinsamen Codebasis im Abnehmer auf andere Anwendungen auswirken.

Die Unabhängigkeit der Anwendungen kann mit einem Abnehmer nur erreicht werden, wenn für jede Anwendung eine eigene Warteschlange mit einem spezialisierten Abnehmer zur Verfügung steht. Doch dies erhöht die Arbeitslast des Warteschlangenservers erheblich, denn die Anzahl der eingehenden Ereignisse multipliziert sich nun mit der Anzahl der Warteschlangen.

#### Warteschlange mit mehreren Abnehmern
Ein nützlicheres Design ist eine einzelne Warteschlange, die es mehreren Abnehmern mit unterschiedlichen Anwendungen ermöglicht eine Nachricht auf eine Nachricht zu reagieren. Dabei wird ein inhärentes Problem des bisher beschriebenen Ansatzes deutlich: eine Nachricht kann nun nicht aus der Warteschlange entnommen werden, wenn ein Abnehmer eine erfolgreiche Verarbeitung gemeldet hat, denn es gibt evtl. noch weitere Abnehmer, die sich für diese Nachricht interessieren und ihre Verarbeitung noch nicht begonnen haben.

Um dieses Problem zu lösen, werden die Nachrichten nicht mehr ad-hoc aus der Warteschlange gelöscht, sondern die Warteschlange hält alle Nachrichten für einen zugesicherten Zeitraum vor und es liegt in der Verantwortung der Abnehmer, die bereits verarbeiteten Nachrichten nicht erneut anzufragen. 

Da alle Nachrichten für eine zugesicherte Zeit in der Warteschlange vorhanden sind, können die Abnehmer im Falle eines Fehlers die Nachrichten in der Reihenfolge ihres Auftretens erneut verarbeiten. Dies ist bei einer Warteschlange mit einem Abnehmer nicht möglich, zudem hat eine Warteschlange mit mehreren Abnehmern keine Nachteile gegenüber einer Warteschlange mit einem Abnehmer. Daher ist die Verwendung einer Warteschlange mit mehreren Abnehmern empfehlenswert (z.B. Apache Kafka).  

#### Streamverarbeitung
Das Storm Modell beschreibt den Ablauf der Datenverarbeitung als einen gerichteten azyklischen Graphen, der als Topologie bezeichnet wird. In dem Graphen repräsentiert jeder Knoten eine Operation und jede Kante repräsentiert den Datenfluss zwischen den Operationen.[Rao19]

### Übliche Technologien
Der Speed-Layer bildet sich einerseits aus einer Technologie für die Verarbeitung der Echtzeitdaten (Stream-Processing) und andererseits aus einer Datenbank, welche die berechneten Views speichert und verfügbar macht.  

Für die Implementierung des Speed-Layers werden Frameworks für Stream-Processing und Cluster-Computing eingesetzt. Einige dieser Projekte werden von der Apache Software Foundation betreut und weiterentwickelt, darunter Apache Storm, Apache Samza, Apache Spark und Apache Flink. Neben den Projekten der Apache Foundation werden auch häufig Lösungen von Microsoft (Azure Stream Analytics) oder Google (Cloud Dataflow) eingesetzt.

Die berechneten Views werden in hochskalierbaren NoSQL-Datenbanken wie z.B. Apache Cassandra gespeichert. 

### Apache Storm
Apache Storm ist eine Implementierung des Storm-Modells. 