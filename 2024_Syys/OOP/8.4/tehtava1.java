import java.util.Arrays;

public class tehtava1 {
    public static void main(String args[]){
        int[] intA = {1, 2, 3, 4, 5, 6, 7, 8};

        // ? a readymade mean function in the stream...
        double mean = Arrays.stream(intA).average().getAsDouble();
        System.out.println(mean);

        double mean2 = (double)Arrays.stream(intA).reduce(0,(a, b) -> a + b) / intA.length;
        double mean3 = (double)Arrays.stream(intA).sum() / Arrays.stream(intA).count();

        System.out.println(mean2 + " - " + mean3);

        Adder adder = (x, y) -> x + y;

        System.out.println((double)Arrays.stream(intA).reduce(0, adder::add) / intA.length);



    }
}

interface Adder{
    int add(int a, int b);
}

//double add(int x, int y){

//}
