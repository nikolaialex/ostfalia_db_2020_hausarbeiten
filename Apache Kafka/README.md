# Apache-Kafka
### Ausarbeitung für das Modul Datenbanktechnologien
### Autor

| Name               | Matrikelnummer | Hochschule  |
| :----------------- | :------------- | :---------  |
| Tina Heilig        | 70268368       | FH Ostfalia |


 **Betreut durch:**

Prof. Dr.-Ing. Nils Jensen und Nicolai Alex

Email: n.jensen\@ostfalia.de

Tel.: +49 5331-939-31550

## Inhaltsverzeichnis

[1 Einleitung 1](#einleitung)

[2 Geschichtliche Aufbau von Apache Kafka
1](#geschichtlicher-abriss-von-apache-kafka)

[2.1 Arten 2](#_Toc54189309)

[2.2 Beeinflussung n 2](#_Toc54189310)

[3 Funktionsweise von Apache Kafka 2](#_Ref41931882)

[3.1 Grundlagen und Ziele 3](#grundlagen-und-kernkomponenten)

[3.2 Technische Gestaltungsmöglichkeiten
3](#technische-gestaltungsmöglichkeiten)

[4 Architektur von Apache Kafka 5](#architektur-von-apache-kafka)

[4.1 Anwendung in 5](#anwendung-in)

[4.2 Anwendung in 6](#_Toc54189316)

[4.3 Anwendung in der 10](#anwendung-in-der)

[4.4 Anwendung in 11](#_Toc54189318)

[5 Zusammenarbeit mit Apache Avro 13](#zusammenarbeit-mit-apache-avro)

[6 Implementierung mit JavaScript 13](#implementierung-mit-javascript)

[7 Anwendung von Apache Kafka anhand eines Unternehmens Beispiels
13](#anwendung-von-apache-kafka-anhand-eines-unternehmens-beispiels)

[8 Fazit 13](#fazit)

[Literaturverzeichnis 13](#literaturverzeichnis)

Abbildungsverzeichnis

[Abbildung 1: VR-Brille (Quelle: (Lautsprecher Teufel GmbH, 2017))
12](#_Toc42016156)

[Abbildung 2: Walt-Disney-Methode (Padberg, 2010) -- eigene Nachbildung
13](#_Toc42016157)

Tabellenverzeichnis

[Tabelle 1: Identifizierte Merkmale der Virtual Reality
5](#_Toc42016121)

[Tabelle 2: Einsatz von VR-Techniken 9](#_Toc42016122)

# Einleitung

Der \_\_\_\_\_\_kleine Einführung...einer Reihe einzigartiger Elemente,
die eher einem Datenbankprotokoll als einem herkömmlichen
Messagingsystem ähneln. In den folgenden Abschnitten werden einige
Elemente des Entwurfs beschrieben.

In Kapitel 2 soll zuerst der geschichtliche Abriss sowie der Begriff
Apache Kafka definiert werden, um aufzuzeigen, wo diese Open Source
Software ansetzt. Anschließend werden in Kapitel 3 die Funktionsweise
und verschiedene Anwendungsgebiete behandelt, um die vielfältigen
Einsatzmöglichkeiten aufzuzeigen. Kapitel 4 geht dann auf die technische
Umsetzungsmöglichkeiten sowie die Architektur von Apache Kafka ein. In
Kapitel 5 wird das Datenformat Apache Avro definiert und die
Zusammenarbeit der beiden Aspekte vorgestellt. Kapitel 6 beschreibt die
Implementierung von Apache Kafka mit der Skriptsprache JavaScript anhand
eines Unternehmensbeispiels.

# Geschichtlicher Abriss von Apache Kafka

Der amerikanische geschäfts- und beschäftigungsorientierte Onlinedienst
**LinkedIn** hat ursprünglich Apache Kafka entwickelt. **LinkedIn**
benötigte eine vollständige Neugestaltung der Infrastruktur, um das
exponentielle Wachstum der Mitglieder und Komplexität der Plattform
unterbringen zu können. Um dies anfänglich in Griff zu bekommen,
migrierten sie ihre Daten zuerst von einer monolithischen[^1] auf eine
auf Microservices basierenden Anwendungsinfrastruktur. Mit Hilfe dieser
Änderung war es **LinkedIn** möglich, die Such-, Profil-,
Kommunikations- und anderen Plattformen effizienter zu gestalten und sie
exponentiell zu vergrößern. Es führte auch zur Schaffung eines zweiten
Ansatzes von Middle-Tier-Diensten[^2], um API-Zugriffe[^3] auf
Datenmodelle und Back-End-Dienste zu ermöglichen und einen konsistenten
Zugriff auf die Datenbanken von **LinkedIn** zu ermöglichen. Zunächst
entwickelten sie verschiedene benutzerdefinierte Datenpipelines für ihre
unterschiedlichen Streaming- und Warteschlangendaten. Die vielseitige
Anwendungsfälle von LinkedIn's Plattformen erstreckten sich von der
Verfolgung von Site-Ereignissen, wie beispielsweise Seitenaufrufen, bis
zum Sammeln aggregierter Protokolle von anderen Diensten. Weiterhin
stellen Datapipelines[^4] Warteschlangenfunktionen für die LinkedIn's
InMail[^5] bereit. Um die Wartung einzelner Datapipelines zu vermeiden,
wurde in die Entwicklung einer einzigen Pub-Sub-Plattform[^6]
investiert. Dies war der Anfang von Apache Kafka. Apache Kafka wurde mit
einer einfachen, aber für einen hohen Durchsatz ausgelegten API für
Hersteller und Verbraucher sowie für eine von Anfang an skalierten
Architektur von LinkedIn entwickelt. (Gutierrez, 2016)

Die Architektur Apache Kafka stellte LinkedIn seit Anfang der Jahr 2011
als Open Source zur Verfügung und in Jahr 2012 wurde sie zum Teil der
**Apache Software Foundation**[^7]. Zwei Jahre später wurde aus LinkedIn
heraus das Unternehmen Confluent gegründet. Dieses hatte als
Hauptaufgabe die Weiterentwicklung von Apache Kafka. (Wikimedia
Foundation Inc., 2020)

Im Allgemein ist Apache Kafka Plattformunabhängig und somit an kein
Betriebssystem gebunden. Laut der offiziellen Apache Kafka
Streaming-Plattform ist 2.6.0 die neueste Version. (Apache Software
Foundation , 2017)

[]{#_Ref41931882 .anchor}Die Apache Software Foundation stellte 2011
Kafka als Open-Source-Lösung für die Verwaltung von Informationsströmen
bereit. Diese konnte sowohl Online als auch Offline angewendet werden.

# Vorstellung und Architekturübersicht von Apache Kafka

Bei einer Direktverbindung zwischen Datenquellen und Datenempfänger
entsteht das Problem, dass Daten ganz oder teilweise verloren gehen
könnten oder zu lange brauchen, um zugestellt zu werden. Zusätzlich
bereiten solche Datenverbindungen Schwierigkeiten bei den erwarteten
Datenformaten der Empfänger-Systeme. Dies bedeutet, dass der Empfänger
das gesendete Datenformate nicht erkennen und somit eine
Fehlerzustellung entstehen kann. Es ist eine Zwischenspeicherung der
Daten und entsprechende Übersetzungsvorbereitung für den Empfänger
nötig, um solche Probleme umgehen zu können.

## Grundlagen und Kernkomponenten

Bevor in die Apache Kafka Welt eingetaucht wird, ist es wichtig den
Aspekt von „Publish/Subscribe" (Pub/Sub) Messaging zu betrachten. Dies
ist eine Messaging-Anwendung, wo der Absender (Herausgeber) eines
Datenelements (Nachricht) es nicht speziell an einen Empfänger
weiterleitet. Anstelle dessen klassifiziert der Herausgeber (Producer)
der Nachricht und der Empfänger (Consumer) zeichnet diese und ordnet sie
bestimmten Nachrichtenklassen zu. Dieses Pub/Sub Messaging wird oft an
einen zentralen Punkt, auch Broker genannt, geliefert und verwaltet.
Dort werden diese Nachrichten an einen Austausch (Exchange) als Postfach
veröffentlicht. Dieser Austausch Punkt sendet mithilfe verschiedener
Regeln die Nachricht dann an eine Warteschlange (Message Queue) und von
da wird diese an dem Empfänger (Consumer) weitergereicht. Der Broker
stellt sicher, dass Nachrichten (verschiedene Daten) an die richtigen
verschiedenen Datenempfänger korrekt und sicher übermittelt werden.

![](media/image1.png){width="5.905555555555556in"
height="1.6152777777777778in"}

Abbildung 1: Message Broker (Haunts, 2020)

Apache Kafka ist so ein Pub/Sub Nachrichten System, das entwickelt
wurden ist, um Daten von einem/einer System/Application zu einem/einer
anderen sicher und schnell zu zustellen. Sie ist skalierbar,
fehlertolerant und ermöglicht Datenspeicherung. Zusätzlich ermöglicht
sie eine hohe Verfügbarkeit und Geschwindigkeit der Verarbeitung der
gespeicherten Daten. Apache Kafka realisiert zusätzlich auch eine
Echtzeit-Aggregierung[^8] der Daten. (Luber, 2018)

Die einzelnen Daten in Apache Kafka werden als Nachrichten bezeichnet.
Dies wird in der Databasis Welt als Zeile oder Datensatz verstanden. Aus
Sicht von Kafka, werden diese Nachrichten als eine Reihe von Bytes
gesehen. Somit haben die erhaltenen Daten aus Sicht von Kafka kein
eingegrenztes Format. Die Nachrichten selbst können ein Byte mit
Metadaten[^9] umfassen, was sich auf einen Schlüssel (Key) bezieht
welcher für Kafka das Protokoll bedeutet. Aus Entwicklersicht wird das
Protokoll als Anwendungsprotokoll verstanden, doch im Bezug auf Kafka
geht es um Protokolldatenstruktur (log data structure). Dieses Protokoll
oder Log ist lediglich eine zeitlich geordnete Folge von
Dateneinfügungen, bei denen die Daten, wie bereits erwähnt, beliebig
sein können. Dies ist grundlegend die Datenstruktur, auf die eine
Datenbank aufgebaut ist.

Für eine höhere Leistungsfähigkeit werden die Nachrichten zu Kafka in
Batches bzw. Stapeln geschrieben. Diese Verfahren ermöglicht eine
sequenzielle automatische Datenverarbeitung einer Sammlung
klassifizierter Daten bzw. Daten gleichen Themas und Partition. Eine
Sammlung von Daten in Batches stellt sicher, dass nicht jede Nachricht
eine Rundreise über das gesamte Netzwerk durchführen muss und dadurch
einen übermäßigen Datenüberhang verursacht. Nichtdestotrotz muss die
Größe der Batches komprimiert werden, denn große Batches können viele
Nachrichten übermitteln, aber dies nimmt viel Zeit in Anspruch. Die
Komprimierung von Batches stellt eine effizientere Datenübermittlung und
-speicherung. Im Folgenden sind einige Vorteile von Kafka aufgeführt
(Tutorials Point (I) Pvt. Ltd., 2020):

-   Zuverlässigkeit

-   Skalierbarkeit - Das Kafka-Messaging-System lässt sich ohne
    Ausfallzeiten problemlos skalieren.

-   Haltbarkeit - Kafka verwendet das verteilte Festschreibungsprotokoll
    (distributed commit log). Dies bedeutet, dass Nachrichten so schnell
    wie möglich und dauerhaft auf der Festplatte gespeichert werden.

-   Leistung - Kafka bietet einen hohen Durchsatz beim Pub/Sub
    Messaging. Es behält eine stabile Leistung bei, selbst wenn viele
    Terabyte große Nachrichten gespeichert sind

Apache Kafka kann in viele verschiedene Anwendungsfälle benutzt werden.
Bekannte Anwendungsfälle sind beispielsweise (Apache Software Foundation
, 2017):

-   Messaging

-   Website-Aktivitäts-Tracking -- Dient zur Verfolgung der
    Benutzeraktivität von Publish-Subscribe-Feeds (Seitenaufrufe,
    Suchvorgänge oder andere Aktionen, die Benutzer ausführen können) in
    Echtzeit. Die gesammelten Daten unterstützen Echtzeitverarbeitung,
    Echtzeitüberwachung und Laden in Apache Hadoop[^10] oder
    Offline-Data-Warehousing-Systeme zur Offline-Verarbeitung und
    Berichterstellung. Für jede Benutzerseitenansicht werden viele
    Aktivitätsnachrichten generiert und somit werden umfangreiche
    Aktivitätsverfolgungen benötigt.

-   Metriken -- Kafka dient auch oft zur Betriebsüberwachung, was das
    Aggregieren von Statistiken aus verteilten Anwendungen beinhält, um
    zentralisierte Feeds mit Betriebsdaten zu erstellen

-   Protokollaggregation -- Kafka sammelt physische Protokolldateien von
    Servern und legt sie an einem zentralen Ort (bspw. Dateiserver) zur
    Verarbeitung ab.

-   Stream-Verarbeitung

-   Event Sourcung

-   Commit Log

## Technische Gestaltungsmöglichkeiten

Kafka wurde so konzipiert, sodass es als einheitliche Plattform für die
Verarbeitung aller Echtzeit-Datenfeeds fungieren kann. Um dies zu
ermöglichen, wurden folgende Aspekte berücksichtigt (Apache Software
Foundation , 2017):

-   Hoher Durchsatz, um Ereignisströme mit hohem Volumen tragen zu
    können

-   Sicherer Umgang mit großen Datenrückständen, um alternierende
    Datenladevorgänge von Offline-Systemen tragen zu können

-   Verarbeitung der Zustellung mit geringer Latenz, um herkömmlichere
    Messaging-Anwendungsfälle zu behandeln

-   Partitionierte und verteilte Echtzeitverarbeitung, um aktuelle Daten
    erstellen zu können

-   Sicherstellung der Datenbereitstellung/-übertragung in andere
    Datensysteme mittels Fehlertoleranz bei Maschinenausfällen.

#  Architektur von Apache Kafka 

## Anwendung in 

## Anwendung in der 

Bildungsmaßnahmen

.

# Zusammenarbeit mit Apache Avro

Die

möglich ist.

# Implementierung mit JavaScript

sdassd

# Anwendung von Apache Kafka anhand eines Unternehmens Beispiels

sfdfsdf

# Fazit

sadadds

# Literaturverzeichnis  {#literaturverzeichnis .list-paragraph}

Aggteleky, B. (1987). Fabrikplanung. Werksentwicklung und
Betriebsrationalisierung. München Wien: Carl Hanser Verlag.Bavaria Film
Interactive GmbH. (13. Nov 2017).
*https://www.bavaria-film-interactive.de/.* Von
https://www.bavaria-film-interactive.de/ abgerufenHecht, E. (2005).
Optik. München: Oldenbourg Wissenschaftsverlag.Hickethier, K. (2012).
*Film und Fernsehanalyse, 5. Auf.* Stuttgart: J.B. Metzler
Verlag.Langer, E. (2020). *Medieninnovationen AR und VR: Erfolgsfaktoren
für die Entwicklung von Experiences.* Heidelberger Platz 3, 14197
Berlin, Germany: Springer-Verlag GmbH Deutschland.Lautsprecher Teufel
GmbH. (2017). *https://blog.teufel.de/*. Von
https://blog.teufel.de/die-vr-brille-ein-neuer-trend-oder-die-zukunft/
abgerufenLefrancois, G. (2003). *Psychologie des Lernens.* Berlin.Meyer,
A. (07. 09 2016). *https://www.deutschlandfunk.de/.* Von
https://www.deutschlandfunk.de/koerperwahrnehmung-wie-sinnestaeuschungen-unser-selbstbild.676.de.html?dram:article_id=365228
abgerufenMobfish. (5. Juli 2019). Von https://mobfish.net/:
https://mobfish.net/de/blog/360-grad-video-erstellen/\#wie-man-360-grad-videos-erstellt
abgerufenMüller, J. (12. Oktober 2018). *https://www.impulse.de/*. Von
https://www.impulse.de/management/selbstmanagement-erfolg/walt-disney-methode/3831387.html
abgerufenOrsolits, H., & Lackner, M. (. (2020). Virtual Reality und
Augmented Reality in der Digitalen Produktion. Wien, Österreich:
Springer Fachmedien Wiesbaden.Peukert, J. (16. 07 2019).
*https://www.playcentral.de/.* Von
https://www.playcentral.de/virtual-reality-studie-testet-vr-gestuetzte-psychotherapie/
abgerufenRalf Dörner, W. B. (2013). Virtual und Augmented Reality (VR /
AR): Grundlagen und Methoden der Virtuellen und Augmentierten Realität.
Heidelberg: Springer Verlag.Volkswagen AG. (2017-2018).
*https://www.volkswagen-newsroom.com/*. Von
https://www.volkswagen-newsroom.com/de/virtuelle-realitaet-3643
abgerufen

[^1]: „Eine **monolithische Anwendung** hat ihre Funktionalität ganz
    oder zum größten Teil innerhalb eines einzelnen Prozesses oder
    Containers und weist interne Schichten oder Bibliotheken als
    Komponenten auf." (Microsoft Corporation, 2020)

[^2]: Middle-Tier-Diensten der SAS Intelligence-Plattform bietet eine
    Umgebung, in der Business Intelligence-Webanwendungen wie SAS Web
    Report Studio und das SAS Information Delivery Portal ausgeführt
    werden können. Diese Produkte werden auf einem Webanwendungsserver
    ausgeführt und kommunizieren mit dem Benutzer, indem Daten an den
    Webbrowser des Benutzers gesendet und von diesem empfangen werden.
    (SAS Institute Inc., 2020)

[^3]: API-Zugriff -- Zugriff einer Programmierschnittstelle; API = von
    Englisch **A**pplication **P**rogramming **I**nterface, übersetzt
    wörtlich ‚Anwendungsprogrammierschnittstelle\' (Wikimedia Foundation
    Inc., 2020)

[^4]: Mit einer **Datenpipeline** können Daten aus mehreren Quellen
    konsolidiert werden und für die Analyse und Visualisierung zur
    Verfügung gestellt werden. (Alley, 2018)

[^5]: **InMail** ist die LinkedInd Nachrichtensystem. **InMail** ist
    eine LinkedIn Funktion, die ermöglicht die Mitglieder die Sendung
    von Nachrichten an anderen LinkedIn Mitglieder, mit den sie vernetzt
    sind. (LinkedIn Corporation, 2020)

[^6]: Publish/Subscribe messaging ist ein Muster, die durch
    gekennzeichnet ist, dass den Absender eines Datenelements (einer
    Nachricht) es nicht speziell an einen Empfänger weiterleitet. (Neha
    Narkhede, 2017, S. 1)

[^7]: „Die Apache Software Foundation ist eine ehrenamtlich arbeitende
    Organisation zur Förderung der Apache-Softwareprojekte, zu denen
    unter anderem auch der Apache-Webserver gehört." (Wikimedia
    Foundation Inc., 2020)

[^8]: Echtzeit-Aggregationsdaten -- die Zusammenfassung von ähnliche
    Daten in eine einzelne Klasse innerhalb einer vorbestimmten
    Zeitspanne

[^9]: Metadaten -- „sind strukturierte Daten, die Informationen über
    Merkmale anderer Daten enthalten" (Wikimedia Foundation Inc., 2020)

[^10]: Die Apache Hadoop-Softwarebibliothek ist ein Framework, das die
    verteilte Verarbeitung großer Datenmengen über Computercluster
    mithilfe einfacher Programmiermodelle ermöglicht. Es wurde
    entwickelt, um von einzelnen Servern auf Tausende von Computern zu
    skalieren, von denen jeder lokale Berechnungen und Speicher bietet.
    (Apache Software Foundation, 2020)
