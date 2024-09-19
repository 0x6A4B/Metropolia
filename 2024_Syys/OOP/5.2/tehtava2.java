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
            /*            Thread.sleep(20);*/
            t1.start();
            /*            Thread.sleep(20);*/
            t2.start();

            t.join(); t1.join(); t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("LIST SIZE: " + b.size());
        b.forEach(System.out::println);
    }
}

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

    synchronized void add(String s){ list.add(s); }
    String get(){ return list.getFirst(); }
    synchronized void del(){ list.removeFirst(); }
    synchronized int size(){ return list.size(); }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }
}

