import java.util.Arrays;
import java.util.List;

public class tehtava2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // stream with method reference and lambdas
        System.out.println(list.stream().filter(tehtava2::isOdd).map(i -> i * 2).reduce(0, (a, b) -> a + b));

        // interfaces
        isOdd odd = (i) -> i % 2 != 0;
        doubled dd = (i) -> i * 2;
        add ad = (i, j) -> i + j;

        // ... this is not the way ...
        // using lambda for sum with foreach... just to avoid stream and use only lambda and functional interface
        int sum[] = {0};
        list.forEach(i -> {
            if (odd.isOdd(i))
                sum[0] = ad.add(sum[0], dd.doubled(i));
        });
        System.out.println(sum[0]);

        // method reference with functional interfaces and integer.sum for reduce
        // but it's just the same stream filter map reduce
        System.out.println(list.stream().filter(odd::isOdd).map(dd::doubled).reduce(0, Integer::sum));
        //reduce(0, (x, y) -> x + y));

        // using recursive function
        System.out.println(recursiveAdd(list.toArray(new Integer[list.size()])));

        // minkä takia "huonompi" taulukon kopionti ratkaisu kykenee käsittelemään suuremman
        // taulukon ennen stackoverflowerror:ia kuin ratkaisu jossa taulukkoa ei kopioida?
        Integer u[] = new Integer[30000000];
        Arrays.fill(u, 1);
        /*
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("2: " + _recursiveAdd(u, u.length - 1));
            } catch (StackOverflowError e) {
                System.out.println("stack overflow2");
            }
            try {
                System.out.println("1: " + recursiveAdd(u));
            } catch (StackOverflowError e) {
                System.out.println("stack overflow1");
            }
        }

         */


        new Thread(null, ()->{
            System.out.println("with thread: " + _recursiveAdd(u, u.length-1));
        }, "test", 1<<30).start(); // noin 1GB stacksize on maksimi

        // nyt päädytään tällä tavalla out of memoryyn eli heap loppuu
        // myös saadaan esille taulukon kopioinnin tehottomuus
        boolean rankaiseCPUta = false;
        if (rankaiseCPUta)
            new Thread(null, ()->{
                System.out.println("with thread and copy: " + recursiveAdd(u));
            }, "test", 1<<26).start();


    }

    static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    // kopioidaan taulukkoa => hitaampi
    static int recursiveAdd(Integer[] a) {
        int sum = 0;
        if (a.length > 1)
            sum += recursiveAdd(Arrays.copyOfRange(a, 1, a.length));
        if (a[0] % 2 != 0)
            return a[0] * 2 + sum;
        return sum;
    }

    // ei kopioida taulukkoa => nopeampi, mutta päätyy stack overflow:hun aiemmin?
    static int _recursiveAdd(Integer[] a, int i) {
        if (i == 0) {
            if (a[0] % 2 != 0)
                return a[0] * 2;
        } else if (a[i] % 2 != 0)
            return a[i] * 2 + _recursiveAdd(a, i - 1);

        return 0;
    }

}

@FunctionalInterface
interface isOdd {
    boolean isOdd(int i);
}

interface doubled {
    int doubled(int i);
}

interface add {
    int add(int i, int j);
}


