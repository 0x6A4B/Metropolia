public class Test{

    public static void main(String []args){

        EventList e = new EventList();
        ArrivalProcess a = new ArrivalProcess();
        Clock clock = Clock.singleton();

 //       a.createEvents(10, e);
        for (int i = 0; i < 10; i++){
            a.addEvent(e);
            clock.set(e.peekEvent().getEventTime());
        }

        while (!e.isEmpty()){
            System.out.printf("Event: %d\n", e.pollEvent().getEventTime());
        }

    }


}
