public class task3{

    public static void main(String[] args){

        for (int i = 1; i < 1000; i++){
        Clock clock = Clock.singleton();
            clock.set(i*60);
            if (i%50 == 0)
                System.out.printf("Time event: %d\tTime: %d\tSome event happened\n"
                        , i, clock.get());
        }
    }
}

class Clock{

    private static Clock clock;
    private int time = 0;

    Clock(){}
    static Clock singleton(){ if (clock == null) clock = new Clock(); return clock; }
    int get(){ return time; }
    void set(int i){ time = i; }

}
