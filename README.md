# Android-Slicer Evaluation
Zugang für Evaluatoren des Android-Slicers im Rahmen der Masterthesis "Entwicklung eines Tools zur statischen Code-Analyse der Android-Systemservices auf Grundlage des WALA-Code-Slicings" (Arbeitstitel)

# Vorwort
Die Ziel der Masterarbeit soll es sein, auf der Grundlage des aktuellen Forschungsstandes ein zeitgemäßes Werkzeug zu entwickeln, welches Sicherheitsevaluatoren  bei der statischen Code-Analyse der Android-Systemservices unterstützt. Dafür sollen innerhalb einer grafischen Oberfläche anhand von sinnvoll konfigurierbaren Parametern Code-Slices erzeugt und analysiert werden können. Das Slicing soll dabei auf der Grundlage des WALA-Slicers implementiert werden. Weiterhin soll das entstandene Programm durch Sicherheitsexperten im Rahmen von simulierten Code-Audits evaluiert und getestet werden.

# Voraussetzungen 
Folgende Software wird zum Ausführen des Android-Slicers benötigt:

## Java 8
Da es sich bei der serverseite des Android-Slicers um eine Java-Applikation handelt, wird eine Java Runtime Environment benötigt. Da die WALA-Bibliothek eine Abhängigkeit zu Java 8 erzeugt, muss zudem das JRE in der Version 8.x installiert sein, welches unter dem folgenden Link heruntergeladen werden kann:

    https://java.com/de/download/manual.jsp

## Web-Browser
Die graphische Benutzeroberfläche des Android-Slicers besteht aus einer Angular-Anwendung und kann daher mit jedem aktuellen Web-Browser bedient werden.

## MongoDB
Der Android-Slicer nutzt eine MongoDB-Datenbank. Beim Start der Applikation wird eine Verbindung zu einem lokalen MongoDB-Server auf Port 27017 (Standardport) gesucht. Zum Starten des Servers sind folgende Schritte notwendig: 

*Alternativ kann der Android-Slicer zu Testzwecken auch mit einem eingebetteten MongoDB-Server gestartet werden (siehe Abschnitt "Programm Starten"), wobei die Daten nach dem Beenden der Anwendung verloren sind.*

1. Download des MongoDB-Servers von 

        https://www.mongodb.com/download-center/community

2.  Installation für die entsprechende Platform gemäß

        https://docs.mongodb.com/manual/administration/install-community/

    Der MongoDB-Compass (GUI für MongoDB) wird dabei nicht benötigt und muss daher nicht mit installiert werden.

3. Nachdem die MongoDB-Ausführdateien (z.B. mongod.exe) installiert wurden, muss der Datenbank-Ordner erzeugt werden. Unter Windows wird dieser z.B. unter C:\data\db erwartet. Danach kann der MongoDB-Server über den Konsolenbefehl:

        mongod

    gestartet werden. Alternativ kann der Server auch als Systemdienst installiert werden, sodass dieser beim Start des Systems automatisch hochgefahren wird

        mongod --install

    Sofern der Datenbank-Ordner nicht im Standardverzeichnis liegt, kann der entpsrechende Pfad über den '--dbpath parameter' angegeben werden, wie z.B.

        mongod --dbpath=C:\folder\to\databases\data\db

