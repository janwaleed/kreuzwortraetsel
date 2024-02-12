# Kreuzworträtsel Editor - Anleitung & Zukünftige Erweiterungen

Der Kreuzworträtsel Editor ist ein kleines Programm, mit dem man spielend leicht ein Kreuzworträtsel erstellen kann. Es besteht hauptsächlich aus zwei Teilen: Einem Rätselgitter, wo die Rätsel entstehen, und einer Tabelle für die Zuordnung von Buchstaben zu Zahlen.

## Los geht's

### Das Rätselgitter

- Das Gitter ist **8 Zeilen** hoch und **18 Spalten** breit.
- Hier trägst du Zahlen ein, die später durch Buchstaben ersetzt werden.

### Buchstaben-Zahlen-Zuordnung

- Unter dem Rätselgitter findest du eine Tabelle mit **21 Spalten**.
- In der oberen Zeile stehen Zahlen von **1 bis 21**.
- In der unteren Zeile kannst du die Buchstaben eintragen, die diesen Zahlen entsprechen sollen.

### Buchstaben einsetzen

- Hast du alle Zuordnungen gemacht, klickst du einfach auf den **"Abgeben"**-Button.
- Das Programm ersetzt dann automatisch die Zahlen im Rätselgitter durch die von dir zugewiesenen Buchstaben.

## Wie du startest

1. Öffne das Programm und lass dich vom leeren Rätselgitter nicht abschrecken.
2. Füll das Gitter mit Zahlen. Du entscheidest, welche Zahl welchen Buchstaben später repräsentieren soll.
3. Geh zur Zuordnungstabelle und teile jeder Zahl den Buchstaben zu, den du im Rätsel haben möchtest.
4. Wenn du fertig bist, drück auf **"Abgeben"** und sieh zu, wie dein Rätsel zum Leben erwacht.

## Zukünftige Erweiterungen

Unser ursprünglicher Plan war es, eine Wortschatz- oder Wörterbuch-API zu nutzen, um nach spezifischen Wörtern zu suchen, basierend auf ihrer Länge und den vorhandenen Buchstaben. Leider haben wir keine API gefunden, die unseren Anforderungen entspricht. Daher planen wir eine Erweiterung unseres Tools:

- **Wörterbuch-Download**: Wir werden ein umfangreiches Wörterbuch herunterladen.
- **Konvertierung in JSON**: Das Wörterbuch wird in ein JSON-Format konvertiert.
- **Speicherung in MongoDB**: Anschließend speichern wir das konvertierte Wörterbuch in unserer MongoDB.

Diese Erweiterung ermöglicht es uns, eine eigene umfassende Suche nach Wörtern durchzuführen, ohne auf externe APIs angewiesen zu sein. So können wir das Kreuzworträtsel-Tool noch effektiver und unabhängiger gestalten.


