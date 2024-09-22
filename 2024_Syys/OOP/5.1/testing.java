public class testing{


   // public testing(String s, int d){ text = s; delay = d; }



    public static void main(String[] args){

        try{
            
            

            Printtaa a = new Printtaa("A", 100);
            Thread.sleep(2);
            Printtaa b = new Printtaa("\tB", 200);
            Thread.sleep(2);
            Printtaa c = new Printtaa("\t\tC", 300);

            Printtaa last = new Printtaa("\t\t\tD", 500);

            Thread at = new Thread(a);
            Thread bt = new Thread(b);
            Thread ct = new Thread(c);

            at.start();
            Thread.sleep(2);
            bt.start();
            Thread.sleep(2);
            ct.start();

            ct.join();
        }catch(InterruptedException e){ System.exit(6); }

        System.out.println("Finished");



    }


}

class Printtaa implements Runnable{

    private int delay;
    private String text;
    private static int lap;
    private int runs = 100;
    private long lastTime;
    
    Printtaa(String s, int d){ text = s; delay = d; }
    
    public void run(){


        try{
            while(lap++ < runs){
                System.out.println(text + " : " + (System.currentTimeMillis() - lastTime));

                lastTime = System.currentTimeMillis();
                Thread.sleep(delay);
            }

        }catch(InterruptedException e){ System.exit(7); }


    }

}
