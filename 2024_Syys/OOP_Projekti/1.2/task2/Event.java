public class Event implements Comparable<Event>{
    private long eventTime = -1;
    private static int lastId = 0;
    private int id = 0;

    public Event(){ id = ++id; }
    public Event(boolean b){ if (b) stampEvent(); id = ++lastId; }

    public long getEventTime(){ return eventTime; }

    public void stampEvent(){
        eventTime = System.nanoTime();
    }

    public int compareTo(Event e){
        return (eventTime < e.eventTime) ? -1 : (eventTime > e.eventTime) ? 1 : 0;
    }

    public String toString(){ return "Event " + id + " event time: " + eventTime; }

}
