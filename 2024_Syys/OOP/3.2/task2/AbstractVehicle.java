public abstract class AbstractVehicle implements Vehicle{


    protected boolean running;
    protected String color, fuel;
    protected String vehicle = "Vehicle";
    protected int capacity;

    public String start(){ running = true; return vehicle + " is starting..."; }
    public String stop(){ running = false; return vehicle + " is stopping..."; }
    public String getInfo(){
        return "Type: " + vehicle +"\nFuel: " + fuel + "\nColor: " + color + "\n";
    }

    public void paintVehicle(String color){ this.color = color; }


}
