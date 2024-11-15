public class Test{

    public static void main(String[] arr){
        int runs = 10;
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
    }

    private static String getRand(String[] s){
        return s[(int)Math.round(Math.random()*(s.length-1))];
    }


}
