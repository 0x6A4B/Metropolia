public class Book{
    private int year = -1;
    private String title = null;
    private String author = null;
   
//    public Book(){}
    public Book(int i, String s, String t){
        year = i; title = s; author = t;
    }

    public int getYear(){ return year; }
    public String getAuthor(){ return author; }
    public String getTitle(){ return title; }


}
