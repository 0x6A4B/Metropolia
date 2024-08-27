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
                    titleS[(int)Math.round(Math.random()*(titleS.length-1))] + " " 
                    + titleL[(int)Math.round(Math.random()*(titleL.length-1))],
                        first[(int)Math.round(Math.random()*(first.length-1))] + " "
                            + last[(int)Math.round(Math.random()*(last.length-1))]
                     ));
        }

        lib.displayBooks();

        for (int i = 0; i < 33; i++) System.out.print("__");
        System.out.print("\n");
        for (int i = 0; i < 5; i++){
            String namn = first[(int)Math.round(Math.random()*(first.length-1))] + " "
                    + last[(int)Math.round(Math.random()*(last.length-1))];
            System.out.println("\nFind books authored by: " + namn);
            lib.findBooksByAuthor(namn);
        }

    }



}
