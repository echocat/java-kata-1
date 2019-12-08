package org.echocat.kata.java.part1.util;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Set;
import org.echocat.kata.java.part1.model.Book;
import org.junit.Test;

public class BookCsvReaderTest {

  @Test
  public void readAuthors() {
    Set<Book> books = BooksCsvReader.readBooks("/org/echocat/kata/java/part1/data/books.csv");

    assertThat(books).isNotEmpty()
        .extracting("isbn", "title", "description")
        .contains(
            tuple("5554-5545-4518", "Ich helfe dir kochen. Das erfolgreiche Universalkochbuch mit großem Backteil",
                "Auf der Suche nach einem Basiskochbuch steht man heutzutage vor einer Fülle von Alternativen. Es fällt schwer, daraus die für sich passende Mixtur aus Grundlagenwerk und Rezeptesammlung zu finden. Man sollte sich darüber im Klaren sein, welchen Schwerpunkt man setzen möchte oder von welchen Koch- und Backkenntnissen man bereits ausgehen kann."),
            tuple("2145-8548-3325", "Das große GU-Kochbuch Kochen für Kinder",
                "Es beginnt mit... den ersten Löffelchen für Mami, Papi und den Rest der Welt. Ja, und dann? Was Hersteller von Babynahrung können, das ist oft im Handumdrehen auch selbst gemacht, vielleicht sogar gesünder, oftmals frischer. Ältere Babys und Schulkinder will das Kochbuch ansprechen und das tut es auf eine verspielte Art angenehm altersgemäß."),
            tuple("4545-8558-3232", "Schlank im Schlaf ",
                "Schlank im Schlaf klingt wie ein schöner Traum, aber es ist wirklich möglich. Allerdings nicht nach einer Salamipizza zum Abendbrot. Die Grundlagen dieses neuartigen Konzepts sind eine typgerechte Insulin-Trennkost sowie Essen und Sport im Takt der biologischen Uhr. Wie die Bio-Uhr tickt und was auf dem Speiseplan stehen sollte, hängt vom persönlichen Urtyp ab: Nomade oder Ackerbauer?"),
            tuple("1024-5245-8584", "Genial italienisch",
                "Starkoch Jamie Oliver war mit seinem VW-Bus in Italien unterwegs -- und hat allerlei kulinarische Souvenirs mitgebracht. Es lohnt sich, einen Blick in sein Gepäck zu werfen..."),
            tuple("3214-5698-7412", "Das Piratenkochbuch. Ein Spezialitätenkochbuch mit den 150 leckersten Rezepten ",
                "Das Piraten-Kochbuch beweist, dass die Seeräuberkapitäne zwar gefürchtete Haudegen waren, andererseits aber manches Mal mit gehobenenem Geschmacksempfinden ausgestattet. ... Kurzum, ein ideales Buch, um maritime Events kulinarisch zu umrahmen."),
            tuple("1215-4545-5895", "Schuhbecks Kochschule. Kochen lernen mit Alfons Schuhbeck ",
                "Aller Anfang ist leicht! Zumindest, wenn man beim Kochenlernen einen Lehrer wie Alfons Schuhbeck zur Seite hat. Mit seiner Hilfe kann auch der ungeschickteste Anfänger beste Noten für seine Gerichte bekommen. Der Trick, den der vielfach ausgezeichnete Meisterkoch dabei anwendet, lautet visualisieren. Die einzelnen Arbeitsschritte werden auf Farbfotos im Format von ca. 3x4 cm abgebildet. Unter diesen stehen kurz und knapp die Angaben zur Zubereitung. So präsentiert Schuhbecks Kochschule alles bequem auf einen Blick. Und der interessierte Kochneuling kann sich auf die Hauptsache konzentrieren – aufs Kochen. Wie die Speise aussehen soll, zeigt jeweils das Farbfoto auf der linken Seite, auf der auch die Zutaten – dank des geschickten Layouts – ebenfalls sehr übersichtlich aufgelistet sind. Außerdem gibt Schuhbeck prägnante Empfehlungen zu Zutaten und Zubereitung."),
            tuple("2221-5548-8585", "Das Perfekte Dinner. Die besten Rezepte",
                "Sie wollen auch ein perfektes Dinner kreieren? Mit diesem Buch gelingt es Ihnen!"),
            tuple("2215-0012-5487", "O'Reillys Kochbuch für Geeks",
                "Nach landläufiger Meinung leben Geeks von Cola und TK-Pizza, die sie nachts am Rechner geistesabwesend in sich reinschlingen. Soweit das Klischee! Dass aber Kochen viel mit Programmieren zu tun hat, dass es nämlich ähnlich kreativ ist, dass viele Wege zum individuellen Ziel führen und dass manche Rezepte einfach nur abgefahren und -- ja, geekig sind: Das zeigen zwei Köchinnen in diesem Buch.")
        );
  }
}