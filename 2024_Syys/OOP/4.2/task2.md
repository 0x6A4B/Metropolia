# 4.2

## Task 2


This is a simple Java program that demonstrates the usage of a Calculator class. Here's a breakdown of what's happening:


### The main() method

In the task1 class, the main() method is where the program starts executing. It creates an instance of the Calculator class and performs some calculations.


- It initializes a variable ii to 0.
- It enters a loop that continues until the value returned by calc.getValue() is less than 20. In each iteration, it adds the current value of ii to the calculator using calc.addInteger(ii++). The ii++ expression increments ii and assigns the new value back to ii.
- After the loop finishes, it resets the calculator using calc.resetCalculator().
- It then enters another loop that runs 5 times. In each iteration, it adds the current integer value (i) to the calculator using calc.addInteger(i).
- Finally, it creates a new instance of the Calculator class, resets it, calculates the sum using the sum() method (which we'll discuss below), and prints the result to the console.


### The Calculator class

This class represents a simple calculator that can perform basic arithmetic operations. Here's what each method does:


- resetCalculator(): Resets the calculator by setting its internal value to 0.
- addInteger(int i): Adds the specified integer i to the calculator's internal value.
- getValue(): Returns the current value stored in the calculator.
- sum(): This method is where things get interesting. It adds the integer 1 to the calculator's internal value 5 times, and then returns the final value.


### Summary

The idea behind this program is to demonstrate how you can create a simple calculator that can perform basic arithmetic operations like adding integers. The sum() method in particular shows how you can write a reusable piece of code that performs a specific calculation.


### Sourcecode


```java

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
```
