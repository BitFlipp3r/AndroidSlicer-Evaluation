# Android-Slicer Evaluation
Zugang für Evaluatoren des Android-Slicers im Rahmen der Masterthesis "Entwicklung eines Tools zur statischen Code-Analyse der Android-Systemservices auf Grundlage des WALA-Code-Slicings" (Arbeitstitel)

# Vorwort
Die Ziel der Masterarbeit soll es sein, auf der Grundlage des aktuellen Forschungsstandes ein zeitgemäßes Werkzeug zu entwickeln, welches Sicherheitsevaluatoren  bei der statischen Code-Analyse der Android-Systemservices unterstützt. Dafür sollen innerhalb einer grafischen Oberfläche anhand von sinnvoll konfigurierbaren Parametern Code-Slices erzeugt und analysiert werden können. Das Slicing soll dabei auf der Grundlage des WALA-Slicers implementiert werden. Weiterhin soll das entstandene Programm durch Sicherheitsexperten im Rahmen von simulierten Code-Audits evaluiert und getestet werden.

# Voraussetzungen 
Folgende Software wird zum Ausführen des Android-Slicers benötigt:

## Java 8
Da es sich bei der serverseite des Android-Slicers um eine Java-Applikation handelt, wird eine Java Runtime Environment benötigt. Da die WALA-Bibliothek eine Abhängigkeit zu Java 8 erzeugt, muss zudem das JRE in der Version 8.x installiert sein, welches unter dem folgenden Link heruntergeladen werden kann:

    https://java.com/de/download/manual.jsp

