public class Bus extends AbstractVehicle{


    public Bus(){
        super();
        color = "Blue"; fuel = "Diesel";
        capacity = 40; vehicle = "Bus";
    }

    @Override
    public String getInfo(){
        return "Type: Bus\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: "
            + capacity + "\n";
    }

    @Override
    public void paintVehicle(String color){
        System.out.println("Bus is owned by the city and painting it would be a terrible "
                + "act of vandalism!! Better put the spray can back in your backbag!!");
    }

    @Override
    public void charge(double kwh){ System.out.println("Cannot charge ICE vehicle!"); }
}
