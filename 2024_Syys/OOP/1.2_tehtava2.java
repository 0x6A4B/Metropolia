/* Module 1.2 task 2
 * Asking the user for the legs of a right triangle and calculating the
 * hypothenuse using pythagora's theorem
 *
 */

import java.util.Scanner;

public class Tehtava2_1_2{

    public static void main(String[] args){
        System.out.print("Input the length of the first leg of a right triangle: ");
        double leg1 = Double.parseDouble(new Scanner(System.in).nextLine());
        
        System.out.print("And the other leg: ");
        double leg2 = Double.parseDouble(new Scanner(System.in).nextLine());
       
        double hypo = Math.sqrt(leg1*leg1+leg2*leg2);
        
        System.out.printf("Hypothenuse: %.1f\n", hypo);


    }

}
