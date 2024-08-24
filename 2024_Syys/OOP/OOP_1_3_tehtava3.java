import java.util.Scanner;

public class OOP_1_3_tehtava3{

    public static void main(String[] args){
        int i=1, a, b, c[];
        boolean prime = false;

        if (!gotArgs(args)){
            Scanner input = new Scanner(System.in);
            System.out.print("Prime number calculator, give start of range: ");
            a = Integer.parseInt(input.nextLine());
            System.out.print("Great! Now the end for the range: ");
            b = Integer.parseInt(input.nextLine());
        } else{
            c = getArgs(args);
            a = c[0]; b = c[1];
        }
       
        if (a > i)
            i = a;

        while(i <= b){
            for(int j = 2; j <= i - 1; j++){
                prime = true;
                if(i%j == 0){
                    // preserve computation by stopping at first
                    // sign of not being a prime
                    prime = false;
                    break;
                }
            }
            if (prime)
                System.out.println(i);
            i++;
        }
        
    }

    public static boolean gotArgs(String[] a){
        if (a.length > 0)
            return true;
        return false;
    }

    public static int[] getArgs(String[] a){
        return new int[] {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
    }

}
