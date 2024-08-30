import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

public class Library{
    ArrayList<Book> books = new ArrayList<>();

    public Library(){}

    public void addBook(Book b){ books.add(b); }
    public void displayBooks(){
        System.out.println("Year | Author       | Title");
        for (Book b : books){
            System.out.println(b.getYear() + " | " + b.getAuthor() + " | " + b.getTitle());
        }
    }
    public void findBooksByAuthor(String author){
        System.out.println("Year | Author       | Title");
        for (Book b : books){
            if(b.getAuthor().equals(author))
                System.out.println(b.getYear() + " | " + b.getAuthor()
                        + " | " + b.getTitle());
        }
    }

    public Book borrowBook(String title){
        for (Book b : books){
            if (b.getTitle().equals(title)){
                Book borrowed = b;
                books.remove(books.indexOf(b));
                return borrowed;
            }
        }
        return null;
    }

    public boolean returnBook(Book b){
        return books.add(b);
    }

    public boolean isBookAvailable(String title){
        for (Book b : books)
            if (b.getTitle().equals(title))
                return true;
        return false;
    }

    public double getAverageBookRating(){
        int nrOfBooks = 0;
        double sumRating = 0;

        for (Book b : books){
            sumRating += b.getRating();
            nrOfBooks++;
        }
        return sumRating/nrOfBooks;
    }

    public Book getMostReviewedBook(){
        Book bb = null;
        for (Book b : books)
            if (bb == null || b.getAmountOfReviews() > bb.getAmountOfReviews())
                bb = b;
        return bb;
    }

    // user part
    //ArrayList<User> users = new ArrayList<>();
    HashMap<String, User> users = new HashMap<>();
    
    public void createUser(String name, int age){ users.put(name, new User(name, age)); }
    //public User readUser(int id){}
    public ArrayList<Book> getBorrowed(String name){
        if (users.containsKey(name))
            return users.get(name).getBorrowed();    
        /*for (User u : users.)
            if (u.getName().equals(name))
                return getBorrowed(u.getId());*/
        return null;
    }
    /*
    public ArrayList<Book> getBorrowed(int id){
        for (User u : users)
            if (u.getId() == id)
                return u.getBorrowed();
        return null;
    }*/

    public HashMap<String, User> getSuspects(){ return users; }

            // 1: success or -1: no such book
            // -2: no such user
    public int userBorrows(String name, String b){
        if (users.containsKey(name))
            return ((users.get(name).borrowBook(borrowBook(b))) ? 1 : -1);
        return -2;
    }

    public int userReturns(String name, Book b){
        if (users.containsKey(name))
            return ((users.get(name).returnBook(b)) ? 1 : -1);
        return -2; 
    }
   
    // to get just some books that are available for test/demonstration
    // returns title to use in borrowing as per original definition
    public String getSuggestion(){ return books.get(0).getTitle(); }

}
