/* 
 * Joonas Karppinen, joonas.karppinen@metropolia.fi
 *
 * Module 1.2, task 3:
 * Convert grams to ancient finnish weights
 *
 * Inputs grams in INTEGERS as the example had grams as an integer
 * and the accuracy doesn't really suit weights smaller than a gram
 */


import java.util.Scanner;


public class Moduuli_1_2_Tehtava_3{

    private static final double luotiGrams = 13.28;
    private static final int naulaLuoti = 32;
    private static final int leivNaula = 20;


    public static void main(String[] args){
        int grams, leiv = 0, naula = 0;
        double luoti = 0;


        System.out.print("Weight(g): ");
        grams = Integer.parseInt(new Scanner(System.in).nextLine());

        // We calculate leiviskä from grams in integer
        leiv = (int) (grams/(leivNaula*naulaLuoti*luotiGrams));
        // We take modulus
        double modu = grams%(leivNaula*naulaLuoti*luotiGrams);
        // Use the modulus to calculate naula from it
        naula = (int) (modu/(naulaLuoti*luotiGrams));
        // Again use the assistant variable for modulus
        modu = modu%(naulaLuoti*luotiGrams);
        // And get the luoti from what is left after calculating leiviskä and naula
        luoti = modu/luotiGrams;


        System.out.printf("%d grams is %d leiviskä, %d naula, and %.2f luoti.\n", grams, leiv, naula, luoti);


    }

}