*Hinweis:* Da MongoDB seit der Version 3.4 keine 32-Bit Systeme mehr unterstützt, wird zum Betrieb des Android-Slicers weiterhin ein 64-Bit Betriebssystem benötigt. Andernfalls muss eine ältere Version der Datenbank installiert werden (vgl. [How to install MongoDB on Windows 7 32 bit? - Stack Overflow](https://stackoverflow.com/questions/51811140/how-to-install-mongodb-on-windows-7-32-bit)).

# Programm Starten
Zunächst sollte das Tool zusammen mit den benötigten Ressourcen mittels

    git clone https://github.com/BitFlipp3r/AndroidSlicer-Evaluation.git

heruntergeladen werden.

Der Start des Android-Slicers erfolgt nach einem Wechsel in das Download-Verzeichnis (`cd AndroidSlicer-Evaluation`) über den Konsolenbefehl:

    java -jar android-slicer-0.9.2.jar

Um das Tool mit einem eingebetteten MongoDB-Server zu starten, müssen die folgenden Parameter genutzt werden:

    java -jar android-slicer-0.9.2.jar --spring.profiles.active=prod,embedded-mongo

*Hinweis: Sollten während des Slicings Out-Of-Memory-Fehler auftreten, kann zusätzlich die maximale Speichernutzung (Heap-Size) der JVM mit dem Parameter -Xmx<ZahlM|ZahlG> erhöht werden (z.B. -Xmx4069M oder -Xmx8G)*

Nachdem die Anwendung erfolgreich gestartet wurde, kann die graphische Benutzeroberfläche des Android-Slicers in einem Browser über die URL

    http://localhost:8080

aufgerufen werden. Eine Anmeldung ist mit dem Benutzerkonto `admin:admin` möglich. Das Benutzerkonto dient dabei keinen sicherheitskritischen Aspekten, sondern lediglich dem Session-Management und als Platzhalter für eine eventuell später ausgebaute Benutzerverwaltung. Daher wurde auf das Anlegen von personenbezogenen Benutzerkonten mit ausreichend starken Passwörtern verzichtet.

## Slice Erstellen
![Slice Erstellen](images/create_slice.JPG?raw=true "Slice Erstellen")

Um einen Slice zu erstellen sind die folgenden Schritte notwendig:

1. Auswahl der Android-Version: Anhand der Unterordner im Order "android-resources" werden die verfügbaren API-Level ausgelesen und in einem Dropdown angezeigt.

2. Auswahl des Systemservices: Nach der Auswahl des API-Levels werden anhand eines regulären Ausdrucks alle verfügbaren Systemservices in einem Dropdown angezeigt. Dabei erfolgt die Suche standardmäßig anhand des Ausdrucks `.*ManagerService.java`, welcher in den Einstellungen (Settings) unter dem Key `Android_System_Service_Regex` geändert werden kann.

3. Auswahl der Einstiegsmethoden: Die Einstiegsmethoden dienen als Wurzeln zum Aufbau eines Call-Graphen. Nach der Auswahl des Systemservices werden hier die öffentlichen Methoden des Services, welche in der AIDL-Spezifikation festgelegt sind, in einem Dropdown zur Auswahl gegeben. Zusätzliche Methoden können nach einem Klick in die Textbox eingegeben und mittels der Bestätigung über die Enter-Taste hinzugefügt werden. Neue Methoden werden temporär in die verfügbare Auswahl übernommen, aber nicht permanent gespeichert.

4. Auswahl der Seed-Statements: Die Seed-Statements entsprechen den Sicherheitsabfragen, welche durch das Code-Slicing analysiert werden sollen. Eine Liste mit möglichen Seed-Statements wird in einem Dropdown zur Auswahl gegeben. Diese ist in den Einstellungen (Settings) unter dem Key `Seed_Statements` definiert und kann dort auch geändert bzw. erweitert werden. Zusätzliche Seed-Statements können nach einem Klick in die Textbox eingegeben und mittels der Bestätigung über die Enter-Taste hinzugefügt werden. Neue Seed-Statements werden temporär in die verfügbare Auswahl übernommen, aber nicht permanent gespeichert.

5. Auswahl der Reflection-Options: Hier kann der Umfang des Call-Graphen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

6. Auswahl der Data-Dependence-Options: Hier kann der Umfang der Datenflussanalysen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

7. Auswahl der Control-Dependence-Options: Hier kann der Umfang der Kontrollflussanalysen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

Neben den bereits genannten Parametern kann unter dem Key `Exclusion_List` in den Einstellungen (Settings) zusätzlich die Liste an Klassen geändert bzw. erweitert werden, welche nicht in die Analysen einbezogen werden sollen. Die Liste soll verhindern, dass der Slicing-Algorithmus zu tief in das Java-Framework vordringt und dadurch nicht mehr terminiert.

Nach der Auswahl aller Parameter kann das Slicing durch einen Klick auf den Button `Save` gestartet werden.

## Slice Ansicht
![Slice Ansicht](images/slice_overview.JPG?raw=true "Slice Ansicht")
Unter dem Menüpunkt `Slices` findet sich eine Übersicht der angelegten Analysen. Ein laufender Slicing-Prozess wird durch zwei rotiertende, grüne Pfeile symbolisiert.

Durch einen Klick auf den Button `View` können die Details des Slices eingesehen werden.

![Slice Details](images/slice_detail.JPG?raw=true "Slice Details")

Die Detailansicht gibt eine Übersicht über die gewählten Slicing-Parameter und zeigt den fertigen Slice an. Sofern der Slicing-Prozess noch nicht abgeschlossen wurde, wird das Feld `Slice` noch nicht angezeigt und es erfolgt eine automatische Aktualisierung des Feldes `Log` nach allen 10 Sekunden.

# Einbindung der Android-Ressourcen
Der Android-Slicer benötigt sowohl zur Auswahl und Anzeige der Android-Services als auch zur Rekonstruktion des Quellcodes während des Slicing-Prozesses die Java-Quelldateien der entsprechenden Klassen. Die Berechnung der Slices mittels WALA erfolgt dagegen auf Binärebene, sodass zusätzlich die kompilierten .class-Dateien innerhalb einer `android.jar`-Datei bereitgestellt werden müssen.  Diese sind für das API-Level 28 (Android 9) im Ordner 

    /android-resources/android-29

bereitgestellt, sodass im Rahmen der Evaluation keine weiteren Schritte notwendig sind.

Der Dateipfad, in dem nach den Java-Quelldateien und der android.jar-Datei gesucht wird, kann in den Optionen (Settings) unter dem Key `Android_Source_Path` bzw. `Android_Platform_Path` eingestellt werden und ist standardmäßig relativ zum Ausführungspfad auf den Order "android-resources" (~/android-resources/) festgelegt. Sofern der angegebene Pfad mit einer Tilde beginnt, wird dieser als relativer Pfad interpretiert. Die Angabe von absoluten Dateipfaden ist ebenfalls möglich. In dem festgelegten Pfad wird zur Laufzeit nach allen "android-XX"-Ordnern gesucht, wobei XX hier das entsprechende API-Level repräsentiert (z.b. android-28 entspricht Android 9, android-17 entspricht Android 4.4)(vgl. [Codenames, Tags, and Build Numbers | Android Open Source Project](https://source.android.com/setup/start/build-numbers)). Innerhalb dieser Ordner sollten die jeweiligen Java-Quelldateien und `android.jar`-Dateien abgelegt sein.

## Bereitstellung weiterer Android-Versionen (optional)
Neben API-Level 29 können weitere Android-Versionen analysiert werden, indem die dafür benötigten Dateien angelegt werden. Für die Rekonstruktion des originalen Quellcodes aus einem Slice werden die LineNumberTable-Attribute, d.h. die Zuordnung der Zeilennummern im Binärcode zu den Zeilennummern im originalen Quellcode, benötigt. Diese sind in den fertig kompilierten Android-Images allerdings nicht mehr vorhanden, sodass die Binärdateien im Rahmen des Android-Buildprozesses extrahiert werden müssen. Dabei werden die kompilierten .class-Dateien als Zwischenerzeugnisse abgelegt.

Um den Android-Quellcode zu kompilieren, muss dieser zunächst heruntergeladen werden:

    https://source.android.com/setup/build/downloading

Danach sollte den Build-Anweisungen unter

    https://source.android.com/setup/build/building

gefolgt werden. Die bereitgestellte Android Version 9 entspricht einem generischen Development-Build (`lunch aosp_arm-eng`). Der gesamte Prozess benötigt eine Maschine mit ausreichend Rechenleistung und Speicher. Hier hat sich bspw. eine AWS-Instanz vom Typ "m5.2xlarge" mit 8 vCPUs und 32 GiB Arbeitsspeicher bewährt. Zudem sollte mindestens 500 GB Festplattenspeicher vorhanden sein. Weiterhin empfiehlt sich ein aktuelles Debian-System, auf dem zusätzlich die folgenden Pakete installiert werden (vgl. [Establishing a Build Environment | Android Open Source Project](https://source.android.com/setup/build/initializing)):

```sudo apt-get install git-core gnupg flex bison gperf build-essential zip curl zlib1g-dev gcc-multilib g++-multilib libc6-dev-i386 lib32ncurses5-dev x11proto-core-dev libx11-dev lib32z-dev libgl1-mesa-dev libxml2-utils xsltproc unzip```

Nach einem erfolgreichen Build können die .class-Dateien der Android-Services ausgehend vom WORKING_DIRECTORY unter 

    out/target/common/obj/JAVA_LIBRARIES/services_intermediates/classes.jar

und die .class-Dateien der Interfaces und .Stub-Klassen unter

    out/soong\.intermediates\frameworks\base\framework\android_common\jarjar\framework.jar

erhalten werden. Um die Jar-Archive zu kombinieren und eine `android.jar`-Datei für den Android-Slicer zu erstellen können z.B. die folgenden Befehle genutzt werden:

```
$ mkdir android_jars
$ (cd intermediate_jars; unzip -uo ../*.jar)
$ jar -cvf android.jar -C android_jars .
```

Die Java-Quelldateien der Android-Systemservices sind im Ordner 

    frameworks/base/services/core/java/

zu finden. Weiterhin können die AIDL-Spezifikationen, welche zur Anzeige der öffentlichen Service-Methoden genutzt werden, in den folgenden Ordnern gefunden werden:

    frameworks/base/core/java/
    frameworks/base/location/java/

Es empfiehlt sich daher den Ordner in einem Zip-Archiv

```
zip -r sources.zip frameworks/base/services/core/java/ frameworks/base/core/java/ frameworks/base/location/java/
```

von der Build-Machine herunterzuladen. Danach sollten alle Ordner und Dateien ausgehend von den oben genannten Pfaden sowie das `android.jar`-Archiv in dem Ordner "android-XX" abgelegt werden, sodass sich die folgende Dateistruktur ergibt:

![Android-Ressourcen Dateistruktur](images/android_resources.PNG?raw=true "Android-Ressourcen Dateistruktur")

# Changelog
## Version 0.9.2
- Die Quelldatei des System-Services wird jetzt in der Detailansicht mit angezeigt.
- Es wurde ein Diff-Editor hinzugefügt.
- Datenbank-Logs während einer Slicing-Analyse werden jetzt asynchron mit kurzen Wartezeiten geschrieben, um die Last auf der DB zu verringern.
- Die Log-Nachrichten für Slice-Statements, welche nicht vom Typ NORMAL sind, wurden entfernt.
## Version 0.9.1
- Fehlende Quelldateien (wie z.B. IBluetToothManager.aidl) zum Ressourcen-Ordner hinzugefügt.
- Return-Statements für Blöcke, in denen WALA ein Statement identifiziert hat, werden bei der Rekonstruktion des Quellcodes jetzt immer in den Slice hinzugefügt. Z.b. wird
    ```
    if (isBluetoothDisallowed()) {
    }
    ```
    damit zu
    ```
    if (isBluetoothDisallowed()) {
        return false;
    }
    ```
   obwohl WALA nur die Zeile `if (isBluetoothDisallowed())` ausgegeben hat.
- Null-Pointer-Exception für Log-Nachricht behoben
- Thread-Pool-Größe angepasst
- Priorität des Slicing-Threads erhöht (Thread.MAX_PRIORITY)
- Log-Nachrichten angepasst für besseres Verständnis
- Die Menüpunkte "Audit" und "Logs" wurden im Frontend entfernt, da für diesen Prototypen die Server-Endpunkte nicht gemäß dem JHipster-Standard eingerichtet sind.
- Fehlermeldungen bzgl. nicht gefunden Quelldateien geben jetzt den durchsuchten Pfad mit an.
- Alle Backslashes in Ordner-Pfaden wurden mit File.Seperator ersetzt, um eine größere Plattformunabhängigkeit zu gewährleisten.
- Fehlende Datenflussoptionen wurden hinzugefügt.
