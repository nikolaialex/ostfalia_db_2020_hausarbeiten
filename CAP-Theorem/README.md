# CAP-Theorem
### Ausarbeitung für das Modul Datenbanktechnologien
### Autoren

| Name               | Matrikelnummer | Hochschule   |
| :----------------- | :------------- | :---------   |
| Selina Schneider   | 902869         | Beuth Berlin |
| Kristina Kölln     | 7011805        | HS Emden/Leer|
| Lars Bleul         | 869680         | Beuth Berlin |

## Inhaltsverzeichnis
[1 Einleitung](#1-einleitung)

[2 Eric Brewer und das CAP-Theorem](#2-eric-brewer-und-das-cap-theorem)
    
[3 Consistency und Partition Tolerance](#3-consistency-und-partition-tolerance)
   <br/>3.1 [MongoDB](#31-mongodb)
   <br/>3.2 [Anwendungsfall](#32-anwendungsfall)

[4 Availability und Partition Tolerance](#4-availability-und-partition-tolerance)
   <br/>4.1 [Cassandra](#41-cassandra)
   <br/>4.2 [Anwendungsfall](#42-anwendungsfall)

[5 Availability und Consistency](#5-availability-und-consistency)
   <br/>5.1 [MySQL](#51-mysql)
   <br/>5.2 [Anwendungsfall](#52-anwendungsfall)
 
[6 Sonderfall Spanner](#6-sonderfall-spanner)

[7 Kritik am CAP-Theorem](#7-kritik-am-cap-theorem)

[8 Was kommt nach CAP?](#8-was-kommt-nach-cap)

[9 Fazit](#9-fazit)

[Literaturverzeichnis](#literaturverzeichnis)

[Fußnote](#fußnote)

<br/>Abbildungsverzeichnis

*[Abbildung 1](https://user-images.githubusercontent.com/40004315/105677043-aa27e980-5eeb-11eb-863b-fd82bf22e2f4.jpeg): Das CAP-Dreieck [Ionos].*

*[Abbildung 2](https://user-images.githubusercontent.com/40004315/105677131-c6c42180-5eeb-11eb-97f2-0fcdd0a57158.jpeg): Darstellung eines einfachen verteilten Systems nach [Whittaker].*

*[Abbildung 3](https://user-images.githubusercontent.com/40004315/105677195-dba0b500-5eeb-11eb-814f-84dc7c728b0d.jpeg): Darstellung eines konsistenten Systems nach [Whittaker].*

*[Abbildung 4](https://user-images.githubusercontent.com/40004315/105677303-f96e1a00-5eeb-11eb-80a2-b1e6a36e906a.jpeg): Darstellung eines ausfalltoleranten Systems nach [Whittaker].*

*[Abbildung 5](https://user-images.githubusercontent.com/40004315/105677350-07bc3600-5eec-11eb-98c2-e2d38ae2f2d8.jpeg): Schreibbefehl bei einem ausfalltoleranten System nach [Whittaker].*

*[Abbildung 6](https://user-images.githubusercontent.com/40004315/105677387-11de3480-5eec-11eb-8883-b446b5787caf.jpeg): Inkonsistente Antwort des ausfalltoleranten Systems nach [Whittaker].*

*[Abbildung 7](https://user-images.githubusercontent.com/40004315/105678887-f2e0a200-5eed-11eb-9197-04b28dd267d6.PNG): Aufbau einer Mongo DB Datenbank [Bhandari, 2020].*

*[Abbildung 8](https://user-images.githubusercontent.com/40004315/105679725-240da200-5eef-11eb-916a-311fd8cb9248.PNG): Aufbau einer Cassandra Datenbank  [Bhandari, 2020].*

*[Abbildung 9](https://user-images.githubusercontent.com/40004315/105680233-b8780480-5eef-11eb-950f-53e3339e48b4.PNG): Beispiel von MySQL Tabellen [Kinsta, 2019].*

*[Abbildung 10](https://user-images.githubusercontent.com/40004315/105680614-45bb5900-5ef0-11eb-9831-a5bf470a62aa.PNG): Linearisierbarkeit nach [Kleppmann Blog, 2015].*

*[Abbildung 11](https://user-images.githubusercontent.com/40004315/105680672-5966bf80-5ef0-11eb-83c6-ca2e29ac1f2c.PNG): PACELC-Theorem [Ardalis, 2015].*

*[Abbildung 12](https://user-images.githubusercontent.com/40004315/105682118-5240b100-5ef2-11eb-8796-fcca734d9271.PNG): Microservices [Richardson, 2020].*

*[Abbildung 13](https://user-images.githubusercontent.com/40004315/105682471-c7ac8180-5ef2-11eb-923c-ed3a8c2f949b.PNG): Kein Netzwerkausfall [Ardalis, 2020].*

*[Abbildung 14](https://user-images.githubusercontent.com/40004315/105682573-e9a60400-5ef2-11eb-9a9d-0b30dad6275f.PNG): Netzwerkausfall bei B [Ardalis, 2020].*

*[Abbildung 15](https://user-images.githubusercontent.com/40004315/105682912-502b2200-5ef3-11eb-980d-0ecf5dc14afa.PNG): Netzwerkausfall bei C [Ardalis, 2020].*

*[Abbildung 16](https://user-images.githubusercontent.com/40004315/105683052-7cdf3980-5ef3-11eb-80c1-c46079c82599.PNG): Zwischenspeicher [Ardalis, 2020].*

*[Abbildung 17](https://user-images.githubusercontent.com/40004315/105683085-8799ce80-5ef3-11eb-9b3e-cd434bd7265c.PNG): Ausfall mit Zwischenspeicher [Ardalis, 2020].*

*[Abbildung 18](https://user-images.githubusercontent.com/40004315/105683366-d9425900-5ef3-11eb-866e-d3626038103f.PNG): Befehle (Commands) [Ardalis, 2020].*

*[Abbildung 19](https://user-images.githubusercontent.com/40004315/105683389-e101fd80-5ef3-11eb-827b-b0e3ab437b6a.PNG): Befehle bei Netzwerkausfall [Ardalis, 2020].*

*[Abbildung 20](https://user-images.githubusercontent.com/40004315/105683416-e7907500-5ef3-11eb-8438-2b9b6fa27bb9.PNG): local persistent message queues [Ardalis, 2020].*

*[Abbildung 21](https://user-images.githubusercontent.com/40004315/105683444-ef501980-5ef3-11eb-86b3-72c3dbdf643d.PNG): Netzwerkausfall bei Queues [Ardalis, 2020].*

<br/>Tabellenverzeichnis

*[Tabelle 1](#Tabelle1): Eine Auswahl verschiedener CP-Datenbanken [Luketic, 2019].*

*[Tabelle 2](#Tabelle2): Eine Auswahl verschiedener AP-Datenbanken [Luketic, 2019].*

*[Tabelle 3](#Tabelle3): Eine Auswahl verschiedener CA-Datenbanken [Luketic, 2019][Brewer, 2017].*

*[Tabelle 4](#Tabelle4): Konsistenzstufen [Kleppmann, 2015].*

## 1. Einleitung

Das CAP-Theorem, von Eric Brewer als Vermutung erstmals veröffentlicht und von Seth Gilbert und Nancy Lynch als Theorem bewiesen, spielt im heutigen Web2.0-Zeitalter eine entscheidende Rolle für die Implementierung der meisten Datenbanken. Die sehr simple und und damit einfach zu verstehende Annahme, dass ein verteiltes Datenbanksystem niemals die drei Eigenschaften Konsistenz, Verfügbarkeit und Ausfalltoleranz gleichzeitig besitzen kann, teilt die Datenbanksysteme in drei Gruppen ein: 

1. konsistente sowie ausfalltolerante Datenbanken (CP) 
2. konsistente sowie verfügbare Datenbanken (CA) 
3. verfügbare sowie ausfalltolerante Datenbanken (AP) 

In den folgenden Abschnitten sollen die Bedeutungen dieser Gruppen näher erläutert, sowie Anwendungsfälle für diese vorgestellt werden. Des Weiteren soll geklärt werden, ob diese Einteilung auch in der Praxis so strikt vorgenommen werden kann und ob es Kritikpunkte an dem CAP-Theorem sowie neuartige Ansätze gibt.


## 2. Eric Brewer und das CAP-Theorem

Das CAP-Theorem beruht auf einer Vermutung des Informatikers Eric Brewer, die er 2000 bei einem Vortrag im Rahmen des PODC (Principles of Distributed Computing) Symposiums veröffentlichte. Aus diesem Grund wird das CAP-Theorem auch Brewers Theorem genannt. Später im Jahre 2020 stützten Seth Gilbert und Nancy Lynch in [Gilbert, 2002] diese Vermutung mithilfe eines axiomatischen Beweises und etablierten sie somit als Theorem [Ionos].

- Konsistenz (**C**onsistency)
- Verfügbarkeit (**A**vailability) 
- Ausfalltoleranz (**P**artition Tolerance) 

Währenddessen besagt das Theorem auch, dass nicht alle Eigenschaften gleichzeitig voll erfüllt sein können, sondern stets maximal zwei [Fekete, 2018].
Dies veranschaulicht folgende Abbildung:

![image1](https://user-images.githubusercontent.com/40004315/105677043-aa27e980-5eeb-11eb-863b-fd82bf22e2f4.jpeg)
<br><b>Abbildung 1: Das CAP-Dreieck [Ionos].</b></p>

Ein konkretes verteiltes System liegt auf einem der Schenkel des Dreiecks [Fekete, 2018]. Damit gibt es drei mögliche (idealisierte) Formen von verteilten Systemen: AP, CP und CA. 
Um zu erklären, warum stets nur zwei Eigenschaften erfüllt sein können, werden zunächst die Begriffe näher erläutert. 
 
**Konsistenz**: Alle Clients, die auf das System zugreifen, sehen zum gleichen Zeitpunkt die gleichen Daten, egal von welchem Rechner bzw. Server aus sie darauf zugreifen [^1] [Fekete, 2018].

**Verfügbarkeit**: Mit der Verfügbarkeit sind auch die Antwortzeiten des Systems gemeint. Eine schnelle Verfügbarkeit besitzt ein System, wenn es jederzeit die Anfragen wie Lese- und Schreibzugriffe des Clients beantwortet [Fekete, 2018].

**Ausfalltoleranz**: Ein System ist ausfalltolerant, wenn es trotz Ausfalls einzelner Nodes stabil weiterläuft. Ausfälle können geplant (Wartungsarbeiten) oder auch ungeplant (Serverabsturz aufgrund von Hardware oder Software) stattfinden, weshalb der Systemdesigner auf diese Eigenschaft den geringsten Einfluss ausüben kann [Fekete, 2018] [codecentric].

 
Nimmt man nun an, dass ein System existiert, dass alle drei Eigenschaften vollends erfüllt, dann würde es bei einer Verbindungsunterbrechung zwischen einzelnen Nodes sowohl die separierten Nodes verfügbar halten als auch konsistent reagieren. Und hier folgt der Widerspruch: Wenn die Daten auf einem Node geändert werden, kann jedoch nicht gewährleistet werden, dass die nicht erreichbaren Nodes konsistent gehalten werden. Das System kann nun entweder inkonsistent oder gar nicht reagieren, somit muss es entweder auf die Konsistenz oder die Verfügbarkeit verzichten [dbengines].

[Whittaker] hat hierzu den Beweis von Gilbert und Lynch vereinfacht dargestellt.
Es wird von folgendem einfachen verteilten System, bestehend aus den zwei Servern G1 und G2, ausgegangen:

![image2](https://user-images.githubusercontent.com/40004315/105677131-c6c42180-5eeb-11eb-97f2-0fcdd0a57158.jpeg)
<br><b>Abbildung 2: Darstellung eines einfachen verteilten Systems nach [Whittaker].</b></p>

Der Client kann auf jedem der beiden Server sowohl lesen als auch schreiben, während die Server untereinander kommunizieren.

Ein **konsistentes System** würde wie folgt aussehen:

![image3](https://user-images.githubusercontent.com/40004315/105677195-dba0b500-5eeb-11eb-814f-84dc7c728b0d.jpeg)
<br><b>Abbildung 3: Darstellung eines konsistenten Systems nach [Whittaker].</b></p>

Der Client führt einen Schreibbefehl auf Server G1 durch und ändert den Wert der Variable v von 0 zu 1. Da das System stets konsistent reagiert, wird bei dem Lesebefehl auf G2 dementsprechend der Wert 1 für die Variable v zurückgegeben. Das System führt also erst die Änderung der Variable und die dementsprechende Kommunikation zum anderen Server durch, bevor es auf den Lesebefehl des Clients antwortet.

Ein **ausfalltolerantes System** kann wie folgt beschrieben werden:

![image4](https://user-images.githubusercontent.com/40004315/105677303-f96e1a00-5eeb-11eb-80a2-b1e6a36e906a.jpeg)
<br><b>Abbildung 4: Darstellung eines ausfalltoleranten Systems nach [Whittaker].</b></p>

Hierbei muss das System einen korrekten Funktionsablauf gewährleisten, selbst wenn einige oder alle Nachrichten zwischen Servern durch Verbindungsabbruch verloren gehen. Die Abbildung 4 zeigt ein System, in dem jegliche Kommunikation zwischen den Servern G1 und G2 eingebußt wird.

Ein **verfügbares System** muss, wie oben bereits erläutert, in der Lage sein, jede Anfrage des Clients zu beantworten, sofern der angesprochene Server vorhanden ist. Es dürfen keine Anfragen ignoriert werden.
Der **Beweis**, dass es kein System gibt, welches sowohl konsistent als auch ausfalltolerant und verfügbar ist, kann wie folgt dargestellt werden:

1. Ausgegangen wird von einem ausfalltoleranten System, wie in Abbildung 4 zu sehen.

2. Im nächsten Schritt schreibt der Client auf Server G1 in die Variable v den Wert 1. Da das System ebenfalls verfügbar ist, muss es auf diesen Befehl antworten und die Variable dementsprechend anpassen.
Da jedoch das System ausfalltolerant ist und die Kommunikation zwischen Server G1 und G2 zum aktuellen Zeitpunkt nicht gegeben ist, kann der Wert für v auf Server G2 nicht synchronisiert werden.

![image5](https://user-images.githubusercontent.com/40004315/105677350-07bc3600-5eec-11eb-98c2-e2d38ae2f2d8.jpeg)
<br><b>Abbildung 5: Schreibbefehl bei einem ausfalltoleranten System nach [Whittaker].</b></p>

3. Wenn nun der Client einen Lesebefehl an G2 richtet und das System aufgrund seiner Verfügbarkeit antworten muss, erfolgt eine inkonsistente Information, nämlich dass die Variable v den Wert 0 hätte.

![image6](https://user-images.githubusercontent.com/40004315/105677387-11de3480-5eec-11eb-8883-b446b5787caf.jpeg)
<br><b>Abbildung 6: Inkonsistente Antwort des ausfalltoleranten Systems nach [Whittaker].</b></p>

Dies beweist, dass kein verteiltes System existiert, das alle drei Eigenschaften, Konsistenz, Ausfalltoleranz und Verfügbarkeit, erfüllt.

Aufgrund dieses Theorems spielt es in heutigen verteilten Datenbanksystemen eine zentrale Rolle vorher zu entscheiden, welche zwei Eigenschaften in den Vordergrund gestellt werden sollen. Je nach Situation kann z.B. die Konsistenz mehr oder weniger bedeutend sein. 
Bei relationalen Datenbanksystemen ist die Konsistenz sehr wichtig. Die Verfügbarkeit und die Ausfalltoleranz werden hierbei versucht durch hochwertige und leistungsfähige Hardware soweit es geht zu erfüllen. 
Für das heutige Web2.0-Zeitalter werden jedoch mit NoSQL-Systemen andere Prioritäten gesetzt. Durch den enorm hohen Datendurchsatz und die hohen Anwenderzahlen sind die modernen Datenbanksysteme meist nur noch auf dynamisch skalierbaren Rechner-/Servernetzwerken realisierbar. Hierbei findet meist eine horizontale Skalierung statt, d.h. die Last wird auf viele Nodes verteilt, die oft mithilfe von preiswerter Hardware umgesetzt werden. Aufgrund dieser hohen Anzahl von Nodes sollte eine hohe Ausfalltoleranz zwingend erforderlich sein, um ein stabiles System zu jeder Zeit gewährleisten zu können. Denn ein Ausfall ist bei dieser hohen Anzahl von Nodes wahrscheinlicher als bei einem Netz bestehend aus weniger Nodes. 
Des Weiteren werden heutzutage immer seltener hohe Antwortzeiten toleriert, dies bedeutet eine Priorität auf einer möglichst hohen Verfügbarkeit. Besonders in E-Commerce-Anwendungen ist die Antwortzeit eine immer kritischer werdende Anforderung, da potenzielle Kunden schnell zur Konkurrenz wechseln, wenn die Antwortzeiten inakzeptabel sind [CAP].

Die Konsistenzbedingungen sind demnach schwächer ausgelegt und leiten zu dem Ergebnis, dass AP-Systeme in den meisten Fällen vorrangig sind [codecentric].
 
Ein häufiges Beispiel für ein AP-System ist der DNS-Server. Die Nodes antworten immer auf die Anfragen der Clients, auch wenn einige Verbindungsabbrüche zwischen einzelnen Nodes bestehen. So entsteht Inkonsistenz. Jedoch wird bei solchen Systemen oftmals das Eventually Consistent-Prizip mithilfe von BASE umgesetzt, so wird ein möglichst kurzer Zeitraum der Inkonsistenz toleriert, sofern er wieder in einen Zustand der Konsistenz führt [codecentric].
Bei CP-Systemen, wie sie bei Finanz- und Banking-Anwendungen anzutreffen sind, antworten die ausgefallenen Nodes hingegen nicht auf Anfragen, um fehlerhafte Buchungen zu vermeiden. Ist die Verbindung zwischen den Nodes wiederhergestellt, wird zunächst die Konsistenz sichergestellt und erst danach sind wieder Anfragen an diese Nodes möglich [Ionos].
 
Nicht aus den Augen zu verlieren ist hierbei die Tatsache, dass CP, AP und CA die idealisierten Formen von verteilten Datenbanksystemen sind. In der Praxis sind die Grenzen oft nicht so klar abzustecken. Aus diesem Grund sind Mischformen, wie zwischen AP und CP möglich. Auf die Ausfalltoleranz kann nicht so flexibel Einfluss genommen werden, daher müssen die Systeme je nach Situation zwischen der Verfügbarkeit oder der Konsistenz entscheiden. 
Eine perfekte Ausfalltoleranz ist zudem ebenfalls nicht möglich. Dies kann verschiedene Ursachen haben. In manchen Systemen kann es vorkommen, dass Nodes keine Kenntnis über eine Verbindungsunterbrechung haben. Außerdem werden Verbindungsunterbrechungen durch Timeouts erkannt. Besitzt ein System jedoch eine schlechte Netzwerkverbindung, kann es sich damit in einem Zwischenzustand befinden: Die Verbindung zu einem anderen Node ist bereits unterbrochen, aber durch die schlechte Netzwerkverbindung kann der Timeout nicht genau bestimmt werden [dbengines]. Latenz ist demnach ein Aspekt, der bei CAP außen vor ist. Dazu jedoch im Abschnitt "Kritik am CAP-Theorem" mehr.

## 3. Consistency und Partition Tolerance

Bietet eine Datenbank die Eigenschaften “Consistency” (C) und “Partition Tolerance” (P) des CAP-Theorems, nennt man sie eine CP-Datenbank. Einige Beispiele von CP-Datenbanksystemen können Tabelle 1 entnommen werden.

| Dokumentenorientiert   | Key-Value | Spaltenorientiert   |
| :----------------- | :------------- | :---------   |
| MongoDB   | Scalaris         | BigTable |
| Terrastore     | Berkeley DB        | Hypertable|
|          | MemcacheDB         | Hbase |
|          | Redis         |       |


<br><b>Tabelle 1:  Eine Auswahl verschiedener CP-Datenbanken [Luketic, 2019].</b></p>

Um als CP-Datenbank eingeordnet werden zu können, müssen diese Datenbanken immer datenkonsistent sein sowie eine hohe Toleranz gegenüber Ausfällen einzelner Nodes aufweisen. Allerdings sind sie (meist während einer Partition) nicht unbedingt jederzeit verfügbar. Um genauer nachvollziehen zu können, wie ein solches Schema aussieht, wird im folgenden eine klassische CP-Datenbank in ihrem Aufbau beschrieben und auf die Eigenschaften “Consistency” und “Partition Tolerance” untersucht. Als Beispiel wurde MongoDB ausgewählt, welches ein bekanntes und viel verwendetes Datenbanksystem ist.


### 3.1 MongoDB

MongoDB ist eine dokumentenorientierte NoSQL-Datenbank. Sie ist plattformübergreifend und nutzt C++, um halbstrukturierte Daten zu speichern [Ali, 2020]. Sie wurde 2009 von MongoDB Inc. als Open Source veröffentlicht. 2011 folgte der Launch des ersten Cloud Services [MongoDB]. Mittlerweile zählt MongoDB laut eigener Webseite Firmen wie eBay, Adobe und SAP zu seinen Kunden. Wenn man von ihrer Standardkonfiguration ausgeht, wird sie als eine klassische CP-Datenbank einsortiert. 
Um zu verstehen, wieso MongoDB eine CP Datenbank ist, muss zunächst ihr Aufbau verstanden werden (siehe Abbildung 7).

![image7](https://user-images.githubusercontent.com/40004315/105678887-f2e0a200-5eed-11eb-9197-04b28dd267d6.PNG)
<br><b>Abbildung 7: Aufbau einer Mongo DB Datenbank [Bhandari, 2020].</b></p>

MongoDB besteht aus einem Primary Node und mehreren Secondary Nodes. Diese Secondary Nodes sind jeweils ein Replikat des Primary Node. Zwischen allen Nodes wird regelmäßig ein sogenannter Heartbeat in Form eines Pings gesendet. Dieser Heartbeat stellt sicher, dass alle Nodes erreichbar sind. Wenn nach 10 Sekunden kein Heartbeat wahrgenommen wird, wird der entsprechende Node als nicht-erreichbar gekennzeichnet. Handelt es sich bei dem ausgefallenen Node um den Primary Node, muss ein neuer Primary Node ausgesucht werden. Bis dieser gefunden wurde, ist es dem Nutzer nicht erlaubt weiter auf der Datenbank zu schreiben. Auf diesem Weg ist das System jederzeit konsistent und kann gut mit Ausfällen umgehen, muss aber in solch einem Fall auf die Verfügbarkeit verzichten [Bhandari, 2020].

### 3.2 Anwendungsfall

In welchen Fällen wäre es zu verschmerzen, dass das System nicht jederzeit zur Verfügung steht, nicht aber, dass die Daten inkonsistent würden oder Ausfälle einzelner Nodes zu anderen Problemen im System führten? Ein häufig angebrachtes Beispiel ist der Finanzbereich [DatenbankenVerstehen]. Als konkretes Beispiel sei hier ein Geldautomatensystem genannt. Wenn der Nutzer auf seine Finanzen zugreift oder Überweisungen tätigt, ist es sehr wichtig, dass die Daten überall übereinstimmen. Sollte der Kunde einen Betrag überweisen und woanders wird dieser nicht oder anders verbucht, kann dies sehr unangenehm für alle Beteiligten werden. Gleichzeitig ist es aber vertretbar, wenn das System für kurze Zeiten nicht verfügbar ist. Mehr noch: Es ist in einem solchen Fall sogar wichtig, dass keine falschen Daten in die Datenbank geschrieben werden können. Hier geht die Sicherheit der Daten über die Verfügbarkeit des Systems.


## 4. Availability und Partition Tolerance

Bietet eine Datenbank die Eigenschaften “Availability” (A) und “Partition Tolerance” (P) des CAP-Theorems, nennt man sie eine AP-Datenbank. Einige Beispiele von AP-Datenbanksystemen können Tabelle 2 entnommen werden. 

| Dokumentenorientiert   | Key-Value | Spaltenorientiert   |
| :----------------- | :------------- | :---------   |
| SimpleDB   | Dynamo         | Cassandra |
| CouchDB     | Voldemort        | |
| Riak         | Tokyo Cabinet         |  |
|          | KAI         |       |

<br><b>Tabelle 2:  Eine Auswahl verschiedener AP-Datenbanken [Luketic, 2019].</b></p>

Als AP-Datenbanken werden solche Datenbanksysteme eingeordnet, die jederzeit zur Verfügung stehen und auch bei größeren Partitionen noch ohne Probleme operieren können. Dateninkonsistenz lässt sich allerdings nicht jederzeit vermeiden. In der Regel werden diese Inkonsistenzen aber mit der Zeit wieder angeglichen. Auch den Aufbau einer AP-Datenbank wollen wir anhand eines Beispiels genauer erläutern, um nachvollziehen zu können, wie ein solches System arbeitet und wie gegebenenfalls diese Inkonsistenzen zustande kommen. Gleichzeitig wird so nachvollziehbarer, wie eine AP-Datenbank mit Partitionen umgeht.
Als Beispiel wurde Cassandra gewählt, die bei Social-Media-Riese Facebook, aber laut eigener Webseite auch bei Firmen wie McDonald's, Instagram und Uber, Verwendung findet.

### 4.1 Cassandra

Cassandra ist ein spaltenbasiertes Datenbanksystem, das von den Entwicklern Lakshman und Prashant Malik ursprünglich bei Facebook entwickelt wurde, um deren »Inbox Search Problem« zu lösen [Schnelle, 2011]. Dabei ging es darum, dass es für die Nutzer möglich sein sollte innerhalb ihres Chatfensters zu suchen. Grundsätzlich zwar kein Problem, durch die extreme Menge der Daten und das konstante Wachstum aber von klassischen SQL Datenbanken nicht mehr performant zu lösen [Schnelle, 2011]. Cassandra löste dieses Problem. 2009 wurde es von der Apache Foundation übernommen und somit zur Open Source Software. Das Datenbanksystem funktioniert plattformübergreifend und basiert auf Java, seit 2011 arbeitet es mit der eigenen Abfragesprache Cassandra Query Language (CQL) [Heise, 2011].
Als Peer-to-Peer System besteht ein Cassandra-System aus mehreren Nodes und jeder Node kann Schreib- oder Lesebefehle des Nutzers erhalten. Es werden mehrere Kopien der Daten eines Nodes auf weiteren Nodes aufrechterhalten. Dadurch ist die Achitektur “Masterlos”, das heißt, dass kein Node “wichtiger” ist als ein anderer und dadurch bei dem Ausfall eines Nodes die Daten auf mindestens einem anderen Node noch vorhanden sind. Teilweise ist es so möglich, dass sogar mehrere Nodes ausfallen können, ohne dass die Funktionalität und Erreichbarkeit eingeschränkt wäre [Bhandari, 2020]. Dadurch sind die Bedingungen für ein AP-System erfüllt.


![image8](https://user-images.githubusercontent.com/40004315/105679725-240da200-5eef-11eb-916a-311fd8cb9248.PNG)
<br><b>Abbildung 8: Aufbau einer Cassandra-Datenbank [Bhandari, 2020].</b></p>

### 4.2 Anwendungsfall

AP-Datenbanken finden überall dort Anwendung, wo eine gewisse Inkonsistenz der Daten nicht weiter dramatisch wäre, aber eine ständige Verfügbarkeit, auch bei Partitionen, gegeben sein muss. Zudem dürfen Partitionen nicht dafür sorgen, dass es zu Fehlern kommt. Die Konsistenz ist hier zweitrangig, sollte aber idealerweise immer wiederherstellbar sein. [Fedak, 2018] nennt hier als wichtiges Beispiel die Social-Media- und Konsum-Welten, genauer Facebook und Netflix, die beide auf Cassandra basieren. 
Social Media ist eine schnelle Welt. In der modernen Zeit ist es besonders wichtig jederzeit erreichbar zu sein, immer auf seine Accounts zugreifen zu können und sofort Fotos von seinen Unternehmungen posten zu können. Gleichzeitig ist es aber nicht sonderlich wichtig, dass jeder auch das gleiche angezeigt bekommt. Im Gegenteil sogar: Viele Nutzer bevorzugen es, wenn sie Inhalte angezeigt bekommen, die genau auf ihre Vorlieben zugeschnitten wurden. Natürlich wollen die Nutzer dennoch alle Zugriff auf den gesamten Content haben. Aber wenn man bei Netflix einen Film mal nicht findet, sucht man sich einen anderen Film für den Abend aus. Meistens weiß der Nutzer gar nicht, ob der Film überhaupt verfügbar sein müsste. Kleine Inkonsistenzen zu anderen Nutzern oder der Gesamtdatenbank würden also kaum auffallen. Ist Netflix aber nicht erreichbar, geht der Nutzer zu einem anderen Video-on-Demand Anbieter, der zu diesem Zeitpunkt direkt verfügbar ist. 


## 5. Availability und Consistency

Bietet eine Datenbank die Eigenschaften “Consistency” (C) und “Availability” (A) des CAP-Theorems, nennt man sie eine CA-Datenbank. Einige Beispiele von CA-Datenbanksystemen können Tabelle 3 entnommen werden.

| Relational   | Spaltenorientiert |
| :----------------- | :------------- |
| RDBMS (MySQL, Postgre, etc.)   | Vertica         |
| Aster Data     |        |
| Greenplum         |         |
|  (Spanner)        |         |

<br><b>Tabelle 3:  Eine Auswahl verschiedener CA-Datenbanken [Luketic, 2019][Brewer, 2017].</b></p>

Um eine CA-Datenbank zu sein, muss das Datenbankensystem einen hohen Wert auf die Konsistenz der Daten als auch auf ihre Verfügbarkeit legen. Partitionen dürfen also vorkommen, aber keinen Einfluss auf diese beiden Faktoren haben. In der Regel sind CA-Datenbanken aber solche, wo Partitionen gar nicht erst vorkommen (können). Ein klassisches Beispiel hierfür sind die Relationalen Datenbanken, die je nach Netzwerksystem gar nicht mit Partitionen umgehen können müssen, da sie nicht relevant sind [DatenbankenVerstehen].
Als Beispiel eines solchen Systems untersuchen wird im Folgenden das vermutlich am weitesten verbreitete RDBMS MySQL.

### 5.1 MySQL

1995 von MySQL AB entwickelt ist MySQL heute ein “relationales Open-Source-SQL-Databaseverwaltungssystem, das von Oracle entwickelt und unterstützt wird” [Kinsta 2019]. Laut offizieller Webseite sind beispielsweise YouTube, LinkedIn und auch PayPal Nutzer dieses Angebots. 
Als klassisches relationales Datenbanksystem besteht MySQL aus mehreren Tabellen, die durch Verweise auf eindeutige IDs der einzelnen Elemente innerhalb einer Tabelle in Beziehung zueinander stehen. Dadurch ist es zum Beispiel möglich in einem Online-Shop System die Bestellungen aus der einen Tabelle mit einem Kunden aus einer anderen Tabelle zu verknüpfen und sich durch bestimmte Abfragen eine Liste dieser Bestellungen eines spezifischen Kunden anzeigen zu lassen [Kinsta 2019].

![image9](https://user-images.githubusercontent.com/40004315/105680233-b8780480-5eef-11eb-950f-53e3339e48b4.PNG)
<br><b>Abbildung 9: Beispiel von MySQL Tabellen [Kinsta, 2019].</b></p>

Des Weiteren arbeitet MySQL nach dem Client-Server-Prinzip: Die Daten sind auf einem Server gespeichert und ein oder mehrere Clients können auf diese Daten zugreifen. 

### 5.2 Anwendungsfall

Da es sich bei CA-Datenbanken in der Regel um solche handelt, die keine Partitionen berücksichtigen müssen, sind vor allem kleinere Anwendungen, die nicht stark skalierbar sein müssen, Nutzer dieser Datenbanken. RDBMS sind ein solcher typischer Anwendungsfall. Vor allem Webanwendungen, CMS-Systeme und Online-Shops basieren auf relationalen Datenbanksystemen. Sie haben eine überschaubare Menge an Daten sowie an Schreib- und Lesebefehlen und sind nebenbei durch ihren recht simplen tabellarischen Aufbau im Vergleich zu anderen Datenbanksystemen vor allem für lineare Anwendungsfälle gut geeignet. Auch Logs werden häufiger mit RDBMS wie MySQL verwaltet [WerbeMarkt]. 

## 6. Sonderfall Spanner

Ein besonderer Fall in den Einstufungen zu den verschiedenen Formen der Datenbanken ist Google Clouds Datenbank Spanner. Sie ist der Nachfolger von Googles Datenbanken BigTable und MegaStore und bietet laut Firmenwebseite eine relationale und skalierbare Datenbank mit automatischer Fragmentierung und 99,999% Verfügbarkeit [Google]. 

Obwohl Spanner technisch eine CP-Datenbank ist, sorgt die Implementierungsweise dafür, dass es effektiv als CA-Datenbank eingestuft werden kann [Agneeswaran 2017, Brewer 2017]. Um dies genauer nachvollziehen zu können, fassen wir den Aufbau von Spanner einmal zusammen:

Spanner ist ein relationales Datenbanksystem, das als erstes System globale Linearisierung ermöglicht. Durch eine Zusammenarbeit mit der TrueTime API ist es Spanner möglich, Transaktionen auf einem verteilten Set von Nodes globale Timestamps zuzuordnen. Dadurch werden zeitliche Unsicherheiten auf weniger als 10ms beschränkt [Agneeswaran 2017]. Google selbst wirbt mit 99,999% Availability, die dadurch erreicht werden kann [Google]. Streng genommen ist Spanner dennoch eine CP-Datenbank. Denn sollte doch einmal eine Partition aufkommen, opfert es die Verfügbarkeit, um eine absolute Konsistenz der Daten zu gewährleisten. Da die Nicht-Verfügbarkeiten für den Nutzer aber - durch ihre extreme Seltenheit und auch Kürze - kaum wahrnehmbar sind, ist das System aus Sicht des Nutzers eine CA-Datenbank [Agneeswaran 2017, Brewer 2017]. Anwendungen, die auf Spanner basieren, werden zum Beispiel von der New York Times, Sony Music oder auch Blockchain verwendet [Google]. 


## 7. Kritik am CAP-Theorem

Das CAP-Theorem ist ein häufig genanntes unmögliches Ergebnis in verteilten Systemen. Unmöglich, weil nur zwei der drei Möglichkeiten gewählt werden können. Martin Kleppmann gehört zu den bekanntesten Kritikern dieses Theorems mit seinem Paper “A Critique of the CAP Theorem” [Kleppmann, 2015]. Im Folgenden sollen Kleppmanns Erkenntnisse dargelegt werden, um ein besseres Verständnis davon zu erhalten, wo das CAP-Theorem an seine Grenzen stößt.

Grundsätzlich besagt das CAP-Theorem, dass eine reale Datenbank, die auf mehr als einem Computer ausgeführt wird, nur eine der beiden folgenden Eigenschaften haben kann:
Linearisierbarkeit (linearizability)

Die klassische Definition von Linearisierbarkeit lautet [Kleppmann Blog, 2015]:
Wenn Operation B gestartet wurde, nachdem Operation A erfolgreich abgeschlossen wurde, muss Operation B das System in demselben Zustand wie nach Abschluss von Operation A oder in einem neueren Zustand sehen.

Eine etwas einfachere Erklärung bietet die folgende Grafik von Martin Kleppmann:

![image10](https://user-images.githubusercontent.com/40004315/105680614-45bb5900-5ef0-11eb-9831-a5bf470a62aa.PNG)
<br><b>Abbildung 10: Linearisierbarkeit nach [Kleppmann Blog, 2015].</b></p>

In der Darstellung sieht man 2 Personen, Alice und Bob, welche sich im selben Raum befinden. Beide suchen auf ihren Handys das Ergebnis des WM Finales 2014. Als das Ergebnis bekannt gegeben wurden, aktualisiert Alice die Internetseite zuerst und sagt Bob das Ergebnis. Bob aktualisiert ebenfalls die Internetseite. Ihm wird jedoch angezeigt, das Spiel würde noch laufen, da seine Anfrage an eine Datenbank-Replika gesendet wird. Diese hängt zeitlich hinterher, weshalb Bob ein veraltetes Ergebnis erhält.
Hätten beide Personen die Seite zeitgleich aktualisiert, wäre dieses Ergebnis nicht verwunderlich gewesen. Dies liegt daran, dass man in diesem Fall nicht genau wissen könnte, wann die einzelnen Anfragen jeweils vom Server verarbeitet wurden. Alice hat Bob das Ergebnis jedoch bereits mündlich mitgeteilt. Daher weiß Bob, dass sein Ergebnis falsch ist. Er würde erwarten das gleiche Ergebnis wie Alice zu erhalten. Diese Tatsache weist auf eine Verletzung der Linearisierbarkeit hin.
Wenn Bob nicht von Alice gehört hätte, dass das Spiel vorbei ist, hätte er nicht gewusst, dass das Ergebnis seiner Anfrage veraltet ist.

Wenn man eine Datenbank erstellt, weiß man nicht, über welche Arten von Backchannel die Kunden verfügen. Wenn man also eine linearisierbare Semantik (CAP-Konsistenz) in der Datenbank bereitstellen möchte, muss man den Eindruck erwecken, dass nur eine einzige Kopie der Daten vorhanden ist, obwohl möglicherweise Kopien (Replikate, Caches) der Daten an mehreren Stellen vorhanden sind.

Verfügbarkeit (availability)

Vereinfacht bedeutet dies, dass jeder Computer im System zu jeder Zeit eine Antwort geben kann.
In der Realität entspricht die Verfügbarkeit aber nicht der Verfügbarkeit des CAP-Theorems. Die Verfügbarkeit einer Anwendung wird wahrscheinlich mit einigen SLA (Service-Level-Agreements) gemessen [Kleppmann Blog, 2015]. Beispielsweise müssen 99,9% der Anfragen innerhalb von einer Sekunde eine erfolgreiche Antwort zurückgeben. Ein solches SLA kann jedoch sowohl mit CAP-verfügbaren als auch mit CAP-nicht-verfügbaren Systemen erfüllt werden.
In der Praxis werden zudem Systeme häufig mit asynchroner Replikation entworfen und sind daher nicht linearisierbar. Der Grund für diese Wahl ist jedoch häufig die Latenz von Weitverkehrsnetzwerken, die nicht nur Datencenter- und Netzwerkfehler tolerieren möchten [Kleppmann Blog, 2015].

In Bezug auf das CAP-Theorem liest man häufig, dass man aus Konsistenz, Verfügbarkeit und Partitionstoleranz zwei wählen müsste. Kleppmann stellt jedoch fest, dass man die Partitionstoleranz nicht opfern kann, sodass man eigentlich nur zwischen C und A wählen kann.

#### Nützlichkeit des CAP-Theorem

Einige verteilte Systeme behaupten, linearisierbar zu sein. Dazu zählen beispielsweise Consul, etcd und zookeeper [Kleppmann Blog, 2015]. Diese verwenden Algorithmen wie Paxos oder Raft. Dem CAP-Theorem gemäß würde dies Folgendes bedeuten: Da die Systeme linearisierbar sind, müssen sie nicht vollständig verfügbar sein. In der Praxis sollten sie mit Ausfallzeiten dieser Systeme rechnen. An dieser Stelle kann das CAP-Theorem durchaus zum Verständnis beitragen.
Ganz anders sieht es jedoch bei nicht linearisierbaren Systemen aus. Ein Beispiel dafür wäre ein Datenbanksystem, dass über ein primäres System verfügt und Schreibvorgänge auf ein sekundäres System repliziert, und dann manchmal aus dem sekundären System liest [Kleppmann, 2015]. Für einen solchen Fall gibt das CAP-Theorem keine Auskunft. Replizierte Datenbank-Setups sind jedoch äußerst häufig und nützlich. AP wäre hier keine treffende Beschreibung für dieses System, da es einige interessante Konsistenz-Merkmale aufweist und sich von einigen anderen AP-Systemen stark unterscheidet. 

#### Kompromiss zwischen Konsistenz und Verfügbarkeit

In dieser Ausarbeitung wurde das CAP-Theorem bereits bewiesen. Dabei wurde deutlich, dass das Theorem eigentlich recht einfach zu beweisen ist. Dazu trifft man zuerst folgende Annahmen:

- Es sind zwei Computer vorhanden.
- Beide Computer können nicht kommunizieren
- Beide Computer sollen sich konsistent verhalten (Wenn man “Hallo” an den Computer 1 schreibt, soll das ganze System den Wert “Hallo” kennen.).

Diese Annahmen beschreiben bereits ein CP-System. Wenn man jetzt möchte, dass das System zusätzlich noch verfügbar (A) ist, ist das unmöglich. Computer 2 kann nicht sagen, dass der aktuelle Wert "Hallo" ist. Es gibt keine Möglichkeit, dies zu wissen, da er nicht mit Computer 1 kommunizieren kann. Damit wäre das CAP-Theorem bewiesen.
Kleppmann stellt dazu fest, dass die Entscheidung eigentlich stets nur zwischen Konsistenz (C) und Verfügbarkeit (A) stattfindet. Er beschreibt dies in der spezifischen Regel: wenn die Systeme linearisierbar sind, können sie nicht verfügbar sein [Kleppmann, 2015]. Daraus erwächst die Kritik, das CAP-Theorem sei absolut, während die Realität dagegen eher nach einem Kompromiss verlangt: Wenn das System ein bisschen konsistenter ist, dann ist es ein bisschen weniger verfügbar. Das CAP-Theorem nach Brewer kann diese Aussage aber nicht bestätigen.

#### Ein langsames Netzwerk

Kleppmann schlägt in seiner Kritik ein alternatives Theorem vor. Dabei bezieht er die Netzwerklatenz ein. Für dieses Theorem wird vorausgesetzt, dass das Netzwerk sehr langsam wird. Für ein linearisierbares System bedeutet dies, dass die Lese- und Schreibvorgänge langsam werden [Kleppmann, 2015]. Sowohl für den Nutzer als auch für das System kann dies problematisch werden. Für ein System, welches weniger konsistent ist, wäre dies weniger problematisch. Kleppmann zeigt, dass unter Verwendung einer sequentiellen Konsistenz, langsame Schreibvorgänge, aber schnelle Lesevorgänge ausgeführt werden können.
Diese Tabelle aus dem Paper von Kleppmann, in der er verschiedene Konsistenzstufen auflistet, wie schnell Lese- / Schreibvorgänge unter ungünstigen Netzwerkbedingungen durchgeführt werden können.

| Konsistenzstufen   | schreiben | lesen   |
| :----------------- | :------------- | :---------   |
| linearisierbar   | langsam         | langsam |
| sequentielle Konsistenz     | langsam        | schnell|
| kausale Konsistenz         | schnell         | schnell |

<br><b>Tabelle 4: Konsistenzstufen [Kleppmann, 2015].</b></p>

Im Umkehrschluss bedeutet dies für ein linearisierbares System, dass das Schreiben von Daten unmöglich ist, sollte das Netzwerk vollständig ausfallen.
Dieses neue Framing von Kleppmann mit Bezug auf Netzwerklatenz und Betriebsgeschwindigkeit ist realistischer. Denn wir alle kennen die Situation von zu Hause, wenn die Verbindung mal schlecht oder einfach langsam wird. Kleppmanns neuer Ansatz führt dazu, dass mehr Systeme beschrieben werden können. Die Unterscheidung zwischen sequentieller und kausaler Konsistenz gibt mehr Möglichkeiten. Sie bricht damit die starre Entscheidung zwischen C und A auf und bietet tatsächlich, wie bereits angesprochen, eine Art Kompromiss [Kleppmann, 2015].

#### Zusammenfassung

Es ist bemerkenswert zu erwähnen, das selbst Eric Brewer Bedenken hinsichtlich seines CAP-Theorems äußerte. Bereits 2012, zwölf Jahre nachdem er seinen Satz zum ersten Mal in die Welt gesetzt hatte, schrieb er Folgendes:
“Although designers still need to choose between consistency and availability when partitions are present, there is an incredible range of flexibility for handling partitions and recovering from them. The modern CAP goal should be to maximize combinations of consistency and availability that make sense for the specific application. Such an approach incorporates plans for operation during a partition and for recovery afterward, thus helping designers think about CAP beyond its historically perceived limitations” [Packt, 2019].
Damit beschreibt er die Erkenntnis, dass es nach einem Kompromiss zwischen Konsistenz und Verfügbarkeit verlangt und die Entscheidung nicht als binär zu betrachten ist. Diese Bedenken hat auch Kleppmann aufgegriffen. In seinem Paper beschreibt er passend, dass die Entscheidung zum einen nur zwischen C und A stattfindet aber auch, dass eine solche harte Entscheidung unrealistisch ist. Kleppmann ist auf der Suche an einem solchen Kompromiss und liefert dazu einen neuen und praxisnahen Ansatz, indem er die Netzwerklatenz einbezieht. Sein Ansatz bietet damit die Möglichkeit mehr Systeme durch die Abwägung von eigenen Bedingungen gegen eigene Bedürfnisse zu beschreiben.


## 8. Was kommt nach CAP?

#### Das PACELC-Theorem

Die Kritik am CAP-Theorem zeigte, dass eine so starre Entscheidung nicht der Realität entspricht. Einen neuen Ansatz bietet hier das PACELC-Theorem, welches als Erweiterung von CAP verstanden werden kann. Dieses bietet über die bisherige Entscheidung hinaus einen Kompromiss zwischen Latenz und Konsistenz.
Daher kann PACELC folgendermaßen gelesen werden: Es übernimmt P, A und C aus CAP, fügt ein Else (E) hinzu, welches dann zusätzlich die Wahl zwischen Latenz (L) und Konsistenz (C)  bietet → PACELC [Wikipedia, 2020].

![image11](https://user-images.githubusercontent.com/40004315/105680672-5966bf80-5ef0-11eb-83c6-ca2e29ac1f2c.PNG)
<br><b>Abbildung 11: PACELC-Theorem [Ardalis, 2015].</b></p>

Im Gegensatz zu CAP wird nun eine Aussage über das Netzwerk hinzugefügt, nämlich ob es vorhanden ist oder nicht. Wenn das Netzwerk vorhanden ist, kann der Anwender zwischen Latenz und Konsistenz wählen. In einem verteilten System kann ein Netzwerkausfall nicht vermieden werden. Daher entscheidet ein verteiltes System gemäß CAP zwischen Konsistenz oder Verfügbarkeit. Eine ACID Datenbank hat die Konsistenz ausgewählt, während eine BASE Datenbank die Verfügbarkeit gewählt hat. PACELC gibt darüber hinaus weitere Aussagen darüber, was passiert, wenn das Netzwerk nicht ausfällt. PACELC geht davon aus, dass die Verfügbarkeit durch Replikationen aufrechterhalten werden kann. Wenn es zu einem Netzwerkausfall kommt, gilt der CAP Satz. Wenn nicht, kann mit PACELC ein Kompromiss zwischen Konsistenz und Latenz gefunden werden.

#### Microservices

Die Wirkungsweise des modernen und realistischeren Theorem PACELC soll nun am Beispiel der Microservices verdeutlicht werden. Mit Microservices ist eine Form der Architektur gemeint, in welcher eine Anwendung umgesetzt ist. 

![image12](https://user-images.githubusercontent.com/40004315/105682118-5240b100-5ef2-11eb-8796-fcca734d9271.PNG)
<br><b>Abbildung 12: Microservices [Richardson, 2020].</b></p>

Eine Besonderheit dieser Architektur ist ihr unabhängiges Deployment [Richardson, 2020]. Einzelne Microservices können unabhängig voneinander in Produktion gebracht werden. Zusätzlich können diese als Docker-Container umgesetzt sein, wobei mehrere Container eine Anwendung bilden [Wolff, 2017]. Dies hat den Vorteil, dass jeder Microservice in einer anderen Programmiersprache verfasst sein kann. Dadurch ermöglicht diese Technologie eine schnelle, regelmäßige und verlässliche Art, um komplexe Anwendungen zu erstellen. Mit dieser Architektur können Unternehmen einfacher in mehreren kleinen Teams und mit unterschiedlichen Technologien arbeiten [Wolff, 2017].
Durch den Einsatz von Microservices in moderner Programmierung, bieten diese ein passendes Beispiel für die Wirkungsweise von CAP und PACELC. Ardalis beschreibt diese in seinem Blogeintrag sehr anschaulich. Er illustriert dafür die unterschiedlichen Szenarien, welche im Folgenden dargestellt werden. 

![image13](https://user-images.githubusercontent.com/40004315/105682471-c7ac8180-5ef2-11eb-923c-ed3a8c2f949b.PNG)
<br><b>Abbildung 13: Kein Netzwerkausfall [Ardalis, 2020].</b></p>

In Abbildung 13 setzt sich der Service A mit einem Nutzer auseinander. Dieser sendet an und empfängt von zwei weitere Microservices. Alle Abfragen und Ergebnisse werden problemlos empfangen, es liegt also kein Netzwerkausfall vor. In diesem Fall ist das abgebildete System sowohl verfügbar (A), als auch konsistent (C).

![image14](https://user-images.githubusercontent.com/40004315/105682573-e9a60400-5ef2-11eb-9a9d-0b30dad6275f.PNG)
<br><b>Abbildung 14: Netzwerkausfall bei B [Ardalis, 2020].</b></p>

![image15](https://user-images.githubusercontent.com/40004315/105682912-502b2200-5ef3-11eb-980d-0ecf5dc14afa.PNG)
<br><b>Abbildung 15: Netzwerkausfall bei C [Ardalis, 2020].</b></p>

In den Abbildungen 14 und 15 kommt es zum Netzwerkausfall bei Service B bzw. C. Dies hat zur Folge, dass Anfragen von A zu B bzw. C in einem Timeout enden und die ursprüngliche Nutzeranfrage an A scheitert. Beide Szenarien haben zur Folge, dass die Verfügbarkeit (A) nicht mehr gegeben ist. Das System wäre jedoch noch immer konsistent [Ardalis, 2020]. Würde A versuchen Ergebnisse zurückzugeben, die von B abhängen, wären die Daten inkonsistent. Daher ist in beiden Fällen der Service A für den Nutzer nicht verfügbar, da Service A von Service B bzw. C abhängig ist.
Abbildung 14 und 15 zeigen direkte und synchrone Abfragen zwischen den einzelnen Microservices. Diese Art der Kommunikation folgt dem CAP-Theorem. Die Beispiele haben zudem verdeutlicht, dass an dieser Stelle Konsistenz der Verfügbarkeit vorgezogen wird, es wäre demnach ein CP System [Ardalis, 2020].

![image22](https://user-images.githubusercontent.com/40004315/105683052-7cdf3980-5ef3-11eb-80c1-c46079c82599.PNG)
<br><b>Abbildung 16: Zwischenspeicher [Ardalis, 2020].</b></p>

![image17](https://user-images.githubusercontent.com/40004315/105683085-8799ce80-5ef3-11eb-9b3e-cd434bd7265c.PNG)
<br><b>Abbildung 17: Ausfall mit Zwischenspeicher [Ardalis, 2020].</b></p>

Um die Verfügbarkeit zu gewährleisten, ist es üblich Zwischenspeicher (Cache) einzusetzen. Damit werden die direkten und synchronen Abfragen praktisch ersetzt. Sobald sich Daten auf B oder C ändern, wird ein Ereignis angestoßen, wodurch auch der Zwischenspeicher aktualisiert wird. Wenn es bei einem der Services zu einem Netzwerkausfall kommt, kann A noch auf den Zwischenspeicher zurückgreifen, um Abfragen zu bedienen. Der Service ist damit verfügbar. Jedoch ist er dadurch auch inkonsistent, da der Zwischenspeicher keine Aktualisierungen mehr erfährt und die Daten veraltet sein könnten [Ardalis, 2020]. Sobald die Verbindung wieder hergestellt wird, ist auch die Konsistenz wieder gegeben.
Neben den klassischen Abfragen (Querys), wurden im letzten Beispiel Events verwendet. Events sind Nachrichten, dass etwas passiert ist [Pierlot, 2017]. In dem zuvor beschriebenen Beispiel sagt das Event aus, dass sich die Daten auf C bzw. B geändert haben. Zu beachten ist, dass die Namen von Ereignissen immer in der Vergangenheitsform lauten müssen, z.B. DataChanged.
Die folgenden Beispiele enthalten eine weitere neue Aktion, den Befehl (Command). In den beschriebenen Szenarien handeln die Microservices nach der sogenannten Command Query Responsibility Segregation, kurz CQRS. Dabei ist jedes Datenobjekt unterteilt in Abfrage (Query) und Befehl (Command) [Pierlot, 2017]. Was unterscheidet jedoch diese beiden Objekte? 
Ein Befehl gibt der Anwendung Anweisungen. Daher haben Befehle immer einen aktiven Namen, wie z.B. SendData. Wichtig ist, dass Befehle einen konkreten Anwendungsfall beschreiben und sich nicht nur auf erstellen, ändern oder löschen beschränken [Pierlot, 2017]. Der Befehl beschreibt eine konkrete Absicht des Benutzers. Dieser ändert den Zustand der Anwendung, gibt aber keine Daten zurück. Eine Abfrage liefert im Gegensatz zum Befehl nur einen Wert zurück [Pierlot, 2017].
Ein Vorteil dieser Trennung zwischen Abfrage und Befehl ist die Skalierbarkeit. Das bedeutet, dass die Anzahl der Lesevorgänge innerhalb der Anwendung anders normiert werden kann als die der Schreibvorgänge. Zusätzlich wird mit CQRS die Datenkonsistenz nicht verändert [Pierlot, 2017].

Doch nun wieder zurück zu den Microservices. Die soeben angesprochenen Befehle sollen nun in das Beispiel einfließen.

![image18](https://user-images.githubusercontent.com/40004315/105683366-d9425900-5ef3-11eb-866e-d3626038103f.PNG)
<br><b>Abbildung 18: Befehle (Commands) [Ardalis, 2020].</b></p>

Abbildung 18 zeigt die allgemeine Wirkungsweise von Befehlen in unserem Szenario. Wenn es hierbei zu keinerlei Störungen kommt, funktioniert es einwandfrei.

![image19](https://user-images.githubusercontent.com/40004315/105683389-e101fd80-5ef3-11eb-827b-b0e3ab437b6a.PNG)
<br><b>Abbildung 19: Befehle bei Netzwerkausfall [Ardalis, 2020].</b></p>

Wenn jedoch Service B ausfällt, wird auf den gesendeten Befehl mit einem “Nicht OK” geantwortet. Dabei wird meistens ein entsprechender Code (500 für Nicht OK) zurückgesendet [Pierlot, 2017]. Dieser wird dann auch von A an den Benutzer zurückgegeben. Damit geht die Verfügbarkeit von A verloren. Zusätzlich ging auch die Konsistenz des gesamten Systems verloren, da C ein OK zurückgegeben hat. Microservices bieten eine Möglichkeit dieses Problem zu beheben [Pierlot, 2017].

![image20](https://user-images.githubusercontent.com/40004315/105683416-e7907500-5ef3-11eb-8438-2b9b6fa27bb9.PNG)
<br><b>Abbildung 20: local persistent message queues [Ardalis, 2020].</b></p>

Um das Problem aus Abbildung 19 zu umgehen, können sog. local persistent message queues eingesetzt werden [Pierlot, 2017]. Dabei werden die Befehle von Service A in Warteschlangen eingereiht. Die Services B und C lesen dann aus den Warteschlangen. Ein Nachteil davon ist, dass es zu hohen Latenzen im Betrieb kommen kann, besonders bei einer hohen Länge der Warteschlange [Pierlot, 2017]. Auf der anderen Seite können genau diese Längen als Indikatoren dienen. Ist dieser Indikator hoch, wäre dies ein Argument weitere Services neben B und C in Betrieb zu nehmen, um das System zu beschleunigen [Pierlot, 2017]. Die hier angesprochene Latenz bringt uns nun wieder zurück zum PACELC-Theorem.

![image21](https://user-images.githubusercontent.com/40004315/105683444-ef501980-5ef3-11eb-86b3-72c3dbdf643d.PNG)
<br><b>Abbildung 21: Netzwerkausfall bei Queues [Ardalis, 2020].</b></p>

Abschließend muss noch der Fall betrachtet werden, wenn mit Einsatz von Warteschlangen einer der Services B oder C ausfällt. In diesem Fall kann C nicht mehr aus der Warteschlange lesen. Das System bleibt verfügbar, da A nicht weiß, was mit C passiert ist. Jedoch ist es nicht mehr konsistent, da die Befehle nicht mehr aus der Warteschlange abgeholt werden. Wenn C wieder eine Netzwerkverbindung herstellt, kann dieser Dienst die Warteschlange abarbeiten und die Konsistenz wiederherstellen [Pierlot, 2017].

#### Zusammenfassung

Welche Erkenntnisse zu PACELC und Microservices lassen sich nun aus den Szenarien gewinnen? 
Gemäß der Definitionen von PACELC, können relationale und NoSql Datenbanken, welche ACID implementieren als PC/EC klassifiziert werden, denn diese sind darauf ausgelegt Konsistenz zu gewährleisten [Nolle, 2020]. Datenbanken wie MongoDB passen in das PA/Ev Model. Diese gewährleisten hohe Verfügbarkeit, auch bei Netzwerkausfall [Nolle, 2020]. Echtzeit-Systeme  wie etwa für das Internet-of-Things passen in das PC/EL Model. Hier wird Konsistenz für Replikationen gewährleistet. Datenbanken wie Cassandra sind gemäß PACELC auf PA/EL ausgelegt, da hier Konsistenz keine Notwendigkeit ist [Nolle, 2020].
Ein Verständnis über das CAP-Theorem ist also wichtig, um auch PACELC richtig anwenden zu können. Ein IT-Architekt muss wissen, welche Kompromisse er an welcher Stelle eingehen kann. Die zuvor beschriebenen Szenarien geben dabei Anhaltspunkte, welche Eigenschaften ein System sicherstellen muss. Konsistenz ist am wichtigsten, wenn viele Nutzer die gleichen Datenelemente aktualisieren. Typisch dafür sind Geschäftsanwendungen, wie z.B. Anwendungen für das Personalmanagement [Nolle, 2020]. Latenz ist wichtig für Echtzeit-Systeme, besonders beim Internet-of-Things. In solchen Systemen muss die Verzögerung möglichst gering gehalten werden [Nolle, 2020]. Verfügbarkeit ist am wichtigsten bei Systemen, in denen es Kunden gibt, aber auch beim Internet-of-Things. Klassische Beispiele dafür sind sämtliche E-Commerce Anwendungen [Nolle, 2020]. 
Besonders der letzte Fall mit E-Commerce-Systemen wie Amazon, ist uns allen aus dem Alltag bekannt und lässt sich gut mit dem obigen Szenario erklären. Wenn man eine Bestellung bei Amazon aufgibt, erhält man im Browser nicht sofort eine Antwort mit dem Status der Bestellung. Der Server verarbeitet weder die Bestellung noch belastet er das Konto des Kunden. Es wird schlicht eine Nachricht zurückgegeben, um den Nutzer darüber zu informieren, dass er erfolgreich einen Kaufvorgang abgeschlossen hat. In der Zwischenzeit wurde ein Workflow in Form eines Befehls (Command) gestartet, der in die Warteschlange gereiht wurde. Andere Prozesse interagieren mit der neu erteilten Bestellung und führen die erforderlichen Schritte aus. Irgendwann wird die Bestellung tatsächlich bearbeitet und ein weiterer Dienst sendet eine E-Mail, in der die Bestellung bestätigt wird. Dies ist die Out-of-Band-Antwort, die der Server nicht synchron über den Browser, sondern per E-Mail sendet. Wenn es ein Problem mit der Bestellung gibt, kümmert sich der Service, der den Warenkorb auf der Website ausgecheckt hat, nicht darum. Stattdessen erhält man eine andere E-Mail, die über das Problem informiert und Anweisungen zur Behebung des Problems gibt. Als Amazon-Kunde ist man an diesen Workflow gewöhnt ohne darüber nachzudenken. Personen, welche mit Amazon vertraut sind, erwarten solche Workflows auch von anderen E-Commerce-Systemen.


## 9. Fazit

Zusammenfassend lässt sich sagen, dass das CAP-Theorem der Beweis für die Nicht-Existenz eines verteilten Datenbanksystems ist, welches alle drei Eigenschaften, Konsistenz (C), Ausfalltoleranz (P) und Verfügbarkeit (A), vereint. Daraus ergeben sich drei Kombinationen für Datenbanksysteme: AP, CA und CP. Je nach Anwendungsfall ist unterschiedlich, welche Kombination der Eigenschaften sinnvoll ist.
CP-Datenbanken legen viel Wert auf eine hohe Konsistenz, z.B. in Geldautomaten, damit es keine Fehlbuchungen gibt. Umgesetzt werden diese Datenbanken bspw. mit MongoDB.
AP-Datenbanken finden ihren Anwendungsfall oft im Social Media- und Konsumbereich. Dort hat Schnelligkeit die Priorität, da Nutzer von z.B. Facebook jederzeit erreichbar sein, auf ihren Account zugreifen und Daten wie Posts oder Fotos veröffentlichen wollen.
CA-Datenbanken bilden den geringen Anteil im Web2.0-Zeitalter, da sie eher für kleinere Anwendungen, die nicht stark skalierbar sein müssen, verwendet werden. Beispiele hierfür sind Webanwendungen oder Online-Shops. Umgesetzt werden sie mit relationalen Datenbanksystemen wie MySCL.

Jedoch konnte gezeigt werden, dass sich in der Praxis nicht alle Datenbanksysteme immer einer Kategorie klar zuordnen lassen, wie z.B. Google Clouds Datenbank Spanner, welche technisch eine CP-Datenbank ist, aber aus Sicht des Nutzers als CA-Datenbank gesehen werden kann. Das liegt daran, dass bei (sehr selten vorkommenden) Ausfällen von Nodes im System, die Konsistenz auf Kosten der Verfügbarkeit erhalten bleibt. Doch durch die extreme Seltenheit und auch Kürze dieser ausbleibenden Verfügbarkeit ist sie von dem Nutzer kaum wahrnehmbar.
Es wurde festgestellt, dass auf die Ausfalltoleranz in den seltensten Fällen verzichtet werden kann, weshalb die Entscheidung stets zwischen Konsistenz und Verfügbarkeit gefällt werden muss. Laut dem CAP-Theorem kann ein ausfalltolerantes, konsistentes System nicht verfügbar sein und ein ausfalltolerantes, verfügbares nicht konsistent. In der Praxis wird aber eher ein Kompromiss angestrebt: Eine steigende Konsistenz geht mit einer sinkenden Verfügbarkeit einher und umgekehrt. 
Kleppmann schlägt ein alternatives Theorem vor, in dem die Netzwerklatenz miteinbezogen wird. Ob nämlich ein System langsamer reagiert als ein anderes, wird im CAP-Theorem nicht berücksichtigt. Besonders für konsistente Systeme ist dies ein wichtiger Aspekt. Sein neuer Ansatz führt dazu, dass mehr unterschiedliche Systeme beschrieben werden können und die starre Entscheidung zwischen Konsistenz und Verfügbarkeit aufgebrochen wird. 
Das PACELC-Theorem bietet also einen erweiterten Ansatz zu CAP und berücksichtigt den Kompromiss zwischen Latenz und Konsistenz, dies wurde beispielhaft an den Microservices gezeigt. 
Entscheidend für die Implementierung von Datenbanksystem ist schlussfolgernd ein Verständnis für das CAP-Theorem, um abzuschätzen, welche Kompromisse in welchem Anwendungsfall eingegangen werden können. Die Erweiterung des PACELC-Theorem hilft zusätzlich dabei, weitere Szenarien abzubilden, die die Netzwerkgeschwindigkeit mit berücksichtigen. Besonders Echtzeit-Systeme sind auf diese Eigenschaft angewiesen.  
Das CAP-Theorem ist sehr eingeschränkt in seiner Definition, gibt aber dennoch einen korrekten Einblick in die Abhängigkeiten zwischen den einzelnen Eigenschaften C, A und P. Hierbei sollte nur unbedingt beachtet werden, dass das Theorem diese Abhängigkeiten als absolut ansieht. Dies ist in der Praxis oftmals nicht der Fall, da es möglich ist, Kompromisse einzugehen, bzw. Systeme je nach Szenario unterschiedlich reagieren zu lassen und flexibel zwischen Verfügbarkeit und Konsistenz zu entscheiden.




## Literaturverzeichnis
Gilbert. (2002). *Brewer's conjecture and the feasibility of consistent, available, partition-tolerant web services.* Acm Sigact News 33.2 (2002): 51-59.

Ionos. *Was ist das CAP Theorem* Von  https://www.ionos.de/digitalguide/server/knowhow/was-ist-das-cap-theorem/ abgerufen

Fekete (2018). *CAP Theorem* In: Liu L., Özsu M.T. (eds) Encyclopedia of Database Systems. Springer, New York.

codecentric. *Grundlagen Cloud Computing - CAP Theorem* Von  https://blog.codecentric.de/2011/08/grundlagen-cloud-computing-cap-theorem/ abgerufen

dbengines. *CAP Theorem* Von  https://db-engines.com/de/article/CAP+Theorem abgerufen

Whittaker. *Illustrated proof of the CAP theorem* Von  https://mwhittaker.github.io/blog/an_illustrated_proof_of_the_cap_theorem/ abgerufen

CAP. *CAP* Von  https://wikis.gm.fh-koeln.de/Datenbanken/CAP abgerufen

Ali. (2020). *MongoDB queries examples* Von https://geekflare.com/de/mongodb-queries-examples/ abgerufen

Bhandari. (2020). *Beginner Guide to CAP Theorem* Von https://www.analyticsvidhya.com/blog/2020/08/a-beginners-guide-to-cap-theorem-for-data-engineering/ abgerufen

Luketic. (2019). *Datenbanken und CAP* Von https://blog.icod.de/2019/03/12/grafik-bzgl-datenbanken-und-cap-theorem/ abgerufen

Brewer. (2017). *Spanner, TrueTime & The CAP Theorem* Von https://storage.googleapis.com/pub-tools-public-publication-data/pdf/45855.pdf abgerufen

Fedak. (2018). *Reasons to use Cassandra* Von https://towardsdatascience.com/top-5-reasons-to-use-the-apache-cassandra-database-d541c6448557 abgerufen

Schnelle. (2011). *Cassandra* Von https://www.pro-linux.de/artikel/2/1531/cassandra-die-datenbank-hinter-facebook.html abgerufen

Heise. (2011). *NoSQL Cassandra* Von https://www.heise.de/newsticker/meldung/NoSQL-Datenbank-Cassandra-in-Version-0-8-1255982.html abgerufen

DatenbankenVerstehen. *CAP Theorem* Von https://datenbanken-verstehen.de/lexikon/cap-theorem/ abgerufen

Agneeswaran. (2017). *Google Spanner* Von http://wp.sigmod.org/?p=2153 abgerufen

WerbeMarkt. *MySQL Anwendung* Von https://www.werbe-markt.de/mysql-anwendung.php abgerufen

Kinsta. (2019). *was ist MySQL* Von https://kinsta.com/de/wissensdatenbank/was-ist-mysql/ abgerufen

Google. *Spanner* Von https://cloud.google.com/spanner abgerufen

MongoDB. *MongoDB* Von https://www.mongodb.com/company abgerufen

Kleppmann. (2015). *Critique of the CAP Theorem* Von https://www.researchgate.net/publication/281895403_A_Critique_of_the_CAP_Theorem abgerufen

Kleppmann-Blog. (2015). *Stop Calling Databases CP or AP* Von https://martin.kleppmann.com/2015/05/11/please-stop-calling-databases-cp-or-ap.html abgerufen

Packt. (2019). *CAP Theorem in practice* Von https://hub.packtpub.com/the-cap-theorem-in-practice-the-consistency-vs-availability-trade-off-in-distributed-databases/ abgerufen

Ardalis. (2020). *CAP, PACELC and Microservices* Von https://ardalis.com/cap-pacelc-and-microservices/ abgerufen

Pierlot. (2017). *CQRS* Von https://medium.com/eleven-labs/cqrs-pattern-c1d6f8517314 abgerufen

Nolle. (2020). *CAP Theorem and Microservices* Von https://searchapparchitecture.techtarget.com/tip/The-CAP-theorem-and-how-it-applies-to-microservices abgerufen

Wolff. (2017). *Was sind Microservices* Von https://jaxenter.de/was-sind-microservices-40571 abgerufen

Richardson. (2020). *Microservices* Von https://microservices.io/ abgerufen

Wikipedia. (2020). *PACELC Theorem* Von https://en.wikipedia.org/wiki/PACELC_theorem abgerufen

## Fußnote
[^1]: Ein verteiltes System setzt voraus, dass ein Netz aus mehreren Rechnern bzw. Servern besteht.
