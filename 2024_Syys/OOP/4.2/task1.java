public class task1{

    public void main(String[] args){
        int ii = 0;
        Calculator calc = new Calculator();

        while(calc.getValue() < 20)
            calc.addInteger(ii++);

        calc.resetCalculator();
        for (int i = 0; i < 5; i++)
            calc.addInteger(i);

        // prompt: sum method that uses addInteger(int i) to add a number 5 times
        Calculator calculator = new Calculator();
        // Reset the calculator
        calculator.resetCalculator();
        // Calculate the sum
        int result = calculator.sum();
        System.out.println("The sum is: " + result);

    }

}

class Calculator{
    private int value = 0;
    public void resetCalculator(){ value = 0; }
    public void addInteger(int i){ value += i; }
    public int getValue(){ return value; }

    public int sum() {
        for (int i = 0; i < 5; i++) {
            addInteger(1); // Add 1 to the value 5 times
        }
        return getValue(); // Return the final value
    }
}
