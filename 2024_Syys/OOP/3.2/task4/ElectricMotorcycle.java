public class ElectricMotorcycle extends AbstractVehicle{

    
    public ElectricMotorcycle(){
        super();
        fuel = "Electric"; color = "Yellow";
        capacity = 1; vehicle = "Electric Motorcycle"; 
    }
    

    @Override
    public void fill(double litres){ System.out.println(AnsiColor.RED
            + "Cannot fill-up electric vehicle!" + AnsiColor.RESET); }

}
