
import java.util.LinkedList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        if (args.length > 0 && args[0].toLowerCase().equals("test"))
            Test();
        else
            Menu();
    }

    public static void Menu(){
        Customer customer;

        LinkedList<Customer> customers = new LinkedList<>();
        Scanner readInput = new Scanner(System.in);

        boolean menu = true;

        while(menu){

            System.out.print("[C]reate customer, [R]ead customer, [D]elete customer, [Q]uit: ");
            char input = readInput.next().charAt(0);

            switch(input){
                case 'C':
                case 'c':
                    customer = new Customer();
                    customers.addFirst(customer);
                    customer.setQueueIn();
                    break;
                case 'R':
                case 'r':
                    if (customers.size() > 0){
                        customer = customers.removeLast();
                        customer.setQueueOut();
                        System.out.println("Customer " + customer.getId() + " fetched. Spent time in queue: " + customer.getQueueTime() + " ms");
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


    public static void Test(){
        LinkedList<Customer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++){
            Customer c = new Customer();
            c.setQueueIn();
            list.addFirst(c);
            Wait();
        }

        while (!list.isEmpty()){
            Wait();
            Customer c = list.removeLast();
            c.setQueueOut();
            System.out.println("Customer " + c.getId() + " queuetime " + c.getQueueTime() + "ms");
        }
    }

    private static void Wait(){
        try{
            Thread.sleep((int)(200*Math.random()));
        }catch(Exception e){
            System.out.println("Erroria pukkaa, mutta pukakkoo :) Ei voi olla meistä kii O_o");
        }
    }
}
