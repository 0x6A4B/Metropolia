import java.util.ArrayList;

public class VehicleDemo{

    public static void main(String[] args){
/*
        Car car = new Car();
        System.out.println(car.start());
        System.out.println(car.stop());
        System.out.println("Car info:\n" + car.getInfo());
        System.out.println("Paint the car pink!!");
        car.paintVehicle("Pink");
        System.out.println("Car info:\n" + car.getInfo());

        Vehicle moto = new Motorcycle();
        System.out.println(moto.start());
        System.out.println(moto.stop());
        System.out.println("Motorcycle info:\n" + moto.getInfo());

        Bus bus = new Bus();
        Vehicle veh = (Vehicle) bus;
        System.out.println(veh.start());
        System.out.println(veh.stop());
        System.out.println("Bus info:\n" + veh.getInfo());
        System.out.println("Paint the bus pink!!");
        veh.paintVehicle("Pink");
        System.out.println("Bus info:\n" + veh.getInfo());
*/

        ArrayList<AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car());
        vehicles.add(new Bus());
        vehicles.add(new Motorcycle());
        vehicles.add(new ElectricCar());
        vehicles.add(new ElectricMotorcycle());


        for (AbstractVehicle v : vehicles){
            System.out.println(v.getType() + " info:\n" + v.getInfo());
            System.out.println("Let's charge the drivebattery!");
            v.charge(99);
            System.out.println("Let's fill the tank!");
            v.fill(99);
            /*System.out.println("Paint the " + v.getType() + " purple!");
            v.paintVehicle("Purple");
            System.out.println(v.getType() + " info:\n" + v.getInfo());*/
        }


    }

}
