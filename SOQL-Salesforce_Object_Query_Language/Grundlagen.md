##3. Grundlagen von SOQL##
__________
Wie der Name schon beschreibt, ist SOQL - **Salesforce Object Query Language** - eine Abfragesprache für eine objektorientiere Datenbank (Objektdatenbank). Dies ist ein erster großer Unterschied im Vergleich zu der bekannten Abfragesprache SQL.   
*(Hinweis: auf eine Erläuterung bzw. weiterführende Defintion von SQL und dem relationalen Datenbankmodell wird hier nicht weiter eingegangen)*  

###3.1 Objektorientiertes Datenbankmodell###

Das objektorientierte Datenbankmodell ergänzt ohne wesentliche Brüche die objektorientierten Programmiersprachen, d.h. eine objektorientierte Datenbank erlaubt die persistente Speicherung von Objekten, also von Instanzen diversen Klassen einer Anwendung über die Laufzeit der Anwendung hinaus. Die Zugriffe auf die Objekte sind im Modell der objektorientierten Anwendung festgelegt, d.h. der Zugriff auf die persistenten Daten erfolgt genau so, wie der Zugriff auf die Objekte in der Anwendung realisiert ist.  
Objektorientierte Datenbanken (OODBMS) setzen also andere Prioritäten, da dort die Daten an erster Stelle stehen, an welchen sich die Datenbankstruktur orientiert.
Eine Weiterführung im Entwicklungsprozess von Datenbanken ist das Objektrelationales Datenbankmodell, welches eine Erweiterung des relationalen Modells um Ideen aus der objektorientierten Programmierung ist. Es ist also eine Mischform, die beide Modelle unterstützt und so das bewährte relationale Modell bereithält, ohne auf die Möglichkeiten des objektorientierten Modells insbesondere im Zusammenhang mit objektorientierten Anwendungen zu verzichten.

####Zusammenfassend: Relationales Datenbankmodells vs. Objektorientiertes Datenbankmodell####

**Relationales Datenbankmodell:** Daten werden zeilenweise in Tabellen verwaltet und es kann beliebige Beziehungen zwischen den einzelnen Daten geben. Die Beziehungen werden durch Werte bestimmter Tabellenspalten festgelegt.

**Objektorientiertes Datenbankmodell:** Die Beziehungen (Relations) zwischen Datenobjekten werden vom Datenbanksystem selbst verwaltet und Objekte können Eigenschaften und Daten von anderen Objekten erben.    


###3.2 Objekte in Salesforce###
Salesforce unterstützt neben den Salesforce-Standardobjekten auch benutzerdefinierte, externe sowie Plattformobjekte.    
Salesforce-Standardobjekte sind z.B.:
 
  * Account (das Account-Objekt ist das "höchstgestellteste" (und wichtigste) Objekt in Salesforce)
  * Contact
  * Lead
  * Opportunity    

Einige dieser Standardobjekte werden wir in späteren Kapiteln als Basis für Abfragen verwenden.
Benutzerdefinierte Objekte können durch jeden Anwender explizit nach den jeweiligen Anforderungen und Wünschen angelegt werden. Ein benutzerdefiniertes Objekt kann z.B. das Objekt "Rechnungen" oder "Kundenaufträge" sein.


###3.3 Anwendung von SOQL###
Wofür kann SOQL verwendet werden?
Im Unterschied zu SQL ist SOQL eine Abfragesprache, die ausschließlich zum Abfragen der Datenbank dient. Es ist mit SOQL nicht möglich, Daten wie - bekannterweise - in SQL zu ändern bzw. zu modifizieren. Anweisungen wie z.B. INSERT-, oder UPDATE-Anweisungen sind nicht vorhanden. Das Ändern von Daten erfolgt über die Salesforce-Benutzeroberfläche oder Apex DML, die Teil der proprietären Programmiersprache von Salesforce ist. In SOQL werden Salesforce-Objekte als SQL-Tabellen dargestellt.

**Merkmale von SOQL**

* SOQL kann verwendet werden, um die Salesforce-Daten nach bestimmten Informationen zu durchsuchen      
* SOQL-Anweisungen beginnen immer mit der SELECT-Anweisung       
* SOQL-Rückgabeliste ist ein sObject (sObject steht für Salesforce-Objekt)<sup>(3)</sup>
* SOQL unterstützt keine erweiterten SQL-Funktionen wie Platzhalter (*) und Joins
* die maximale Anzahl von Zeichen in SOQL beträgt 20000 (Zeichen)
* SOQL kann einen Datensatz nach bestimmten Kriterien nur in einem einzigen sObject durchsuchen. Es ist möglich, in mehren Objekten zu suchen / abzufragen, jedoch müssen diese Objekte in einer Beziehung zueinander stehen - z.B. *Parent-Child-Relationship*
* SOQL unterstützt verschachtelte Abfragen
* SOQL verwendet dieselbe Struktur und dieselben Schlüsselwörter wie SQL
* Daten aus Salesforce können mithilfe von SOQL-Abfragen in den folgenden Werkzeuge abgefragt werden:
  * direkt über Apex-Code, 
  * der Entwicklerkonsole, 
  * über Salesforce-REST- und SOAP-APIs (z.B. Workbench, Salesforce Inspector), 
  * über die Salesforce-CLI<sup>(4)</sup>
  
 
**Fehlermeldung "QUERY-TO-COMPLICATED" bei SOQL-Abfragen:**

* Wenn eine SOQL-Abfrage zu viele Formelfelder enthält, führt dies zu einem QUERY-TO-COMPLICATED-Fehler
* Wenn ein Seitenlayout in Salesforce-Lightning<sup>(5)</sup> mehr als 250 Felder enthält, führt dies zu einem QUERY-TO-COMPLICATED-Fehler, da Lighning automatisch generierte Abfragen verwendet, um die Felder abzurufen

<sup>(3)</sup>*Ein sObject ist ein Apex-Datentyp, der einem Salesforce-Objekt (sObject) in einer Organisation entspricht. sObjects sind komplexe Datentypen, die in einer einzelnen Variablen mehrere Werte enthalten. Sie enthalten einen einzigen Datensatz mit Daten aus einem Salesforce-Objekt, wie beispielsweise einem Account, einem Kontakt oder einer Opportunity.*

<sup>(4)</sup>*Die Salesforce-CLI ist eine leistungsstarke Befehlszeilenschnittstelle, die die Entwicklung und Build-Automatisierung bei der Arbeit mit Ihrer Salesforce-Organisation vereinfacht*

<sup>(5)</sup>*Salesforce-Lightning ist eine neue Benutzeroberfläche von Salesforce*


__________

[Nächstes Kapitel](SOQL-Types.md)