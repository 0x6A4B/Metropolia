public class Circle extends Shape{

    private double r;

    public Circle(){};
    public Circle(String colour){ super(colour); }

    public double calculateArea(double r){ return Math.PI*(r*r); }
    public double calculateArea(){ return Math.PI * (r*r); }
    public void setRadius(double r){ this.r = r; }
    public double getRadius(){ return r; }

    @Override
    public void setColor(String color){ this.color = color; }
    @Override
    public String getColor(){ return color; }

}
