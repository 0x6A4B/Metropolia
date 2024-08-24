import java.util.Scanner;

public class OOP_1_4_tehtava3{

    public static void main(String[] arguments){
        int size, array[];
        Scanner input = new Scanner(System.in);
                
        size = getArraySize(input);
        array = getArray(size, input);
        
        System.out.print("The arrays without duplicates:\n");
        for (int i: removeDuplicates(array)){
            System.out.print(i + " ");
        }
        System.out.print("\n\n");

    }

    // Let's pass around the created scanner object for fun, why not?
    private static int getArraySize(Scanner i){
        System.out.print("Enter the size of the array: ");
        return Integer.parseInt(i.nextLine());
    }

    private static int[] getArray(int size, Scanner i){
        int[] yarr = new int[size]; // this array has tendencies for thievery on the high seas
        for (int ii = 0; ii < size; ii++){
            System.out.print("Enter integer " + (ii+1) + ":");
            yarr[ii] = Integer.parseInt(i.nextLine());
        }
        return yarr;
    }

    private static int[] removeDuplicates(int[] i){
        int[] culled = new int[i.length];
        int size = 0, indx = 0;
        
        for (int ii: i){
            if (intInArray(ii, culled) && ii != 0){

            }
            else {
                if (ii != 0 || (ii == 0 && firstZero(indx, culled))){
                    culled[indx] = ii;
                    indx++;
                    size++;
                }
            }
        }
        culled = java.util.Arrays.copyOf(culled, size);
        return culled;
    }

    private static boolean intInArray(int i, int[] a){
        for (int ii: a){
            if (i == ii)
                return true;
        }
        return false;
    }

    private static boolean firstZero(int i, int[] a){
        for (int ii = 0; ii < i; ii++){
            if (a[ii] == 0)
                return false;
        }
        return true;
    }

}
