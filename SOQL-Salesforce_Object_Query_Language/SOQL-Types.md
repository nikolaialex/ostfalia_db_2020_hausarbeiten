


##4. Typen von SOQL Abfragen##
__________

###4.1 Wann nutzt man SOQL?###

* für das Abrufen von Daten von einem einzelnen Objekt oder von Multiplikationsobjekten, die miteinander in Beziehung stehen
* zum Zählen der Anzahl der Datensätze, die bestimmte Kriterien erfüllen
* um Ergebnisse als Teil der Abfrage(n) zu sortieren
* um Daten aus Zahlen-, Datums- oder Kontrollkästchenfeldern abzurufen


###4.2 SOQL Struktur / Syntax###
**Die Werte in der *WHERE* Operation in SOQL Abfragen sind nicht *case sensitive*, Groß- und Kleinbuchstaben müssen somit nicht beachtet werden!**

**SOQL Befehle:**

* SELECT *one or more fields, [SubQuery]* 
* FROM *an objectType* 
* WHERE *filter statements / conditions* 
* GROUP BY *fieldGroupByList* - (Ergebnismenge wird basierend auf dem angegebenen Feld gruppiert)
* HAVING *count(Field) condition / operator* - (Ergebnis wird gefiltert, Rückgabe ist eine aggregierte Funktion)
* ORDER BY *fieldOrderByList {ASC|DESC} [NULLS {FIRST|LAST}}]*
* LIMIT *numberOfRowsToReturn*
* OFFSET *numberOfRowsToShip*
* FOR {VIEW, UPDATE}


**Beispiel einer SOQL-Syntax:**

<span style="color:green">SELECT</span> *Id, Name, CloseDate, Amount* <span style="color:green">FROM</span> *Opportunity* <span style="color:green">WHERE</span> *Amount > 50000* <span style="color:green">AND</span> *CloseDate = Last_Year*
 
Weitere mögliche *WHERE*-Bedingungen:
 
 * <span style="color:green">WHERE</span> *Name LIKE 'Volkswagen%'* -> der Wert im Feld 'Name' startet mit 'Volkswagen'
 * <span style="color:green">WHERE</span> *Name LIKE '%Auto%'* -> der Wert im Feld beinhaltet das Wort 'Auto'
 * <span style="color:green">WHERE</span> *Account_Name__c* <span style="color:green">IN</span> *('Volkswagen', 'Auto')*
 * <span style="color:green">WHERE</span> *Account_Name__c* <span style="color:green">NOT IN</span> *('Volkswagen', 'Auto')*
 * <span style="color:green">ORDER BY</span> *Amount DESC* -> wird nach dem Feld *Amount* sortiert
 * <span style="color:green">LIMIT</span> *5* -> Maximal 5 Datensätze werden ausgegeben
  
###4.3 Operatoren###

SOQL unterstützt die folgenden bedingte Operatoren:

|      Operator      |                                                            Beschreibung                                                            |    
|:------------------:|:----------------------------------------------------------------------------------------------------------------------------------:|    
| =                  | ist gleich                                                                                                                         |    
| !=                 | ungleich                                                                                                                           |     
| <, <=              | kleiner als, kleiner als oder gleich                                                                                               |    
| >, >=              | größer als, größer als oder gleich                                                                                                 |    
| INCLUDES, EXCLUDES | schließt Werte ein oder aus und gilt nur für Auswahllisten mit Mehrfachauswahl                                                     |    
| LIKE               | Gibt die Datensätze zurück, bei denen die Werte mit dem nach dem Like-Operator angegebenen Muster übereinstimmen                   |    
| IN                 | Wählt nur die Datensätze aus, bei denen der Wert des Felds mit einem der nach dem Schlüsselwort IN angegebenen Werte übereinstimmt |     
| NOT IN             | Wählt nur die Datensätze aus, bei denen der Wert von nicht mit einem der nach dem Schlüsselwort IN angegebenen Werte übereinstimmt |             

* jeder in der obigen Tabelle erwähnte bedingte Operator gibt einen TRUE / FALSE-Wert zurück    
* benutzerdefinierte Logik durch z.B. mehrere bedingte Operatoren, welche mithilfe logischer Operatoren verbunden werden (AND, OR, NOT -> Boolescher Operator), ist möglich
* Verwendung von Apex-Variablen zum Vergleich in der SOQL-Abfrage möglich (vor Variablennamen Doppelpunkt (:) einfügen)


