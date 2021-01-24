# 2. Object Relational Mapping
Viele moderne Business-Anwendungen verwenden objektorientierte Programmiersprachen in Verbindung mit relationalen Datenbanken. Objekte aus der Anwendung werden hierbei über die Laufzeit des Programms hinaus in einer Datenbank abgelegt, um diese für einen späteren Zugriff verfügbar zu machen. Dieser Vorgang wird Persistieren genannt. Die Java Persistence API (JPA) ist eine Schnittstelle, um die Übertragung von Objekten zu Tabellen zu vereinfachen und zu standardisieren.

Diese Schnittstelle ist notwendig, da Objekte und Relationen grundsätzlich verschiedene Paradigmen besitzen und von Natur aus nicht gut miteinander vereinbar sind. Es müssen so genannte "Mappings" eingesetzt werden, um Objekte auf Relationen abzubilden und umgekehrt. Um die objektrelationalen Mapper bereitzustellen, existieren für Java mehrere Frameworks und Bibliotheken, wie beispielsweise Hibernate und EclipseLink. Diese Frameworks implementieren die von der Spezifikation JPA vorgegebenen Richtlinien und Regeln [11].

## 2.1 Die objektrelationale Unverträglichkeit
Objektorientierte Programmiersprachen basieren auf Konzepten des Software Engineerings und bilden Daten in Form von Objekten ab, welche miteinander verbunden sind. Relationale Datenbanken wiederum basieren auf mathematischen Prinzipien, mithilfe der relationalen Algebra werden die Daten in Tabellenform repräsentiert. Dieser grundlegende Unterschied beider Konzepte wird allgemein als objektrelationale Unverträglichkeit (engl. "Object-Relational Impedance Mismatch") bezeichnet.

Bereits am Beispiel von Datentypen werden die Unterschiede beider Konzepte deutlich:  

| Java       | Oracle     |
| :------------- | :----------: |
| String | varchar   |
| int   | smallint |
| Collections | Tabellen   |
| Objekte   | BLOBs |

Während einfache Datentypen wie *String* und *varchar* sehr einfach zu konvertieren sind, so sind beispielsweise *Collections/Tabellen* weniger eindeutig wandelbar.  

Bei genauerer Betrachtung ergeben sich 5 Probleme durch die konzeptionellen Unterschiede:  
**Granularität:** Stellt man dieselbe Datenstruktur dar, so kann es passieren, dass im Objekt-Modell mehr Klassen existieren als Tabellen im Relationen-Modell. Man sagt, das Objekt-Modell ist feinkörniger.    
**Vererbung:**  Das Objekt-typische Vererbungsmodell existiert in der Tabellenform nicht.  
**Identität:**  In einer Tabelle definiert allein der Primärschlüssel die Identität. Das Objekt-Modell definiert jedoch sowohl *Identität (foo==bar)* als auch *Gleichheit* (foo.equals(bar)).  
**Assoziation:** Tabellen nutzen Fremdschlüssel, während Assoziationen zwischen Objekten mit Referenzen (uni- oder bidirektional) gearbeitet wird.  
**Daten-Navigation:** Um an bestimmte Daten zu gelangen, wird innerhalb von Objekten und deren Beziehungen zum gewünschten Objekt navigiert. In Relationen wird mit Joins gearbeitet, um Tabellen zu verknüpfen und die gewünschte Information aus der neuen Tabelle ausgelesen.  

Die folgende Abbildung verdeutlicht die Unterschiede beider Paradigmen auf andere Weise, und zwar auf verschiedenen Ebenen: der konzeptuellen, sprachlichen, schematischen und der Instanz-Ebene:  

<img src="Abbildungen/mismatch.png" width="500">

Abb. Object Relational Mismatch

Um all diesen Widersprüchen entgegen zu wirken, existieren verschiedene Lösungsansätze, beispielsweise können die Objekte und Klassen der Programmiersprache in einer *objektorientierten* statt relationalen Datenbank abgelegt werden. Dieser Ansatz ist einfach und direkt, kann aber zu Performance-Einbußen bei komplexen Datenabfragen führen. Weitere Möglichkeiten sind die Verwendung eines objektrelationalen Datenbanksystems (ORDBRMS) oder die Erweiterung der Programmiersprache um relationale Funktionen, was jedoch die Programmierung einschränken kann.  

Das **objektrelationale Mapping bzw. Abbildung** beschreibt den letzten Lösungsansatz: Hier wird eine weitere Schicht zwischen den Daten und der Anwendung hergestellt, welche Objekte und Tabellen miteinander kompatibel macht und verknüpft. Dadurch können sowohl die Programmiersprache als auch die Datenbank in ihrer Form bestehen bleiben.  

