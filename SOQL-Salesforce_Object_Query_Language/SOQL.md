##2. Was ist SOQL?##
__________
SOQL (Salesforce Object Query Language) ist eine Datenbank-Abfragesprache, mittels welcher Daten aus einer Salesforce-Organisation ausgelesen werden können.  
Datenbankentwicklern bzw. Datenbankadministratoren mit SQL-Kenntnissen ist SOQL wahrscheinlich syntaktisch bekannt, es sind jedoch einige wichtige Unterschiede zu beachten (siehe hierzu die folgenden Kapitel). SOQL ist die Abfragesprache, welche explizit für das cloudbasierte CRM-System<sup>(2)</sup> von Salesforce entwickelt wurde und auch für diese Softwarelösung hochfrequent unter allen Anwendern verwendet wird. 
###2.1 Was ist Salesforce und Force.com?###
![Salesforce Logo](Salesforce-logo.png)  
Salesforce ist ein *Software as a Service* Anbieter für die gleichnamige cloudbasierte CRM-Lösung für das Management von Kundenbeziehungen. Alle verarbeiteten Daten werden zentral auf einer Plattform - *Platform as a Service* - gespeichert und stehen theoretisch allen Nutzern einer Organisation zur Verfügung.   
Force.com ist - neben der weiteren Cloud-Entwicklungsplattform *Heroku* - die Entwicklungsplattform von Salesforce, auf welcher cloudbasierte Anwendungen und Websites weltweit für alle Salesforce-Abonennten (Mandanten) bereitgestellt werden.   

Folgend möchte ich die aus meiner Sicht bestehenden Vor- und Nachteile des Salesforce-CRM-Systems benennen: 

* Vorteile:
  * Prozesse in Salesforce sind extrem automatisierbar bzw. individualisierbar
  * guter (Kunden-)Support (Zugriff über Login Access für einen Benutzer)
  * interessante Reportingmöglichkeiten (BI)
  * ständige Weiterentwicklung (mindestens 2 Releases pro Kalenderjahr)
  * über API Drittprogramme ansprechbar (z.B. über REST-APIs), z.B. SAP, guter Datenfluß
  * gute allgemeine Datensicherheit (DSGVO) und viele Möglichkeiten um Datensicherheit und Zugriffe zu gewährleisten (z.B. Einstellungen zur 2-Faktor-Authentifizierung, Zugriffseinschränkung über IP-Adressen, Zugriff nur zu gewünschten Uhrzeiten, usw. möglich)
* Nachteile: 
  * Salesforce ist relativ kostenintensiv (hohe Benutzerlizenzen je nach Produkt-Edition)
  * Onboarding bzw. Implementierung von Salesforce ist Zeit- und Kostenaufwändig, bei größeren Projekten bzw. Prozessen geht die Inbetriebnahme meist nicht ohne Implementierungsparter bzw. Beratungsagentur 
  * komplexe Datenstruktur in Salesforce wird oftmals unterschätzt
  
<sup>(2)</sup> *Ein CRM-System - Customer-Relationship-Management - ist ein Softwaresystem für die Pflege und Weiterverarbeitung von Kundendaten und Geschäftsinteraktionen. Mittels einer solchen Softwareanwendung sollen Kundeninteraktionen und natürlich auch die Umsätze gesteigert werden.* 

__________

[Nächstes Kapitel](Grundlagen.md)