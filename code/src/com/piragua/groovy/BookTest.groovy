package com.piragua.groovy

public class BookTest extends GroovyTestCase {
    Book book
    Chapter grails, groovy, why

    void setUp() {
        book = new Book(title: "Groovy Jam", subTitle:"Jammin",
                authorName: "Mike Hugo", numberOfPages: 300,
                publishDate:new Date(), publisher: "Piragua Press")
        grails = new Chapter(title: 'Grails')
        groovy = new Chapter(title: 'Groovy')
        why = new Chapter(title: 'Why should I care?')
        book.chapters = [
                why,
                groovy,
                grails
        ]
    }

    void testToString() {
        assertEquals(book.title.toUpperCase(), book.toString())
        book.title = null
        assertNull(book.toString())
    }

    void testDisplayString() {
        assertEquals("<u>Groovy Jam</u> by Mike Hugo, (300 pages)",
                book.displayString())
    }

    void testFindChapters() {
        assertNull("non existent title",
                book.findChapterByTitle("non existent chapter"));

        assertEquals("existing chapter",
                grails, book.findChapterByTitle("Grails"));

        book.setChapters(null);
        assertNull("null chapter list", book.findChapterByTitle("Grails"));

    }

    void testPrintChapterTitles() {
        book.printChapterTitles()
    }

    void testFindChaptersWithTitleStartingWith() {
        assertEquals("with G", [groovy, grails], book.findChaptersByTitleStartingWith("G"))

        assertEquals("with W", [why], book.findChaptersByTitleStartingWith("W"))
    }

    void testSortChapters() {
        assertEquals("before sort", [why, groovy, grails], book.chapters)
        book.sortChapters()
        assertEquals("after sort", [grails, groovy, why], book.chapters)
    }

    void testGetFirstChapter(){
        assertEquals(why, book.firstChapter)
    }

    void testGetLastChapter(){
        assertEquals(grails, book.lastChapter)
    }

}