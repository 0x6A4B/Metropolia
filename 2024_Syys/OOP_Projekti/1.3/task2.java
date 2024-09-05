/* 
 * Task 2 : distribution
 */
import java.util.ArrayList;

public class task2{

    static int iterations = 1000000;

    // array with percentage chances and ages
    static int ageDistribution[][] = {
        {10, 18},
        {20, 19},
        {20, 20},
        {20, 21},
        {10, 22},
        {5, 23},
        {5, 24},
        {5, 25},
        {3, 24},
        {2, 25}
    };


    public static void main(String[] args){
  
        ArrayList<Age> ages = generateAges(ageDistribution);
        // iterate for better distribution. use floor to make sure we won't get 101
        // use +1 to make sure we won't get 0
        for (int i = 0; i < iterations; i++)
            match((int)Math.floor(Math.random()*100)+1, ages);
        
        // printing with pretty lambda
        ages.forEach( (age) -> { 
            System.out.printf("Age: %d \tChance: %.2f \tHits: %d \tHit: %.2f\n"
                    , age.getAge()
                    , age.getChance(), age.getHits(), (1.0*age.getHits()/iterations)*100);
        });
    }

    // function for aesthetically matching age
    // return only for simplicity
    static boolean match(int i, ArrayList<Age> ages){
        for (Age age : ages)
            if (age.match(i))
                return age.addHit();
        return false;
    }

    static ArrayList<Age> generateAges(int[][] a){
        // let's make sure the given array at least totals 100%
        // for minimal validation
        int maxPerc = 0;
        for (int[] i : a)
            maxPerc += i[0];
        if (maxPerc != 100) return null;

        ArrayList<Age> ages = new ArrayList<>();
        int lastNum = 0;
        for (int[] i : a){
            ages.add(new Age(i[0], lastNum+i[0], i[1]));
            lastNum += i[0];
        }
        return ages;
    }
}

class Age{

    int dist;
    double chance;
    int age;

    int hits;

    Age(double chance, int age){ this.chance = chance; this.age = age; }
    Age(double chance, int dist, int age){
        this.chance = chance; this.dist = dist; this.age = age;
    }
    Age(){}

    boolean addHit(){ hits++; return true; }
    int getHits(){ return hits; }
    int getAge(){ return age; }
    double getChance(){ return chance; }

    boolean match(int i){ return (i <= dist); }
}

