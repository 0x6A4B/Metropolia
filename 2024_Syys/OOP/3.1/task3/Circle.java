public class Circle implements Shape{

    private double r;

    public double calculateArea(double r){ return Math.PI*(r*r); }
    public double calculateArea(){ return Math.PI * (r*r); }
    public void setRadius(double r){ this.r = r; }
    public double getRadius(){ return r; }

}
