# Backend CoWorking Project

Dieses Projekt ist ein Backend für eine CoWorkingSpace Applikation mittels Transaktionen und Multi- User-Fähigkeit. 

## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
2. Stelle sicher, dass Docker installiert ist und läuft.
3. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
4. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
5. Öffne das Projekt mit Visual Studio Code.
6. Öffne das Projekt im Entwicklungscontainer.
7. Starte das Projekt mit der Tastenkombination Ctrl + Shift + P suche nach `Quarkus: Debug current Quarkus Project` oder `mvn quarkus:dev `.
8. Probiere die Client-Applikation unter http://localhost:8080 aus.
9. Schaue die API mit swagger auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Testdaten

Die Testdaten befinden sich im import.sql File im verzeichniss: `src/main/resources/import.sql` und werden beim starten des Projekts geladen.

## Mein Github mit dem Projekt

https://github.com/GianIuca/CoWorkingSpace223

## Kommentar zu umsetzung

Es gab viele Logikfehler und kleine Details, die ich übersehen habe und das Projekt in die Länge gezogen haben.
Ich finde, wir hatten zu wenig Zeit für diesen Auftrag und ich konnte nicht alles fertig machen.

## Änderungen

Ich habe das 3. Funktionale Ziel geändert, da ich, während ich die Endpunkte erstellt habe, das Ziel nicht mit meinen Ideen übereinstimmte und ich es anders aufgeschrieben habe als zum Zeitpunkt, wo ich die Idee hatte.
Das neue Ziel ist:
Als Mitglied kann ich zusätzliche technische Mittel erstellen (Monitor, Maus, Tastatur, Kabel etc.), die ich gerne in Zukunft an den Arbeitsplätzen haben möchte.

In der Tabelle Booking habe ich zusätzlich das Attribut status: boolean hinzugefügt, da dieses notwendig ist, um die Buchung an/abzulehnen. Wenn sie null ist, soll sie pending darstellen

Bei der Schnittstellen planung sind auch noch ein paar änderungen passiert, da ich nicht alle brauchte und ein paar mehr brauche wie z.B. `/login/{email}/{password}` oder `/register`

## Login
(http://localhost:8080/auth/login/gianluca.ferrara@gmail.ch/JuveToTheTop69")" -> Admin
http://localhost:8080/auth/login/mattia.loiarro@gmail.com/MilanIschNedGuet420" -> Mitglied
