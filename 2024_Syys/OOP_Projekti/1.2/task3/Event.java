public class Event implements Comparable<Event>{
    private long eventTime = -1;
    private static int lastId = 0;
    private int id = 0;
    private EventType eventType = EventType.UNDEFINED;

    public Event(){ id = ++lastId; }
    public Event(boolean b){ this(); if (b) stampEvent(); /*id = ++lastId;*/ }
    public Event(EventType e){ this(); eventType = e; }
    public Event(EventType e, boolean b){ this(b); eventType = e; }


    public long getEventTime(){ return eventTime; }
    public void setEventTime(long l){ eventTime = l; } // this is only for testing/demonstration

    public void stampEvent(){
        eventTime = System.nanoTime();
    }

    public void setEventType(EventType e){ eventType = e; }

    public EventType getEventType(){ return eventType; }

    @Override
    public int compareTo(Event e){
        return (eventTime < e.eventTime) ? -1 : ((eventTime > e.eventTime) ? 1 : 0);
    }

    public String toString(){ return "Event " + id + " of type " + eventType.toString() + " with event time: " + eventTime; }

}
/*
enum EventType{
    UNDEFINED ("Undefined"),
    ARRIVAL ("Arrival"),
    EXIT ("Exit");

    private final String eventString;

    EventType(String s){ eventString = s; }

    public String toString(){ return eventString; }
}
*/
