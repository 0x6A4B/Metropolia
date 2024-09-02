public class Triangle extends Shape{
    private double side;

    public Triangle(){}
    public Triangle(String colour){ super(colour); }

    public double calculateArea(double side){ return side*side/2; }
    public double calculateArea(){ return side*side/2; }
    public void setSide(double side){ this.side = side; }
    public double getSide(){ return side; }

    @Override
    public void setColor(String color){ this.color = color; }
    @Override
    public String getColor(){ return color; }
}
