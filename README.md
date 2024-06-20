# Rezepte

## Rezepte: vor 1. Spring

### Daten:
- **Name des Rezeptes**
- **Inhalte der Speisen**
- **Benötigte Hilfsmittel** 
- **Vorgehen** 
- **Dauer** 
- **Für wieviele Personen berechnet** 

### Funktionen:
Sie können das funktionen in der order Java\RecipeApplication\src\Recipes\Recipes.java
- **Einfügen**
- **Löschen** 
- **Ändern** 
- **Sortieren** 
- **Filtrieren** 
- **Suchen** 

### Nicht funktionale Anforderungen:
- **Java-Applikation für PC** (Linux, Windows, MacOS)
- **Selbsterklärende Oberfläche**, kein Handbuch nötig

### GUI: NetBeans
### DB: Personal, SQLite

# Coding Convention

## Namen

- **Klassen**: PascalCase. Beispiel: `MyClass`
- **Methoden**: camelCase. Beispiel: `myMethod`
- **Variablen**: camelCase. Beispiel: `myVariable`
- **Konstanten**: UPPER_SNAKE_CASE. Beispiel: `MY_CONSTANT`

## Format

- **Einrückung**: 1 tab pro Einrückungsebene
- **Zeilenlänge**: Beschränke die Zeilen auf 80 Zeichen
- **Klammern**: Setze die öffnende Klammer `{` in die gleiche Zeile wie die Anweisung und die schließende Klammer `}` in eine neue Zeile:
  ```java
  if (condition) {
      // Code
  } else {
      // Code
  }

## Abstand

- Verwende Leerzeichen um binäre Operatoren. Beispiel:
  ```java
  int sum = a + b;
- Verwende keine Leerzeichen nach (und vor) in Methoden und Kontrollflussanweisungen. Beispiel:
  ```java
  if (a == b) {
      // Code
  }

## Kommentare

- **Einzeilige Kommentare**: Verwende `//` und schreibe klare und kurze Kommentare
- **Block Kommentare**: Verwende `/* */` für längere Kommentare, die mehrere Zeilen umfassen
- **Javadoc Kommentare**: Verwende `/** **/` um Klassen und Methoden zu dokumentieren



# PROJEKT-DOKUMENTATION

**M-426_LB01**

**Cyrill Augustiny, Leandro Schultze, Noah Luan Lezama, Adrian Jasaroska**

**INF 23A**

**Gruppe Rezepte**

**Donnerstag, 20. Juni 2024**

