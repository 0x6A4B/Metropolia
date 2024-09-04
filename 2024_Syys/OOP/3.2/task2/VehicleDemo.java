public class VehicleDemo{

    public static void main(String[] args){

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

    }

}
