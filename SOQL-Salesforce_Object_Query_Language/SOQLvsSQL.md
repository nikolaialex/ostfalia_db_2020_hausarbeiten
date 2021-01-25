##5. Unterschiede zwischen SOQL und SQL##
__________
Obwohl die beiden Datenbankabfragesprachen **SQL** *- Structured Query Language -* und **SOQL** *- Salesforce Object Query Language -* sehr ähnlich sind und SOQL auch auf Basis von SQL entwickelt wurde, existieren einige signifikante Unterschiede, was natürlich auch mit deren Verwendung in unterschiedlichen Datenmodellen zu tun hat.

**Vergleich - Auflistung der wichtigsten Unterschiede**     

* SQL ist die Standard-ANSI-Standardabfragesprache zum Speichern, Bearbeiten und Abrufen von Daten in Datenbanken
* SQL wird zum Abrufen von Daten aus einer oder mehreren Tabellen verwendet. Diese Tabellen können entweder miteinander in Beziehung stehen oder nicht
* SQL ist eine Abfragesprache zum Abrufen von Daten in der relationalen Datenbank (z.B. Oracle, My SQL)     
* SQL unterstützt die: Datenabfragesprache (DQL), Datendefinitionssprache (DDL), Datensteuerungssprache (DCL), Datenmanipulationssprache (DML)
* SQL ermöglicht eine große Anzahl von Zeichenfolgen und numerischen Funktionen
* SQL kann innerhalb einer Abfrage mittels (*) alle Spalten in einer Tabelle zurückgeben
_ _ _ _ _ _ _ _ _ _  
* SOQL ist die Objektabfragesprache zum Abfragen von Daten und eine speziell optimierte Version von SQL, die speziell für die Arbeit mit der zugrunde liegenden Salesforce.com-Datenbank bzw. der force.com-Plattform entwickelt wurde 
* SOQL wird zum Abfragen der Daten eines bestimmten Objekts und der zugehörigen, in einer Beziehung zueinanderstehenden Objekte verwendet. Es ist in SOQL nicht möglich, Daten von zwei nicht verwandten Objekten abzurufen
* SOQL unterstützt keine SQL-spezifischen Funktionen auf fortgeschrittenem Niveau wie die Verwendung von Platzhaltern (*), Verknüpfungsoperationen, usw.
* SOQL unterstützt nur SELECT-Abfragen mit Feldauswahl, Filterung, begrenzten Verknüpfungen, begrenzten Group-Bys, Aggregaten und Sortierungen
* SOQL unterstützt Aggregatfunktionen, Datumsfunktionen für Gruppierungs- und Formatierungsfunktionen (toLabel, format, convertCurrency)
* SOQL unterstützt die Auswahl (*) - Stern - nicht, jeder Feldname muss explizit angegeben werden

###5.1 Fallbeispiel für die JOIN-Datenbankoperation###

**JOIN**     
Der wichtigste Unterschied bei der Verwendung von SOQL ist der Umgang mit JOINs. Das Schlüsselwort JOIN ist in SOQL nicht vorhanden. Außerdem können nur verwandte Objekte zusammen abgefragt werden.
Eltern-Kind- (Parent-Child) oder Kind-Eltern- (Child-Parent) Beziehungen sind die häufigsten und einfachsten Beziehungen in Salesforce. Anhand der Beziehung zwischen dem Account (übergeordnet) und Contact (untergeordnet) möchte ich das Konzept von SOQL-Joins demonstrieren.

**Data Model:**   

*Gegegeben sind die zwei Salesforce-Objekte **Contact** und **Account**. Ein Accountdatensatz kann mit 1:n Datensätzen des Contact-Objekts in Beziehung stehen. Ein Contact-Datensatz kann jedoch nur zu maximal einem Accountdatensatz zugeordnet sein.*  

Contact (0...n) <>----> (1) Account 

**Right Join:**     
SOQL: SELECT FirstName, LastName, Account.Name FROM Contact

SQL: SELECT contact.FirstName, contact.LastName, account.Name FROM Contact contact. RIGHT OUTER JOIN Account ON contact.Account=account.Id

**Left Join:**      
SOQL: SELECT Name,(SELECT FirstName, LastName FROM Contacts) FROM Account

SQL: SELECT account.Name, contact.FirstName, contact.LastName FROM Contact contact.LEFT OUTER JOIN Account ON contact.Account=account.Id



###5.1 Fallbeispiel für die SELECT-Datenbankoperation###


Die SELECT-Operation einer SOQL-Abfrage ähnelt der SQL-Syntax, es gibt jedoch eine wesentlichen Ausnahme: SELECT * ist nicht zulässig, es müssen immer die auszuwählenden Felder explizit angeben werden.      
Folges Syntax-Beispiel im Vergleich zw. SQL und SOQL:

SQL: SELECT * FROM Lead    
SQL: SELECT COUNT(*) FROM Account

SOQL: SELECT Id, Name, Company, Industry FROM Lead *('Id', 'Name', 'Company' und 'Industry')*    
SOQL: SELECT COUNT() FROM Account


__________

[Nächstes Kapitel](Werkzeuge.md)