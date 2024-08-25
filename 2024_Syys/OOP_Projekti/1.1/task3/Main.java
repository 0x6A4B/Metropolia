
import java.util.LinkedList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Asiakas customer;

        LinkedList<Asiakas> customers = new LinkedList<>();
        Scanner readInput = new Scanner(System.in);

        boolean menu = true;

        while(menu){

            System.out.print("[C]reate customer, [R]ead customer, [D]elete customer, [Q]uit: ");
            char input = readInput.next().charAt(0);

            switch(input){
                case 'C':
                case 'c':
                    customer = new Asiakas();
                    customers.addFirst(customer);
                    customer.setQueueIn();
                    break;
                case 'R':
                case 'r':
                    if (customers.size() > 0){
                        customer = customers.removeLast();
                        customer.setQueueOut();
                        System.out.println("Asiakas " + customer.getId() + " haettu. Vietti aikaa jonossa: " + customer.getQueueTime() + " millisekuntia");
                    } else
                        System.out.println("Queue is empty.");

                    break;
                case 'D':
                case 'd':
                    //
                    System.out.println("Not implemented yet :(");
                    break;
                default:
                    menu = false;
                    // error

            }
        }
    }

}