## 2.2 Objektrelationale Abbildung
Die einfachste Abbildung einer Klasse zu einer Tabelle wäre eine direkte *eins-zu-eins-Abbildung*, das heißt, eine Klasse bzw. Objekt wird auf genau eine Tabelle im Datenbankschema gemappt, und jedes Attribut der Klasse wird durch eine Reihe in der Tabelle repräsentiert. Diese sehr einfache Abbildung ist jedoch, außer bei sehr simplen Datenbanken, selten zu erreichen.  
Nachfolgend ist eine einfache Datenstruktur abgebildet, um die strukturellen Unterschiede zu verdeutlichen:  

![](Abbildungen/2models.png)

Abb. Paradigmen-Vergleich

Die Objekt-Attribute Vorname und Nachname können wie oben beschrieben eins zu eins als Tabellenreihe abgebildet werden. Jedoch sind im Tabellenschema Primärschlüssel vonnöten, um jede Reihe/jeden Datensatz in der Tabelle eindeutig identifizieren zu können. Um Verweise auf andere Tabellen herstellen zu können und damit Relationen auszudrücken, sind Fremdschlüssel vorgesehen.

### Shadow Information
Da Primärschlüssel per se im objektorientierten Schema nicht existieren, müssen diese Informationen hinzugefügt werden, um die Eindeutigkeit von Objekten auf Persistenz-Ebene sicher zu stellen. Zusätzlich müssen noch Timestamps oder Increment Counters hinzugefügt werden, um gleichzeitige Zugriffe auf das selbe Objekt zu verhindern (Zugriffssteuerung), oder Versionsnummern. All diese Informationen, welche über die regulären Daten des Objektes hinausgehen, werden **Schatteninformationen** genannt. Diese sind zwingend notwendig, um ein Objekt erfolgreich persistieren zu können.

### Mapping von Vererbung
Das Konzept der Vererbung ist prinzipiell nicht in relationalen Datenbanken vorhanden. Um diese Strukturen erfolgreich abzubilden, gibt es mehrere Möglichkeiten:

**Abbildung der gesamten Klassenhierarchie auf eine Einzeltabelle:** Alle Attribute und Klassen werden in einer einzelnen Tabelle abgebildet. Simpelstes Verfahren. Schneller Datenzugriff, neue Klassen können schnell hinzugefügt werden, da nur neue Spalten erzeugt werden müssen. Für simple Klassenhierarchien zu empfehlen.  
**Abbildung jeder konkreten Klasse in eine eigene Tabelle:** Es werden nur Tabellen für die Unterklassen angelegt. Die Attribute der Basisklasse werden in jede Tabelle übernommen. Zu empfehlen, wenn Objekte nur selten geändert werden, oder wenig Überlappung existiert.  
**Abbildung jeder Klasse in eine eigene Tabelle:** Die Basisklasse sowie Unterklassen werden je in einzelnen Tabellen abgebildet. Wenn viel Überlappung zwischen den Typen existiert oder diese häufig geändert werden.  
**Abbildung der Klassen in eine generische Tabellen:** Es werden genau 5 Tabellen angelegt: Attribute, Instanzen, Klassen, Beziehungen, Attributwerte. Für sehr komplexe Anwendungen mit wenig Daten.  

### Mapping von Beziehungen
Es gibt 3 grundlegend verschiedene Beziehungen, welche beim Mapping berücksichtigt werden müssen. Diese werden im Relationen-Modell anders implementiert als im Objekt-Modell. Ein prinzipieller Unterschied ist, dass das Relationen-Modell keine unidirektionalen Assoziationen kennt, all Beziehungen dort sind von Natur aus bidirektional [5].

**0/1...0/1 (Null oder eins zu Null oder eins):** In Tabellen werden diese mithilfe von Fremdschlüsselverweisen in beiden Tabellen und ggf. Not-Null Bestimmungen realisiert. Wird im Objekt-Modell mit Referenzen zu Objekten sowie *Getter*- und *Setter*-Methoden implementiert.  
**0/1...n (Null oder eins zu N):** Werden in Java mit Arrays oder HashSets implementiert. Mit Methoden wie *add()*, *set()*, *remove()* etc., werden die Arrays dynamisch geändert. In Tabellen genügt ein Fremdschlüssel in jener Tabelle, welche beliebig oft genannt werden soll, ggf. mit einer Not-Null Bestimmung.  
**n...n (N zu N):** In Tabellenform wird eine zusätzliche assoziative Tabelle benötigt, beispielsweise *meldet_an*. Mit gekreuzten Fremdschlüssel-Verweisen wird hierdurch eine *n...n*-Beziehung hergestellt. In Objektform werden hier ebenfalls Collections verwendet, hier jedoch beidseitig.  

Vorsicht ist zu genießen bei **Ordered Collections**, beispielsweise in einer Beziehung zwischen einer *Order* und *OrderItem* Klasse, in welcher die Reihenfolge der Elemente von Bedeutung ist: Soll eine solche Beziehung in Relationen-Form überführt werden, so muss eine extra Spalte erzeugt werden, welche diese Information trägt [5]. Zusätzlich müssen hierbei weitere Dinge beim Mapping beachtet werden, beispielsweise dass die Sequenz-Nummer nicht im Schlüssel abgelegt werden sollte, und dass eine zusätzliche *ORDER BY*-Anweisung im SQL Statement hinzugefügt werden muss, um die Daten auch in korrekter Reihenfolge anzuzeigen.

