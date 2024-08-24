import java.util.Scanner;

public class OOP_1_3_tehtava2{

    public static void main(String[] args){
        int decimal = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a binary number: ");
        String bin = input.nextLine();

        char[] binC = swapArray(bin.toCharArray());

        for (int i = 0; i < binC.length; i++){
            if (checkCharacter(binC[i])){
                if (binC[i] == '1')
                    decimal += 1 * Math.pow(2, i);
            }
            else {
                System.out.println("ERROR!! Something else than 1 or 0 given!! Shame on user!!");
                System.exit(666);
            }
        }
        
        System.out.println("Decimal is: " + decimal);

    }

    private static char[] swapArray(char[] c){
        char[] cc = new char[c.length];
        int i = 0;
        for (int j = c.length-1; j >= 0; j--){
            cc[i] = c[j];
            i++;
        }
        return cc;
    }

    private static boolean checkCharacter(char x){
        if (x == '0' || x == '1')
            return true;
        return false;
    }

}
