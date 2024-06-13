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
