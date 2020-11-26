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

[2.2 Beeinflussung n 2](#beeinflussung-n)

[3 Funktionsweise von Apache Kafka
2](#vorstellung-und-architekturübersicht-von-apache-kafka)

[3.1 Grundlagen und Ziele 3](#grundlagen-und-kernkomponenten)

[3.2 Technische Gestaltungsmöglichkeiten 3](#_Toc54189313)

[4 Architektur von Apache Kafka 5](#architektur-von-apache-kafka)

[4.1 Anwendung in 5](#anwendung-in)

[4.2 Anwendung in 6](#anwendung-in-1)

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
5](#_Ref42096638)

[Tabelle 2: Einsatz von VR-Techniken 9](#_Ref41814816)

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
migrierten sie ihre Daten zuerst von einer monolithischen<sup>1</sup> auf eine
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

##  Versionen 

Im Allgemein ist Apache Kafka Plattformunabhängig und somit an kein
Betriebssystem gebunden. Laut der offiziellen Apache Kafka
Streaming-Plattform ist 2.6.0 die neueste Version. (Apache Software
Foundation , 2017)

Die.

## Beeinflussung n

Das

unberührt.

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

Abbildung : Message Broker (Haunts, 2020)

Apache Kafka ist so ein Pub/Sub Nachrichten System, das entwickelt
wurden ist, um Daten von einem/einer System/Application zu einem/einer
anderen sicher und schnell zu zustellen. Sie ist skalierbar,
fehlertolerant und ermöglicht Datenspeicherung. Zusätzlich ermöglicht
sie eine hohe Verfügbarkeit und Geschwindigkeit der Verarbeitung der
gespeicherten Daten. Apache Kafka realisiert zusätzlich auch eine
Echtzeit-Aggregierung[^8] der Daten. (Luber, 2018)