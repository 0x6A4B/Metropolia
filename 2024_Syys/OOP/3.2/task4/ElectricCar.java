public class ElectricCar extends AbstractVehicle{

    
    public ElectricCar(){
        super();
        fuel = "Electric"; color = "Gray";
        capacity = 4; vehicle = "Electric Car"; 
    }
    

    @Override
    public void fill(double litres){ System.out.println(AnsiColor.RED
            + "Cannot fill-up electric vehicle!" + AnsiColor.RESET); }

}