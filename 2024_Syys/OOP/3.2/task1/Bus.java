public class Bus implements Vehicle{

    private boolean running;
    private String color = "Blue", fuel = "Diesel";
    private int capacity = 40;

    public String start(){ running = true; return "Bus is starting..."; }
    public String stop(){ running = false; return "Bus is stopping..."; }
    public String getInfo(){
        return "Type: Bus\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: "
            + capacity + "\n";
    }

}
