import java.util.ArrayList;

public class VehicleDemo{

    public static void main(String[] args){

        ArrayList<AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car());
        vehicles.add(new Bus());
        vehicles.add(new Motorcycle());
        vehicles.add(new ElectricCar());
        vehicles.add(new ElectricMotorcycle());


        for (AbstractVehicle v : vehicles){
            System.out.println("\n" + AnsiColor.BLUE + v.getType() + " info:\n"
                    + AnsiColor.RESET + v.getInfo());
            System.out.println(AnsiColor.BLUE + "Let's charge the drivebattery!"
                    + AnsiColor.RESET);
            v.charge(99);
            System.out.println(AnsiColor.BLUE + "Let's fill the tank!" + AnsiColor.RESET);
            v.fill(99);

            //fuel efficiency
            double fuelUsed = (int)(Math.random()*1000*100)/100.0;
            double kmTravelled = (int)(Math.random()*10000*100)/100.0;
            v.calculateFuelEfficiency(kmTravelled, fuelUsed);
            System.out.println(AnsiColor.CYAN + "Fuel used: " + fuelUsed + "\n"
                    + "Km travelled: " + kmTravelled + "\n"
                    + v.getFuelEfficiency() + AnsiColor.RESET);
        }


    }

}
