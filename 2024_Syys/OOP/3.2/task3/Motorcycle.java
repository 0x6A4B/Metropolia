public class Motorcycle extends AbstractVehicle{

    public Motorcycle(){
        super();
        vehicle = "Motorcycle"; color = "Green";
        capacity = 1; fuel = "Petrol";
    }

    @Override
    public void charge(double kwh){ System.out.println("Cannot charge ICE vehicle!"); }
}
