/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    protected double speed;
    protected double gasolineLevel;
    protected String typeName;

    protected double tankCapacity = 100, maxSpeed = Double.MAX_VALUE;

    protected int acceleration = 5, deceleration = 5, consumption = 5;

    protected int maxPassengers = 4, passengers = 0;

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
        if (gasolineLevel > 0){
            speed = (speed + acceleration <= maxSpeed) ? speed + acceleration : maxSpeed;
            gasolineLevel = (gasolineLevel - consumption >= 0)
                ? gasolineLevel - consumption : 0;
        }
        else
            speed = 0;
    }
    public void decelerate() {
        if (gasolineLevel > 0) {
            speed = Math.max(0, speed - deceleration);
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
    protected double targetSpeed = 0, maxCruiseSpeed = 120, minCruiseSpeed = 50;

    public boolean toggleCruise(){
        if (targetSpeed > maxCruiseSpeed || targetSpeed < minCruiseSpeed)
            return false;

        while(speed > targetSpeed)
            decelerate();

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

    // BUS
    //
    public boolean passengersEnter(int passengers){
        if (this.passengers == maxPassengers)
            return false;
        this.passengers = Math.min(maxPassengers, this.passengers + passengers);
            /*(this.passengers + passengers <= maxPassengers)
            ? this.passengers + passengers : maxPassengers;*/
        return true;
    }

    public boolean passengersExit(int passengers){
        if (this.passengers == 0)
            return false;
        this.passengers = Math.max(0, this.passengers - passengers);
/*            (this.passengers - passengers >= 0)
            ? this.passengers - passengers : 0;*/
        return true;
    }

}
