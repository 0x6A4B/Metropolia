public class task1{
    private int value = 0;
    public void resetCalculator(){ value = 0; }
    public void addInteger(int i){ value += i; }
    public int getValue(){ return value; }
    public void main(String[] args){
        for (int i = 0; i < 5; i++)
            addInteger(i);

        int i = 0;
        while(getValue() < 20)
            addInteger(i++);

        // prompt: sum method that uses addInteger(int i) to add a number 5 times
        task1 calculator = new task1();
        // Reset the calculator
        calculator.resetCalculator();
        // Calculate the sum
        int result = calculator.sum();
        System.out.println("The sum is: " + result);
    }

    public int sum() {
        for (int i = 0; i < 5; i++) {
            addInteger(1); // Add 1 to the value 5 times
        }
        return getValue(); // Return the final value
    }
}
