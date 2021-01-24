### Query-Layer
Der Query-Layer vereint die Batch- und Echtzeit-Views und macht diese verfügbar. Um Abfragen zu beantworten, muss der Query-Layer entscheiden, welche Inhalte aus den jeweiligen Views verwendet werden sollen und wie diese vereint werden. Die Logik zur Vereinigung der Views hängt jeweils vom Anwendungsfall ab und kann unterschiedlich für verschiedene Views implementiert werden. 

Eine naheliegende Strategie um eine Anfrage zu beantworten, ist die Verwendung der Batch-Views bis zu dem Zeitpunkt an dem diese vollständig vorliegen. Den Zeitraum in dem keine Views aus dem Batch-Layer vorliegen kann der Query-Layer mit Views aus dem Speed-Layer vervollständigen.

Komplexere Strategie wären u.a. Daten aus Batch- oder Speed-Layer bevorzugt zu behandeln oder Daten aus dem Speed-Layer zu bevorzugen bis genauere Ergebnisse aus dem Batch-Layer vorliegen. 

Manche Anfragen könnten auch nur auf die Views aus dem Batch-Layer zurückgreifen, wenn die Echtzeitdaten des Speed-Layers für den Anwendungsfall nicht relevant sind oder umgekehrt, wenn nur Echtzeitdaten betrachtet werden sollen. 

Die Views müssen dementsprechend so strukturiert sein, dass die Vereinigung im Query-Layer möglich ist. Dies ist eine wichtige Designentscheidung um die Views nutzbringend miteinander kombinieren zu können. 