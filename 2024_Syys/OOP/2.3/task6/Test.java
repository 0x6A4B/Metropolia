import java.util.HashMap;
import java.util.ArrayList;

public class Test{

    public static void main(String[] arr){
        int runs = 30;
        int[] years = { 1991, 1982, 2007, 2020, 1888, 2240, 2010, 1999, 1938, 2002 };
        String[] first = { "John", "Jack", "Piedro", "Constantin", "Mary", "Anne", "Jill" };
        String[] last = { "Johnsson", "Jacksson", "el Piedronsson", "Constantinsson",
            "Annesson" };
        String[] titleS = { "Book of", "Boring", "Exciting", "Essential", "Holy",
            "10 ways to create" };
        String[] titleL = { "Dead", "Life", "Work", "Hobbies", "Weapons of mass destruction",
            "Transmittable Diseases" };


    
        if(arr.length > 0)
            try{ runs = Integer.parseInt(arr[0]); }
            catch(Exception e){ /* örrör */ }
         
        Library lib = new Library();
       
        for (int i = 0; i < runs; i++){
             lib.addBook(new Book(years[(int)Math.round(Math.random()*(years.length-1))],
                    getRand(titleS) + " " + getRand(titleL),
                    getRand(first) + " " + getRand(last)));
        }

        lib.displayBooks();



        for (int i = 0; i < 33; i++) System.out.print("__");
        System.out.print("\n");
        for (int i = 0; i < 5; i++){
            String namn = getRand(first) + " " + getRand(last);

            System.out.println("\nFind books authored by: " + namn);
            lib.findBooksByAuthor(namn);

        }
    
        // let's borrow
        Book borrowed;
        do{
            borrowed = lib.borrowBook(getRand(titleS) + " " + getRand(titleL));
        }
        while(borrowed == null);

        System.out.println("\n\nWe borrowed book: " + borrowed.getTitle() + " by: "
                + borrowed.getAuthor());

        System.out.println("Let's see if the book is still in the library. Hoping there isn't"
                + " a perfect copy there...");
        //lib.findBooksByAuthor(borrowed.getAuthor());
        System.out.println("Book is " + ((lib.isBookAvailable(borrowed.getTitle())
                        ? "available" : "borrowed by someone (YOU!!!!) ( - _ - )")));

        System.out.println("And now let's return it!");
        System.out.println("Return is a "
                + ((lib.returnBook(borrowed) == true) ? "success" : "failure"));

        //lib.findBooksByAuthor(borrowed.getAuthor());
        System.out.println("Book is " + ((lib.isBookAvailable(borrowed.getTitle())
                        ? "available" : "borrowed by someone (YOU!!!!) ( -__- )")));


        // libary
        int __ = 10;
        for (int i = 0; i < 10; i++){
            System.out.print(Character.toString(10) + Character.toString(13));
            for (int k = (__-1)/2; k >= 0; k--)
                System.out.print(" ");
            for (int j = i; j >= 0; j--)
                System.out.print("*");
            i++; __--; __--;
        }
        System.out.println("\n\nUSER PART!!!\n\n");
        for (int i = 0; i < 10; i++){
            // create user with name and age
            String nomen = "UniqueVonPerson_" + i;
            lib.createUser(nomen, i*10);
            lib.userBorrows(nomen, lib.getSuggestion());
            lib.userBorrows(nomen, lib.getSuggestion());
        }
       
        // now let's check users and their borrows
        HashMap<String, User> users = lib.getSuspects();
        ArrayList<Book> books = null;
        for (String u : users.keySet()){
            System.out.printf("\nUser: %s has borrowed:\n", u);
            books = lib.getBorrowed(u);
            if (books != null)
                //for (Book b : books){
                for (int i = books.size()-1; i >= 0; i--){
                    System.out.println(books.get(i).getAuthor() + " - "
                            + books.get(i).getTitle());
                    int ret = lib.userReturns(u, books.get(i));
                    System.out.println("\tReturned: "
                            + (((ret) == 1) ? "Succesfully" : (ret == -2) ? "What user"
                                : "What book"));

                    /*             
                    System.out.println(b.getAuthor() + " - " + b.getTitle());
                    int ret = lib.userReturns(u, b);
                    System.out.println("Returned: "
                            + (((ret) == 1) ? "Succesfully" : (ret == -2) ? "What user"
                                : "What book"));
                      */           
                }
        }

        // let's check errors
        for (String u : users.keySet()){
            int ret = lib.userBorrows(u, "aapiskukko");
            System.out.printf("\n\nUser: " + u + " borrows the aapiskukko: %s"
                    , ((ret == 1) ? "SUCCESS!" : (ret == -1) ? "NO SUCH BOOK!"
                        : "NO SUCH USER"));
            break;
        }

        int ret = lib.userBorrows("Idi Amin", "aapiskukko");
        System.out.printf("\n\nUser: Idi Amin borrows the aapiskukko: %s"
                , ((ret == 1) ? "SUCCESS!" : (ret == -1) ? "NO SUCH BOOK!"
                    : "NO SUCH USER\n"));
    }

    private static String getRand(String[] s){
        return s[(int)Math.round(Math.random()*(s.length-1))];
    }


}
