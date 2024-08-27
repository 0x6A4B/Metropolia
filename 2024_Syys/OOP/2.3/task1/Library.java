import java.util.ArrayList;

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

}
