import java.util.ArrayList;

public class Book{
    private int year = -1;
    private String title = null;
    private String author = null;
    private ArrayList<String> reviews;
    private double rating = -1;
   
//    public Book(){}
    public Book(int i, String s, String t){
        year = i; title = s; author = t;
        reviews = new ArrayList<>();
    }

    public int getYear(){ return year; }
    public String getAuthor(){ return author; }
    public String getTitle(){ return title; }
    public ArrayList<String> getReviews(){ return reviews; }
    public double getRating(){ return rating; }
    public void setRating(double d){ rating = d; }
    public void addReview(String s){ reviews.add(s); }
    public int getAmountOfReviews(){ return reviews.size(); }

}
