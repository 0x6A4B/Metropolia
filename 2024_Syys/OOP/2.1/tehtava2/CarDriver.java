public class CarDriver {

public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 80, 180);
        myCar.fillTank();

        for (int i = 0; i < 26; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
