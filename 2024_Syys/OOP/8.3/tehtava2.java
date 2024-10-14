import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tehtava2 {
    public static void main(String[] args){
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> newList = new ArrayList<>();

        // koska foreach:ista ei voi palauttaa arvoa, eikä muokata kyseistä listaa, en keksi
        // muuta tapaa kuin käyttää toista listaa
        intList.forEach(i -> {if (i % 2 != 0) newList.add(i);});
        newList.replaceAll((i) -> i*2);


        newList.forEach(System.out::println);

        // en kyllä keksi miten lambdaa voisi käyttää summaamiseen ilman stream:ia
        // lambdassa muuttujan oltava final, miten pystyn pitämään muistissa edellisen arvon?
        // foreach:ista ei saa palautettua, joten mikä olisi lambdalle luonteva iterointi?
        // tämä käyttää lambdaa summaamiseen, mutta ei tässä järkeä ole?
        // nyt en vain tajua
        int sum = 0;
        SumF summF = (x, y) -> x + y;
        for (int i : newList) sum = summF.add(sum, i);

        System.out.println(sum);

        // typerä tapa kiertää final koska taulukko on final vaikka arvo sen sisällä vaihtuu
        int sumA[] = new int[1];
        newList.forEach(i -> sumA[0] += i);
        System.out.println(sumA[0]);

        // stream on kyllä ehdottoman fiksu keksintö


    }
}

interface SumF{
    int add(int a, int b);
}


