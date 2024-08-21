import java.util.Scanner;

public class OOP_1_1_tehtava3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        /* Average needs to be a floating point number instead of an integer
         * to include decimals.
         * Int simply casted to double
         */

        System.out.println(
            "The sum of the numbers is " + (first + second + third) + "\n" +
            "The product of the numbers is " + (first * second * third) + "\n" +
            "The average of the numbers is " + ((double) first  + second + third) / 3

                );
    }
}
