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
}
