/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private String typeName;

    private double tankCapacity = 100, maxSpeed = Double.MAX_VALUE;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
                                    // The reference is useful if you want to use parameter names that are
                                    // identical to instance variable names (and for more, later on)
    }

    // Additional constructor
    public Car(String t, double g, double s){ this(t); tankCapacity = g; maxSpeed = s; }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0)
            speed = (speed + 5 <= maxSpeed) ? speed + 5 : maxSpeed;
        else
            speed = 0;
    }
    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    public double getSpeed() {
        return speed;
    }
    public String getTypeName() {
        return typeName;
    }
    public void fillTank() {
        gasolineLevel = tankCapacity;
    }
    public double getGasolineLevel() {
        return gasolineLevel;
    }

    // Cruise control added
    private double targetSpeed = 0, maxCruiseSpeed = 120, minCruiseSpeed = 50;

    public boolean toggleCruise(){
        if (targetSpeed > maxCruiseSpeed || targetSpeed < minCruiseSpeed)
            return false;

        while(speed > targetSpeed)
            decelerate(10);

        while (speed < targetSpeed)
            accelerate();

        return true;
    }

    public void setTargetSpeed(double i){
        targetSpeed = i;
    }

    public double getTargetSpeed(){
        return targetSpeed;
    }


}
