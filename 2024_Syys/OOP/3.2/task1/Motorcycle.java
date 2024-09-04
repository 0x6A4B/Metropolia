public class Motorcycle implements Vehicle{

    private boolean running;
    private String color = "Red", fuel = "Petrol";

    public String start(){ running = true; return "Motorcycle is starting..."; }
    public String stop(){ running = false; return "Motorcycle is stopping..."; }
    public String getInfo(){
        return "Type: Motorcycle\nFuel: " + fuel + "\nColor: " + color + "\n";
    }
}
