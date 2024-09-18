import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class tehtava2 implements Runnable{
    // static as we can share this
    private static long sum = 0;
    
    // even though it is in one file the program is still oop and main is basically
    // the same as another class calling this class, so we will use instance variables
    private int[] numbers;
    private int cores;
    private int[] start;
    private int num;
    private int core;

    /* Best spaghetti north of Naples !!! */

    public static void main(String[] args){
        Thread[] threads;
        int cores;
        int[] start;
        int num = 1000000;
        int[] numbers;

        // parameterize the size
        try{
        if (args.length > 0)
            num = Integer.parseInt(args[0]);
        }catch(Exception e){ System.out.println("Naughty user!!! Santa won't visit you!!!"); }

        numbers = new int[num];

        // using stringbuilder for checking results
        StringBuilder numString = new StringBuilder();

        // creating the array and the stringbuilder for checking the results
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int) ((Math.random() * 100) * (Math.random() * 100));
            numString.append(numbers[i] + ",");
            writer(numbers[i], "for.csv");
        }

        // let's write a csv file to be able to confirm the calculation works
        try(FileWriter writer = new FileWriter("num.csv")){
            writer.write(numString.toString().substring(0, numString.toString().length()-1));
        }catch(IOException e){ örr(e); }

        long confirm = 0;
        int values = 0;
        // initializing to meaningless value
        String read[] = new String[1];

        // simple reading the csv to double check while leaving .csv for manual confirmation
        try(BufferedReader reader = new BufferedReader(new FileReader("num.csv"))){
            read = reader.readLine().split(",");
        }catch(IOException e){ örr(e); }

        for (String s : read)
            try{ confirm += Integer.parseInt(s); values++; }catch(Exception e){ örr(e); }

        cores = Runtime.getRuntime().availableProcessors();
        threads = new Thread[cores];
        start = new int[cores];

        // cheap way to handle the first thread as we can't divide by zero,
        // unfortunately in this universe
        start[0] = 0;
        for (int i = 1; i < cores; i++)
            start[i] = num / cores * i;
        
        threads[0] = new Thread(new tehtava2(1, numbers, start, num, cores));
        for (int i = 1; i < cores; i++)
            threads[i] = new Thread(new tehtava2(i+1, numbers, start, num, cores));
        
        for (Thread t : threads)
            t.start();

        // we'll wait for all threads to finish and collate a kind of a report
        try{
            for (int i = 0; i < cores; i++){
                threads[i].join();
                System.out.println("Thread: " + (i+1) + "\tStart: " + (start[i]+1) + "\tEnd: "
                        + ((i < cores-1) ? start[i+1] : num));
            }
        }catch(InterruptedException e){ örr(e); };

        System.out.println("Sum is " + sum);

        System.out.println("Calculated from the " + values + " values in .csv the sum is: " + confirm);
        // I guess it worked? Who would've guessed, not me..
        //

        writeP(numbers);
    }

    public tehtava2(int core, int[] numbers, int[] start, int num, int cores){
        this.numbers = numbers;
        this.cores = cores;
        this.start = start;
        this.num = num;
        this.core = core;
    }

    public void run(){
        int end = core < cores ? start[core] : num;
        for (int i = start[core-1]; i < end; i++){
            add(numbers[i]);

        }
    }


    // debugging for what goes wrong
    // this proves that the add misses lines?
    // wc -l addP.csv && wc -l numsP.csv
    // shows different number of lines
    // diff addP.csv numsP.csv -y --suppress-common-lines
    // shows missing lines
    // why? something goes wrong with synchronized?
    private static PriorityQueue<Integer> added =
        new PriorityQueue<>((Integer i1, Integer i2) -> Integer.compare(i1, i2));
    private static void writeP(int[] numbers){
        while (!added.isEmpty())
            writer(added.poll(), "addP.csv");
        PriorityQueue<Integer> nums =
            new PriorityQueue<>((Integer i1, Integer i2) -> Integer.compare(i1, i2));
        for (int i : numbers)
            nums.add(i);
        
        while (!nums.isEmpty())
            writer(nums.poll(), "numsP.csv");
    }


    private synchronized void add(int i){ sum += i; writer(i, "add.csv"); added.add(i); }

    private static synchronized void writer(int i, String s){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(s, true))){
            bw.write(i+"\n");
        }catch(IOException e){ örr(e); }
    }

   

    // örr-örr vii häv ei feiljur
    private static void örr(Exception e){
        System.out.println("Örr... I'm in the wrong line of work..\n" + e.toString());
        // Developer.fired(true);
    }

}
