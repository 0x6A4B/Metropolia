public abstract class AbstractVehicle implements Vehicle, ElectricVehicle{


    protected boolean running;
    protected String color, fuel;
    protected String vehicle = "Vehicle";
    protected int capacity;
    protected double fuelAmount;

    public String start(){ running = true; return vehicle + " is starting..."; }
    public String stop(){ running = false; return vehicle + " is stopping..."; }
    public String getInfo(){
        return "Type: " + vehicle +"\nFuel: " + fuel + "\nColor: " + color + "\n";
    }

    public void paintVehicle(String color){ this.color = color; }
    public void charge(double kwh){ fuelAmount += kwh; }
    public void fill(double litres){ fuelAmount += litres; }

    public String getType(){ return vehicle; }

}
