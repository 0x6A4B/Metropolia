public abstract class AbstractVehicle implements Vehicle, ElectricVehicle{


    protected boolean running;
    protected String color, fuel;
    protected String vehicle = "Vehicle";
    protected int capacity;
    protected double fuelAmount;
    protected double fuelEfficiency;

    public String start(){ running = true; return vehicle + " is starting..."; }
    public String stop(){ running = false; return vehicle + " is stopping..."; }
    public String getInfo(){
        return "Type: " + vehicle +"\nFuel: " + fuel + "\nColor: " + color + "\n";
    }

    public void paintVehicle(String color){ this.color = color; }
    public void charge(double kwh){ fuelAmount += kwh; }
    public void fill(double litres){ fuelAmount += litres; }

    public String getType(){ return vehicle; }

    // returns litres per 100km or kwh / 100km
    public double calculateFuelEfficiency(double kilometers, double fuelUsed){
        fuelEfficiency = fuelUsed/(kilometers/100.0);
        return fuelEfficiency;
    }

    public String getFuelEfficiency(){
        return ((int)(fuelEfficiency*100))/100.0
            + (fuel.equals("Electric") ? "kwh/100km" : "litres/100km");
    }
}
