package library.model;

import java.util.UUID;

public class Book{

    private String title;
    private final String isbn;
    private String author;
    private boolean reserved = false;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isbn = UUID.randomUUID().toString();
    }

    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getIsbn(){ return isbn; }

    public boolean getReserved(){ return reserved; }
    public void setReserved(boolean reserved){ this.reserved = reserved; }
    public void toggleReserved(){ reserved = !reserved; }

    @Override
    public String toString(){ return title + "\tBy: " + author + "\tISBN: " + isbn; }

}
