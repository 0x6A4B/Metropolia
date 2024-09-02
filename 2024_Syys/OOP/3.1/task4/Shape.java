public abstract class Shape{

    protected String color;

    public Shape(){}
    public Shape(String colour){ color = colour; }

    public abstract double calculateArea();

    public abstract double calculateArea(double d);
   
    public abstract String getColor();
    public abstract void setColor(String c);

}
