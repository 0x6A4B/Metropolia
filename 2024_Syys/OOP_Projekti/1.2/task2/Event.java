public class Event implements Comparable<Event>{
    private long eventTime = -1;
    private static int lastId = 0;
    private int id = 0;

    public Event(){ id = ++lastId; }
    public Event(boolean b){ this(); if (b) stampEvent(); }


    public long getEventTime(){ return eventTime; }
    public void setEventTime(long l){ eventTime = l; } // this is only for testing/demonstration
                                                       // of the compareto sorting based on event time

    public void stampEvent(){
        eventTime = System.nanoTime();
    }



    @Override
    public int compareTo(Event e){
        return (eventTime < e.eventTime) ? -1 : ((eventTime > e.eventTime) ? 1 : 0);
    }

    public String toString(){ return "Event " + id + " with event time: " + eventTime; }

}
