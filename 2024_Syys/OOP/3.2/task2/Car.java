public class Car extends AbstractVehicle{
/*
    private boolean running;
    private String color = "Red", fuel = "Petrol";

    public String start(){ running = true; return "Car is starting..."; }
    public String stop(){ running = false; return "Car is stopping..."; }
    public String getInfo(){
        return "Type: Car\nFuel: " + fuel + "\nColor: " + color + "\n";
    }
*/

    public Car(){
        super();
        vehicle = "Car";
        color = "Red";
        fuel = "Petrol";
        capacity = 4;
    }
}
