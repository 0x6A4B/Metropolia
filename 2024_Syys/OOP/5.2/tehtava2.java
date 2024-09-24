import java.util.ArrayList;
import java.util.Iterator;

public class tehtava2{

    public static void main(String args[]){
        ArrayList<String> list = new ArrayList<>();

        bag b = new bag();

        Thread t = new Thread(new test2(b, "1"));
        Thread t1 = new Thread(new test2(b, "2"));
        Thread t2 = new Thread(new test2(b, "3"));

        try{

            t.start();
            //Thread.sleep(20);
            t1.start();
            //Thread.sleep(20);
            t2.start();

            t.join(); t1.join(); t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("LIST SIZE: " + b.size());
        b.forEach(System.out::println); // pääsinpäs käyttämään method referenceä
    }
}

// Testataan thread safety, 3 * 3 pitäisi johtaa 9 kokoiseen listaan jossa
// kaikki EKA, TOKA ja KOLMAS esiintyy 3 kertaa
// delete operaation jälkeen 6 elementtiä listassa ja se mikä puuttuu on satunnaista, mutta
// useimmiten EKA:t puuttuu jokaiselta threadiltä koska kaikki threadit nopeammin ajaa run() metodin
// ensimmäisen add() metodin kuin yksi ehtisi koko metodin läpi
// eli: joka thread lisää EKA elementin, sitten TOKA elementin ja lopuksi KOLMAS elementin
// yleensä samaan tahtiin joten YLEENSÄ kolme ensimmäistä elementtiä ovat EKA
// Mutta ei aina johtuen threadien skeduloinnin satunnaisuudesta
// JOS sleepit ottaa käyttöön silloin jokainen thread ehtii tehdä kaikki lisäykset ennen seuraavaa
// ja ensimmäisen threadin EKA, TOKA ja KOLMAS tulee ensimmäisiksi ja poistetuksi
class test2 implements Runnable{
    String thread = "";

    public void run(){
        System.out.println("THREAD " + thread + " RUNNING");
        b.add("EKA: " + thread);
        b.add("TOKA: " + thread);
        b.add("KOLMAS: " + thread);
        System.out.println("Thread: " + thread + " SIZE: " + b.size());
        b.del();
    }

    bag b;
    test2(bag b, String s){
        this.b = b; thread = s;
    }
}

class bag implements Iterable<String>{
    ArrayList<String> list;

    bag(){ list = new ArrayList<>(); }

    // synkronisoidaan kaikki, myös size vaikka se ei olisi pakollinen koska lukua
    synchronized void add(String s){ list.add(s); }
    String get(){ return list.getFirst(); }
    synchronized void del(){ list.removeFirst(); }
    synchronized int size(){ return list.size(); }

    // koska method reference
    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }
}

