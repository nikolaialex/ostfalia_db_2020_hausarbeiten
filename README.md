# Headline 1
## Headline 2
### Headline 3
#### Headline 4

This is a *bold* text. This is _emphasized_. (Link)[http://google.com]

Hallo Peter

* Sensordaten zur Steuerung von Raketen (SpaceX) 
* Incident Monitoring im eCommerce
* Analyse von Bilddaten 

# Notizen
## Layer und übliche Technologien
### Data Ingestion Layer
Technologien: Kafka

Komponenten/Aufgaben: Sammelt erstmal Daten

### Speed Layer
Technologien: Spark, Flink

Komponenten/Aufgaben: Verarbeitet Daten möglichst in Echtzeit, hält die Daten im RAM vor. 

### Batch Layer
Technologien: Hadoop
Komponenten/Aufgaben: Master Dataset, Data Processing, Fehlerbehebung des Speedlayers

### Serving Layer
Technologien: Cassandra, HBase
Komponenten/Aufgaben: Bereitstellung der aufbereiteten Daten
