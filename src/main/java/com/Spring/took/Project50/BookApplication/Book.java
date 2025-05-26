package com.Spring.took.Project50.BookApplication;

public class Book {
    private String id ;
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;
    private String borrowedByUserId;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", borrowedByUserId='" + borrowedByUserId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book(String id, String title, String author, String genre, boolean isBorrowed, String borrowedByUserId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
        this.borrowedByUserId = borrowedByUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowedByUserId() {
        return borrowedByUserId;
    }

    public void setBorrowedByUserId(String borrowedByUserId) {
        this.borrowedByUserId = borrowedByUserId;
    }
}
