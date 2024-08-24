import java.util.Scanner;
import java.util.Random;

public class OOP_1_4_tehtava1{

    public static void main(String[] args){
        String[] firstNames = { "John", "Jack", "Jill", "Janice", "Kate",
            "Mike", "Mark", "Bill", "Winston" };
        String[] lastNames = { "Smith", "Anderson", "McMuffin", "Thatcher",
            "Reagan", "Clinton" };

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many names to be generated? ");
        int num = Integer.parseInt(input.nextLine());

        for (int i = 0; i < num; i++){
            System.out.println(firstNames[rand.nextInt(0, firstNames.length-1)]
                    + " " + lastNames[rand.nextInt(0, lastNames.length-1)]);
        }

    }


}
