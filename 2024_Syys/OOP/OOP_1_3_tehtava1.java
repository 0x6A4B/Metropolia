import java.util.Scanner;

public class OOP_1_3_tehtava1{
    public static void main(String[] args){
        double a=0, b=0, c=0;
        Scanner input = new Scanner(System.in);

        System.out.print("Give the coefficients for quadratic equation\na:");
        a = Double.parseDouble(input.nextLine());
        if (a == 0) {
            System.out.println("Error!! a cannot be zero! Bad user, shame!");
            System.exit(666);
        }

        System.out.print("b:");
        b = Double.parseDouble(input.nextLine());

        System.out.print("c:");
        c = Double.parseDouble(input.nextLine());

//       (-b- sqrt(b^2-4ac))/2a

        double toBeSquared = (b*b-4*a*c);

        if (toBeSquared < 0){
            System.out.println("No real roots");
            System.exit(999);
        }

//        double rootA = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
//        double rootB = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
        double rootA = (-b - Math.sqrt(toBeSquared))/(2*a);
        double rootB = (-b + Math.sqrt(toBeSquared))/(2*a);


        System.out.println("First root: " + rootA + "\nSecond root: " + rootB);


    }

}