Weiterführende Themen beim Mapping stellen die Abbildung von **Class-Scopes** (Geltungsbereichen von Klassen), **rekursiven Beziehungen** (Objekte, welche beliebig viele Referenzen auf Objekte desselben Typs besitzen können), sowie **Performance-Tuning** dar.  

## 2.3 Frameworks für Objektrelationale Abbildungen  
Da die JPA nur eine Spezifikation ist, kann diese Objekte nicht von sich aus persistieren. Die von der Spezifikation vorgegebenen Regeln müssen implementiert werden. Für Java existieren viele solcher Frameworks, an dieser Stelle soll eine kurze Übersicht und Vergleich der populärsten Frameworks **Hibernate** und **EclipseLink** erläutert werden [11].  

Grundsätzlich muss ein ORM-Framework folgende Leistungen zur Verfügung stellen:  
- eine API für CRUD-Operationen auf persistierten Objekten  
- eine API oder Sprache für Queries, welche sich auf Klassen und deren Attribute anwenden lässt
- ein Mapping der Metadaten zur Verfügung stellen

Es sollten außerdem weitere Optimierungsmechanismen vorhanden sein, wie beispielsweise **Lazy Loading** (welches entscheidet, ob auch zusätzlich die Subklasse zur Oberklasse geladen wird) und **Dirty Checking** (Wodurch Änderungen an einem Objekt automatisch in der DB gespeichert werden, wenn die Transaktion commited wird). [9]

### Hibernate  
Das 2001 erschienene Framework sitzt als zusätzliche Schicht zwischen Java und dem RDBMS und unterstützt eine Vielzahl von Datenbanksystemen, darunter *Oracle, PostgreSQL und MySQL*.  
Zusätzlich unterstützt Hibernate gängige Java-Technologien wie *Maven und XDoclet Spring* [10].  
Die Hauptaufgabe von Hibernate besteht im Abbilden/Mappen von Java-Objekten zu Relationen, dessen genereller Prozess oben ausführlich beschrieben wurde. Durch den Einsatz von Hibernate fällt für den Programmierer etwa 95% des Aufwandes von Persistenz-Aufgaben weg [10].

Ein Vorteil von Hibernate ist, dass das Mapping mit *XML-Dateien* konfiguriert wird, ohne zusätzlichen Code schreiben zu müssen. Weiterhin wird kein Applikationsserver benötigt (wie es etwa bei *JSP* der Fall war), und dass eine API bereitgestellt wird, welche die einfache Übertragung von Java-Objekten von und zur Datenbank vereinheitlicht.

JPA nutzt die *javax.persistence* Klassen, um zu definieren, welche Klassen persistiert werden sollen. Hibernate implementiert all diese Klassen, welche ansonsten vom Programmierer selbst implementiert werden müssten. Zusätzlich bietet Hibernate Funktionalitäten wie *Hibernate Tools, Validator*, und *Search*. Außerdem sind folgende Funktionen vorhanden:

- Die *org.hibernate.annotations.Entity* Klasse erlaubt Feintuning von Entitäten durch zusätzliche Metadaten
- Die *@Table* Annotation erlaubt es, den Relationen benutzerdefinierte Namen zu geben  
- Die *@SQLInsert*, *@SQLUpate* und  *@SQLDelete* Annotationen ermöglichen anpassbare CRUD Statements
- Die *@Immutable* Annotation erlaubt unveränderliche Entitäten  

### EclipseLink
Wie auch Hibernate implementiert EclipseLink die notwendigen JPA-Regeln. Zusätzlich dazu untersützt aber auch weitere Persitenz-Standards wie *Java Architecture for XML Binding (JAXB)*,
*Java Connector Architecture (JCA)* und *Service Data Objects (SDO)*.  

Beispielsweise werden mit der JAXB-Unterstützung die Objekte in eine XML-Repräsentation überführt.  
Weiterhin sind beispielsweise mit der *@ReadOnly* Annotation Entitäten möglich, welche nur gelesen werden können. *@Struct* wiederum bildet das Objekt innerhalb der Datenbank als *struct*-Typ ab. Beide Optionen werden von Hibernate nicht untersützt [11].  

Sollte Performanz im Vordergrund stehen, so lohnt sich ein Vergleich der beiden Frameworks, in welchen Hibernate in mehreren Punkten besser abschneidet als EclipseLink:  

**Performance-Vergleich von Hibernate und EclipseLink (mit MySQL):**

| Operation       | Hibernate     | EclipseLink     |
| :------------- | :----------: | :----------: |
| Persistieren | geringfügig besser   |    |
| Retrieval   |  | geringfügig besser |
| Query ausführen   | sehr viel besser |  |
| Update | äquivalent   | äquivalent   |
| Remove   | geringfügig besser |  |
| JPA DB Operationen   | geringfügig besser |  |

[13]
