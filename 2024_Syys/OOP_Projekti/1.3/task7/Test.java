public class Test{

    public static void main(String []args){

        EventList e = new EventList();
        ArrivalProcess a = new ArrivalProcess();

        ServicePoint sp = new ServicePoint();

        Clock clock = Clock.singleton();

        a.createEvents(5, e);
        System.out.println("First arrival event time: " + e.peekEvent().getEventTime());
        System.out.println("Last arrival event time: " + a.getLastArrival() + "\n");

        while (!e.isEmpty()){
            // set the clock to point to the next arrival event time
            clock.set(e.peekEvent().getEventTime());
            System.out.printf("Arrival Event: %d processed\n", e.pollEvent().getEventTime());
            sp.addToQueue(new Customer());
//            clock.set(clock.get()+1);
            System.out.println("This would be exit event");
            sp.serve();
            System.out.println();
        }

    }


}
