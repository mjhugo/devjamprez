package com.piragua.groovy

class Book {
    String title
    String authorName
    Integer numberOfPages
    List chapters

    String toString() {
        title?.toUpperCase()
    }

    String displayString() {
        "<u>${title}</u> by ${authorName}, (${numberOfPages} pages)"
    }

    Chapter findChapterByTitle(String title) {
        // finding the first item that matches criteria
        chapters?.find({it?.title == title})
    }

    List findChaptersByTitleStartingWith(String searchKeyword) {
        // finding all matching items
        chapters?.findAll({it?.title?.startsWith(searchKeyword)})
    }

    void printChapterTitles() {
        // iterating over a list
        chapters.each {chapter ->
            println chapter?.title
        }
    }

    void sortChapters() {
        // sorting a list
        chapters.sort({it?.title})
    }

    void addChapter(Chapter newChapter) {
        // adding a new item to a list
        chapters << newChapter
    }

    Chapter getFirstChapter() {
        chapters[0]
    }

    Chapter getLastChapter() {
        chapters[-1]
    }
}


