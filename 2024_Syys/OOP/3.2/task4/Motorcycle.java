public class Motorcycle extends AbstractVehicle{

    public Motorcycle(){
        super();
        vehicle = "Motorcycle"; color = "Green";
        capacity = 1; fuel = "Petrol";
    }

    @Override
    public void charge(double kwh){ System.out.println(AnsiColor.RED 
            + "Cannot charge ICE vehicle!" + AnsiColor.RESET); }
}
