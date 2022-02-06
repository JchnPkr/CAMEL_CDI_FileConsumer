#Camel CDI WAS Beispiel

Einfaches Beispiel, welches Dateien einliest und daraus Nachrichten generiert, die in eine Queue gestellt werden.

##Konfiguration

Zur Nutzung dieses Beispiels müssen folgende Resourcen konfiguriert sein

###Auf dem Server
- Connection Factory unter JNDI jms/connection/connectionFactory (konfigurierbar in application.properties)
- Queue unter JNDI jms/camel/queue (konfigurierbar in application.properties)
- URL zu dem Pfad der log4j Datei (in den bindings vorbelegt mit url/camel/fileconsumer/logger)
- URL zu dem Pfad der properties Datei (in den bindings vorbelegt mit url/camel/fileconsumer/properties)

###Auf dem lokalen System
- Dateien mit zu lesendem Inhalt (Beispiele liegen im Projekt unter data, der Pfad ist in den Properties konfigurierbar)
