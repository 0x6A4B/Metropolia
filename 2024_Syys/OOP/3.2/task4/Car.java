public class Car extends AbstractVehicle{

    public Car(){
        super();
        vehicle = "Car";
        color = "Red";
        fuel = "Petrol";
        capacity = 4;
    }

    @Override
    public void charge(double kwh){ System.out.println(AnsiColor.RED
            + "Cannot charge ICE vehicle!" + AnsiColor.RESET); }
}
