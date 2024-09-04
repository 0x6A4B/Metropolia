public class Motorcycle extends AbstractVehicle{
/*
    private boolean running;
    private String color = "Red", fuel = "Petrol";

    public String start(){ running = true; return "Motorcycle is starting..."; }
    public String stop(){ running = false; return "Motorcycle is stopping..."; }
    public String getInfo(){
        return "Type: Motorcycle\nFuel: " + fuel + "\nColor: " + color + "\n";
    }*/

    public Motorcycle(){
        super();
        vehicle = "Motorcycle"; color = "Green";
        capacity = 1; fuel = "Petrol";
    }
}
