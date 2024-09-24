public class tehtava1{


    public static void main(String[] args){

        Thread[] customers = new Thread[25];

        for (int i = 1; i <= 25;i++){
            customers[i-1] = new Thread(new Seat(i));
            customers[i-1].start();
        }

        try{
        for(Thread t : customers)
            t.join();
        }catch(InterruptedException e){ System.out.println(e.toString()); }
        System.out.println("Done");
    }


}


class Seat implements Runnable{

    private static int seats = 20;
    private int customerId = -1;

    public Seat(int customerId){ this.customerId = customerId; }

    public void run(){
        book(customerId, (int)Math.ceil(Math.random() * 5));
    }

    synchronized void book(int customerId, int seatNr){
        if (seats >= seatNr){
            seats -= seatNr;
            System.out.printf("Customer %d reserved %d tickets.\n", customerId, seatNr); 
        }else{
            System.out.printf("Customer %d couldn't reserve %d tickets.\n", customerId, seatNr);
        }
    }

}