## Inhalt
1. [Abbildungsverzeichnis](#abbildungsverzeichnis)
2. [Tabellenverzeichnis](#tabellenverzeichnis)
3. [User Cases](#user-cases)
4. [Klassendiagramm](#klassendiagramm)
5. [Styleguide](#styleguide)
6. [Zielgruppen](#zielgruppen)
7. [Persona](#persona)
8. [Benutzerfreundlichkeit](#benutzerfreundlichkeit)
9. [Barrierefreiheit](#barrierefreiheit)
10. [Mockup](#mockup)
11. [Storyboard](#storyboard)
12. [Coding Convention](#coding-convention)
13. [Testkonzepte](#testkonzepte)
14. [Daily Scrum](#daily-scrum)
15. [Quellenverzeichnis](#quellenverzeichnis)

## Abbildungsverzeichnis
- Abbildung 1 Mockup
- Abbildung 2 Storyboard

## Tabellenverzeichnis
- Tabelle 1 Verhältnisse und Grundfarben
- Tabelle 2 Schrift Informationen
- Tabelle 3 Inhaltsverhältnisse
- Tabelle 4 Personas 10-18 Jahre
- Tabelle 5 Personas 19-29 Jahre
- Tabelle 6 Personas 30-49 Jahre
- Tabelle 7 Personas 50+ Jahre
- Tabelle 8 Kriterien der Benutzerfreundlichkeit
- Tabelle 9 Barrierefreiheit
- Tabelle 10 Unit Test Konzept
- Tabelle 11 Usability Testkonzept Erster Durchlauf (GUI)
- Tabelle 12 Usability Test Applikation Zweiter Durchlauf

## User Cases
In diesem "User Cases" können Sie sehen, dass der Benutzer 6 Hauptoptionen hat, und diese Optionen haben andere Kriterien.

## Klassendiagramm
Wir haben 3 Klassen, eine davon ist die "Main", wo wir die Klasse "Recipies" aufrufen, um die Rezepte zu sehen, und auch "Recipies" ist mit der DB verbunden, um auf die notwendigen Daten zuzugreifen.

## Styleguide
### Verhältnisse und Farben der Applikation in [Red, Green, Blue]
- **Grundfarbe**: [255, 255, 255]
- **Akzentfarbe**: [26, 35, 126]
- **Bildschirm Verhältnisse**: 1920x1080 (16:9)

### EroeffnungsFrame
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
  - S = 250x250, F = NULL, C = NULL, I = Logo.png
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
  - S = 223x44, F = Calibri 36 Bold, C = [0, 0, 0], I = “Meine Rezepte”
- **jButton1**: Grösse S, Font F, Color C, Inhalt I
  - S = 205x115, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “Öffnen”
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “EN”
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “FR”
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “DE”

### MainMenu
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
  - S = 250x250, F = NULL, C = NULL, I = Logo.png
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
  - S = 223x44, F = Calibri 36 Bold, C = [0, 0, 0], I = “Meine Rezepte”
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “EN”
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “FR”
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
  - S = 135x100, F = Calibri 24 Bold, C = [255, 255, 255] & [26, 35, 126], I = “DE”
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
  - S = 370x50, F = Calibri 12 Plain

### RezeptAendern
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jButton7**: Grösse S, Font F, Color C, Inhalt I
- **jButton8**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jTextField2**: Grösse S, Font F, Color C, Inhalt I
- **jTextField3**: Grösse S, Font F, Color C, Inhalt I
- **jTextField4**: Grösse S, Font F, Color C, Inhalt I
- **jTextField5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField6**: Grösse S, Font F, Color C, Inhalt I
- **jRadioButton4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel3**: Grösse S, Font F, Color C, Inhalt I
- **jLabel4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel7**: Grösse S, Font F, Color C, Inhalt I
- **jLabel8**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I

### RezeptAendernSuchen
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jLabel3**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I

### RezeptErstellen
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jTextField2**: Grösse S, Font F, Color C, Inhalt I
- **jTextField3**: Grösse S, Font F, Color C, Inhalt I
- **jTextField4**: Grösse S, Font F, Color C, Inhalt I
- **jTextField5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel3**: Grösse S, Font F, Color C, Inhalt I
- **jLabel4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel7**: Grösse S, Font F, Color C, Inhalt I
- **jLabel8**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I
- **jButton12**: Grösse S, Font F, Color C, Inhalt I

### RezeptInfos
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel7**: Grösse S, Font F, Color C, Inhalt I
- **jLabel8**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I
- **jLabel9**: Grösse S, Font F, Color C, Inhalt I
- **jLabel10**: Grösse S, Font F, Color C, Inhalt I
- **jLabel11**: Grösse S, Font F, Color C, Inhalt I
- **jLabel12**: Grösse S, Font F, Color C, Inhalt I
- **jLabel13**: Grösse S, Font F, Color C, Inhalt I
- **jLabel14**: Grösse S, Font F, Color C, Inhalt I

### RezeptLoeschen
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jLabel3**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I

### ZutatenBearbeiten
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jTextField3**: Grösse S, Font F, Color C, Inhalt I
- **jTextField4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel7**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I
- **jComboBox1**: Grösse S, Font F, Color C, Inhalt I
- **jComboBox2**: Grösse S, Font F, Color C, Inhalt I

### ZutatenEinfügen
- **jLabel1**: Grösse S, Font F, Color C, Inhalt I
- **jLabel2**: Grösse S, Font F, Color C, Inhalt I
- **jButton3**: Grösse S, Font F, Color C, Inhalt I
- **jButton4**: Grösse S, Font F, Color C, Inhalt I
- **jButton5**: Grösse S, Font F, Color C, Inhalt I
- **jTextField1**: Grösse S, Font F, Color C, Inhalt I
- **jButton10**: Grösse S, Font F, Color C, Inhalt I
- **jTextField3**: Grösse S, Font F, Color C, Inhalt I
- **jTextField4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel4**: Grösse S, Font F, Color C, Inhalt I
- **jLabel5**: Grösse S, Font F, Color C, Inhalt I
- **jLabel6**: Grösse S, Font F, Color C, Inhalt I
- **jLabel7**: Grösse S, Font F, Color C, Inhalt I
- **jButton11**: Grösse S, Font F, Color C, Inhalt I
- **jComboBox1**: Grösse S, Font F, Color C, Inhalt I
- **jComboBox2**: Grösse S, Font F, Color C, Inhalt I

## Zielgruppen
Diese Applikation ist für Personen, die gerne kochen und backen. Entsprechend sind es statistisch gesehen Frauen ab 30 Jahren. Hauptsächlich werden es Personen nutzen, die eigene Rezepte haben und diese gerne abspeichern wollen, oder gerne neue Rezepte, die sie im Internet finden, abspeichern wollen. Auch für Leute, die das Kochen mit Rezepten lernen wollen, ist diese Applikation geeignet.

Weniger geeignet ist diese Applikation für Leute die ungern Kochen. Junge Kinder sind von der Bedienung ausgeschlossen, da diese nicht kochen werden. Das wären Kinder von 0 bis 10 Jahren.

Ein maximal Alter gibt es nicht, da man auch im hohen Alter noch Rezepte heraussuchen und schreiben können sollte.

Zusammengefasst sind die Zielgruppen jedes Alter ab 10 Jahren. Die wichtigsten sind jedoch Frauen ab 30 Jahren. Unterteilt sind diese in 10 – 18 Jahren, 19 – 29 Jahren, 30 – 50 Jahren und 50+.

## Persona
### 10 – 18 Jahre
- **Leonardo Schulden**: 16, Männlich, Sehschwäche
- **Dieter von Haus**: 10, Männlich, Hörschwäche
- **Tina Toll**: 14, Weiblich, Nur ein linker Arm. Sie kann die Maus nicht bedienen.
- **John Fischer**: 18, Männlich, Kann nicht kochen, will es jedoch lernen.

### 19 – 29 Jahre
- **Jakob Mango**: 27, Männlich, Schlechtes Verständnis für GUI
- **Sophia Goog**: 19, Weiblich, Farbenblind
- **Mike Rawsoft**: 25, Männlich, Autismus
- **Andreas Getea**: 29, Männlich, Kann nur Englisch

### 30 – 49 Jahre
- **June Sommer**: 43, Weiblich, Legasthenie
- **Maurice Müller**: 30, Non binary, Blind
- **Bob Baumeister**: 47, Männlich, Rollstuhl
- **Siegrid Sieg**: 36, Weiblich

### 50+ Jahre
- **Mario Kemptner**: 61, Männlich, Vegan
- **Luigi Kemptner**: 70, Männlich, Mag nur bestimmte Zutaten
- **Jürgen Schulz**: 107, Männlich, Sehr alt
- **Steve Mienenkraft**: 50, Männlich, Er ist ein Koch in einer großen Familie. Muss für viele Personen kochen.

## Benutzerfreundlichkeit
- **Kriterium 1**: Die Farben müssen so gewählt sein, dass es angenehm für den Benutzer ist. Es muss außerdem alles erkennbar sein. (Kein Blau auf Hellgrün etc.)
- **Kriterium 2**: Die Schriftart muss passend sein, damit der Benutzer alles lesen kann.
- **Kriterium 3**: Es muss klar sein, was die jeweiligen Elemente machen. Buttons müssen insbesondere beschriftet sein.
- **Kriterium 4**: Die Elemente müssen außerdem groß genug sein.
- **Kriterium 5**: Es muss klar sein, wie man zu den jeweiligen Seiten kommt.
- **Kriterium 6**: Es muss klar sein, wie man etwas macht. Zum Beispiel muss ein Benutzer schnell sehen, wie man ein neues Rezept erstellt.
- **Kriterium 7**: Ladezeiten müssen möglichst schnell sein.
- **Kriterium 8**: Die App sollte sich an verschiedenen Bildschirmgrößen anpassen.

## Barrierefreiheit
- **Sehschwäche / Blind**: Tooltips müssen gesetzt sein, damit diese vorgelesen werden können.
- **Person kann keine Maus bedienen**: Die Applikation muss mit einer Tastatur bedienbar sein (Tabulator, Enter, etc.).
- **Schlechtes Verständnis für GUI**: Das GUI muss klar und verständlich sein. Jeder muss verstehen, wie er etwas macht.
- **Farbenblind**: Farben, die einfach zu unterscheiden sind. Hohe Kontraste.
- **Autismus**: Keine ablenkenden Sachen in der Applikation.
- **Kann nur Englisch**: Die Sprache muss einstellbar sein.
- **Legasthenie**: Die Applikation braucht eine Rechtschreibkorrektur.
- **Vegan / Laktoseintolerant / Isst nur bestimme Sachen**: Die Rezepte haben einen Filter für Zutaten.

## Mockup
![Mockup](mockup.png)

## Storyboard
![Storyboard](storyboard.png)

## Coding Convention
- **Namen**
  - **Klassen**: PascalCase. Beispiel: „MyClass“
  - **Methoden**: camelCase: Beispiel: „myMethod“
  - **Variablen**: camelCase: Beispiel: “myVariable”
  - **Konstanten**: UPPER_SNAKE_CASE: Beispiel: “MY_CONSTANT”

- **Format**
  - Einrückung: 1 Tab pro Einrückungsebene
  - Zeilenlänge: Beschränke die Zeilen auf 80 Zeichen
  - Klammern: Setzen die öffnende klammer «{» in die gleiche Zeile wie die Anweisung und die schließende klammer «}» in eine neue Zeile:
    ```java
    if (condition) {
        // Code
    } else {
        // Code
    }
    ```

- **Abstand**
  - Verwende Leerzeichen, um binäre Operatoren. Beispiel:
    ```java
    int sum = a + b;
    ```
  - Verwende keine Leerzeichen nach (und vor) in Methoden und Kontrollflussanweisungen Beispiel:
    ```java
    if (a == b) {
        // Code
    }
    ```

- **Kommentare**
  - Einzeilige Kommentare: Verwende «//» und schreibe klare und kurze Kommentare
  - Block Kommentare: Verwende «/* */» für längere Kommentare, die mehrere Zeilen umfassen
  - Javadoc Kommentare: Verwende «/** **/» um Klassen und Methoden zu dokumentieren

## Testkonzepte
### Unit-Testkonzept
| Nummer | Funktion | Daten | Erwartetes Resultat |
|--------|----------|-------|---------------------|
| 1 | insert() | Name: Kuchen<br>Beschreibung: ein leckerer Kuchen für die ganze Familie.<br>Zutaten: Milch, Mehl, Schokolade<br>Dauer: 10<br>Personen: 5 | True |
| 2 | insert() | Name: Spaghetti<br>Beschreibung: tolle Spaghetti für einen Italiener wie Jacopo.<br>Zutaten: Spaghetti, Tomate, Käse<br>Dauer: Jacopo<br>Personen: 3 | False |
| 3 | insert() | Name: 5pa93tti<br>Beschreibung: ToLLe 5pagetti 7ür einen 1taliener #*ie ()acopo.<br>Zutaten: 5pagetti, Tomate, Käse<br>Dauer: 5<br>Personen: 3 | True |
| 4 | delete() | ID: 7 | True |
| 5 | delete() | ID: Spaghetti | False |
| 6 | delete() | ID: 7183753 | True |
| 7 | replace() | ID: 1<br>Name: Hamburger<br>Beschreibung: ein perfekter Hamburger zum alleine essen<br>Zutaten: Tomate, Fleisch, Zwiebel<br>Dauer: 20<br>Personen: 1 | True |
| 8 | replace() | ID: 2<br>Name: Pizza<br>Beschreibung: Eine Pizza mit Tomaten und Käse<br>Zutaten: Tomate, Käse und Teig<br>Dauer: Tomate und Käse<br>Personen: Pizza | False |
| 9 | replace() | ID: Pizza<br>Name: Taco<br>Beschreibung: Ein echter Taco, kein Texmex<br>Zutaten: Tomate, Zwiebel und Fleisch<br>Dauer: 100<br>Personen: 2 | False |
| 10 | filter() | Tomate | True |
| 11 | filter() | NOAH | Data Not found |
| 12 | filter() | Käse | |
| 13 | search() | Name: Spaghetti | True |
| 14 | search() | Name: Null | False |
| 15 | search() | Name: Undefined | False |
| 16 | search() | Name: #sfi)ü!21_u | True |
| 17 | sort() | Kriterium: Name<br>Aufsteigend: Ja | True |
| 18 | sort() | Kriterium: Name<br>Aufsteigend: nein | True |
| 19 | sort() | Kriterium: nAme<br>Aufsteigend: nein | True |
| 20 | sort() | Kriterium: Namen<br>Aufsteigend: ja | false |
| 21 | sort() | Kriterium: ID<br>Aufsteigend: ja | true |
| 22 | sort() | Kriterium: ID<br>Aufsteigend: Null | false |

### Usability-Testkonzept Durchlauf 1, GUI
Gefundene Bugs müssen in einem Protokoll aufgeschrieben werden.

| Nummer | Test | Erwartetes Resultat |
|--------|------|---------------------|
| 1 | Ein neues Rezept einfügen | Der Benutzer sollte in kurzer Zeit den Button finden, um ein Rezept einzufügen. |
| 2 | Nach dem Rezept „Pasta“ suchen. | Der Benutzer sollte die Suchleiste finden und verstehen, dass er nach dem Namen suchen muss. |
| 3 | Nach den Zutaten „Ananas“ filtern. | Der Benutzer sollte den schnell sehen, wie er filtern kann. |
| 4 | Ein Rezept ändern. | Der Benutzer sollte die Seite zum Ändern der Befehle schnell finden. |
| 5 | Ein Rezept löschen. | Der Benutzer sollte schnell herausfinden, wie er ein Rezept löscht. |
| 6 | Die Liste der Rezepte sortieren | Der Benutzer sollte herausfinden, wie er die Rezepte sortieren kann. |

### Usability-Testkonzept Durchlauf 2, funktional
Gefundene Bugs müssen in einem Protokoll aufgeschrieben werden.

| Nummer | Test | Erwartetes Resultat |
|--------|------|---------------------|
| 1 | Ein neues Rezept einfügen mit dem Namen „Pizza“, der Beschreibung „Guter Pizzateig und Beleg“, den Zutaten, „100 g Mehl, Schinken und ein Würfel Hefe“, der Dauer von „1 Stunde“ und mit der Anzahl einer Person. | Der Nutzer sollte das ein Feedback bekommen, dass das Rezept hinzugefügt wurde. |
| 2 | Mit dem Namen des Rezeptes das Rezept suchen. | Der Nutzer sollte das Rezept zurückbekommen. |
| 3 | Nach den Zutaten „Schinken“ filtern | Der Nutzer sollte das Rezept zurückbekommen, weil im Rezept Schinken enthalten sind. |
| 4 | Die Anzahl der Person auf zwei Personen ändern. | Der Nutzer sollte ein Feedback zurückbekommen, dass das Rezept geändert wurde. |
| 5 | Das Rezept löschen. | Der Nutzer sollte ein Feedback zurückbekommen, dass das Rezept gelöscht wurde. |
| 6 | Nach dem Rezept „Curry Chicken“ suchen. | Dem Benutzer muss klar sein, dass das Rezept nicht existiert. |
| 7 | Die Liste der Rezepte alphabetisch aufwärts sortieren. | Die Liste sollte nun alphabetisch sortiert sein. |

### Tests
Usability-Test Durchlauf 1, GUI
Konnten die Aufgaben einfach erledigt werden? (Nicht funktional)

| Nummer | Frage | Resultat |
|--------|-------|---------|
| 1 | Ein neues Rezept einfügen | JA |
| 2 | Nach dem Rezept „Pasta“ suchen. | JA |
| 3 | Nach den Zutaten „Ananas“ filtern | JA |
| 4 | Ein Rezept ändern. | JA |
| 5 | Ein Rezept löschen | JA |
| 6 | Die Liste der Rezepte sortieren | JA |

## Daily Scrum
### Erster Daily SCRUM
- **Stand**: Allgemein haben wir als Gruppe einen guten Stand, vieles aus dem Sprint Backlog wurde bereits abgeschlossen.
- **Erfolge**:
  - Gutes Tempo
  - Viele Tasks wurden bereits erledigt
  - Konzeptionierung
  - Dokumentation beinhaltet bereits viele Tasks aus dem Sprint Backlog
- **Probleme**:
  - Github (Unklarheiten beim Commit)
  - Es wurden wichtige Elemente im Storyboard vergessen.
  - Daher viele Korrekturen
- **Lösungen**:
  - Hilfe des Teams
  - Internet (Quellenangaben)
- **Bemerkungen**: Keine
- **Teamgefühl**:
  - Gutes Teamgefühl / Teamgeist
  - Gute Kommunikation
  - Gute Zusammenarbeit
- **Unklarheiten**:
  - Wann werden die Usability-Tests abgeschlossen sein? Und wie?
  - Nächste Schritte, Funktionen?
  - Test-Konzepte?

### Zweiter Daily SCRUM
- **Stand**: Das Tempo ist zum Teil langsamer als beim ersten Daily SCRUM, jedenfalls nicht zu langsam (im Zusammenhang mit Problemen) Natürlich auch weil die anspruchsvollere und zeitaufwändigere Tasks abgeschlossen werden müssen sowie das GUI etc.
- **Erfolge**:
  - DB-Treiber funktioniert
  - Testkonzept abgeschlossen
  - Noah hat bereits alle seine Tasks abgeschlossen (Ist in der Lage anderen Gruppenmitgliedern zu helfen)
- **Probleme**:
  - DB-Treiber
  - Unklarheiten bei Usability Tests, „Was wird getestet?“
  - Vergessene Elemente im Mockup/Storyboard
- **Lösungen**:
  - DB-Treiber → Recherche (Quellenangaben)
- **Bemerkungen**: Keine
- **Teamgefühl**:
  - Gute Zusammenarbeit
  - Offen
  - Gute Kommunikation
  - Arbeitsklima ist gemütlich
- **Unklarheiten**:
  - Neuer Kundenwunsch → Listen Ausgeben?
  - Präsentation: Narrator? → Noah?

### Dritter Daily SCRUM
- **Stand**: Adrian ist fertig mit dem GUI (Somit fertig mit allen Tasks) und Noah ist auch bereits fertig mit seinen Tasks. DB ist In-Progress → bald fertig
- **Erfolge**: SELECT funktioniert und die Navigation und Sprachfunktionen funktionieren im GUI
- **Probleme**: JOINS / SELECT mit Java hat Probleme herbeigerufen
- **Lösungen**: Sehr viel Experimentieren und SQL Validator
- **Bemerkungen**: Keine
- **Teamgefühl**:
  - Gute Zusammenarbeit
  - Gute Kommunikation
  - Noah ist glücklich mit der Gruppe, → Lieblingsgruppe
  - Kommunikation von oben (SCRUM MASTER / PRODUCT OWNER) nach Unten (SCRUM DEVELOPER) ist Perfekt
  - Alle sind konzentriert, respektvoll und Ruhig
- **Unklarheiten**: Keine

### Vierter Daily SCRUM
- **Stand**: (Text fehlt)
- **Erfolge**: (Text fehlt)
- **Probleme**: (Text fehlt)
- **Lösungen**: (Text fehlt)
- **Bemerkungen**: (Text fehlt)
- **Teamgefühl**: (Text fehlt)
- **Unklarheiten**: (Text fehlt)

## Quellenverzeichnis
1. [https://www.crossvertise.com/printwerbung/kochen-und-geniessen](https://www.crossvertise.com/printwerbung/kochen-und-geniessen)
2. [https://www.versacommerce.de/glossar/app-usability](https://www.versacommerce.de/glossar/app-usability)
3. [https://excalidraw.com](https://excalidraw.com)
4. [https://www.javatpoint.com/java-naming-conventions](https://www.javatpoint.com/java-naming-conventions)
5. [https://stackoverflow.com/questions/20133119/i-need-an-array-or-arraylist-that-accepts-objects-of-any-type](https://stackoverflow.com/questions/20133119/i-need-an-array-or-arraylist-that-accepts-objects-of-any-type)
6. [https://app.diagrams.net](https://app.diagrams.net)
7. [https://www.sqlitetutorial.net/sqlite-java/create-database/](https://www.sqlitetutorial.net/sqlite-java/create-database/)
8. [https://www.sqlitetutorial.net/sqlite-java/create-table/](https://www.sqlitetutorial.net/sqlite-java/create-table/)
9. [https://www.sqlitetutorial.net/sqlite-java/select/](https://www.sqlitetutorial.net/sqlite-java/select/)
10. [https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/](https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/)
11. [https://stackoverflow.com/questions/16725377/unable-to-connect-to-database-no-suitable-driver-found](https://stackoverflow.com/questions/16725377/unable-to-connect-to-database-no-suitable-driver-found)
12. [https://github.com/xerial/sqlite-jdbc/issues/597](https://github.com/xerial/sqlite-jdbc/issues/597)
13. [https://github.com/xerial/sqlite-jdbc/releases/tag/3.46.0.0](https://github.com/xerial/sqlite-jdbc/releases/tag/3.46.0.0)
14. [https://www.geeksforgeeks.org/how-to-insert-multiple-rows-in-sqlite/](https://www.geeksforgeeks.org/how-to-insert-multiple-rows-in-sqlite/)
15. [https://stackoverflow.com/questions/7905859/is-there-auto-increment-in-sqlite](https://stackoverflow.com/questions/7905859/is-there-auto-increment-in-sqlite)
16. [https://stackoverflow.com/questions/27041163/sql-error-or-missing-database-near-syntax-error](https://stackoverflow.com/questions/27041163/sql-error-or-missing-database-near-syntax-error)
17. [https://youtu.be/TQu11h2-1dw?t=322](https://youtu.be/TQu11h2-1dw?t=322)
18. [https://netbeans.apache.org/front/main/download/nb22/](https://netbeans.apache.org/front/main/download/nb22/)
19. [https://stackoverflow.com/questions/32542273/java-how-do-i-rerefrence-sqlite-database-in-the-same-folder-with-my-project-file](https://stackoverflow.com/questions/32542273/java-how-do-i-rerefrence-sqlite-database-in-the-same-folder-with-my-project-file)
