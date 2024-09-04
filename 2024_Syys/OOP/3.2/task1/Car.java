public class Car implements Vehicle{

    private boolean running;
    private String color = "Red", fuel = "Petrol";

    public String start(){ running = true; return "Car is starting..."; }
    public String stop(){ running = false; return "Car is stopping..."; }
    public String getInfo(){
        return "Type: Car\nFuel: " + fuel + "\nColor: " + color + "\n";
    }


}
