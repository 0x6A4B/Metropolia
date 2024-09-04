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
            System.out.println("\n" + v.getType() + " info:\n" + v.getInfo());
            System.out.println("Let's charge the drivebattery!");
            v.charge(99);
            System.out.println("Let's fill the tank!");
            v.fill(99);
        }


    }

}
