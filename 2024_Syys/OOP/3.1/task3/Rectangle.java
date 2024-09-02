public class Rectangle{
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
