public class Triangle{
    private double side;

    public double calculateArea(double side){ return side*side/2; }
    public double calculateArea(){ return side*side/2; }
    public void setSide(double side){ this.side = side; }
    public double getSide(){ return side; }

}
