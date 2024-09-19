/*  We shall do it the easy way and let's cut the array in to thread sized bites
    in the main and just let all run their own sum ints and arrays for no need of
    synchronizing, because the version with sync ended up having erratic results when
    ran for many many iterations. Weird..
 */

public class tehtava2{
    public static void main(String[] args){
        Thread[] threads;
        int cores;
        int num = 1000000;
        int[] numbers;
        long sum = 0;
        numbers = new int[num];

        // parameterize the size
        try{
        if (args.length > 0)
            num = Integer.parseInt(args[0]);
        }catch(Exception e){ System.out.println("Naughty user!!! Santa won't visit you!!!"); }

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = (int) ((Math.random() * 100) * (Math.random() * 100));

        cores = Runtime.getRuntime().availableProcessors();
        threads = new Thread[cores];

        int[][] numnum = new int[cores][numbers.length/cores];
        int u = 0;
        for (int i = 0; i < cores; i++){
            for (int j = 0; j < numbers.length/cores; j++)
                numnum[i][j] = numbers[u++];
        }

        Adder[] adders = new Adder[cores];

        for (int i = 0; i < cores; i++){
            adders[i] = new Adder(numnum[i]);
            threads[i] = new Thread(adders[i]);
        }

        for (Thread t : threads)
            t.start();

        // we'll wait for all threads to finish and collate a kind of a report
        try{
            for (int i = 0; i < cores; i++){
                threads[i].join();
                sum += adders[i].getSum();
                System.out.println("Thread: " + (i+1) + "\tSum: " + adders[i].getSum());
            }
        }catch(InterruptedException e){ örr(e); };

        System.out.println("Sum is " + sum);
        System.out.println("Cores: " + numnum.length + "\tNumbers per core: " + numnum[0].length);

        // testing our sum in two different ways to find out possible
        // errors and the possible error in multidimensional array
        long test = 0;
        for (int i = 0; i < cores; i++){
            for (int j = 0; j < numnum[0].length; j++)
                test += numnum[i][j];
        }
        System.out.println("Test 1: " + test);
        test = 0;
        for (int i = 0; i < numbers.length; i++)
            test += numbers[i];
        System.out.println("Test 2: " + test);
    }

    // örr-örr vii häv ei feiljur
    private static void örr(Exception e){
        System.out.println("Örr... I'm in the wrong line of work..\n" + e.toString());
        // Developer.fired(true);
    }
}

class Adder  implements Runnable{

    private int sum = 0;
    private int[] numbers;

    public Adder(int[] numbers){
        this.numbers = numbers;
    }

    public void run(){
        for (int i : numbers)
            sum += i;
    }

    public int getSum() {
        return sum;
    }
}