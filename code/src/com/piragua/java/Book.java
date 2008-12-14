package com.piragua.java;

import java.util.List;

public class Book {
    private String title;
    private String authorName;
    private Integer numberOfPages;
    private List<Chapter> chapters;

    public List getChapters() {
        return chapters;
    }

    public void setChapters(List chapters) {
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String toString() {
        String upperCaseTitle = null;
        if (title != null) {
            upperCaseTitle = title.toUpperCase();
        }
        return upperCaseTitle;
    }

    public String displayString() {
        return "<u>" + title + "</u> by " + authorName + ", (" + numberOfPages + " pages)";
    }

    public Chapter findChapterByTitle(String chapterTitle) {
        Chapter foundChapter = null;

        if (chapterTitle != null && chapters != null) {
            for (int i = 0; i < chapters.size(); i++) {
                if (chapters.get(i) != null &&
                        chapterTitle.equals(chapters.get(i).getTitle())) {
                    foundChapter = chapters.get(i);
                    break;
                }
            }
        }
        return foundChapter;
    }
}