>## GraalVM (alternativ)
>Anstelle der JVM kann alternativ auch die GraalVM genutzt werden. GraalVM ist eine polyglotte Alternative für JVM und soll eine bessere Performance für JVM-Sprachen bieten. Die Performance des Android-Slicers konnte dadurch signifikant erhöht werden. Neben der Erstellung von nativen Code für JVM-Sprachen erlaubt es GraalVM auch mit einfachen Compiler-Flags optimierten JIT-Code zu kompilieren (vgl. [GraalVM - JVM Languages Reference](https://www.graalvm.org/docs/reference-manual/languages/jvm/#running-jvm-based-apps)).

>Der Compiler-Parameter `-Dgraal.CompilerConfiguration` stellt dabei verschiedene Optimierungsstufen bereit. Für die kostenfreie Community-Version von GraalVM bietet die Stufe `community` die höchsten Optimierungen. 

>Die Community-Version der GraalVM kann unter

>https://github.com/oracle/graal/releases

>heruntergeladen werden. Danach sollte der Android-Slicer mit der Java-Binary aus dem heruntergeladen Zip und dem `-Dgraal`-Flag gestartet werden. Unter Windows würde das Kommando zum Beispiel folgendermaßen aussehen:

 >`C:\[...]\graalvm-ce-19.1.1\bin\java.exe -jar android-slicer-0.9.3.jar -Dgraal.CompilerConfiguration=community`


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

Ein Löschen der Datenbank ist über die Mongo-Konsole möglich:

```
$ mongo
> use android_slicer_db
> db.dropDatabase()
```

# Programm Starten
Zunächst sollte das Tool zusammen mit den benötigten Ressourcen mittels

    git clone https://github.com/BitFlipp3r/AndroidSlicer-Evaluation.git

heruntergeladen werden.

Der Start des Android-Slicers erfolgt nach einem Wechsel in das Download-Verzeichnis (`cd AndroidSlicer-Evaluation`) über den Konsolenbefehl:

    java -jar android-slicer-0.9.3.jar

Um das Tool mit einem eingebetteten MongoDB-Server zu starten, müssen die folgenden Parameter genutzt werden:

    java -jar android-slicer-0.9.3.jar --spring.profiles.active=prod,embedded-mongo

*Hinweis: Sollten während des Slicings Out-Of-Memory-Fehler auftreten, kann zusätzlich die maximale Speichernutzung (Heap-Size) der JVM mit dem Parameter -Xmx<ZahlM|ZahlG> erhöht werden (z.B. -Xmx4069M oder -Xmx8G)*

Nachdem die Anwendung erfolgreich gestartet wurde, kann die graphische Benutzeroberfläche des Android-Slicers in einem Browser über die URL

    http://localhost:8080

aufgerufen werden.

## Slice Erstellen
![Slice Erstellen](images/ansicht-slice-erstellen.png?raw=true "Slice Erstellen")

Um einen Slice zu erstellen sind die folgenden Schritte notwendig:

1. Auswahl der Android-Version: Anhand der Unterordner im Order "android-resources" werden die verfügbaren API-Level ausgelesen und in einem Dropdown angezeigt.

2. Auswahl des Systemservices: Nach der Auswahl des API-Levels werden anhand eines regulären Ausdrucks alle verfügbaren Systemservices in einem Dropdown angezeigt. Dabei erfolgt die Suche standardmäßig anhand des Ausdrucks `.*ManagerService.java`, welcher in den Einstellungen (Settings) unter dem Key `Android_System_Service_Regex` geändert werden kann.

3. Auswahl der Einstiegsmethoden: Die Einstiegsmethoden dienen als Wurzeln zum Aufbau eines Call-Graphen. Nach der Auswahl des Systemservices werden hier die öffentlichen Methoden des Services, welche in der AIDL-Spezifikation festgelegt sind, in einem Dropdown zur Auswahl gegeben. Zusätzliche Methoden können nach einem Klick in die Textbox eingegeben und mittels der Bestätigung über die Enter-Taste hinzugefügt werden. Neue Methoden werden temporär in die verfügbare Auswahl übernommen, aber nicht permanent gespeichert.

4. Auswahl der Seed-Statements: Die Seed-Statements entsprechen den Sicherheitsabfragen, welche durch das Code-Slicing analysiert werden sollen. Eine Liste mit möglichen Seed-Statements wird in einem Dropdown zur Auswahl gegeben. Diese ist in den Einstellungen (Settings) unter dem Key `Seed_Statements` definiert und kann dort auch geändert bzw. erweitert werden. Zusätzliche Seed-Statements können nach einem Klick in die Textbox eingegeben und mittels der Bestätigung über die Enter-Taste hinzugefügt werden. Neue Seed-Statements werden temporär in die verfügbare Auswahl übernommen, aber nicht permanent gespeichert.

5. Auswahl des CFA-Levels: Im Rahmen der Points-To-Analysen können verschiedene Präzisionsstufen bzgl. der Kontextsensitivität der CFA-Algorithmen ausgewählt werden. Die 0-Level-Analyse entspricht dabei einem n-CFA-Algorithmus mit n = 0, d.h. es wird lediglich eine kontextinsensitive, typbasierte Analyse durchgeführt, wobei Objekte lediglich anhand der Klassennamen unterschieden werden. Variablen werden ebenfalls lediglich anhand ihrer Namen differenziert. Die 0-1-CFA nimmt dagegen eine Call Stack-basierte Unterscheidung der einzelnen Objektinstanzen vor, wobei die Nachverfolgung des Call Stacks auf eine Ebene begrenzt ist. Der Referenzkontext der Variablen unterliegt weiterhin einem globalen Kontext. Sofern der Typ "N_CFA" oder "VANILLA_N_CFA" gewählt wird, muss zusätzlich ein Wert für n (CFA-Level) eingeben werden, wobei die Algorithmen sowohl Variablen anhand von verschiedenen Referenzkontexte als auch Objekte mittels unterschiedlichen Instanzkontexten auf Basis des Call Stacks unterscheiden. Das CFA-Level entspricht dabei der Anzahl an Aufrufermethoden, welche auf dem Call Stack nachverfolgt werden. Algorithmen mit der Bezeichnung "Vanilla" schalten von WALA eingebaute Optimierungen aus (vgl. [UserGuide:PointerAnalysis](http://wala.sourceforge.net/wiki/index.php/UserGuide:PointerAnalysis)). Weiterhin können die Analysen mit objektsensitiven Algorithmen für Container-Objekte verknüpft werden, wie z.B. die 0-1-Container-CFA. Diese differenzieren Methodenaufrufe für Container, beispielsweise `List.add()`, anhand der Allozierungen des entsprechenden Container-Objekts. Ein höheres CFA-Level bedeutet in der Regel eine höhere Genauigkeit, allerdings auch einen größeren Ressourcenaufwand. In der Regel ist die 0-1-CFA gut für das Slicing geeignet.


6. Auswahl der Reflection-Options: Hier kann der Umfang des Call-Graphen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

7. Auswahl der Data-Dependence-Options: Hier kann der Umfang der Datenflussanalysen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

8. Auswahl der Control-Dependence-Options: Hier kann der Umfang der Kontrollflussanalysen eingestellt werden. Die verfügbaren Parameter sind innerhalb des Dropdowns beschrieben. Weiterhin wird bei der Erstellung eines neuen Slices zunächst immer der Standard-Parameter ausgewählt. Dieser kann in den Slicer-Optionen im Administrationsbereich geändert werden, indem der Wert `Default` auf `true` geändert wird. Dabei werden die Default-Werte der anderen Parameter des gleichen Typs auf `false` gesetzt. Zusätzlich können die Beschreibungstexte in den Slicer-Optionen angepasst werden. 

Neben den bereits genannten Parametern kann unter dem Key `Exclusion_List` in den Einstellungen (Settings) zusätzlich die Liste an Klassen geändert bzw. erweitert werden, welche nicht in die Analysen einbezogen werden sollen. Die Liste soll verhindern, dass der Slicing-Algorithmus zu tief in das Java-Framework vordringt und dadurch nicht mehr terminiert.

Nach der Auswahl aller Parameter kann das Slicing durch einen Klick auf den Button `Save` gestartet werden.

## Slice Ansicht
![Slice Ansicht](images/slice_overview.JPG?raw=true "Slice Ansicht")
Unter dem Menüpunkt `Slices` findet sich eine Übersicht der angelegten Analysen. Ein laufender Slicing-Prozess wird durch zwei rotiertende, grüne Pfeile symbolisiert.

Durch einen Klick auf den Button `View` können die Details des Slices eingesehen werden.

![Slice Details](images/ansicht-slice-detail.png?raw=true "Slice Details")

Die Detailansicht gibt eine Übersicht über die gewählten Slicing-Parameter und zeigt den fertigen Slice an. Sofern der Slicing-Prozess noch nicht abgeschlossen wurde, wird das Feld `Slice` noch nicht angezeigt und es erfolgt eine automatische Aktualisierung des Feldes `Log` nach allen 10 Sekunden. 

Der Slice kann dabei mit dem originalen Quelltext verglichen werden. Eine Diff-Ansicht der beiden Code-Dateien kann über den `Show Diff`-Button aktiviert werden.

# Einbindung der Android-Ressourcen
Der Android-Slicer benötigt sowohl zur Auswahl und Anzeige der Android-Services als auch zur Rekonstruktion des Quellcodes während des Slicing-Prozesses die Java-Quelldateien der entsprechenden Klassen. Die Berechnung der Slices mittels WALA erfolgt dagegen auf Binärebene, sodass zusätzlich die kompilierten .class-Dateien innerhalb einer `android.jar`-Datei bereitgestellt werden müssen.  Diese sind für das API-Level 28 (Android 9) im Ordner 

    /android-resources/android-28

bereitgestellt, sodass im Rahmen der Evaluation keine weiteren Schritte notwendig sind.

Der Dateipfad, in dem nach den Java-Quelldateien und der android.jar-Datei gesucht wird, kann in den Optionen (Settings) unter dem Key `Android_Source_Path` bzw. `Android_Platform_Path` eingestellt werden und ist standardmäßig relativ zum Ausführungspfad auf den Order "android-resources" festgelegt. Die Angabe von absoluten Dateipfaden ist ebenfalls möglich. In dem festgelegten Pfad wird zur Laufzeit nach allen "android-XX"-Ordnern gesucht, wobei XX hier das entsprechende API-Level repräsentiert (z.b. android-28 entspricht Android 9, android-17 entspricht Android 4.4)(vgl. [Codenames, Tags, and Build Numbers | Android Open Source Project](https://source.android.com/setup/start/build-numbers)). Innerhalb dieser Ordner sollten die jeweiligen Java-Quelldateien und `android.jar`-Dateien abgelegt sein.

## Bereitstellung weiterer Android-Versionen (optional)
Neben API-Level 28 können weitere Android-Versionen analysiert werden, indem die dafür benötigten Dateien angelegt werden. Für die Rekonstruktion des originalen Quellcodes aus einem Slice werden die LineNumberTable-Attribute, d.h. die Zuordnung der Zeilennummern im Binärcode zu den Zeilennummern im originalen Quellcode, benötigt. Diese sind in den fertig kompilierten Android-Images allerdings nicht mehr vorhanden, sodass die Binärdateien im Rahmen des Android-Buildprozesses extrahiert werden müssen. Dabei werden die kompilierten .class-Dateien als Zwischenerzeugnisse abgelegt.

Um den Android-Quellcode zu kompilieren, muss dieser zunächst heruntergeladen werden:

    https://source.android.com/setup/build/downloading

Danach sollte den Build-Anweisungen unter

    https://source.android.com/setup/build/building

gefolgt werden. Die bereitgestellte Android Version 9 entspricht einem generischen Development-Build (`lunch aosp_arm-eng`). Der gesamte Prozess benötigt eine Maschine mit ausreichend Rechenleistung und Speicher. Hier hat sich bspw. eine AWS-Instanz vom Typ "m5.2xlarge" mit 8 vCPUs und 32 GiB Arbeitsspeicher bewährt. Zudem sollte mindestens 500 GB Festplattenspeicher vorhanden sein. Weiterhin empfiehlt sich ein aktuelles Debian-System, auf dem zusätzlich die folgenden Pakete installiert werden (vgl. [Establishing a Build Environment | Android Open Source Project](https://source.android.com/setup/build/initializing)):

```sudo apt-get install git-core gnupg flex bison gperf build-essential zip curl zlib1g-dev gcc-multilib g++-multilib libc6-dev-i386 lib32ncurses5-dev x11proto-core-dev libx11-dev lib32z-dev libgl1-mesa-dev libxml2-utils xsltproc unzip```

Nach einem erfolgreichen Build können die .class-Dateien der Android-Services ausgehend vom WORKING_DIRECTORY unter 

    out/target/common/obj/JAVA_LIBRARIES/services_intermediates/classes.jar

und die .class-Dateien der Interfaces und .Stub-Klassen unter

    out/soong/.intermediates/frameworks/base/framework/android_common/jarjar/framework.jar

erhalten werden. Um die Jar-Archive zu kombinieren und eine `android.jar`-Datei für den Android-Slicer zu erstellen können z.B. die folgenden Befehle genutzt werden:

```
$ mkdir android_jars
$ (cd android_jars; unzip -uo ../out/target/common/obj/JAVA_LIBRARIES/services_intermediates/classes.jar)
$ (cd android_jars; unzip -uo ../out/soong/.intermediates/frameworks/base/framework/android_common/jarjar/framework.jar)
$ jar -cvf android.jar -C android_jars .
```

Die Java-Quelldateien der Android-Systemservices sind im Ordner 

    frameworks/base/services/core/java/
    frameworks/base/services/restrictions/java/
    frameworks/base/services/accessibility/java/
    frameworks/base/services/devicepolicy/java/
    frameworks/base/services/autofill/java/
    frameworks/base/services/voiceinteraction/java/
    frameworks/base/services/backup/java/
    frameworks/base/services/print/java/

zu finden. Weiterhin können die AIDL-Spezifikationen, welche zur Anzeige der öffentlichen Service-Methoden genutzt werden, in den folgenden Ordnern gefunden werden:

    frameworks/base/core/java/
    frameworks/base/location/java/  (für den LocationManager)
    system/bt/binder/  (für den BluetoothManager)

Es empfiehlt sich daher den Ordner in einem Zip-Archiv

```
(cd frameworks/base/services/core/java/; zip -r ../../../../../android-sources.zip .); (cd frameworks/base/services/restrictions/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/accessibility/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/devicepolicy/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/autofill/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/voiceinteraction/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/backup/java/; zip -ur ../../../../../android-sources.zip .); (cd frameworks/base/services/print/java/; zip -ur ../../../../../android-sources.zip. ); (cd frameworks/base/core/java/; zip -ur ../../../../android-sources.zip .); (cd frameworks/base/location/java/; zip -ur ../../../../android-sources.zip .); (cd system/bt/binder/android/bluetooth/; zip -ur ../../../android-sources.zip .)
```

von der Build-Machine herunterzuladen. Danach sollten die Inhalte des Archivs `android-sources.zip` sowie das `android.jar`-Archiv in dem Ordner "android-XX" abgelegt werden, sodass sich die folgende Dateistruktur ergibt:

![Android-Ressourcen Dateistruktur](images/android_resources.PNG?raw=true "Android-Ressourcen Dateistruktur")

# Changelog
## Version 0.9.5
- Seed Statements können jetzt auch als reguläre Ausdrücke eingegeben werden (z.B. check.* oder enforce.*). Unzulässige Ausdrücke werden entfernt, was mit einer Warnung im Log angezeigt wird. Die Ausdrücke können u.a. [hier](https://www.freeformatter.com/java-regex-tester.html) getestet werden.
- Die Pseudo-Anmeldung mittels admin:admin wurde entfernt. Das Frontend sowie die REST-API benötigen jetzt keine Authentifizierung mehr.
- Ein Fehler wurde behoben, welcher Zeilen, die mit "|" beginnen als Kommentar erkannt hat und diese daher mehrfach im Slice ausgegeben wurden. Zum Beispiel:
    ```
	if (PowerManager.REBOOT_RECOVERY.equals(reason)
         || PowerManager.REBOOT_RECOVERY_UPDATE.equals(reason)) {
         || PowerManager.REBOOT_RECOVERY_UPDATE.equals(reason)) {
    ```

## Version 0.9.4 (benötigt DB-Reset)
- Generelle Programm-Einstellungen (Settings) und Slicing-Parameter (Slicer Options und CFA Options) können nicht mehr vom Endbenutzer erstellt oder gelöscht werden, da diese Funktionen keinen Sinn machen.
- Generelle Programm-Einstellungen (Settings) haben jetzt ein Beschreibungsfeld.
- Relative Pfade (für Quelldateien und die android.jar-Datei) werden jetzt ohne Tilde angegeben.
- Beim Aufruf des Android-Slicers mit "-h" oder "--help" wird nun ein Hinweis bzgl. der verfügbaren Parameter gegeben.
- Sofern nur eine Android-API Version zur Verfügung steht, wird diese jetzt vorausgewählt.

## Version 0.9.3
- Update der JHipster Version auf 6.2 (vgl. [JHipster release v6.2.0](https://www.jhipster.tech/2019/08/01/jhipster-release-6.2.0.html))
- Auswahl der CFA-Algorithmen und -Level im Rahmen der Pointer-Analysen sind jetzt möglich (Achtung: Aufgrund des veränderten Datenbankmodells muss die android_slicer_db im MongoDB-Server gelöscht werden.)
## Version 0.9.2
- Die Quelldatei des System-Services wird jetzt in der Detailansicht mit angezeigt.
- Es wurde ein Diff-Editor hinzugefügt.
- ~~Datenbank-Logs während einer Slicing-Analyse werden jetzt asynchron mit kurzen Wartezeiten geschrieben, um die Last auf der DB zu verringern.~~ (DB Logs sind wieder im Slicer-Thread, da Logs sonst teilweise stark verspätet erscheinen. Die Verringerung der Log-Details stellte sich als sinnvoller heraus, um die DB-Last zu senken.)
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
