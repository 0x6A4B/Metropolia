package model;

public class Pet {
    private double x, y;
    private String img;

    // I guess I hardcoded the png here..
    public Pet(){ img = "CutePet.png"; x = 0; y = 0; }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setLoc(double x, double y){ this.x = x; this.y = y; }
    public String getImg(){ return img; }
}
