# Blockchain

#### Autoren

<table>
  <tr>
   <td>Name
   </td>
   <td>Matrikelnummer
   </td>
  </tr>
  <tr>
   <td>Jan Kalthöfer
   </td>
   <td>317191
   </td>
  </tr>
  <tr>
   <td>Kadir Thal
   </td>
   <td>320955
   </td>
  </tr>
  <tr>
   <td>Fabio Rasp
   </td>
   <td>889362
   </td>
  </tr>
  <tr>
   <td>Sebastian Magolz
   </td>
   <td>301521
   </td>
  </tr>
</table>

## Inhaltsverzeichnis

1. [Einführung](#1-einführung)

2. [Grundlagen](#2-grundlagen)
   <br> 2.1 [Herkunft der Blockchain](#21-herkunft-der-blockchain)
   <br> 2.2 [Aufbau einer Blockchain](#22-aufbau-einer-blockchain)
   <br> 2.3 [Distributed Ledger Technologie](#23-distributed-ledger-technologie)
   <br> 2.4 [Double Spending Problem](#24-double-spending-problem)
   <br> 2.5 [Vorteile einer Blockchain](#25-vorteile-einer-blockchain)
   <br> 2.6 [Nachteile einer Blockchain](#26-nachteile-einer-blockchain)
   <br> 2.7 [Vergleich Relationalen und Blockchain-Datenbanken](#27-vergleich-relationalen-und-blockchain-datenbanken)

3. [Funktionsweise](#3-funktionsweise)
   <br> 3.1 [Aufbau eines Blocks](#31-aufbau-eines-blocks)
   <br> &nbsp;&nbsp;&nbsp;&nbsp; 3.1.1 [Transaktionen](#311-transaktionen)
   <br> &nbsp;&nbsp;&nbsp;&nbsp; 3.1.2 [Hash Referenzen](#312-hash-referenzen)
   <br> &nbsp;&nbsp;&nbsp;&nbsp; 3.1.3 [Block Header](#313-block-header)
   <br> &nbsp;&nbsp;&nbsp;&nbsp; 3.1.4 [Block Head](#314-block-head)
   <br> 3.2.[Fork](#32-fork)
   <br> 3.3.[Netzwerkteilnehmer und Speicherung](#33-netzwerkteilnehmer-und-speicherung)
   <br> 3.4.[Digitale Signatur](#34-digitale-signatur)
   <br> 3.5.[Hash-Funktionen](#35-hash-funktionen)
   <br> 3.6.[Konsensmechanismus und Mining](#36-konsensmechanismus-und-mining)

4. [Sicherheit](#4-sicherheit)
   <br> 4.1 [Integrität](#41-integrität)
   <br> 4.2 [Authentizität](#42-authentizität)
   <br> 4.3 [Verfügbarkeit](#43-verfügbarkeit)
   <br> 4.4 [Vertraulichkeit](#44-vertraulichkeit)
   <br> 4.5 [Konsensmechanismus](#45-konsensmechanismus)
   <br> 4.6 [Smart Contract Programmierung](#46-smart-contract-programmierung)

5. [Anwendungsbeispiele](#5-anwendungsbeispiele)
   <br> 5.1 [Kryptowährung](#51-kryptowährung)
   <br> 5.2 [Kapitalmarkt](#52-kapitalmarkt)
   <br> 5.3 [Gesundheitswesen](#53-gesundheitswesen)
   <br> 5.4 [Vertragswesen](#54-vertragswesen)
   <br> 5.5 [Versicherungsbranche](#55-versicherungsbranche)
   <br> 5.6 [Logistikbranche](#56-logistikbranche)
   <br> 5.7 [Mobilitätssektor](#57-mobilitätssektor)
   <br> 5.8 [Potenzielle Märkte](#58-potenzielle-märkte)

6. [Probleme und Herausforderungen](#6-probleme-und-herausforderungen)
   <br> 6.1 [Standardisierung](#61-standardisierung)
   <br> 6.2 [Skalierbarkeit](#62-skalierbarkeit)

7. [Fazit und Ausblick](#7-fazit-und-ausblick)

[ Literaturverzeichnis](#literaturverzeichnis)
<br><br>

## 1. Einführung

In dieser Lektüre wird das Thema “Blockchain” ausführlich untersucht und veranschaulicht. Dabei werden nicht nur die Entstehung und die technischen Aspekte näher betrachtet, sondern auch die damit einhergehenden Probleme und Herausforderungen.

Zudem werden zukünftige Anwendungsgebiete und die Sicherheit der neuartigen Technologie unter die Lupe genommen und hier verwertbar dargestellt.

Die Idee hinter Blockchain lässt sich zurückführen auf die Person oder Gruppe namens “Satoshi Nakamoto”, dass als Pseudonym verwendet wird. Der Grundgedanke lässt sich relativ simpel zusammenfassen.

**_Wie stellen wir die Integrität und die Zuverlässigkeit der monetären Werte wieder her?_**

Um die Frage besser zu verstehen wird auf die Veröffentlichung des Bitcoin-White Paper ([https://bitcoin.org/bitcoin.pdf](https://bitcoin.org/bitcoin.pdf)) verwiesen. Die Idee soll den Vertrauensmissbrauch bestimmter Institutionen erschweren.

Als Beispiel wird Banken vorgeworfen, mit dem ihnen anvertrauten Geldern selbst risikoreiche Geschäfte getätigt zu haben. Dies könnte weltweite, negative Auswirkungen auf das globale Wirtschaftssystem haben.

Um den Datenmissbrauch auf systematischer Ebene vorzubeugen, wurde diese neue Technologie entwickelt. Eine Veruntreuung von Geldern, Vertrauensmissbrauch oder schlichtweg Betrug wird durch die Blockchain Technologie erschwert.

Die Blockchain ist eine dezentrale Datenbank für den Austausch von Werten, wie zum Beispiel Bitcoin oder Smart Contracts. Dabei sind keine Zwischenhändler wie Banken oder Notare nötig.

Die Experten sind der Meinung, dass die Blockchain-Technologie die faszinierendste und bedeutendste Erfindung seit dem Internet selbst sei. Der Schwerpunkt dieser Technologie liegt derzeit auf dem Finanzsektor, wird sich aber in der Zukunft ebenso in anderen Bereichen verbreiten. Blockchain gilt als eine Art Revolution, die die Welt in der Zukunft verändern soll.

Diese Technologie lässt sich jedoch nicht nur auf das Finanzwesen anwenden. Denkbar wären noch Anwendungsgebiete im medizinischen oder in logistischen Bereichen. Es werden täglich neue Szenarien erschlossen, um „veraltete” Technologien abzulösen. Selbst die Grundlage des World-Wide-Web (Client-Server) könnte durch die Blockchain ersetzt werden. Eine potentielle Technologie mit schier unbegrenzten Möglichkeiten.

Die technischen Einzelheiten und der Funktionsumfang werden in den folgenden Kapiteln näher betrachtet.

## 2. Grundlagen

### 2.1 Herkunft der Blockchain

Die Blockchain entstammt aus der kryptographischen Währung Bitcoin. Im November 2008 wurde ein Whitepaper mit dem Titel „Bitcoin: A Peer-to-Peer Electronic Cash System” ([https://bitcoin.org/bitcoin.pdf](https://bitcoin.org/bitcoin.pdf)) veröffentlicht. Dieser Artikel wurde von einer unbekannten Person unter dem Pseudonym Satoshi Nakamoto publiziert. In diesem Artikel wird ein technisches Konzept für digitales Geld beschrieben. Vor dieser Veröffentlichung haben sich ebenso andere Autoren mit der digitalen Währung beschäftigt. Der Unterschied zwischen Nakamoto und seinen Vorgängern ist, dass er nach einer Lösung für das sogenannte Double Spending Problem suchte. Die Lösung ist die Erfindung der Blockchain. Die Blockchain wurde in dem Whitepaper aufgeführt und ist als ein Werkzeug für dezentrale Transaktionen ohne die Mitwirkung von dritten Personen zu gebrauchen. Die Grundidee sei dabei, eine transparente dezentrale Datenbank herzustellen, die nicht gehackt oder manipuliert werden kann.

Die Blockchain basiert auf einer dezentral verteilten Netzwerkstruktur. Diese wird auf Tausenden von Computern verteilt und laufend synchronisiert. Das bedeutet nichts anderes, als dass jeder Computer eine Kopie des anderen Computers ist.

Werden neue Transaktionen oder Dateien in das Blockchain Netzwerk hinzugefügt, wird erst mit den anderen Computern im Netzwerk verglichen, ob diese Änderung gültig ist. Ist sie es, wird diese in einen neuen Block gepackt und an den letzten bestätigten Block angehängt. So entsteht eine **Verkettung von Blöcken** – sprich eine Blockchain.

Eine Blockchain ist eine Kette von Blöcken, die über eine kryptographische Hashfunktion miteinander verbunden sind. Der mittels einer Hashfunktion erzeugte Hashwert kann dabei als Zeiger auf den vorangehenden Block verstanden werden. Neu anzuhängende Blöcke müssen stets den Hashwert des Blockes enthalten, an den sie angehängt werden sollen. Das Grundprinzip einer Blockchain entspricht somit einer verketteten Liste, welche durch kryptographische Verfahren abgesichert werden [WI17].

### 2.2 Aufbau einer Blockchain

####

<br>

![alt_text](images/image1.png 'image_tooltip')

**Abbildung 1: Zusammenhänge der Blöcke in der Blockchain [NO17]**

Die vorstehende Grafik zeigt den typischen Aufbau einer Blockchain. Das Hauptelement, über das die namensgebende Kette ("chain") hergestellt wird, ist der Hashwert des vorhergehenden Blockes. Darüber hinaus enthält ein Block typischerweise einen Zeitstempel und eine sogenannte Nonce ("number used once"). Die Nonce ist ein Zahlenwert, der in die Berechnung des Hashwertes einfließt. Schließlich enthält der Block noch die eigentliche Transaktion (oder ggf. eine Gruppe von Transaktionen), welche überhaupt erst zur Erzeugung eines neuen Blocks geführt haben [NO17].

Eine einmal erzeugte Kette von Blöcken kann nur durch neue Blöcke erweitert werden. Das Ändern oder Löschen bestehender Blöcke ist nicht vorgesehen. Eine Blockchain wird im Laufe ihres Lebens also immer größer.

### 2.3 Distributed Ledger Technologie

Blockchain basiert auf der Distributed Ledger Technologie (DLT), die als ein “Verteiltes Knotenbuch” übersetzt wird. Dabei handelt es sich um eine Datenbank, in welcher die Daten verteilt gespeichert werden. Bei der DLT werden die Daten auf eine andere Weise wie die üblichen Datenbanken gespeichert. Bei den gewöhnlichen Datenbanken verläuft die Speicherung der Daten auf zentralen Servern und die Verwaltung dieser Daten obliegt einem Bevollmächtigten. Im Gegensatz dazu werden die Daten in der DLT in einer dezentralen Datenbank in einem spezifischen Format in einem Peer-to-Peer Netzwerk gespeichert. Jeder Nutzer hat Zugriff auf die Daten der Teilnehmer im Netzwerk. Hier ist zu beachten, dass es keine zentrale Instanz gibt, die zuständig für die Verwaltung der Daten ist. Im Gegensatz dazu wird die Datenverwaltung von den Distributed Ledger selbst organisiert. In der Blockchain haben alle Teilnehmer die gleichen Rechte. Man könnte sagen, dass die Distributed Ledger Technologie ein Oberbegriff ist, der für Datenbanken mit verteilter Struktur steht. Die Blockchain ist eine Form der Anwendung der verschiedenen Formen des Distributed Ledgers [BE18].

### 2.4 Double Spending Problem

Das Double Spending Problem lässt sich mit Hilfe eines Beispiels leichter veranschaulichen:

Angenommen Alice hat ein Bild auf ihrem Smartphone. Dieses Bild kann Alice auf einer Website A hochladen. In diesem Fall hat Alice eine Kopie des Bildes erstellt und zwar ohne Kosten. Dasselbe Bild kann Alice auf der Website B hochladen, ebenso ohne Kosten. Das heißt, dass das spezifische Bild auf dem Smartphone **doppelt verwendet** wurde. Da die Tat des Hochladens des Bildes keinen Einfluss auf andere Personen hat, gibt es folglich kein Interesse von irgendjemandem daran. Aus diesem Grund gibt es auch keine Überwachung der Tat, ob dieses Bild zweimal oder mehrere Male hochgeladen wird. Des Weiteren nehmen wir an, es gäbe eine digitale Währung mit dem Namen Credits. Bob, eine zufällige Person, hätte 100 Credits zur Verfügung, die er zu einer Freundin Claudia senden möchte. Das könnte er machen wie im Beispiel mit dem Bild, indem er 100 Credits kopiert und Claudia ohne Kosten sendet. Doch in diesem Fall interessiert diese Tat von Bob andere, denn Geld weist eine Form von Wert und Vertrauen auf. Beispielsweise würde eine Bank darauf achten, dass für Bob nicht die Möglichkeit entsteht das Geld zu verdoppeln. Hier kommt es zum Einsatz einer zentralen Kontrollinstitution. Um das im Beispiel beschriebene Problem jedoch dezentral lösen zu können (also ohne zentrale Institution), muss eine Lösung zur Vermeidung der Doppelausgaben gefunden werden. Die Lösung dazu gab, wie bereits erwähnt, Satoshi Nakamoto mit der Blockchain [SP18].

### 2.5 Vorteile einer Blockchain

Die Blockchain-Technologie bringt einige Vorteile mit sich:

-   Dezentralisierung - Durch die Dezentralisierung gibt es keinen zentralen Verantwortlichen über das gesamte Netzwerk. Dadurch bekommen alle Teilnehmer des Netzwerkes eine Gleichberechtigung bezüglich der Daten. Da es sich um eine verteilte Datenbank handelt, ist für jedem Teilnehmer immer eine aktuelle Version der Daten vorhanden.
-   Transparenz - Da die Daten verteilt im Netz gespeichert werden, sind diese von allen Beteiligten zugänglich. Hier ist zu bemerken, dass es Unterschiede zwischen öffentlichen und privaten Blockchains gibt. Bei den öffentlichen Blockchains ist keine Zugangsbeschränkung vorgesehen. Das hat als Folge, dass die Daten von jedem Teilnehmer eingelesen werden können und dadurch auch anonym sind. Bei den privaten Blockchains ist es anders, da für jeden Teilnehmer der Zugangsdaten eine Beschränkung vorliegt. Dafür sind die Teilnehmer dieses Netzes bekannt und identifizierbar.
-   Ausfallsicherheit - Aufgrund der verteilten Datenspeicherung ist bei einem möglichen Verlust von Daten bei einem Knoten wiederherstellbar. Das geschieht durch das Auffangen der Daten von einem anderen Rechner, so dass die Daten bei dem jeweiligen Knoten wiederhergestellt werden. In diesem Punkt kommt es zum Einsatz der “single Point of Failure”. Das ist eine Datenquelle, die zur Sperrung der Datenabfragen führt, solange der Fehler nicht behoben wurde.
-   Manipulationsresistenz - Eine Manipulation kann von den anderen Teilnehmern eingesehen werden, denn auf allen Knoten liegt eine identische Datenspeicherung vor und durch die Blockchain ist es möglich, den Teilnehmern Auskunft darüber zu geben.
-   Integrität - Im gesamten Netzwerk werden Validierungs- und Autorisierungsmechanismen zum Einsatz gebracht. Durch sichere mathematische Verschlüsselungsverfahren sind die Daten in einer Blockchain zuverlässig und vertrauenswürdig. Die Knoten validieren jede Blockchain-Transaktion, was zur Sicherstellung der Integrität beihilft.
-   Authentizität - In einer Blockchain können keine Änderungen bei den geschriebenen Daten stattfinden. Bei einem Änderungsversuch wird dies bemerkbar und die Teilnehmer werden informiert.

Schließlich sollen die direkten Transaktionen nicht außer Acht gelassen werden. Durch die nicht vorhandene Kontrollinstanz entsteht weniger Aufwand und geringere Kosten. Beispielsweise braucht eine Blockchain für eine Transaktion zehn Minuten, wobei unter Miteinbeziehung von Drittanbietern diese mehrere Tage dauern kann.

### 2.6 Nachteile einer Blockchain

Es ergeben sich zur Zeit folgende Nachteile:

-   Benutzbarkeit - Die Transaktionen beanspruchen große Mengen an Speicherkapazitäten. Die große Menge der Datenkapazität ist heutzutage nicht für einen Normalnutzer erträglich. Mit jedem Block vergrößert sich die Blockchain und demnach wird auch der Speicher belastet. Dadurch wird auch die Internetverbindung überfordert. Damit die Verteilung dieser großen Blockchain-Daten im Netzwerk möglich wird, wird eine haltbare Internetverbindung vorausgesetzt. Aufgrund der fehlenden zentralen Instanz kann es zu Trennungen im Netzwerk vorkommen. Im Fall durch den Teilnehmer nicht durchgeführtem Software-Updates, spaltet sich die Blockchain in zwei nicht miteinander verbundene Netzwerke, die dieselbe Historie haben.
-   Leistungsfähigkeit - Die Blockchain ist nicht leistungsfähiger als eine zentrale Datenbank, denn sie hat bei einer Transaktion neben den gewöhnlichen Aufgaben (wie bei den zentralen), zusätzlich noch drei: Jede Transaktion braucht die Verifikation über eine Signatur. Dieses mathematisches Krypto Verfahren benötigt zusätzliche Leistung. Alle Knoten müssen den aktuellsten Stand der Daten enthalten. Die Synchronisation eines solchen Prozesses bereitet großen Aufwand. Jeder Knoten im Netzwerk prozessiert eine und dieselbe Transaktion. Das impliziert viel Aufwand für dasselbe Ergebnis.
-   Transparenz - Da jeder Teilnehmer Auskunft über die Transaktionshistorie (vergangene, zukünftige) in jedem Knoten hat, könnte z.B. ein Wettbewerber die Preise einsehen. Damit würde die Privatsphäre betroffen sein, denn ein Teilnehmer könnte Ein- und Ausgaben eines anderen auslesen. Schließlich darf nicht außer gelassen werden, dass die Miners viel Rechenleistung in Anspruch nehmen, um eine Transaktionsvalidierung zu ermöglichen. Das heißt, dass viel Strom dafür benötigt wird.

### 2.7 Vergleich Relationalen und Blockchain-Datenbanken

Eine relationale Datenbank im World Wide Web nutzt meistens eine Client-Server Architektur. Die Clients haben bestimmte Rechte auf die Datenverarbeitung der Datenbank. Jedoch können alle Aktionen eines Benutzers von dem Administrator kontrolliert werden. Anders ist es bei einer Blockchain, die in einem verteilten Netzwerk funktioniert und alle Nutzer bezüglich der Datenverarbeitung gleichberechtigt sind, ohne, dass eine zentrale Instanz vorliegt. Aufbauend dazu, folgen zwei grundlegende Begriffe: das anonyme Vertrauen und die Integrität, die Unterschiede zwischen den beiden Datenbanktypen aufweisen. Als anonymes Vertrauen wird bezüglich der Blockchain gemeint, dass man einer unbekannten Person vertrauen kann. Hier besteht ein Widerspruch an sich, denn Vertrauen ist mit bekannten Personen oder Institutionen verbunden. Doch die Blockchain-Technologie ermöglicht, Vertrauen an unbekannte Teilnehmer zu geben. Das wird als anonymes Vertrauen bezeichnet. Ein Beispiel dafür ist, dass man im realen Leben die Identität des Geschäftspartners und die Glaubwürdigkeit identifizieren muss. Bei den Blockchains ist die Bestimmung der Glaubwürdigkeit in einigen Fällen wegzulassen. Das wird durch Konsensus Algorithmen der verteilten Blockchain ermöglicht, die das Vertrauen anbieten, was bei den relationalen Datenbanken nicht der Fall ist. Bei den relationalen Datenbanken ist der Administrator die zentrale Instanz, der jederzeit Änderungen an den Daten vornehmen kann. Das Vertrauen wird in diesem Fall gewonnen, da man davon ausgeht, dass die Organisation, wo die Daten sich befinden, keine unerlaubte Datenänderung erlaubt. Ein anderer Punkt ist, dass Blockchain derzeit einen Beweis für die Datenintegrität anbietet und versucht, den Datenmissbrauch gering zu halten. Die Speicherung der Daten und Transaktionen in einer Blockchain, ergibt eine Verkettung dieser Daten miteinander über kryptografische Hashfunktionen. Wenn eine Datenveränderung innerhalb einer Blockchain stattfindet, dann sind die kryptografischen Hashwerte nicht mehr übereinstimmend und somit weist die Blockchain keine Konsistenz mehr auf. Dieser Vorgang gilt als ein Beweis für die Garantie einer Blockchain, dass die Integrität der Daten bewiesen wird und dass keine Datenveränderung vorhanden ist. Eine Ausnahme ergibt sich „beim “Hacken” des SHA-256 kryptographischen Hash Algorithmus“. Hier wäre die Garantie nicht mehr gegeben. Dieser Fall ist jedoch sehr unwahrscheinlich [PL16]. Ein anderer Unterschied ist die Geschwindigkeit. Bei den traditionellen Datenbanken ist die Schreibgeschwindigkeit der Daten schneller, als bei den Blockchain-Datenbanken. Dafür ist aber die Lesegeschwindigkeit bei den Blockchain-Datenbanken schneller. Das spielt eine besondere Rolle bei großen Daten [DI17].

## 3. Funktionsweise

### 3.1 Aufbau eines Blocks

Jeder Block in einer Blockchain besteht aus Transaktionen, Hash Referenzen, Blockheader und Block Head [LL18].

#### 3.1.1 Transaktionen

Transaktionen sind der Wunsch Eigentum auszutauschen. Jede Transaktion wird einzeln in einem Block abgelegt. Hierbei wird zwischen drei Arten von Transaktionen unterschieden. Die Standard-Transaktion, die aggregierte Transaktion und die Verteilung Transaktion. Die Standard-Transaktion weist eine 1:1 Relation zwischen Sender und Empfänger auf. Eine n:1 Relation beschreibt die aggregierte Transaktion. Hierbei wird dem Empfänger aus unterschiedlichen Quellen Daten gesendet. Die umgekehrte Variante bildet die Verteilung Transaktion wieder. Diese weist eine 1:n Relation auf [AA14].

<table>
  <tr>
   <td><strong>Transaktions Art</strong>
   </td>
   <td><strong>Relation</strong>
   </td>
  </tr>
  <tr>
   <td>Standard-Transaktion
   </td>
   <td>1:1
   </td>
  </tr>
  <tr>
   <td>Aggregierte Transaktion
   </td>
   <td>n:1
   </td>
  </tr>
  <tr>
   <td>Verteilung Transaktion
   </td>
   <td>1:n
   </td>
  </tr>
</table>

**Abbildung 2: Mögliche Transaktionsarten innerhalb einer Blockchain [AA14]**

Neben den verschiedenen Transaktionsverfahren kommen eine oder mehrere Hash-Pointer zum Einsatz. Diese zeigen auf vergangene Transaktionen und können dem Problem des Double-Spendings entgegen steuern [BJ16].

#### 3.1.2 Hash Referenzen

Hash Referenzen verweisen mit Hilfe von Hashwerten eine Transaktion einer Person zu. Dabei werden die jeweiligen Daten in eine Nummern- und Buchstabenkette transformiert. Jegliche Änderung der Datei führt zu einem neuen Hashwert. Dieser ist einmalig und kann nicht wieder in die eigentliche Nachricht umgewandelt werden (siehe
[Hash-Funktionen](#35-hash-funktionen)) [LL18].

#### 3.1.3 Block Header

Der Block Header besteht aus dem Hashwert der Referenzen und den Referenzen zum vorherigen Block. Jede Transaktion benötigt hierbei ihre eigene Hash Referenz und wird im Block Header (Hashwert der Referenzen) zusammengefasst. Die Referenzen zum vorherigen Block verweisen auf den vorherigen Block und bestehen ebenfalls aus einem Hashwert [LL18].

#### 3.1.4 Block Head

Der Block Head befindet sich am Ende eines jeden Blocks und referenziert auf den vorherigen. Die daraus gebildete Referenz setzt sich aus dem Hashwert der Referenzen und dem Hashwert des Blocks zusammen [LL18].

<br>

![alt_text](images/image2.png 'image_tooltip')

**Abbildung 3: Aufbau eines Block-Heads [LL18]**

Beim errechnen von Blöcken für eine Blockchain können verschiedene Arten von Blöcken entstehen. Der erste Block einer Kette ist der Genesis Block (grün). Dieser ist fast immer fest in die Software der Anwendung eingebunden. Daraus entsteht die Hauptkette. Sie bildet den längsten Teil an Blöcken innerhalb einer Blockchain ab (schwarz). Der Stale Block ist ein Block der erfolgreich berechnet wurde jedoch durch einen gleichzeitig errechneten Block nicht teil der Blockchain ist. Wenn ein Block auf einen vorhergehenden Block beruht der noch nicht abgelegt bzw. verarbeitet wurde kann dieser noch nicht fertiggestellt werden. Dieser ist zwar Teil der Blockchain wird jedoch nicht genutzt (lila) [TH15].

<br>

![alt_text](images/image3.png 'image_tooltip')

**Abbildung 4: Aufbau verschiedener Blockketten [TH15]**

##

### 3.2. Fork

Der Konsens-Algorithmus sorgt für die Erstellung und Speicherung einer Blockchain. Wenn dieser Algorithmus geändert wird kommt es zu einer Fork. Eine Fork kann entweder die Aufteilung des Konsens oder die Änderung der Protokollregeln zur Folge haben. Die Änderung des Konsens-Algorithmus zieht einen Soft- oder Hard-Fork mit sich. Soft-Forks neuerungen innerhalb einer Blockchain sind kosmetischer Natur und vergleichbar mit einem Software Upgrade. Hierbei werden die Protokollregeln leicht abgeändert. Dies geschah bei der Soft-Fork SegWit. Hier sollten die nicht zur Transaktion gehörenden Signaturdaten aus dem Block des Bitcoin-Blockchain entfernt bzw. ausgelagert werden. Dies hätte zur Folge gehabt, dass mehr Transaktionen pro Block möglich wären. Der Hard-Fork beschreibt die Abspaltung eines Blocks innerhalb einer Blockchain. Eine fundamentale Änderung innerhalb des Blocks verursacht solch einen Fork. Die Abspaltung von einer bestehenden Blockchain (Hard-Forck) und die daraus resultierende Koexistenz beider, bringt auch immer eine Abwertung der Blockchains mit sich. Nach der Abspaltung müssen sich die Teilnehmer nunmehr entscheiden welche Blockchain Sie ab sofort nutzen. Ein Hard-Fork kann geplant oder umstritten von statten gehen. Ein umstrittener Fork ist ein Fork der nicht von der Mehrheit der Teilnehmer einer Blockchain akzeptiert wird. Im August 2017 fand ein geplanter Fork statt. Hierbei spaltete sich der Bitcoin Cash von der etablierten Blockchain Bitcoin. Dies hatte zur Folge, dass sowohl der Bitcoin als auch der Bitcoin Cash an Wert verlierte [BA20].

<br>

![alt_text](images/image4.png 'image_tooltip')

**Abbildung 5: Forkarten [BA20]**

##

### 3.3. Netzwerkteilnehmer und Speicherung

Die Anzahl der Netzwerkteilnehmer und Art der Speicherung kann laut Walport je Blockchain unterschiedlich ausfallen. Diese können nach Grad der Zentralisation, Art der Genehmigung und deren Sichtbarkeit unterschieden werden. Je nach Zentralisationsgrad kann hierbei von einer Blockchain gesprochen werden. Ein 100 prozentiges zentrales Register ist Privat. Da diese nicht die Eigenschaften einer Blockchain widerspiegelt, sondern die einer herkömmlichen Datenbank (Herkömmliche Register). Die Sichtbarkeit definiert, ob eine Blockchain öffentlich oder privat einsehbar ist. Eine private Blockchain ist nur mit einer Genehmigung zugänglich (Konfiguration 3) [SSUF16]. Diese Art der Blockchain kommt in Firmen und Organisationen zur Anwendung, in denen die darin enthaltenen Daten und Prozesse nicht für die Öffentlichkeit bestimmt sind. Durch die zuvor festgelegte private Struktur ist eine höhere Geschwindigkeit der Prozessierung festzustellen [PP15]. Eine öffentliche Blockchain kann von jedem Nutzer eingesehen werden. Hierbei ist zwischen zwei Arten zu unterscheiden. Eine öffentlich zugängliche Blockchain mit und ohne Genehmigung. Bei einer öffentlich zugänglichen Blockchain mit Genehmigung, wird jedem Teilnehmer eine Rolle zugewiesen (Konfiguration 2) [SSUF16]. Dieses Vorgehen trägt dazu bei, dass die Vertrauenswürdigkeit der Teilnehmer bekannt ist. Blockchains wie Ripple oder Hyperledger nutzen diese Art der Blockchain [ST15]. Die einfachste Form der Blockchain ist eine öffentliche Blockchain, die ohne eine Genehmigung genutzt werden kann. Bei dieser Art der Blockchain hat jeder Nutzer zu jeder Zeit die Rechte eines Administrators inne (Konfiguration 1) [SSUF16].

<br>

![alt_text](images/image5.png 'image_tooltip')

**Abbildung 6: Grad der Zentralisierung verschiedener Blockchain-Systeme - in Anlehnung an Walport [SSUF16]**

##

### 3.4. Digitale Signatur

Die Digitale Signatur ist Teil einer jeden Blockchain. Die Technik ist seit dem Jahr 1994 standardisiert und sorgt für eine elektronische Unterzeichnung von Dokumenten und Daten [BD11]. Die erstellte digitale Signatur ist persönlich und kann nur vom jeweiligen Nutzer erstellt werden. Sie ist nur auf den Dokumenten und Datensätzen die willentlich unterzeichnet wurden ersichtlich und kann nicht vervielfältigt werden. Andere Nutzer eines Systems können die digitale Signatur eingesehen und verifizieren [BJ16]. So ist eine Fälschung einer solchen Signatur nicht zu erzwingen. Der Unterschied herkömmlicher Signaturen ist, dass innerhalb einer Blockchain der Hash-Pointer und nicht die klare Nachricht eines jeden Blocks signiert wird. Eine weitere Eigenschaft ist die digitale Identität. Diese erfolgt mit Hilfe des Private und Public Key. Das Konzept personalisiert und identifiziert Nachrichten und Daten gegenüber anderen. Die Blockchain folgt dem Prinzip der Dezentralisation durch Distribution. Die Erstellung einer digitalen Identität erfolgt mit Hilfe des Private und Public Key. Das dezentralisierte Identitätsmanagement ermöglicht der Blockchain Identitäte anzulegen und zu prüfen. Die digitale Signatur wird innerhalb der Wallet abgelegt. Die Wallet ist die Geldbörse einer jeden Blockchain. Das Programm speichert die digitalen Signaturen der Blockchain und legt diese als Public und Privat Key ab. Der Public Key deckt hierbei die Adresse des Wallets innerhalb der Blockchain ab. Der Privat Key findet bei Transaktionen Anwendung [AA14]. Je nach Blockchain gibt es eine Vielzahl an Anbietern die sowohl Hard- als auch Softwarelösungen der Wallet anbieten.

### 3.5. Hash-Funktionen

Zur Verschlüsselung von Daten benutzt die Blockchain Hash-Funktionen. Diese verstehen sich als digitaler Fingerabdruck. Jede Form von Daten kann einem Hash-Wert zugewiesen werden. Die Länge des Hash-Werts ist stetig. Dies hat zur Folge, dass die Länge bzw. der Inhalt der Daten unabhängig von der Ausgabe als Hash-Wert ist. Innerhalb einer Blockchain wird der Secure Hash Algorithm SHA-256 verwendet. Der durch diesen Algorithmus berechnete Wert ist 256 Bit groß. Es kann vorkommen, dass der eingegebene Wert größer als der ausgegebene Wert ist. Falls dies der Fall ist, kommt das Merkle-Damgård-Verfahren zur Anwendung. Es teilt mit Hilfe eines Initialisierungsvektors Null den eingegebenen Wert auf und sorgt so für einen Output der 256 Bit groß ist. Dies entspricht zum heutigen Zeitpunkt einer der sichersten Verschlüsselungsmethoden [PP09]. Innerhalb der Blockchain kommen die Hash-Funktionseigenschaften Collision Resistance, Hiding, Verifikation und Puzzle Friendliness zur Anwendung. Die Hash Collision Resistance wird Mathematisch wie folgt ausgedrückt:

𝑥1 ≠ 𝑥2; 𝐻(𝑥1) = 𝐻(𝑥2)

Die Variablen 𝑥1 und 𝑥2 sind als unabhängige Werte zu betrachten. Diese befinden sich innerhalb der Hash-Funktion 𝐻() und führen zu ein und dem gleichen Wert. Dieses Vorgehen wird als Kollision bezeichnet. Eine Kollisionsresistenz (engl. collision resistance) tritt auf, wenn es nicht möglich ist zwei unterschiedliche Werte für die Variablen 𝑥1 und 𝑥2 zu finden, die eine Hash Collision Resistance befolgen [BJ16]. Eine Hash Algorithmus Kollision ist möglich, jedoch durch die verwendete Verschlüsselung von 256 Bit sehr unwahrscheinlich. Ein Computer der 10.000 Werte pro Sekunde berechnet, bräuchte mehr als zehn hoch 27 Jahre, um die Hälfte aller Möglichkeiten auf eine Kollision zu prüfen [PP09]. Eine weitere Eigenschaft ist Hiding. Hierbei wird auf die Tatsache eingegangen, dass die Hash-Funktion 𝑦 = 𝐻(𝑥) aufgrund des nicht genau zu ermittelnden Wertes 𝑥 nicht gelöst werden kann. Diese Diskrepanz wird mit Hilfe des zufälligen Wertes 𝑟 konkateniert:

𝐻(𝑟‖𝑥)

Der Wert 𝑟 ist eine willkürlich gewählte Zahl,die nur einmalig vergeben werden darf. Sie wird in der Kryptographie als Nonce bezeichnet [NS78]. Da in der Blockchain neben dem Hiding auch das SHA-256 Verfahren Anwendung findet, ist eine Ermittlung des Wertes 𝑥 der über die Nonce konkateniert wird nicht mehr möglich. Hier ist zwischen dem Hiding und dem Biding zu unterscheiden. Binding ist die Undurchführbarkeit zweier Paare (𝑥, 𝑟) und (𝑥<sup>′</sup>, 𝑟<sup>′</sup>) zu finden, so dass 𝑥 ≠ 𝑥′ aber dennoch 𝐻(𝑟‖𝑥) == 𝐻(𝑟′‖𝑥′) gilt. Die Eigenschaften des eben erwähnten Hiding und Binding sorgen für eine Verifikation der Transaktion. Die Variable 𝑥 wird durch die Nonce 𝑟 mit einer anderen Partei verifiziert. Dies geschieht mit Hilfe des Wertes aus der Hash-Funktion 𝐻 und wird mit 𝑟‖𝑥 ausgeführt. Die Kollisionsresistenz sorgt hierbei für eine einmalige Wertevergabe der Variablen 𝑥 und 𝑟 ,die wieder zum identischen Hash-Wert führen. Eine weitere Eigenschaft der Hash-Funktion ist die Puzzle Friendliness. Hierfür gilt:

𝐻(𝑟‖𝑥) = 𝑦; t<2𝑛

Die Nonce 𝑟 kann hierbei nicht für jedes n-bit das kleiner 2𝑛 ist gefunden werden. In anderen Worten: Die Puzzle Friendliness ist dann gegeben, wenn der einzige anwendbare Lösungsweg der ist, dass alle erdenklichen Möglichkeiten für die Nonce 𝑟 berechnet werden <sup> </sup>[BJ16]. Neben den oben aufgeführten Eigenschaften gibt es noch Weitere, diese sind jedoch für das Verständnis der Hash-Funktion innerhalb der Blockchain nicht relevant [MK16].

##

### 3.6. Konsensmechanismus und Mining

Der Konsensmechanismus beschreibt das in der Blockchain implementierte Proof of Work. Dies besagt, dass die Wahrscheinlichkeit eines Identitätsdiebstahls durch die zufällige Auswahl eines Teilnehmers ausgeschlossen werden kann. Der Bitcoin Konsensmechanismus kann laut Bonneau et al vereinfacht zusammengefasst werden [BJ16]:

1. Neue Transaktionen werden allen Teilnehmern mitgeteilt.
2. Neue Transaktionen werden von jedem Teilnehmer gesammelt.
3. Jede Iteration hat die Möglichkeit einen zufällig erstellten Block mit allen Teilnehmern zu teilen.
4. Blöcke werden von den Teilnehmern nur dann akzeptiert, wenn diese nicht ausgeben wurden und gültig sind.
5. Blöcke werden durch die Inkludierung ihres Hash-Wertes in die Blöcke der Teilnehmer akzeptiert.

Der zuvor erwähnte Proof of Work findet zwischen Schritt drei und vier Anwendung. Er gibt die Zieladresse für den zu generierenden Hash-Wert bzw. die maximale Länge vor. Die zuvor definierte Länge des Wertes bildet den Grad der Schwierigkeit zur Berechnung des Target Values. Laut der Plattform bitcoinmining.com werden anhand gesammelter Transaktionen Blöcke vorgeschlagen. Mit Hilfe des vorangegangenen Block-Header und der Nonce wird ein Hash-Wert gebildet. Der zu berechnende Hash-Wert wird hierbei mit dem Target-Value verglichen. Falls der Hash-Wert größer oder gleich dem Target Value ist, muss die Nonce neu gefunden werden. Wenn nicht, ist das Proof of Work gelöst und das Mining abgeschlossen. Je nach Blockchain gibt es hierfür einen sogenannten Reward. Bei der Kryptowährung Bitcoin ist es für jedes abgeschlossene Mining ein Bitcoin [BM20].

## 4. Sicherheit

Grundsätzlich wird die Blockchain als Technologie angesehen, die durch die Verwendung von kryptografischen Verfahren wie Hash-Funktionen und digitalen Signaturen hohe Sicherheitseigenschaften hat. Die Blockchain-Technologie alleine löst jedoch keine IT-Sicherheitsprobleme [BSI18].

Aus diesem Grund werden in diesem Abschnitt die Schutzziele, welche aus dem Bereich der IT-Sicherheit stammen, genauer betrachtet. Bei den Schutzzielen handelt es sich um Integrität, Authentizität, Verfügbarkeit und Vertraulichkeit. Außerdem wird auch der Konsensmechanismus, welcher neben den kryptografischen Verfahren auch spieltheoretische Eigenschaften aufweist, auf den Aspekt der Sicherheit untersucht. In dem letzten Abschnitt wird speziell auf die Sicherheit von programmierten Smart Contracts eingegangen.

### 4.1. Integrität

Integritätsschutz beschreibt den Zustand der unzulässigen Veränderung von Daten und Informationen. Das bedeutet, dass die Vollständigkeit und Korrektheit sichergestellt werden kann. Im Blockchain Kontext wird der Integritätsschutz von Transaktionen mit kryptografisch “sicheren” Hash-Funktionen erreicht.

Bei dem Einsatz von Hash-Funktionen muss darauf geachtet werden, dass das eingesetzte Verfahren als sicher gilt. Bei sicheren Hash-Funktionen geht man davon aus, dass nur mit enormen Rechenaufwand eine Kollision erzeugt werden kann. Kollisionsresistenz bedeutet dabei, dass praktisch keine zwei unterschiedlichen Eingabewerte gefunden werden können, die den gleichen Hash-Wert ergeben.

Auf der Webseite des BSI ist eine umfangreiche Übersicht zu finden, die angibt, welche Hash-Funktionen nach heutigem Stand als sicher und ungebrochen eingestuft werden und welche bereits gebrochen wurden und somit als nicht mehr sicher gelten.

Nur wenn bei der jeweilige Blockchain eine sichere Hash-Funktion für das Erstellen der Prüfsummen verwendet wird, kann gewährleistet werden, dass die Blöcke sicher verkettet sind und die Transaktionen integritätsgeschützt sind.

Eine hundertprozentige Sicherheit kann jedoch keine Hash-Funktion liefern, denn konstruktionsbedingt sind Hash-Funktionen nicht injektiv [BSI19]. Das bedeutet, dass grundsätzlich verschiedene Eingabewerte gefunden werden könnten, die den gleichen Hash-Wert ergeben. Auch wenn nach heutigem Stand dieses Verursachen einer Kollision bei sicheren Hash-Funktionen praktisch unmöglich ist, sollte mit Blick auf die Langzeitsicherheit eine Blockchain so gestaltet sein, dass Anpassungen bezüglich der kryptografischen Mechanismen vorgenommen und Hash-Funktionen ausgetauscht werden können.

Anzumerken ist, dass bei einigen Blockchains aufgrund temporärer Forks kein sofortiger Integritätsschutz einer Transaktion gewährleistet ist.

### 4.2. Authentizität

Unter Authentizität versteht man das Sicherstellen des Ursprungs von Daten und Informationen. Im Blockchain-Kontext bedeutet das, dass mit Hilfe des asymmetrischen Kryptoverfahrens der digitalen Signaturen Transaktionen authentisch ausgeführt werden können.

Der Besitzer des privaten Schlüssels kann sich mit dem Signaturverfahren dem Netzwerk gegenüber authentisieren und nachweisen, dass die Urheberschaft der Transaktion von ihm veranlasst wurde. Allerdings kann die Blockchain-Technologie nur Autorisierung innerhalb des Netzwerkes sicherstellen. Öffentliche und genehmigungsfreie Systeme wie das Bitcoin-Netzwerk haben die Eigenschaft, dass die öffentliche Adresse, welche über den öffentlichen Schlüssel generiert wird, keinem konkreten Kommunikationspartner zugeordnet werden kann.

Bei der Benutzung dieses Blockchain-Systems spricht man von Pseudonymität, die ein Anwender hat. Ein Teilnehmer, der an dem Netzwerk teilnimmt, muss keine persönlichen Daten angeben. Allerdings agiert man nicht vollkommen anonym in dem Netzwerk, denn die öffentliche Adresse wird einem Netzwerkteilnehmer zugeordnet und ist von jedem ersichtlich [BSI19].

Der Schutz des privaten Schlüssels ist von zentraler Bedeutung, wenn man sicherstellen möchte, dass Transaktionen als authentisch betrachtet werden. Der private Schlüssel ist der einzige Nachweis über den Besitz von Eigentumswerten auf der Blockchain und sollte dementsprechend ausreichend gut geschützt werden.

Es gibt verschiedene Möglichkeiten diese Schlüssel in gesonderten Bereichen aufzubewahren. Offline-Speichermedien bieten dabei grundsätzlich deutlich weniger Angriffsmöglichkeiten für Hacker als die Speicherung der Schlüssel in einem Bereich mit Verbindung zum Internet. Als Beispiel können verschlüsselte Festplatten-Container oder Hardware-Token dienen. Außerdem sollten Backup-Kopien von dem Schlüssel erstellt und diese getrennt verwaltet werden [BSI19].

In Bezug auf die Langzeitsicherheit gilt, wie bereits für die Hash-Funktionen erwähnt, dass digitale Signaturverfahren im Rahmen der Kryptoagilität bei Blockchain-Systemen austauschbar sein sollten. Da es sich um ein asymmetrischen Kryptoverfahren handelt, stellen Quantencomputer, die in Zukunft leistungsstärker werden können, eine grundlegende Gefährdung dar. Bereits heute existieren in der Theorie Algorithmen für Quantencomputer, die asymmetrische Kryptoverfahren mit geringem Aufwand brechen könnten [BSI19].

Das Forschungsgebiet Post-Quantum-Kryptografie beschäftigt sich mit Verschlüsselungsverfahren, die gegenüber Quantencomputern sicher sind. Für die Langzeitsicherheit von Blockchain-Systemen sind solche Verfahren ebenso relevant, wie beispielsweise für die sichere E-Mail-Verschlüsselung oder die Absicherung von Internet-Zugängen.

### 4.3. Verfügbarkeit

Aufgrund der hochgradig redundanten Speicherung der Daten bei allen Netzwerkteilnehmern sorgt die Blockchain-Technologie für ein hohe Verfügbarkeit. Im Gegensatz zu zentralen Registern gibt es bei der dezentralen Technologie keinen Single Point of Failure [DB17].

Voraussetzung für die hohe Verfügbarkeit ist, das ausreichende Vorhandensein von Netzwerkknoten, die als Full Node agieren. Benutzer können auch als Light Node an dem Netzwerk teilnehmen und müssen somit nicht die gesamte Transaktionshistorie lokal abspeichern und würden somit für keine Erhöhung der Verfügbarkeit sorgen.

Wenn Daten aus Vertraulichkeit ausgelagert werden und stattdessen nur Referenzen der Daten in Form von Hash-Werten in der Blockchain gespeichert werden, dann kann die Blockchain-Technologie keine Verfügbarkeit der Daten garantieren.

Die ausgelagerten Daten werden dann in einer externen Struktur, wie zum Beispiel in einer Datenbank, gespeichert und dort vor unbefugtem Zugang und Datenverlust geschützt. Außerdem ist es wichtig, dass bei dieser Lösung sichere kryptografische Hash-Funktionen für die Referenzierung ausgewählt werden [BSI19].

Neben dem Einsatz von Hash-Funktionen für die Referenzierung von Daten bietet sich auch die Verwendung von einem Message Authentication Code (abgekürzt MAC) an. Mit dieser Variante können mehrere Netzwerkteilnehmer über einen gemeinsamen geheimen Schlüssel auf die Daten zugreifen.

Auch wenn die Verfügbarkeit von referenzierten Daten in der Blockchain eingeschränkt ist, bringt die Verwendung einen wesentlichen Vorteil mit sich. Die Größe der Blockchain wird reduziert. Besonders bei der Speicherung von großen Datenmengen bietet sich der Einsatz dieser Methode an.

### 4.4. Vertraulichkeit

Vertraulichkeit sollte in Bezug auf die Sicherheit kein Schutzziel bei dem Einsatz von Blockchain-Technologie sein. Die grundsätzliche Architektur sieht vor, dass allen Netzwerkteilnehmern die gesamten Transaktionsdaten zur Verfügung stehen und Transaktionen transparent einsehbar sind.

Damit stehen sich die beiden Eigenschaften Vertraulichkeit und Transparenz diametral gegenüber und eine gemeinsame Kombination ist schwer zu realisieren [BSI19]. Naheliegend wäre eine Verschlüsselung der Transaktionen, besonders dann, wenn es sich um sensible Daten handelt.

Diesem Ansatz stehen jedoch einige Herausforderungen gegenüber. Der Verifikationsprozess könnte nicht ohne weiteres durchgeführt werden, denn die Miner haben keinen Zugang zu den entschlüsselten Daten und könnten deshalb nicht entscheiden, ob es sich um eine valide Transaktion handelt.

Ein anderes Problem adressiert die Langzeitsicherheit. Wenn das eingesetzte Verschlüsselungsverfahren in der Zukunft gebrochen werden kann, dann können alle Daten, die mit dem Verfahren verschlüsselt wurden, rückwirkend entschlüsselt werden.

Auch der Bereich der Kryptoagilität, der eine Anpassung der Verfahren vorsieht, könnte hier mit einer Aktualisierung auf ein neues, als sicher geltendes Verfahren, nicht weiterhelfen. Die verschlüsselten Daten sind im gesamten Netzwerk verteilt und befinden sich nicht mehr unter der Kontrolle des Netzwerkteilnehmers, der die Verschlüsselung durchgeführt hat [BSI19].

Bei privaten und genehmigungsbasierten Blockchains ist die Anzahl der Netzwerkteilnehmer in der Regel geringer als bei öffentlich zugänglichen Blockchains. Zusätzlich sind die Teilnehmer in dem Netzwerk bekannt. Deshalb können die Daten grundsätzlich innerhalb dieser Gemeinschaft als vertraulich betrachtet werden. Wenn es innerhalb des Netzwerkes unterschiedliche Vertrauensebenen gibt, dann können separate Datenkanäle für vertrauliche Inhalte eingerichtet werden, auf die ausschließlich ausgewählte Netzwerkteilnehmer Zugriff haben. Die Hyperledger Ledger Fabric Blockchain setzt dieses Verfahren ein.

### 4.5. Konsensmechanismus

Neben den bereits aufgeführten Schutzzielen stellt auch der eingesetzte Konsensmechanismus eine essentielle Rolle bezüglich der Datensicherheit in der Blockchain dar. Gemeinsam mit den kryptografischen Verfahren schützt der Konsensmechanismus das System insbesondere vor Manipulationssicherheit.

Aufgrund der unterschiedlichen Funktionsprinzipien verschiedener Konsensmechanismen, gibt es auch verschiedene Anforderungen an die Sicherheit. Vielfach sind es ökonomische Anreize, die das Validieren des Netzwerkes attraktiv machen. Aus diesem Grund ist der Forschungsbereich der Kryptoökonomie entstanden.

Der spieltheoretische Ansatz soll die Netzwerkteilnehmer dazu veranlassen, sich rational zu verhalten und die Spielregeln zu befolgen.

Am Beispiel vom Bitcoins eingesetzten PoW Algorithmus besteht der Anreiz für die Miner darin, neue Bitcoins zu bekommen, indem mit aufgewendeter Rechenleistung das Netzwerk abgesichert und validiert wird.

Es ist schwierig, den genauen Sicherheitsbeitrag dieses ökonomischen Anreizes quantitativ zu bewerten und in Zahlen zu fassen. Ein direkter Vergleich mit dem kryptografischen Sicherheitsniveau ist ebenso schwer durchzuführen [BSI19].

Grundsätzlich lässt sich festhalten, dass ein Blockchain-System mit steigender Teilnehmerzahl dezentraler und sicherer wird. Je mehr Teilnehmer das Netzwerk mit Hilfe des Konsensmechanismus validieren, desto unwahrscheinlicher ist es, dass einzelne Teilnehmer, die nicht den Spielregeln folgen, das Netzwerk manipulieren können.

Ein gegenläufiger Trend ist jedoch bei Bitcoin zu beobachten. Die Miner schließen sich zu sogenannten Mining-Pools zusammen, um gemeinsam am Lösen des Rätsels zu arbeiten. Mit der gebündelten Rechenleistung wird die Wahrscheinlichkeit erhöht, das Rätsel als Rrster zu lösen und dementsprechend die Belohnung zu erhalten. Die Zusammenschlüsse einzelner Teilnehmer sorgen für eine Zentralisierung innerhalb des Netzwerks.

Abbildung 7 zeigt, dass bei der Bitcoin-Blockchain sieben Mining-Pools im Zeitraum von August 2018 bis Januar 2019 über die Hälfte der gesamten Rechenleistung im Netzwerk ausmachten.
<br>

![alt_text](images/image6.png 'image_tooltip')

**Abbildung 7: Aufteilung der Hashrate auf Mining Pools (Durchschnitt über den Zeitraum August 2018 bis Januar 2019) [BSI19]**

### 4.6. Smart Contract Programmierung

Die richtige Programmierung von Smart Contracts spielt eine wichtige Rolle bei der Betrachtung der Sicherheit von Blockchains. Auch hier muss nach der jeweiligen Blockchain und ihren Eigenschaften differenziert werden.

Der Einsatz verschiedener Programmiersprachen, in denen Smart Contracts programmiert werden, hat sowohl Einfluss auf die mögliche Komplexität als auch auf die Fehleranfälligkeit des Codes [BSI19].

Während einige Blockchains Turing-vollständige Programmiersprachen anbieten, kommen bei anderen Blockchains Skriptsprachen zum Einsatz, bei denen bewusst Einschränkungen der Funktionalität in Kauf genommen werden. Aus Sicherheitsgründen wird auf die Implementierung von missbrauchsanfälligen Sprachelementen wie beispielsweise Schleifen verzichtet [BSI19].

Eine weitere Einschränkung kann die Skriptgröße oder die Anzahl der Befehle sein, die ausgeführt werden können. Besonders bei mächtigen Programmiersprachen ohne Einschränkung ist die formale Verifikation der Sprache besonders schwierig und die Korrektheit kann nicht bewiesen werden [BSI19].

So kann beispielsweise die Hyperledger Blockchain mit den eingesetzten Programmiersprachen nicht garantieren, dass ein Smart Contract immer terminiert. Die Folge könnte ein unerwünschtes Laufzeitverhalten sein, welches durch das Programmieren einer Endlosschleife hervorgerufen wird. Das Worst-Case-Szenario wäre, dass das gesamte Blockchain-System zum Erliegen kommt.

Während es bei klassischen Programmen üblich ist, fehlerhaften Programmcode durch Softwareupdates zu verbessern, ist die Korrektheit von Smart Contracts von äußerster Wichtigkeit. Der Architektur einer Blockchain liegt zugrunde, dass aufgrund des Integritätsschutzes die Transaktionen in der Blockchain rückwirkend nicht verändert werden können. Das gilt auch für programmierte Smart Contracts, welche in der Blockchain gespeichert werden.

Rückblickend gibt es einige Hacks und Angriffe, die auf die fehlerhafte Programmierung von Smart Contracts zurückzuführen sind. Dabei entstanden teilweise Schäden in Millionenhöhe.

Der prominenteste und schwerwiegendste Angriff ist unter dem Namen DAO-Hack bekannt und betraf die Ethereum Blockchain.

## 5. Anwendungsbeispiele

Die Blockchain-Technologie ist vielseitig einsetzbar. Durch die Abstraktheit des Funktionsprinzips kann es auf verschiedene Bereiche angewendet werden. Dies umfasst die Bereiche Kryptowährung, Kapitalmarkt, Gesundheitswesen, Versicherungswesen, Vertragswesen, Logistikbranche und den Mobilitätssektor. Auch sind Anwendungsmöglichkeiten in Märkten möglich, die momentan noch nicht absehbar sind. Der Bereich Kryptowährung ist hierbei besonders hervorzuheben, da die Blockchain ursprünglich für die Kryptowährung Bitcoin entworfen wurde. Die Anwendung der Blockchain-Technologie steht in vielen Bereichen allerdings noch in der Konzeptphase.

### 5.1. Kryptowährung

Die bekannteste Anwendung der Blockchain ist die weltweit führende Kryptowährung Bitcoin. Der Bitcoin wurde 2009 nach der Finanzkrise von dem pseudonymisierten Entwickler Satoshi Nakamoto als Open-Source-Software veröffentlicht. Ob es sich dabei um eine Einzelperson oder eine Gruppe handelt, ist nicht bekannt.

Während der Finanzkrise entstand der Wunsch, eine unabhängige Währung zu schaffen, um bei zukünftigen Finanzkrisen eine unabhängige und stabile Währung zu haben. In einem 2008 veröffentlichten neunseitigen Thesenpapier von Satoshi Nakamoto wurden die Grundsätze des Bitcoin festgelegt. Dazu gehört eine Begrenzung der maximalen Bitcoin-Menge auf 21 Mio., um eine Inflation zu vermeiden.

Aus technischer Sicht wird ein Bitcoin durch aufwendige mathematische Verfahren von sogenannten Minern berechnet. Dabei wird eine hohe Rechenleistung benötigt und mit zunehmender Bitcoin-Anzahl steigt der Rechenaufwand zur Erzeugung weiterer Bitcoin [MO20]. Der erzeugte Bitcoin wird dann in der elektronischen Brieftasche (engl. Wallet) des Besitzers aufbewahrt und in der Blockchain dokumentiert. Die Speicherung der Blockchain erfolgt dezentral. Jede Wallet hat eine eigene Kennung, ähnlich einer Kontonummer, die es erlaubt anonym mit Bitcoin zu handeln [BU20].

Seit der Entstehung im Jahr 2009 hat die Kryptowährung viele Phasen durchlebt, vom strahlenden Aufstieg als zukunftsträchtiges Spekulationsobjekt zu Beginn, bis hin zu starken Kursabstürzen über Nacht. Im Jahr 2010 betrug der Wert eines Bitcoin noch 0,08 US-Dollar [HA17]. Momentan ist der Kurs wieder auf Höhenfahrt und weckt risikofreudige Spekulanten an. Heute steht der Kurs bei 21.832 US-Dollar (Stand: 29.12.2020). Innerhalb von elf Jahren wurde eine extreme Kurssteigerung des Bitcoin erreicht.

Durch den Erfolg des Bitcoin, vor allem in der Anfangszeit nach der Veröffentlichung, wurden viele weitere Kryptowährungen mit eigenen Einsatzzwecken und Alleinstellungsmerkmalen entwickelt. So stehen mittlerweile über 1000 Kryptowährungen zur Verfügung. Besonders der hohe Rechenaufwand des Bitcoin ist mit einer nachhaltigen Zukunft nur schwer vereinbar, weshalb auch zu diesem Problem Alternativen entwickelt wurden.

Nachfolgend ist die Marktkapitalisierung der acht größten Kryptowährungen dargestellt.

<br>

![alt_text](images/image7.jpg 'image_tooltip')

**Abbildung 8: Marktkapitalisierung der größten virtuellen Währungen 2020 [BO20]**

Angeführt wird diese Statistik von dem bereits vorgestellten Bitcoin mit 337 Mrd. US-Dollar Marktkapitalisierung. Auf Platz zwei folgt die Kryptowährung Ether der Plattform Ethereum, mit der auf Basis von Blockchain dezentral Verträge überwacht werden können. Weitere Erläuterungen zu dieser Plattform folgen in Kapitel 6.5 Vertragswesen. Auf dem dritten Platz befindet sich Tether. Bei Tether handelt es sich um eine Kryptowährung, deren Wert an eine Fiatwährung, den US-Dollar oder den Euro gebunden ist. Dies bringt den Vorteil einer leichteren Übertragung von der digitalen Währung in Fiatgeld [SC19].

### 5.2. Kapitalmarkt

Auch der Kapitalmarkt profitiert von der Einbindung von Blockchain-Softwaresystemen. Bisher überwachen Investmentbanken die Aufnahme von Eigen- und Fremdkapital sowie Unternehmensbeteiligungen. Sie stehen als Vermittler zwischen dem Investor und dem kapitalaufnehmenden Unternehmen. Dies verlangsamt den Prozess der Geldvergabe und erzeugt hohe Kosten für Investor und Unternehmen. Auch der Wertpapierhandel leidet unter diesen Problemen.

Eine Lösung für dieses Problematik ist die Plattform neufund.org. Mit ihr können Investoren digitales Wertpapier, sogenannte Equity Tokens, von Start-ups handeln. Dieser Wertpapierhandel ist flexibler, günstiger und schneller als herkömmliche Unternehmensbeteiligungen [KR19]. Er ermöglicht somit auch Kleinanlegern einfach in Unternehmen zu investieren.

Der Kapitalmarkt ist bei der Blockchain-Nutzung in Deutschland allerdings noch in den Anfängen. So hat die Bundesregierung im Dezember 2020 ein Gesetz beschlossen, um Wertpapiere auf komplett digitalem Wege, ohne eine papiergebundenes Wertpapier handelbar zu machen [BU20]. Statt papiergebundene Wertpapiere bei einem Intermediär zu lagern, soll der Eigentumsstatus zukünftig digital in einer Blockchain dokumentiert werden. Dies würde zu einem einfacheren und günstigeren Wertpapierhandel führen [HO20].

### 5.3. Gesundheitswesen

Die Blockchain-Technologie ist überall sinnvoll einsetzbar, wo Dokumentationspflichten herrschen. Dies ist auch im Gesundheitswesen der Fall. So müssen Patientendaten, Behandlungsdaten, Personaldaten, Lieferketten und Verbrauchsdaten dokumentiert werden, um gesetzlichen Pflichten nachzukommen. Daher sind die vielversprechendsten Anwendungsgebiete im Gesundheitswesen der digitale Austausch von Patientendaten zwischen verschiedenen Parteien, die Verwaltung von Versicherungsfällen und deren Abrechnung, die Überwachung von Lieferketten und die Verwaltung von klinischen Studien [PO18].

Um neue Ideen zu fördern, hat das Bundesministerium für Gesundheit im vergangenen Jahr einen Ideenwettbewerb ausgerufen, bei dem spannende Einsatzfelder und Konzepte entwickelt wurden. Gewonnen hat dabei ein Konzept zur digitalen Verwaltung von Betäubungsmittelrezepten auf Basis der Blockchain. Das elektronische Rezept wird direkt durch Arztpraxen, Apotheken und Aufsichtsbehörden verwaltet. Dadurch kann der Verwaltungsaufwand reduziert werden.

Eine weitere ausgezeichnete Idee ist die Verwaltung von Patienteneinwilligungen basierend auf der Blockchain-Technologie. Patienteneinwilligungen sind an vielen Stellen im Gesundheitswesen notwendig, sei es in Aufklärungsgesprächen, Studienteilnahmen oder Organspenden. Mit dem entwickelten Konzept können Patienten für jeden Einzelfall entscheiden, was mit ihren Daten passiert.

Auch die Arbeitsunfähigkeitsbescheinigungen beim Arzt können durch die Blockchain revolutioniert werden. Bislang müssen diese Bescheinigungen aufwendig beim Arzt gedruckt und vom Patienten an Krankenkasse und Arbeitgeber gesendet werden. Mit dem entwickelten Konzept sollen Arbeitsunfähigkeitsbescheinigungen elektronisch vom Arzt erstellt und in einer Blockchain gespeichert werden. Anschließend erhalten die Krankenkasse und der Arbeitgeber nach Freigabe durch den Patienten per Smartphone die Bescheinigung automatisch. Zusätzlich können sie nur die Informationen einsehen, auf die sie aus rechtlicher Sicht zugreifen dürfen. Dies minimiert den Verwaltungsaufwand und erhöht die Fälschungssicherheit der Arbeitsunfähigkeitsbescheinigungen [BU19].

### 5.4. Vertragswesen

Um Verträge auch in der digitalen Welt durch Computer anwendbar zu machen, wurden Smart Contracts (dt. Intelligente Verträge) entwickelt. Dies sind Verträge, die auf Computerprotokollen basieren und somit von Maschinen gelesen, geprüft und angewendet werden können. Sie erlauben es die Kosten bei der Vertragsverwaltung zu verringern und die Bearbeitungszeit deutlich zu minimieren. Die Vereinbarungen eines intelligenten Vertragen werden in der Blockchain gespeichert und sind daher nachvollziehbar, transparent und irreversibel [SC19]. Sie können Wenn-Dann-Regeln enthalten, wodurch automatisch Bedingungen abgefragt und vordefinierte Aktionen ausgeführt werden können. Da Verträge in allen Wirtschaftsbereichen genutzt werden, sind Smart Contracts universal einsetzbar. Aufgrund der fortschreitenden Digitalisierung sind digitale Verträge zukünftig unersetzbar, damit Computersysteme untereinander handlungsfähig sind.

Im Kapitel 5.1 Kryptowährung wurde bereits die Währung Ether vorgestellt, die zur Plattform Ethereum gehört. Ethereum ist eine Plattform, auf der Nutzer Transaktionen mit Ether durchführen können. Als Besonderheit bietet die Plattform allerdings auch die Möglichkeit Smart Contracts zu verwenden. So können digitale Verträge angelegt werden, bei denen Bedingungen automatisch abgefragt und nachfolgende Aktionen ausgelöst werden. So kann beispielsweise ein Unternehmen A bei Unternehmen B 500 Teppiche bestellen, die zum 1.3.2021 geliefert werden, erst dann erfolgt die Zahlung von Unternehmen A an Unternehmen B. Ist dieser Sachverhalt auf der Ethereum-Plattform in einem digitalen Vertrag umgesetzt, prüft die Software am 1.3.2021 automatisch, ob die Lieferung erfolgt ist. Bei erfolgreichen Prüfung der Bedingung, wird vollautomatisiert der vorher festgelegte Geldbetrag von Unternehmen B an Unternehmen A überwiesen [SC192].

Im Personalbereich können Smart Contracts dazu verwendet werden, um Verträge abteilungsübergreifend zu verwalten und so einen schnellen, einfachen Zugriff sowie einen reibungslosen Austausch zu ermöglichen.

In der Personalbeschaffung könnten Blockchain-Technologie und Smart Contracts zukünftig genutzt werden, um Bewerberdaten fälschungssicher, korrekt und transparent zwischen Unternehmen und Bewerbern auszutauschen. So könnten Bildungs- und Arbeitszeugnisse, Informationen über Beschäftigungsverhältnisse und weitere bewerbungsrelevante Daten in die persönliche Blockchain eines Absolventen eingetragen werden. Diese persönliche Blockchain könnte dann vom Bewerben für das gewählte Unternehmen freigegeben werden, sodass diese direkt auf die Daten zugreifen. Somit würde ein konstanter und fälschungssicherer Bewerbungsprozess sichergestellt, der Bewerbern und Unternehmen Zeit und Kosten spart [AC19].

### 5.5. Versicherungsbranche

Die Versicherungsbranche ist auf aktuelle und korrekte Daten angewiesen, um Schäden angemessen regulieren zu können. Sie greifen auf Unfallstatistiken, Wetterdaten, Risikoberechnungen und viele mehr zu, um faktenbasierte Schadensregulierungen durchzuführen. Alle Vorgänge und Daten sind zusätzlich zu dokumentieren, um die Nachvollziehbarkeit zu wahren. Dabei kann die Blockchain-Technologie eine große Hilfe darstellen.

Laut einer Studie von Cognizant von 2018 halten 86 Prozent der Führungspersonen in der Versicherungsbranche die Blockchain-Technologie für künftig wichtig oder sehr wichtig. Im gleichen Jahr ergab eine Studie von Accenture, dass 48 Prozent der Versicherer Blockchain-Technologie in den nächsten zwei Jahren einsetzen werden. 84 Prozent waren sogar der Meinung, dass diese Technologie und Smart Contracts „die Interaktion mit Partnern völlig neu definieren” [TE19].

Blockchain-basierte Systeme bieten für die Versicherungsbranche enorme Vorteile. So können automatisiert Datenabgleiche zwischen verschiedenen Akteuren durchgeführt werden, ohne jeweils eigene Schnittstellen programmieren zu müssen. Verträge können automatisiert und effizienter verwaltet werden. Es können zukünftige Anwendungen wie das Internet der Dinge mit digitalen Verträgen und einer Datendokumentation abgedeckt werden. Des Weiteren bietet die Technologie auch für Kunden mehr Transparenz und Datensicherheit. Der Kunde kann stets über die Speicherung und Verwendung seiner Daten entscheiden.

So kann die Blockchain unter anderem in der Betrugserkennung, Risikoprävention, Schadenprävention und im Schadenmanagement genutzt werden. Dabei kann die Technologie als sicherer Speicherort für Umweltdaten, Statistiken, persönliche Daten, Fahrzeugdaten und ähnlichen Daten genutzt werden. Durch eine einheitliche Datenbasis kann der Aufwand der Versicherungen reduziert und gleichzeitig die Zufriedenheit der Kunden gesteigert werden, da die Kunden jederzeit Zugriff auf die eigenen Daten haben und den Bearbeitungsfortschritt einsehen können. So könnte ein Auto bei einem Unfall zukünftig automatisch die Polizei, den Rettungsdienst, die Werkstatt und die Versicherung benachrichtigen. Es würde automatisiert eine Schadensmeldung erfolgen und alle Daten des Fahrzeugs, der Personen und der beteiligten Dienste werden zwischen den Diensten ausgetauscht. Dies würde zu einer reibungslosen Interoperabilität führen, da auf eine gemeinsame Datenbasis zugegriffen wird, die laufend Aktualisierungen erhält. Gleichzeitig würde die Betrugsprävention verbessert, da alle Daten von autorisierten Akteuren in die Blockchain eingepflegt werden [EY18].

Gerade im Hinblick auf das kommende Internet der Dinge sind die Blockchain-Technologie und Smart Contracts für das Versicherungswesen von großer Bedeutung. So könnte in Zukunft ein Feuchtigkeitssensor bei der Waschmaschine automatisch einen Wasserschaden erkennen, den Wasserhahn automatisch zu drehen und diesen Schadenfall sofort an die Versicherung melden. Diese erhält die Daten des Sensors, des Wasserhahns und der Waschmaschine direkt in ihre Blockchain. Anhand dieser und bereits vorhandener Daten des Hauses kann automatisiert eine Schadensberechnung durchgeführt und reguliert werden.

### 5.6. Logistikbranche

Die Logistikbranche profitiert ebenfalls von der Entwicklung der Blockchain-Technologie. Die Aufgabe der Logistik ist es, eine Ware vom Anfangspunkt bis zu einem Zielpunkt zu liefern. Dabei durchläuft die Ware häufig mehrere Landesgrenzen, Behörden, Verladepunkte, Transporteure und Finanzierer. Bei diesen Schnittstellen der einzelnen Akteure fallen Unmengen an rechtlich notwendigen Daten an. Sei es der Warenzustand beim Einladen, die Temperatur und Feuchtigkeit im Container während des Transportes oder steuerliche Informationen bei Grenzübergängen. Eine dezentrale transparente, konsistente und unmanipulierbare Datenbasis ist daher ein deutlicher Vorteil, der allen Beteiligten große Kostenersparnisse einbringt.

Im Schifffahrtsbereich fallen ein Fünftel der Gesamtkosten im Welthandel für die Verwaltung und die Dokumentation der Logistik an. Um diese Kosten und den Zeitaufwand zu verringern, haben die Reederei Maersk und das IT-Unternehmen IBM sich zusammengeschlossen. Sie möchten mithilfe des Blockchain-Projektes **„**TradeLens” den weltweiten Handel teilautomatisieren. So sollen Versanddaten, Frachtpapiere, Genehmigungen und Sensordaten in Echtzeit zurückverfolgbar und von den Beteiligten Unternehmen einsehbar sein. Mit der Blockchain-Technologie soll dann beispielsweise rückverfolgbar sein, ob die Kühlkette bei zu kühlenden Waren nicht unterbrochen wurde, indem Sensoren im Container die Temperatur in Echtzeit in die Blockchain übertragen [BI20].

Ein weiteres Beispiel aus der Schifffahrt ist die Übergabe des Konnossement. Im Konnossement ist der Wert der verschifften Güter angegeben. Dieses Dokument kann anstatt der eigentlichen Güter verkauft, gekauft oder verpfändet werden. Bisher ist dieses Dokument hauptsächlich in Papierform vorhanden und wird zwischen unzähligen Beteiligten ausgetauscht. Die Sender, Empfänger, Banken, Versicherungen und Spediteure sind überall auf der Welt verteilt. Daher muss das Dokument teilweise per Post durch die ganze Welt geschickt werden, was immense Kosten verursacht. Zur Umgehung dieses Problems soll das Konnossement per Blockchain-Technologie digitalisiert und dadurch erheblich schneller und günstiger übertragbar werden [PWC17].

Auch die intelligenten digitalen Verträge können in der Logistikbranche eingesetzt werden, um dem Ziel der Logistik 4.0 und der Industrie 4.0 näher zu kommen. In der Zukunftsvision Industrie 4.0 kann der Kunde sein Produkt persönlich individualisieren. Das Produkt wird dann vollautomatisiert von Fertigungsrobotern hergestellt, ohne dass ein Mensch die Produktionsmaschinen vor der Fertigung einstellen muss. Analog dazu wird in der Logistik 4.0 die Anlieferung von Roh- und Betriebsstoffen sowie die endgültige Auslieferung des Produktes vollautomatisiert. Um diesem Ziel der Industrie 4.0 näher zu kommen, sind alle involvierten Prozesse ebenfalls zu digitalisieren und interoperabel zu konzipieren [FRA20].

### 5.7. Mobilitätssektor

Der Mobilitätssektor spielt in der fortschreitenden Digitalisierung und im Wandel vom Verbrennungsmotor zum verbundenen Elektroauto eine bedeutende Rolle. So sollen sich die Fahrzeuge in Zukunft autonom über die Straßen bewegen. Dazu müssen sie auch autonom an eine Ladesäule fahren und elektrisch geladen werden. Wie bei einer herkömmlichen Tankstelle ist dann die genutzte Energie zu zahlen, wofür eine Authentifizierung des Fahrzeugs beim Ladesäulenbetreiber notwendig ist. Für die Transaktion, die Dokumentation und die Verwaltung der anfallenden Daten während der Maschine-zu-Maschine-Kommunikation sind die Blockchain-Technologie und Smart Contracts sehr gut nutzbar. Auch während des Fahrens muss das autonome Fahrzeug selbstständig Geschäfte mit Mautstellen, Waschstraßen, Parkplätzen und Werkstätten abschließen [GE19].

Des Weiteren könnte die Blockchain zukünftig in Systemen zum Staumanagement eingesetzt werden, bei dem die Fahrzeuge untereinander kommunizieren und die Routenplanung aufeinander abstimmen, um eine möglichst effiziente Straßennetzauslastung zu erreichen.

Der Handel von Gebrauchtwagen unterliegt einer großen Unsicherheit bezüglich der Vergangenheit des Fahrzeugs. Ob der angezeigte Kilometerstand den tatsächlich gefahrenen Kilometern entspricht, ist nur schwer nachvollziehbar. Auch Unfälle oder Motorschäden können leicht vom Verkäufer verschwiegen werden. Für diesen Anwendungsfall wäre es sinnvoll, die Vergangenheit des Fahrzeugs manipulationssicher in einer Blockchain zu dokumentieren. Darin könnten die bisherigen Fahrzeughalter, der Kilometerstand, eventuelle Unfälle und weitere Schäden leicht von offizieller Seite hinterlegt werden. Diese Blockchain ist an das Fahrzeug gebunden und wird bei jedem Fahrzeughalterwechsel weitergegeben. Somit wird für den Käufer und weitere Beteiligte wie Versicherungen, Transparenz bezüglich der Vergangenheit des Fahrzeugs geschaffen [RE19].

Ein weiteres Anwendungskonzept, was allerdings noch einen sehr futuristischen Charakter besitzt, ist das Platooning. Beim Platooning fahren mehrere Fahrzeuge, vorrangig Lastwagen, dicht hintereinander und bilden eine Kolonne. Die Fahrzeuge nach dem Führungsfahrzeug schließen sich der führenden Geschwindigkeit an und nutzen den Windschatten. Da für die folgenden Fahrzeuge ein finanzieller Nutzen in Form von Kraftstoffeinsparungen entsteht, berechnen die Fahrzeuge die Kosten für den gesparten Kraftstoff und überweisen ihn nach Beendigung der Kolonnenfahrt automatisch an das Führungsfahrzeug. Hierdurch kann eine umfangreiche Kraftstoffeinsparung im Straßenverkehr erreicht werden [TR20].

### 5.8. Potenzielle Märkte

Trotz der bereits genannten Einsatzbereiche existieren noch Weitere, die ebenfalls für die Anwendung der Blockchain-Technologie und der Smart Contracts in Frage kommen. So könnte die öffentliche Verwaltung stark vereinfacht werden, indem die Daten dezentral für alle Einrichtungen verfügbar wären. Die Daten könnten sicher ausgetauscht und gepflegt werden. Aufwendige Schnittstellen zwischen den einzelnen Institutionen könnten entfallen, was zu erheblichen Kosteneinsparungen führen würde.

Auch der globale Handel könnte von den Technologien partizipieren. Ein Bauer in China könnte seine Ware direkt an einen Käufer in Deutschland verkaufen, ohne jegliche Intermediäre, allein mithilfe einer Blockchain-basierten Software. Private Energieerzeuger könnten ihren eigens auf dem Hausdach produzierten Solarstrom direkt an Verbraucher verkaufen, ohne den Umweg über einen Energiekonzern zu nehmen [FU20].

Viele Anwendungsfälle werden sich erst während der alltäglichen Nutzung von Blockchain-Technologien ergeben und sich auf weitere Einsatzbereiche übertragen. Welche das genau sind, ist in der derzeitigen Anfangsphase der Blockchain-Nutzung noch nicht absehbar.

## 6. Probleme und Herausforderungen

Die Blockchain-Technologie hat sich in den letzten Jahren rasant entwickelt und immer mehr Akteure beschäftigen sich mit der Thematik. Trotzdem ist der Einsatz von Blockchain-Anwendungen in der breiten Bevölkerungsschicht bis jetzt ausgeblieben.

Ein Grund dafür sind die vielen Herausforderungen, die der Technologie aktuell noch gegenüberstehen. In diesem Abschnitt sollen einige der Probleme und Herausforderungen aufgeführt werden, die die Blockchain daran hindern, in den Alltag der Bevölkerung adaptiert zu werden.

Die zwei wohl am meisten diskutierten Herausforderungen sind die Skalierbarkeit und die damit einhergehende Effizienz. Aber auch grundlegende Fragen in Bezug auf die Rechtswirksamkeit von Smart Contracts spielen eine wichtige Rolle. Außerdem fehlen aktuell einheitliche Standards für die Technologie. Daraus resultieren Inkompatibilitäten zwischen den verschiedenen Blockchains und die unübersichtliche Menge an verschiedenen Lösungen macht eine Entscheidung für den Anwender schwierig.

Bevor die einzelnen Herausforderungen näher betrachtet werden, wird noch einmal auf die Unterschiede zwischen privaten und öffentlichen Blockchains eingegangen. Private Blockchains können einige Problem wie die Skalierung und Effizienz teilweise lösen. Jedoch wird bei dieser Art von Blockchain eine andere Diskussion geführt.

Mit der Zugangsbeschränkung der Teilnehmer und mit der Auswahl einiger weniger Netzwerkknoten, die die Validierung durchführen und damit den Konsens herstellen, sprechen Kritiker von einem Widerspruch zu dem eigentlichen Grundgedanken der hinter einer dezentralen Blockchain-Technologie steht. Wie in Abbildung 6 bereits gezeigt wurde, ähneln private und genehmigungsbasierte Blockchain-Systeme zentralisierten Servern bzw. Registern stark.

Die Diskussion, ob es sich bei privaten genehmigungsbasierten Blockchains tatsächlich um eine Blockchain-Architektur handelt, soll in dieser Arbeit jedoch nicht weiter aufgegriffen werden. Stattdessen werden die untersuchten Probleme und Herausforderungen ausschließlich auf öffentliche und genehmigungsfreie Blockchain-Systeme, wie die vorgestellte Bitcoin- oder Ethereum-Blockchain, bezogen.

### 6.1. Standardisierung

Aufgrund fehlender Standardisierung entstehen immer mehr Blockchains und Anwendungen die nicht interoperabel untereinander sind. Auch wenn sich im praktischen Einsatz mittlerweile einige Open Source Blockchain-Plattformen wie zum Beispiel die Blockchain-Frameworks von Hyperledger oder die Plattform Corda von R3 “Quasi-Standards” etabliert haben, gibt es keine Lösung, die Kompatibilität untereinander schafft.

Die Entwicklung von Standards für den einheitlichen Einsatz von Blockchain-Technologie kann helfen, verständliche Rahmenbedingungen zu schaffen und so den Einsatz von Blockchains zu erleichtern. Einige internationale und nationale Organisationen beschäftigen sich darum seit einiger Zeit mit dem Vorantreiben der Standardisierung und versuchen, einheitliche Richtlinien zu entwerfen.

Die International Organization for Standardization (abgekürzt ISO) gründete bereits im Jahr 2016 eine Kommission zur Erarbeitung eines Standards für Blockchain und Distributed Ledger Technologie. Im September dieses Jahres wurde der erste Standard veröffentlicht. Unter der Norm ISO/TC 307 ist der Standard ISO/TR 23455:2019 zu finden.

Das Dokument gibt einen Überblick über Smart Contracts in Blockchain und DLT Systemen. Es wird beschrieben, was genau Smart Contracts sind und wie diese funktionieren. Dabei wird besonders auf die technischen Aspekte eingegangen. Allerdings werden rechtsverbindliche Smart Contracts nur kurz abgehandelt [BSI19] [ISO19].

Das Deutsche Institut für Normung (abgekürzt DIN) hat entsprechend zu der ISO Kommission ein Spiegelgremium eingerichtet. Die Arbeitsgruppe “security, privacy and identity” rechnet mit einem Abschluss der Standardisierungsarbeit für 2021 [BSI19]. Im Juni 2019 wurde bereits die DIN SPEC 3103:2019-06 mit dem Titel “Blockchain und Distributed Ledger Technologie in Anwendungsszenarien für Industrie 4.0 in Kombination mit Blockchain veröffentlicht. Dabei werden Anwendungsfälle aus dem Bereich der Industrie 4.0 in Kombination mit Blockchain und DLT Systemen erarbeitet und dargestellt [DIN19].

Mit der Publikationsreihe P2418 führt das Institute of Electrical and Electronics Engineers (abgekürzt IEEE) Standardisierungsprojekte für Blockchains durch. Eine ganze Reihe von Veröffentlichungen können auf der Webseite https://blockchain.ieee.org/standards eingesehen werden.

Auch das US-amerikanische National Institute of Standards and Technology (abgekürzt NIST) führt einige Blockchain-Projekte auf seiner Webseite auf. Im Oktober 2018 veröffentlichte das NIST ein Paper, welches unter dem Kürzel NISTIR 8202 mit dem Titel “Blockchain Technology Overview” zu finden ist [NIST00].

### 6.2. Skalierbarkeit

Die schlechte Skalierbarkeit bei öffentlichen und zugangsfreien Blockchains ist ein Problem, welches seit langem bekannt ist. An der technischen Beschränkung wird ausgiebig geforscht und entwickelt. Es existieren bereits eine Vielzahl an Verbesserungsvorschlägen [BSI19].

Da per Definition die Teilnahme an dieser Art von Blockchain frei zugänglich ist, muss das System besonders vor Teilnehmern geschützt sein, die sich missbräuchlich verhalten. Transaktionen, die in dem Netzwerk getätigt werden, müssen mit einem aufwändigen Konsensmechanismus validiert werden, damit es sich für Angreifer nicht lohnt, das Netzwerk zu manipulieren.

Somit stellt der Konsensmechanismus den Hauptgrund für das Skalierungsproblem dar. Die Latenz, die durch einen Konsensmechanismus wie PoW bei Bitcoin entsteht, sorgt dafür, dass Anwendungen, die Echtzeitverfügbarkeit benötigen, gar nicht realisiert werden können.

Bei der Bitcoin-Blockchain dauert es im Durchschnitt ca. 10 Minuten, bis ein Block validiert wird. Außerdem sollten einige weitere Blöcke abgewartet werden, um sicher zu gehen, dass es sich nicht um einen temporären Fork handelt und der Block mit einer sehr hohen Wahrscheinlichkeit unwiderruflich verankert ist.

Da nur eine gewisse Anzahl an Transaktionen in einen Block aufgenommen werden kann, ist der Durchsatz des Netzwerkes durch diese Anzahl limitiert. Sowohl Bitcoin als auch Ethereum sind während der Hypephase im Jahr 2017 jeweils an ihre Transaktionslimits gestoßen. Es wurden mehr Transaktionen veranlasst, als verarbeitet werden konnten. Das führte dazu, dass sich ein Rückstau an Transaktionen gebildet hat und die Miner die Transaktionen für die Validierung bevorzugten, die die größten Transaktionsgebühr enthielten. Die Verfügbarkeit der Bitcoin und Ethereum Blockchain war mit der Überlastung des Netzwerkes für eine normale Benutzung stark eingeschränkt.

Ein Ansatz von dem Hard Fork Bitcoin Cash ist es, die Blockgröße zu erweitern. Im Vergleich zu Bitcoin wurde die Blockgröße von einem Megabyte auf 32 Megabyte angehoben und dadurch statt sieben transactions per second (abgekürzt TPS) ein Durchsatz von 230 TPS erzielt [MA19]. Für eine Massenadaption im Zahlungsverkehr ist das jedoch immer noch deutlich zu wenig. Generell gibt es mittlerweile viele verschieden Varianten, bei denen die Parameter von PoW im Vergleich zu Bitcoins eingesetzten PoW verändert wurden.

Die mangelnde Effizienz ist ein weiterer Aspekt, weshalb der aktuell am häufigsten eingesetzte Konsensmechanismus PoW von Experten nicht als zeitgemäß eingestuft wird und für Debatten um die Skalierungsproblematik sorgt [SI17].

Mit dem Arbeitsnachweis, den die Miner leisten müssen, um einen Block zu validieren, wird enorme Energie in Form von Strom aufgewendet. Die Kryptowährung Bitcoin stellt hier das absolute Negativbeispiel aller Blockchains dar.

Der von der Universität Cambridge geschätzt Stromverbrauch liegt bei 62 Terawattstunden für das Jahr 2019. Zum Vergleich: Bei einem Länderrating bedeutet dieser Stromverbrauch Platz 43 zwischen Schweiz und Tschechien. Rechnet man den Stromverbrauch auf eine

Transaktion runter, dann werden pro Transaktion 200 Kilowattstunden Strom verbraucht. Damit kommt ein durchschnittlicher Vier-Personen-Haushalt drei Wochen lang aus [DR19].

In Zeiten des Klimawandels ist dieser Ressourcenverbrauch keinesfalls zu rechtfertigen. An einer Abhilfe für PoW wird gearbeitet. Abbildung 9 gibt eine Übersicht von Konsensmechanismen, die entwickelt wurden oder noch in der Entwicklung sind und deutlich energieeffizienter funktionieren.

<br>

![alt_text](images/image8.png 'image_tooltip')

**Abbildung 9: Übersicht über verschiedene Konsensmechanismen [AN18]**

Einer der in Abbildung 9 aufgeführten Kosensmechanismen ist der Directed Acyclic Graphs (DAG) und wird zum Beispiel bei IOTA eingesetzt.

## 7. Fazit und Ausblick

Technologie braucht Zeit um sich zu entwickeln und durchzusetzen. Die Blockchain-Technologie hat in den vergangenen Jahren immer mehr an Bedeutung gewonnen. Viele verschiedene Konzepte für ihren Einsatz wurden entworfen, verschiedene Pilotprojekte durchgeführt und in unterschiedlichen Bereichen wird sie bereits erfolgreich eingesetzt. Durch die Datensicherheit, die Konsistenz und die Transparenz ist sie für Datenstrukturen zur Haltung sensibler Daten geeignet.

Insgesamt ist zu erwarten, dass die Anzahl der tatsächlich umgesetzten Konzepte in den kommenden Jahren weiter und immer stärker ansteigen wird. Das Geschäftspotenzial ist bereits ausgereift vorhanden. Ob die Technologie sich erwartungsgemäß durchsetzt, wird die Gesellschaft, die sich darauf einlassen muss, maßgeblich beeinflussen. Es ist gut möglich, dass die Blockchain-Technologie zu einer wichtigen Schlüsseltechnologie wird. Zum Teil wird sie schon jetzt als solche betrachtet. Auch wenn sie nicht alle existierenden Probleme lösen kann, ist sie doch eine innovative Datenbanktechnologie, die durch ihre vielen Vorteile überzeugt.

## Literaturverzeichnis

<table>

  <tr>
   <td>[AA14]
   </td>
   <td>Antonopoulos, A., 2014. Mastering Bitcoin: Unlocking Digital Cryptocurrencies. Sebastopol: O'Reilly Media.
   </td>
  </tr>

  <tr>
   <td>[AC19]
   </td>
   <td>Aconso, 2019. Blockchain und HR: Recruiting, Arbeitsverträge und mehr. Online verfügbar unter: https://www.aconso.com/blockchain-und-hr-recruiting-arbeitsvertraege-und-mehr/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[AN18]
   </td>
   <td>Anwar, H. Consensus Algorithms: The root of the Blockchain Technology. Online verfügbar unter: https://101blockchains.com/consensus-algorithms-blockchain/#prettyPhoto/2/ (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

 <tr>
   <td>[BA20]
   </td>
   <td>Bitpanda Academy, 2020. Wie funktionieren Hard Forks und Soft Forks?. Online verfügbar unter: https://www.bitpanda.com/academy/de/lektionen/wie-funktionieren-hard-forks-und-soft-forks/ (Letzter Zugriff: 15.12.2020).
   </td>
  </tr>

<tr>
   <td>[BD11]
   </td>
   <td>Boneh, D., 2011. Digital Signature Standard. Encyclopedia of Cryptography and Security, pp. 347-347.
   </td>
  </tr>

  <tr>
   <td>[BE18]
   </td>
   <td>Belyaev, A., et. al., 2018. Die Blockchain als eine Technologie für die Verwirklichung von Visionen der I4.0. Online verfügbar unter: <a href="https://www.researchgate.net/publication/326625600_Die_Blockchain_als_eine_Technologie_fur_die_Verwirklichung_von_Visionen_der_I40">https://www.researchgate.net/publication/326625600_Die_Blockchain_als_eine_Technologie_fur_die_Verwirklichung_von_Visionen_der_I40</a> (Letzter Zugriff: 19.01.2021).
   </td>
  </tr>

  <tr>
   <td>[BI20]
   </td>
   <td>BITO, 2020. Blockchain in der Logistik. Online verfügbar unter: https://www.bito.com/de-de/fachwissen/artikel/blockchain-in-der-logistik/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[BJ16]
   </td>
   <td>Bonneau, J. et al., 2016. Bitcoin and cryptocurrency technologies. Princeton: Princeton University Press.
   </td>
  </tr>

  <tr>
   <td>[BM20]
   </td>
   <td>Bitcoinmining, 2020. What is Bitcoin Mining?. Online verfügbar unter: https://www.bitcoinmining.com/ (Letzter Zugriff: 17.01.2021).
   </td>
  </tr>

 <tr>
   <td>[BO20]
   </td>
   <td>Bocksch, R., 2020. Bitcoin ist unangefochtener Krypto-Primus. Online verfügbar unter: https://de.statista.com/infografik/1939/marktkapitalisierung-von-kryptowaehrungen/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

 <tr>
   <td>[BSI18] 
   </td>
   <td>Bundesamt für Sicherheit in der Informationstechnik, 2018. Blockchain sicher gestalten – Eckpunkte des BSI, Bonn.
   </td>
  </tr>

  <tr>
   <td>[BSI19]
   </td>
   <td>Bundesamt für Sicherheit in der Informationstechnik, 2019. Blockchain sicher gestalten – Konzepte, Anforderungen, Bewertungen. Bonn.
   </td>
  </tr>
  
   <tr>
   <td>[BU20]
   </td>
   <td>Bundesministerium für Justiz und Verbraucherschutz, 2020. eWpG: Gesetz zur Einführung von elektronischen Wertpapier beschlossen. Online verfügbar unter: https://www.der-betrieb.de/meldungen/ewpg-gesetz-zur-einfuehrung-von-elektronischen-wertpapieren-beschlossen/ (Letzter Zugriff: 03.01.2020).
   </td>
  </tr>
  
   <tr>
   <td>[BU19]
   </td>
   <td>Bundesministerium für Gesundheit, 2019. Zukunftswerkstatt: Blockchain im Gesundheitswesen. Online verfügbar unter: https://www.bundesgesundheitsministerium.de/blockchain.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

   <tr>
   <td>[BU20]
   </td>
   <td>Bundesamt für Sicherheit in der Informationstechnik, 2020. BSI für Bürger - Blockchain und Kryptowährung. Online verfügbar unter: https://www.bsi-fuer-buerger.de/BSIFB/DE/DigitaleGesellschaft/OnlineBanking/Blockchain_und_Kryptowaehrung/blockchain_kryptowaehrung_node.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[DB17]
   </td>
   <td>Deutsche Bundesbank, 2017. Distributed-Ledger-Technologien im Zahlungsverkehr und in der Wertpapierabwicklung: Potenziale und Risiken, Frankfurt am Main.
   </td>
  </tr>

  <tr>
   <td>[DI17]
   </td>
   <td>Dixon, P., 2017. Blockchain: mehr als Bitcoin. Wiesbaden: Springer Fachmedien.
   </td>
  </tr>

   <tr>
   <td>[DIN19]
   </td>
   <td>DIN SPEC 3103:2019-06, 2019. Online verfügbar unter: https://www.beuth.de/de/technische-regel/din-spec-3103/306199037 (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

   <tr>
   <td>[DR19]
   </td>
   <td>Drösser, C., 2019. Verbraucht der Zahlungsverkehr mit Bitcoin so viel Energie wie ein ganzes Land?. Online verfügbar unter: https://www.zeit.de/2019/32/bitcoin-kryptowaehrung-energieverbrauch-kilowatt-stimmts (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

  <tr>
   <td>[EY18]
   </td>
   <td>EY Global, 2018. Wie die Blockchain-Technologie die Versicherungsbranche revolutioniert. Online verfügbar unter: https://www.ey.com/de_de/insurance/five-tech-trends-that-will-define-the-future-of-insurance (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

<tr>
   <td>[FRA20]
   </td>
   <td>Fraunhofer-Institut für Materialfluss und Logistik IML, 2020. Logistik 4.0. Online verfügbar unter: https://www.iml.fraunhofer.de/de/abteilungen/b1/intralogistik-und--it-planung/dienstleistungen0/Logistik_4_0.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[FU20]
   </td>
   <td>FutureManagementGroup AG, 2020. Leben und Arbeiten: Führt die Blockchain-Technologie zu einer Revolution?. Online verfügbar unter: https://www.futuremanagementgroup.com/de/werden-blockchains-co-unser-leben-und-arbeiten-revolutionieren/# (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[GE19]
   </td>
   <td>Gensrich, E., 2019. Wie die Blockchain-Technologie autonomes Fahren ermöglicht. Online verfügbar unter: https://partner.mvv.de/blog/wie-die-blockchain-technologie-autonomes-fahren-ermoeglicht (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[HA17]
   </td>
   <td>Hauptfleisch, K., 2017. So reich wären Sie heute, wenn Sie 2009 in Bitcoin investiert hätten. Online verfügbar unter: https://www.cancom.info/2017/08/so-reich-waeren-sie-heute-wenn-sie-2009-in-bitcoin-investiert-haetten/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[HO20]
   </td>
   <td>Holtermann, F., 2020. „Revolution am Kapitalmarkt“: Bundesregierung legt Gesetzentwurf für virtuelle Wertpapiere vor. Online verfügbar unter: https://app.handelsblatt.com/finanzen/boerse-maerkte/blockchain-anleihe-revolution-am-kapitalmarkt-bundesregierung-legt-gesetzentwurf-fuer-virtuelle-wertpapiere-vor/26084362.html?ticket=ST-22977890-RS3sBIHxla9cOCZqP3xT-ap1 (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  </tr>
    <tr>
   <td>[ISO19]
   </td>
   <td>ISO/TR 23455:2019, 2019. Online verfügbar unter: https://www.iso.org/standard/75624.html?browse=tc (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

  <tr>
   <td>[KR19]
   </td>
   <td>Krug, K., 2019. Was die Blockchain für Kapitalmärkte bedeutet. Online verfügbar unter: https://www.wiwo.de/finanzen/geldanlage/verkehrte-finanzwelt-was-die-blockchain-fuer-kapitalmaerkte-bedeutet/25265202.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[LL18]
   </td>
   <td>Laube, L., 2018. Blockchain einfach erklärt — Teil 3 Aufbau eines Blocks. Online verfügbar unter: https://medium.com/@luca.laube/blockchain-einfach-erkl%C3%A4rt-teil-3-aufbau-eines-blocks-dbb45319da7e (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

 <tr>
   <td>[MA19]
   </td>
   <td>Mantinger, L. Warum gibt es Bitcoin Cash?. Online verfügbar unter: https://cryptoticker.io/de/warum-gibt-es-bitcoin-cash/ (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

  <tr>
   <td>[MK16]
   </td>
   <td>Matusiewicz, K. et al., 2016. Analysis of simplified variants of SHA-256, Graz: Graz University of Technology.
   </td>
  </tr>
  
  <tr>
   <td>[MO20]
   </td>
   <td>Morrien, R., 2020. Bitcoin: Die Entstehung. Online verfügbar unter: https://www.gevestor.de/details/bitcoin-die-entstehung-819953.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

<tr>
   <td>[NIST00]
   </td>
   <td>NIST, Blockchain Projects. Online verfügbar unter: https://www.nist.gov/topics/blockchain (Letzter Zugriff: 21.12.2020).
   </td>
  </tr>

  <tr>
   <td>[NO17]
   </td>
   <td>Nofer, M. et. al., 2017. Blockchain. Erschienen in: Business & Information Systems Engineering, Juni 2017, Volume 59, Issue 3. Wiesbaden: Springer Fachmedien.
   </td>
  </tr>

  <tr>
   <td>[NS78]
   </td>
   <td>Needham, R. & Schroeder, M., 1978. Using encryption for authentication in large networks of computers. Communications of the ACM.
   </td>
  </tr>

  <tr>
   <td>[PO18]
   </td>
   <td>Polavis, 2018. Das Potential der Blockchain im Gesundheitswesen – der Hype und die Realität. Online verfügbar unter: https://www.polavis.de/blog/blockchain-im-gesundheitswesen-der-hype-und-die-realitaet/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[PP09]
   </td>
   <td>Paar, C. & Pelzl, J., 2009. Understanding Cryptography - A Textbook for Students and Practitioners. Heidelberg: Springer.
   </td>
  </tr>

  <tr>
   <td>[PP15]
   </td>
   <td>Peters, G. W. & Panayi, E., 2015. Understanding Modern Banking Ledgers Through Blockchain Technologies: Future of Transaction Processing and Smart Contracts on the Internet of Money, London: SSRN.
   </td>
  </tr>

 <tr>
   <td>[PWC17]
   </td>
   <td>PWC Deutschland, 2017. Warum Blockchain auch die Logistik revolutionieren wird. Online verfügbar unter: https://www.pwc.de/de/transport-und-logistik/warum-blockchain-auch-die-logistik-revolutionieren-wird.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>
  
  <tr>
   <td>[RE19]
   </td>
   <td>Reichhardt, M., 2019. Blockchain für Mobilität – Idee oder ideal?. Online verfügbar unter: https://www.automobil-industrie.vogel.de/blockchain-fuer-mobilitaet-idee-oder-ideal-a-851649/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[SC19]
   </td>
   <td>Schiller, K., 2019. Was ist Tether (USDT)?. Online verfügbar unter: https://blockchainwelt.de/tether/ (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

   <tr>
   <td>[SC192]
   </td>
   <td>Schierhorn, 2019. Ethereum: Was Sie über die Kryptowährung wissen sollten. Online verfügbar unter: https://www.hanseaticbank.de/klarmacher/wissen/kryptowaehrung-ethereum-was-ist-das-brauche-ich-das (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[SI17]
   </td>
   <td>Sixt, E.: Bitcoins und andere dezentrale Transaktionssysteme. Blockchains als Basis einer Kryptoökonomie, 2017. Berlin: Springer-Verlag.
   </td>
  </tr>

   <tr>
   <td>[SP18]
   </td>
   <td>Specht, P., 2018. Die 50 wichtigsten Themen der Digitalisierung : künstliche Intelligenz, Blockchain, Bitcoin, Virtual Reality und vieles mehr verständlich erklärt. München: Redline Verlag.
   </td>
  </tr>
  <tr>
   <td>[SSUF16]
   </td>
   <td>Schlatt, V. et. al., 2016: Blockchain: Grundlagen, Anwendungen und Potenziale. Online verfügbar unter: https://www.fim-rc.de/Paperbibliothek/Veroeffentlicht/642/wi-642.pdf (Letzter Zugriff: 17.01.2021).
   </td>
  </tr>

  <tr>
   <td>[ST15]
   </td>
   <td>Swanson, T., 2015. Consensus-as-a-service: a brief report on the emergence of permissioned, distributed ledger systems, Sidney: R3cev. 
   </td>
  </tr>

  <tr>
   <td>[TE19]
   </td>
   <td>Temperli, D., 2019. Wieso ist Blockchain für Versicherungen so interessant?. Online verfügbar unter: https://www.axa.ch/de/unternehmenskunden/blog/gruendung-und-innovation/blockchain-versicherungen-schweiz.html (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[TH15]
   </td>
   <td>Theymos, 2015. Blockchain. https://en.bitcoin.it/wiki/Block_chain/ (Letzter Zugriff: 20.12.2020).
   </td>
  </tr>

   <tr>
   <td>[TR20]
   </td>
   <td>Parsons Trommler, K., 2020. Blockchain-Technologie: Hype, Enttäuschung und die Rückkehr zur Realität. Online verfügbar unter: https://www.bayern-innovativ.de/seite/blockchain-fuer-mobilitaet (Letzter Zugriff: 03.01.2021).
   </td>
  </tr>

  <tr>
   <td>[WI17]
   </td>
   <td>Wiefling, S. et. al., 2017. Anwendung der Blockchain außerhalb von Geldwährungen. Erschienen in: Datenschutz und Datensicherheit - DuD, August 2017, Volume 41, Issue 8.Wiesbaden: Springer Fachmedien.
   </td>
  </tr>

</table>
