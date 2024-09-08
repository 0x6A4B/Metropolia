package library;


import library.system.*;
import library.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class Main {

    public static void main(String[] args){
        // llama made me a bunch of funny names, all hail AI!!!! Our new overlords!
        // first use of LLM, using it to generate names
        String[] firstNames = { "Bramble", "Finnley", "Gizmo", "Jingle", "Kaiju", "Lulu Belle", "Moxie", "Noodle" };
        String[] lastNames = { "Picklefart", "Snodgrass", "Flibberflabber", "Wobblebottom", "Snazzlefrazz"
                , "Mumblesworth", "Gibletsley", "Flumplenook" };
        String[] titles = { "Zombies Ate My Homework", "The Secret Life of Socks"
                , "Cats vs. Robots: The Battle for World Domination"
                , "How to Train Your Dragon (and Other Fuzzy Creatures)"
                , "The Art of Napping: Mastering the Fine Craft of Doing Nothing"
                , "I'm Not Arguing, I'm Just Explaining Why I'm Right" };
        String[] authors = { "Bethany Peculiar", "Reginald Fumbleworth III", "Lola Larkspur"
                , "Cedric Crumpton-Smythe", "Penelope Pixelstein", "Roderick Ruckus"};

        int members = 5, books = 50, booksBorrowed = 10;
        Library library = new Library("Keskuskirjasto");

        // not gonna error check these let it fail, I'm too busy
        switch (args.length) {
            case 0:
                break;
            case 1:
                members = Integer.parseInt(args[0]);
            case 2:
                books = Integer.parseInt(args[1]);
            case 3:
                booksBorrowed = Integer.parseInt(args[2]);
        }

        for (int j = 0; j < books; j++){
            library.addBook(Rand.getRand(titles), Rand.getRand(authors));
        }

        String[] existingIsbn = Arrays.copyOf(library.getBooks().keySet().toArray()
                , library.getBooks().keySet().toArray().length, String[].class);

        // create users and borrow a set of books
        for (int i = 0; i < members; i++){
            LibraryMember member = library.addUser(Rand.getRand(firstNames) + " " + Rand.getRand(lastNames));
            System.out.printf(AnsiColor.BLUE + "User %s borrowing:\n", member.getName());
            if (member == null){
                System.out.println(AnsiColor.RED + "Error in creating memebr" + AnsiColor.RESET);
                break;
            }
            for (int j = 0; j < booksBorrowed; j++){
                Book b = library.getBook(Rand.getRand(existingIsbn));
                System.out.printf(AnsiColor.GREEN + "Title: %s\tAuthor: %s\n" + AnsiColor.RESET
                        , b.getTitle(), b.getAuthor());
                library.borrowBook(member, b);
//                library.borrowBook(member, library.getBook(Rand.getRand(existingIsbn)));
                b = library.getBook(Rand.getRand(existingIsbn));
                if (!b.getReserved()) b.toggleReserved();
            }
        }

        System.out.printf("\nReserved books: %d\n", library.countReserved());
        library.listReserved();

        // let's return all books
        System.out.print(AnsiColor.GREEN + "Users and their borrows, returning\n\n" + AnsiColor.RESET);
        while (!library.getMembers().values().isEmpty()) {
            // using optional to just be able to use the current while loop
            // interesting new promise kind of thing for me
            // maybe not prettiest but forgot can't modify hashmap within foreach
            // so dug myself a snug little hole for a home
            LibraryMember m = (LibraryMember) library.getMembers().values().stream().findFirst().get();
            System.out.printf(AnsiColor.BLUE + "User: %s\tMemberID: %s\n", m.getName(), m.getMemberID());
            while (!m.getBorrowedBooks().isEmpty()) {
                Book b = m.getBorrowedBooks().getFirst();
                System.out.printf(AnsiColor.CYAN + "Title: %s\tAuthor: %s\n", b.getTitle(), b.getAuthor());
                m.returnBook(b);
            }
            System.out.println(AnsiColor.RED + "Removing user" + AnsiColor.RESET);
            library.delUser(m.getMemberID());
        }

        System.out.println("List users: (should not be any)");
        library.getMembers().forEach((s, m) -> {
            System.out.printf("User: %s\n", m.toString());
        });


        System.out.printf("\nReserved books: %d\n", library.countReserved());
        library.listReserved();

        ArrayList<Book> cancelList = new ArrayList<>();



        int count = 0;
        Book bb;
        for (Object o : library.getBooks().values()) {
            bb = (Book) o;
            if (bb.getReserved()) {
                count++;
                if (count % 2 == 0) {
                    cancelList.add(bb);
                    bb.setReserved(false);
                    System.out.println("cancelling reservation");
                }
            }
        }

        System.out.println("Cancelled reservations: " + cancelList.size());

        System.out.printf("\nReserved books: %d\n", library.countReserved());
        library.listReserved();
    }


}
