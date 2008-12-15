package com.piragua.java;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

public class BookTest extends TestCase {
    Book book;
    Chapter chapter;

    public void setUp() {
        book = new Book();
        book.setNumberOfPages(300);
        book.setAuthorName("Mike Hugo");
        book.setTitle("Groovy Jam");
        book.setSubTitle("Jammin' with Groovy");
        book.setPublisher("Piragua Press");
        book.setPublishDate(new Date());

        chapter = new Chapter("Grails");
        ArrayList chapters = new ArrayList();
        chapters.add(new Chapter("Groovy"));
        chapters.add(new Chapter());
        chapters.add(chapter);
        chapters.add(new Chapter("Why should I care?"));
        book.setChapters(chapters);
    }

    public void testToString() {
        assertEquals(book.getTitle().toUpperCase(), book.toString());
        book.setTitle(null);
        assertNull(book.toString());
    }

    public void testDisplayString() {
        assertEquals("<u>Groovy Jam</u> by Mike Hugo, (300 pages)",
                book.displayString());
    }

    public void testFindChapters() {
        assertNull("null title",
                book.findChapterByTitle(null));
        assertNull("non existent title",
                book.findChapterByTitle("non existent chapter"));

        assertEquals("existing chapter",
                chapter, book.findChapterByTitle("Grails"));

        book.setChapters(null);
        assertNull("null chapter list", book.findChapterByTitle("Grails"));

    }

}
