public interface Vehicle{

    public String start();
    public String stop();
    public String getInfo();
    public void paintVehicle(String color);

    public String getType();
    public void fill(double litres);

    public double calculateFuelEfficiency(double kilometers, double fuelUsed);
}
