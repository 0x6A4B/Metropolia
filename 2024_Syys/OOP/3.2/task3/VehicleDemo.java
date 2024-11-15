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
        }


    }

}
