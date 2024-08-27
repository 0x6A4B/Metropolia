public class CarDriver {

    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 77, 160);
        myCar.fillTank();

        for (int i = 0; i < 26; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is "
                    + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is "
                    + myCar.getSpeed() + " km/h");
        }

        
        // Cruise
        boolean testing = true;
        int cruiseSpeed = 50;

        System.out.println("Cruisecontrol test starting");
        for (int __ = 0; __ < 15; __++)
            System.out.print("__");
        System.out.print("\n");

        while(testing) {
            myCar.setTargetSpeed(cruiseSpeed);
            myCar.toggleCruise();
            System.out.println("Setting cruise control to: " + cruiseSpeed);
            if (!myCar.toggleCruise()){
                testing = false;
                System.out.println("Cruise control couldn't be set to: " + cruiseSpeed
                        + "\nMaybe we are trying to set it to too high?");
            }
            
            System.out.println("Cruise speed is set to: " + myCar.getTargetSpeed() + " car speed is " + myCar.getSpeed());
            if (myCar.getSpeed() == myCar.getTargetSpeed())
                System.out.println("Cruising at set speed");
            else
                System.out.println("Cruise control has failed us, sir!");

            cruiseSpeed += 15;
            myCar.toggleCruise();
        }
        
        
    }
}
