package library.system;

import library.model.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Library{

    private String name;

    private HashMap<String, LibraryMember> members;
    private HashMap<String, Book> books;

    public Library(String name){
        this.name = name;
        members = new HashMap<>();
        books = new HashMap<>();
    }

    public LibraryMember addUser(String name){
        if (members.containsKey(name)) return null;
        LibraryMember member = new LibraryMember(name);
        members.put(member.getMemberID(), member);
        return member;
    }
    public boolean delUser(String memberId) {
        // unnecessarily going through hashmap even if member removed?
        // perhaps lambda not best in this case
        if (members.containsKey(memberId)) {
/*            members.forEach((s, m) -> {
                if (m.getMemberID().equals(memberId)) members.remove(memberId);
            });*/
            members.remove(memberId);
            return true;
        }
        return false;
    }

    public boolean addBook(String title, String author) {
        if (books.containsKey(title)) return false;
        Book book = new Book(title, author);
        books.put(book.getIsbn(), book);
        return true;
    }
    public boolean delBook(String isbn) {
        if (books.containsKey(isbn)){
            books.remove(isbn);
            return true;
        }
        return false;
    }

    // not a good way to do this, but wanted to add for coding fun
    public void borrowBook(String name, String title){
        boolean bookFound = false;
        boolean memberFound = false;
        for (LibraryMember member : members.values()){
            if (member.getName().equals(name)){
                for (Book book : books.values()){
                    if (book.getTitle().equals(title)) {
                        if(book.getReserved()){
                            System.out.println(AnsiColor.RED + "BOOK RESERVED" + AnsiColor.RESET);
                            break;
                        }
                        member.borrowBook(book);
                        bookFound = true;
                    }
                }
                memberFound = true;
            }
        }
        if (!memberFound)
            throw new MemberNotFoundException("Member not found! Name: " + name);
        if (!bookFound)
            throw new BookNotFoundException("Book not found! Title: " + title);
    }
    public void borrowBook(LibraryMember member, Book book){
        if (!book.getReserved()) member.borrowBook(book);
        else System.out.println(AnsiColor.RED + "BOOK RESERVED" + AnsiColor.RESET);
    }

    // not a good way to do this, but wanted to add for coding fun
    public void returnBook(String name, String title){
        boolean bookFound = false;
        boolean memberFound = false;
        for (LibraryMember member : members.values()){
            if (member.getName().equals(name)){
                for (Book book : member.getBorrowedBooks()){
                    if (book.getTitle().equals(title)) {
                        member.returnBook(book);
                        bookFound = true;
                    }
                }
                memberFound = true;
            }
        }
        if (!memberFound)
            throw new MemberNotFoundException("Member not found! Name: " + name);
        if (!bookFound)
            throw new BookNotFoundException("Book not found! Title: " + title);
    }
    public void returnBook(LibraryMember member, Book book){ member.returnBook(book); }

    public LibraryMember getUser(String name){ return members.get(name); }
    public Book getBookByTitle(String title){
        for (Book book : books.values()){
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }
    public Book getBook(String isbn){ return books.get(isbn); }
    public HashMap getBooks(){ return books; }
    public HashMap getMembers(){ return members; }
    public void listBooks(){ books.forEach((s, b) -> System.out.println(b.toString())); }
    public void listMembers(){ members.forEach((s, m) -> System.out.println(m.toString())); }

    public void reserveBook(Book book){ book.setReserved(true); }
    public void cancelReservation(Book book){ book.setReserved(false); }
    public void listReserved(){
        System.out.printf(AnsiColor.BLUE + "List of reserved books:\n" + AnsiColor.RESET);
        books.forEach((s, b) -> {
            System.out.printf(AnsiColor.GREEN + "Title: %s\tAuthor: %s\n", b.getTitle(), b.getAuthor());
        });
    }

    // to demonstrate reservation cancelling
    public int countReserved(){
        int count = 0;
        for (Book b : books.values()){
            if (b.getReserved()) count++;
        };
        return count;
    }

}
