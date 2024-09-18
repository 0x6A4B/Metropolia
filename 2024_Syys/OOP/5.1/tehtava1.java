public class tehtava1 implements Runnable{

    private int thread;

    public static void main(String[] args){
        Thread t1 = new Thread(new tehtava1(1));
        Thread t2 = new Thread(new tehtava1(2));

        t1.start(); t2.start();
        try{
            t1.join(); t2.join();
        }catch(InterruptedException e){ System.out.println(e.toString()); }
        System.out.println("Printing complete.");
    }

    public tehtava1(int i){ thread = i; }

    public void run(){
        while(thread <= 20){
            String threadS = thread % 2 == 0 ? "Even" : "Odd";
            System.out.println(threadS + " Thread: " + thread);
            thread += 2;
        }
    }

}
