package controller;

import model.Pet;
import view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;
    private double targetX, targetY;
    private final double TOLERANCE = 0.001;

    public PetController(PetView view){
        pet = new Pet();
        this.view = view;
    }

    public double getX(){ return pet.getX(); }
    public double getY(){ return pet.getY(); }
    public void setLoc(double x, double y){ pet.setLoc(x, y); }
    public String getImg(){ return pet.getImg(); }

    // old simpler method, used for when moving only when mouse moves
    public void update(double mouseX, double mouseY){
        double curX = getX(), curY = getY();
        double newX, newY;

        if (mouseX == curX && mouseY == curY)
            return; // we are at mouse

        if (mouseX < curX)
            newX = --curX;
        else
            newX = ++curX;

        if (mouseY < curY)
            newY = --curY;
        else
            newY = ++curY;

        setLoc(newX, newY);
    }

    // smarter, tries to move more linearly towards target
    public void update(){
        double x = getX(), y = getY();
        double dx, dy;
        double dist;

        dx = targetX - x; dy = targetY - y;
        dist = Math.sqrt(dx*dx + dy*dy);

        if (Math.abs(targetX - x) < TOLERANCE && Math.abs(targetY - y) < TOLERANCE)
            return; // we are at mouse

        x += dx / dist;
        y += dy / dist;

        setLoc(x, y);
    }

    public void target(double x, double y){
        targetX = x; targetY = y;
    }
}