###4.4 Aggregat-Funktionen###
Folgende Aggregatfunktionen stehen in SOQL zur Verfügung:

* COUNT, COUNT(fieldName), COUNT_DISTRICT()
* AVG - gibt den Mittelwert eines numersichen Feldes aus
* SUM - bestimmt den Gesamtwert (Summe) eines numerischen Feldes
* AVERAGE (Value) - bestimmt den Durchschnittswert eines numerischen Feldes
* MIN (Value) - gibt den Minimalwert eines Feldes aus
* MAX (Value) - gibt den Maximalwert eines Feldes aus
 
 
**Beispiel-Sytnax:**

<span style="color:green">SELECT</span> **COUNT(id)** <span style="color:green">FROM</span> *Opportunity* <span style="color:green">WHERE</span> *CloseDate = LAST_YEAR* 
(Als Rückgabewert würde man eine numerische Zahl erhalten, z.B. 77) 

<span style="color:green">SELECT</span> *StageName*, **COUNT(Id)** <span style="color:green">FROM</span> *Opportunity* <span style="color:green">WHERE</span> *CloseDate = Last_Year* <span style="color:green">GROUP By</span> *StageName* (gibt eine Übersicht aller Datensätze mit der jeweiligen Anzahl zurück)

<span style="color:green">SELECT</span> *StageName*, **COUNT(Id)** <span style="color:green">FROM</span> *Opportunity* <span style="color:green">WHERE</span> *CloseDate = Last_Year* <span style="color:green">GROUP By</span> *StageName* <span style="color:green">HAVING</span> COUNT(Id) > 1 (gibt nur die Datensätze zurück, welche größer 1 sind)  

Der Unterschied zwischen der HAVING- und der WHERE-Bedingung besteht auch darin, dass man die aggregierte Funktion in der HAVING-Bedingung verwenden kann, aber nicht in der WHERE-Bedingung.

 
###4.5 Relationship Queries###
Eigenschaften von Relationship-Abfragen:

* wird verwendet, um Daten von mehr als einem verwandten Objekt gleichzeitig abzurufen
* ermöglicht das Abrufen von Daten von Objekten, die sowohl untergeordnet als auch übergeordnet zum aktuellen Objekt sein können
* verwendet die Punktnotation in der Abfrage, um übergeordnete Objektfelder abzurufen, z.B. SELECT FirstName, LastName, <span style="color:green">Account.Name</span> FROM Contact
* es gibt 2 Typen von Relationship Queries: 
  - from "child to parent relationship" 
  - from "parent to child relationship" 

**Beispiele für Relationship-Abfragen:**

Parent-Object: Account, Child-Object: Opportunity        
SELECT Name, Account.Name, Account.Type FROM Opportunity)     
SELECT Name, (SELECT Id, Name, CloseDate FROM Opportunities) FROM Account) WHERE Name = 'Volkswagen' => alle Opportunity-Datensätze des Accounts 'Volkswagen' werden ausgegeben


###4.6 SOQL in Apex###
SOQL-Abfragen können auch direkt in einer Apex-Klasse geschrieben werden. 
Hierbei ist Folgendes zu beachten:

* die SOQL-Abfrage gibt immer eine Liste <SObject> zurück und muss in Apex eine Liste <ObjectType> für das in der Abfrage angegebene Objekt zuordnnen
* das Abfrageergebnis wird immer in einer Liste und nicht in einer einzelnen Instanz gespeichert
* um die Ergebnisse einer SOQL-Abfrage zu durchlaufen, wird eine for-Schleife verwendet

**Beispiel für eine SOQL Abfrage in Apex:**
//fetch the records via SOQL
List<apex_invoice_c> invoiceList=new List<apex_invoice__c>();
invoiceList=[ select id, name, Apex_customer__r.Name, Apex_Status__c from Apex_Invoice__c where createdDate=today AND Apex_customer__r.Name != 'Test'];

System.debug('We have total of '+invoice.List.size()+ ' records in the list'); for (Apex_Invoice__c of objInvoice:invoiceList)
{
 System.debug('Invoice record '+objInvoice); //print the record fetched one by one
} 
 

__________

[Nächstes Kapitel](SOQLvsSQL.md)