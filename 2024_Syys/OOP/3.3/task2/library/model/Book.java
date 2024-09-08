package library.model;

import java.util.UUID;

public class Book{

    private String title;
    private final String isbn;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isbn = UUID.randomUUID().toString();
    }

    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getIsbn(){ return isbn; }

    @Override
    public String toString(){ return title + "\tBy: " + author + "\tISBN: " + isbn; }

}
