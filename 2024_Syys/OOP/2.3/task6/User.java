import java.util.ArrayList;

public class User{
    private ArrayList<Book> borrowed = new ArrayList<>();
    private String name;
    private int age;
    private static int id = -1;


    public User(String s, int i){ name = s; age = i; id += 1; }

    public static int getNextId(){ return id+1; }
    public int getAge(){ return age; }
    public String getName(){ return name; }
    public int getId(){ return id; }

    public ArrayList<Book> getBorrowed(){ return borrowed; }

    public boolean borrowBook(Book b){
        if (b == null)
            return false;
        return borrowed.add(b); }
    public boolean returnBook(Book b){ return borrowed.remove(b); }

}
