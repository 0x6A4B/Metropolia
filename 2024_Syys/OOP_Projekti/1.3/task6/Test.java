public class Test{

    public static void main(String []args){

        EventList e = new EventList();
        ArrivalProcess a = new ArrivalProcess();

        a.createEvents(10, e);

        while (!e.isEmpty()){
            System.out.printf("Event: %d\n", e.pollEvent().getEventTime());
        }

    }


}
