import java.io.IOException;
import java.math.BigInteger;
import java.io.FileWriter;

public class task2 {

    public static void main(String[] args){
        int nr = 100;
        BigInteger []fib = new BigInteger[100];
        fib[0] = BigInteger.valueOf(0); fib[1] = BigInteger.valueOf(1);
        for (int i = 2; i < 100; i++)
            fib[i] = fib[i-1].add(fib[i-2]);

        StringBuilder sb = new StringBuilder();
        for (BigInteger l : fib)
            sb.append(l + ",");

        String result = sb.toString().substring(0, sb.toString().length()-1);
        System.out.println(result);

        try(FileWriter writer = new FileWriter("fibonacci.csv")){
            writer.write(result);
        }catch (IOException e){
            System.out.println("We messed up..." + e.getMessage());
        }
    }
}
