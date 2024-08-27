public class Test{
    
    public static void main(String[] args){
        int events = 10;
        EventList list = new EventList();

        if (args.length > 0){
            try{ events = Integer.parseInt(args[0]); }
            catch (Exception e){}
        }

        // add an event but do not stamp it, so no event time
        // it is also an undefined event
        // Using this to test the sorting based on event time and not time of adding
        // or id etc.
        list.addEvent(new Event());
        // stamp the first event with a number obviously shifting the event to last
        list.peekEvent().setEventTime(6666666666666666L);


        for (int i = 0; i < events; i++){
            list.addEvent(new Event((i%2==0 ? EventType.ARRIVAL : EventType.EXIT), true));
        }

        // remove first event on the queue based on event time because priority queue
        // returns based on the compareto which is set to return based on event time,
        // first event will be event ID 2 as event ID 1 is set to be last based on event
        // time
        list.removeEvent(list.peekEvent());

        while (!list.isEmpty()){
            System.out.println(list.pollEvent().toString());
        }
    }

}
