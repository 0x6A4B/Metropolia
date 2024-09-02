public class Rectangle implements Shape{

    // gets too complicated for dynamic instantiation if there are two parameters
    // for now I'll just use one parameter and rectangle is just a square
    /*private double sideA, sideB;

    public double calculateArea(){ return sideA*sideB; }
    public void setSide(double A, double B){ this.sideA = A; this.sideB = B; }
    public double[] getSide(){ return (new double[] { sideA, sideB }); }*/

    private double side;

    public double calculateArea(double side){ return side*side; }
    public double calculateArea(){ return side*side; }
    public void setSide(double side){ this.side = side; }
    public double getSide(){ return side; }
    


}
