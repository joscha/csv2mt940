# csv2mt940
Automatically exported from code.google.com/p/csv2mt940

This program can convert a CSV file containing transaction data exported from T-Online Banking 5 into the well-known MT940 (SWIFT) data format.

ATTENTION: The inital source line is from 2004 and ~~probably~~ definitely (!) not ~~completely~~ stable. It has been imported here, because there were a lot of requests to open the source. 

```
Mini-FAQ in german:

1. F:   Wie bekomme ich aus T-Online Banking ein CSV exportiert?
   A:   Ein Konto öffnen, in der Umsatzübersicht unten rechts den
        Button "Exportieren" wählen. Die Umsatzreihenfolge darf
        NICHT vertauscht werden.

2. F:   Bei mir kommt in VR-Networld beim Import der Fehler:
        "-Für das Konto...
        ...wurde aufgrund von Datumskonflikten kein Import durchgeführt"
   A:   Für den Importzeitraum dürfen keine Daten vorhanden sein, am ein-
        fachsten ist es, ein neues (leeres) Konto anzulegen und dann zu
        importieren.

3. F:   Bei mir kommt in VR-Networld beim Import der Fehler:
        "-Das Konto...
        ...konnte nicht berücksichtigt werden, da es nicht gefunden wurde"
   A:   Es muss zuerst das Konto angelegt werden, in welches importiert werden soll.

4. F:   Was muss ich tun, um aus der csv Datei eine mt940 zu machen?
        Finde da keine exe-datei zum installieren oder so was.
   A:   Um das Programm zu starten wird die Java Runtime Edition von Sun Microsystems
        benötigt, hier umsonst herunterzuladen: http://www.java.com/de/. Wenn die JRE
        installiert ist einfach "CsvToMT940.jar" starten oder unter Windows die Datei
        "start.bat" ausführen.
```
