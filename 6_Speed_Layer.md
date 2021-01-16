## Speed-Layer
Mit dem Batch- und Serving-Layer werden die Anforderungen ... und wahlfreien lesenden Zugriff mit niedriger Latenz erfüllt. Die Anforderung des wahlfreien schreibenden Zugriffs, also Aktualisierungen mit niedriger Latenz, wird von den beiden Layern nicht erfüllt. Der Speed-Layer ist verantwortlich diese Anforderung an ein Datenhaltungssystem zu erfüllen. [Mar16, S. 245]

### Einführung
Die vom Batch-Layer erzeugten Views sind i.d.R. nicht aktuell sobald sie dem Serving-Layer verfügbar gemacht werden können. Die Berechnung der Views benötigt Zeit und während diese berechnet werden, gehen weiterhin Daten ein, die in der Berechnung nicht berücksichtigt werden können. Der Speed-Layer verarbeitet die eingehenden Daten, die in den Batch-Views fehlen. Batch-Layer und Serving-Layer sind also für den bestehenden Datenbestand zuständig und der Speed-Layer ergänzt dies, in dem er Echtzeitdaten verarbeitet und als View verfügbar macht bis diese Daten durch den Batch-Layer verfügbar gemacht werden. [Mar16, S. 245]

Unter Echtzeit verstehen wir hier wenige Millisekunden bis zu einigen Sekunden. Die Aufgabe des Speed-Layers diese Daten in Views zusammenzufassen und die Views aktuell zu halten stellt besondere Anforderungen an die Berechnung der Views. [Mar16, S. 246]

### Effizienz, inkrementelle Berechnungen
Da die Echtzeit-Views innerhalb von Millisekunden aktualisiert werden sollen, ist die Berechnung komplexer als die aus dem Batch-Layer bekannte Vorgehensweise die Views aus allen bekannten Daten neu zu berechnen. 
Bei neuen Daten wird das Ergebnis der vorhergehenden View-Erzeugung wiederverwendet und aktualisiert. Diese _inkrementelle Berechnung_ ist effizient, aber auch komplex, da wahlfreies Lesen und Schreiben erforderlich sind und weiterhin Skalierbarkeit und Fehlertoleranz umgesetzt werden müssen. [Mar16, S. 246 ff.]

### CAP-Theorem

### Wie sich Batch- und Speed-Layer ergänzen
Batch- und Echtzeit-Views bilden ihre Inhalte auf dieselbe Art ab. Jedoch werden die Inhalte nicht immer auf dieselbe Art hergeleitet. Für den Batch-View sind die vollständigen Daten für die Berechnung bekannt, der Speed-View muss mit unvollständigen Daten berechnet und dann inkrementell aktualisiert werden. Häufig werden die Inhalte der Echtzeit-Views angenähert, da dies effizienter umgesetzt werden kann und meistens ausreichend ist. 

Da alle Daten letztlich durch Batch- und Serving-Layer berechnet bzw. repräsentiert werden, werden die durch eine Näherung im Speed-Layer entstandenen Ungenauigkeiten fortlaufend korrigiert. Somit ist es möglich, Genauigkeit für schnellstmögliche Verfügbarkeit einzutauschen und dennoch akkurate Daten zu erhalten, nachdem diese durch den Batch-Layer verarbeitet wurden. [Mar16, S. 249]