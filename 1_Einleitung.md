## Einleitung 

Die Lambda-Architektur ist ein häufig anzutreffendes Entwurfsmuster für Big Data. Meist stoßen relationale Datenbanken, oder auch allgemeiner ausgedrückt herkömmliche Datenbanktechnologien, bei sehr großen Datenmengen an ihre Grenzen. Probleme ergeben sich dabei aufgrund der Skalierbarkeit, aber auch aufgrund der Komplexität.

Verwaltet beispielsweise eine relationale Datenbank um ein Vielfaches größere Datenmengen (Terabytes/Petabytes) als üblich, kann sie möglicherweise Anfragen nicht zeitnah bearbeiten oder aufgrund von Ressourcenmangel überhaupt nicht bearbeiten. Es gibt verschiedene Technologien, um die Skalierbarkeit von traditionellen Datenbanksystemen zu verbessern, beispielsweise Clustering, Sharding oder Caching; aber den Möglichkeiten sind Grenzen gesetzt. Zudem haben die meisten dieser Techniken in der praktischen Anwendung Nachteile. Grundsätzlich gilt: Der Skalierbarkeit normaler Datenbanksysteme ist eine Grenze gesetzt.

Die Lambda-Architektur skizziert ein Entwurfsmuster für Big-Data-Datenbanksysteme, das eine Skalierbarkeit in hohem Maße ermöglicht und dennoch mit geringer Latenz Anfragen beantworten kann, die auch kürzlich hinzugekommene Datensätze berücksichtigen. Die Komplexität ist merklich höher als bei traditionellen Datenbanksystemen, wird aber durch die Designentscheidungen der Lambda-Architektur auf ein praktisch handhabbares Maß begrenzt.

### Lambda Architektur und Big Data

Die folgende Tabelle soll erklären, welche Anforderungen an Big-Data-Systeme mittels der Eigenschaften der Lambda-Architektur gut erfüllt werden können.

Eigenschaft | Beschreibung
------------|-------------
Belastbarkeit und Fehlertoleranz	| Handling von Maschinenausfällen, Semantik/Konsistenz verteilter Datenbanken, Datendopplungen, parallele Ausführungen
Lesen und Aktualisieren mit geringen Latenzzeiten |	Geringe Latenzzeiten können implementiert werden: siehe Speed-Layer
Skalierbarkeit|	Bei der Lambda-Architektur sind alle drei Layer horizontal skalierbar, indem weitere Maschinen hinzugefügt werden
Allgemeingültigkeit |	Funktionen sind allgemeingültig anwendbar
Erweiterbarkeit |	Migrationen sollen schnell und einfach durchführbar sein
Ad-hoc-Abfragen|	Beliebige Abfragen sollen möglich sein (wenn auch mit suboptimaler Performance)
Minimaler Wartungsaufwand	| Komplexität aus den Kernkomponenten wird ausgelagert. Die Ausgaben von komplexen Komponenten sollten nach einiger Zeit ausgesondert werden
Fehlerbehebung	| Wird ermöglicht, indem die Nachverfolgung jedes einzelnen Wertes möglich ist

[< Deckblatt](README.md) | [2. Architektur >](2_Architektur.md)