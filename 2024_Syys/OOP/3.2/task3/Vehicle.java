public interface Vehicle{

//    Boolean running = null;
//    String color = null, fuel = null;

    public String start();
    public String stop();
    public String getInfo();
    public void paintVehicle(String color);

    public String getType();
    public void fill(double litres);

}
