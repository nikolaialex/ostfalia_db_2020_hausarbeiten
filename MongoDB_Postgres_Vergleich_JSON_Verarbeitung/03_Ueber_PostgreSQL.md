[Zurück](02_Ueber_JSON.md)

## 3. Über PostgreSQL

<p align="center">
<img width="500" src="img/postgresql-logo.png">
</p>
<p align="center">
Abbildung 3: Logo von PostgreSQL<br>
(Quelle:  https://www.computersnyou.com/4281/setup-postgresql-ubuntudabian-quick-tip/)
</p>




### Überblick

PostgreSQL, oder auch kurz Postgres, ist ein objektrelationales Datenbank-Managementsystem. Objektrelational beschreibt, dass das klassische relationale Datenbankmodell um objektorientierte Ansätze erweitert wurde. Das ermöglicht es Postgres typische Limitationen relationaler Datenbanken zu vermeiden. [6]

Postgres ist im Vergleich schon sehr lange auf dem Markt, was aber keineswegs gegen die Datenbank spricht, im Gegenteil. In der Entwickler Community gilt Postgres gerade durch seine lange Entwicklungsgeschichte als ausgereift und zuverlässig. Das System zeichnet sich besonders durch seine hochgradige Modifizierungs- und Erweiterungsmöglichkeiten aus, die beispielsweise je nach Bedarf das Hinzufügen neuer Datentypen, Funktionen, Operationen, Indexierungsmethoden oder prozeduraler Sprachen (Programmiersprachen zum Schreiben von Funktionen) ermöglichen. [6]



### Entstehung

Die Entstehung von Postgres ist eng verknüpft mit der Universität Berkeley in Kalifornien und dem dortigen Professor Michael Stonebraker. Den Anfang bildete in den 1970er Jahren die Entwicklung des Datenbanksystems Ingres, die Stonebraker leitete. [6]\[7] Zwischenzeitlich verließ Stonebraker Berkeley, kehrte aber zurück und startete 1986 das neue Projekt Post-Ingres, aus dem sich nach und nach das heutige Postgres entwickelte. [6] Wichtig für den Ursprung ist noch, dass Progres eine eigene neue Codebasis hatte und nicht die von Ingres weiter verwendete.

Ab 1994 kam es für Postgres zu mehreren entscheidenden Veränderungen. Zuerst ist da die Integration eines SQL-Interpreters. [8] Bis dahin hatte Postgres den Query Language Interpreter “POSTQUEL” verwendet. In diesem Zug wurde außerdem das Client-Programm für den Zugriff “monitor” durch “psql” ersetzt. [8] Diese neue Version trug den Namen Postgres95, die dann erstmals Open-Source verfügbar gemacht wurde, was einen weiteren wichtigen Schritt darstellte. 1996 wurde dann schließlich der bis heute bestehende Name PostgreSQL eingeführt, der die Unterstützung von SQL klar macht. [8]

Seitdem wurde Postgres stetig weiterentwickelt, wobei zum einen immer neue Funktionen hinzugefügt wurden. Mittlerweile wird PostgreSQL über 30 Jahre lang weiterentwickelt und das System scheint weiter an Popularität zu gewinnen. Bei einer stackoverflow Umfrage 2019 wurde Postgres zur zeit populärsten Datenbanktechnologie nach dem erstplatzierten MySQL gewählt. [7]



### JSON Support

Der native Support für JSON war lange reinen NoSQL Datenbanken vorbehalten, während im klassischen RDBMS Umfeld JSON Objekte weiter als Text Dateien behandelt wurden, was die Möglichkeiten damit zu arbeiten erheblich eingeschränkte. Als 2012 mit Version 9.2 Support für JSON zu Postgres hinzugefügt wurde, war dies deshalb ein entscheidender Schritt, der auch die Popularität von Postgres seitdem mit vergrößert hat. [9] Mit PostgreSQL-9.4 wurde ein weiterer wichtiger Schritt im JSON Support erreicht, mit der Einführung von JSONB, was für JSON im Binärformat steht. [9] Mit diesen Fähigkeiten ist Postgres direkt in Konkurrenz zu NoSQL Datenbanken wie MongoDB getreten, die um JSON herum konstruiert sind und somit hier eigentlich deutlich führend sein sollten. Mehr dazu aber im Kapitel zum Vergleich von MongoDB und PostgreSQL.

### Wichtige Features

- Möglichkeit komplexer Abfragen

- Mengenoperationen

- Vererbung von Tabellen

- Fremdschlüssel (Foreign Keys) zur Verknüpfung von Daten zweier Tabellen

- Trigger, die bei Input automatisch ausgelöst werden und diesen überprüfen, bestätigen, ändern, löschen oder wahlweise Referenzdaten einsetzen

- aktualisierbare Ansichten

- umfassendes Transaktionskonzept

- Multiversion Concurrency Control (MVCC) zur effizienten Ausführung gleichzeitiger Datenbankzugriffe

- Integrierte Datentypen für Array, Bereich, UUID, Geolocation usw.

- Native Unterstützung für Dokumentenspeicherung (JSON-Stil), XML und Schlüsselwertspeicherung (Hstore)

- Synchrone und asynchrone Replikation

- Skriptfähig in PL, Perl, Python und mehr

- Volltextsuche

  [6]\[10]

Neben diesen Features und den schon zu Beginn erwähnten vielfältigen Erweiterungsmöglichkeiten, zeichnet sich Postgres auch durch Flexibilität beim Soft- und Hardware Setup aus. Bei UNIX/Linux Systemen ist es bereits enthalten. In Apples macOS Server ist Postgres seit Version 10.7 als Standarddatenbank enthalten. Voraussetzung ist nur eine gmake-Version von min. 3.80. [6] Auch unter Windows kann Postgres installiert werden. Die Software selbst benötigt nur knapp 20MB Speicher.



### Einsatzgebiet und Verbreitung

Postgres ist durch seine Stabilität und Flexibilität für eine Vielzahl von Einsatzgebieten geeignet. Das integrierte Transaktionskonzept und die Unterstützung von MVCC (Multiversion Concurrency Control: Verfahren zur effizienten Ausführung konkurrierender Zugriffe) machen es z.B. eine gute Lösung für Online-Banking-Software. [6]Für Analyseprogramme wie Matlab es ebenfalls gut geeignet. Ein weiteres Feld in dem das System überzeugt ist die Arbeit mit Geodaten. Dies wird in Zusammenarbeit mit der Erweiterung PostGIS erreicht, die eine Vielzahl von Funktion zur Arbeit mit Geodaten anbietet. [6] Die gute Zusammenarbeit mit Frameworks, wie Django, Node.js oder Ruby on Rails wird ebenfalls als als Vorteil genannt. [6] Zuletzt ist noch einmal die Unterstützung von JSON zu betonen, die weitere Anwendungsmöglichkeiten für Postgres schafft. Die Unterstützung von JSON wurde über die letzten Jahre sukzessive ausgebaut und gilt als sehr gut. 
Der Erfolg von Postgres zeigt sich auch im Kreis der großen Nutzer. Wie bereits erwähnt verwendet Apple Postgres als Standard Datenbank in macOS Server. Weitere große Nahmen sind: Instagram, Reddit, Spotify, Twitch, IMBD und die Internationale Raumstation ISS. [7]



<p align="center">
<img width="500" src="img/MongoDB_Logo.png">
</p>
<p align="center">
Abbildung 4: Logo von MongoDB<br>
(Quelle:  https://www.mongodb.com/brand-resources)
</p>