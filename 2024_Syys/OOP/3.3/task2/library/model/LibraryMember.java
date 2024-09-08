package library.model;

import library.model.Book;

import java.util.ArrayList;
import java.util.UUID;

public class LibraryMember{
    
    private String name;
    private String memberID;
    private ArrayList<Book> borrowedBooks;
    
    public LibraryMember(String name){
        memberID = UUID.randomUUID().toString();
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book){ borrowedBooks.add(book); }
    public void returnBook(Book book){ borrowedBooks.remove(book); }
    public ArrayList<Book> getBorrowedBooks(){ return borrowedBooks; }

    public String getName(){ return this.name; }
    public String getMemberID() { return this.memberID; }

//    public static String getNextUUID(){ return}

    @Override
    public String toString(){ return this.name + "\tID: " + memberID; }

}
