/*public class task3{

    public static void main(String[] args){

        for (int i = 1; i < 1000; i++){
        Clock clock = Clock.singleton();
            clock.set(i*60);
            if (i%50 == 0)
                System.out.printf("Time event: %d\tTime: %d\tSome event happened\n"
                        , i, clock.get());
        }
    }
}*/

public class Clock{

    private static Clock clock;
    private long time = 0;

    public Clock(){}
    public static Clock singleton(){ if (clock == null) clock = new Clock(); return clock; }
    public long get(){ return time; }
    public void set(long i){ time = i; }

}
