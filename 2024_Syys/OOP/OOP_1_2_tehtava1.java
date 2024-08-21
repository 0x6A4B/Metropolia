
import java.util.Scanner;

public class OOP_1_2_tehtava1{

    public static void main(String[] args){
        System.out.print("Give temperature in Fahrenheit: ");
        Scanner fahr = new Scanner(System.in);
        double f = Double.parseDouble(fahr.nextLine());
        double c = (f-32)*5/9;
        System.out.printf("%.1f\n", c);
    }

}
