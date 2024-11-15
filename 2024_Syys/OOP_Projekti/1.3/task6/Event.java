public class Event implements Comparable<Event>{
    private long eventTime = -1;
    private static int lastId = 0;
    private int id = 0;
    private EventType eventType = EventType.UNDEFINED;

    public Event(){ id = ++lastId; }
    public Event(boolean b){ this(); if (b) stampEvent(); }
    public Event(EventType e){ this(); eventType = e; }
    public Event(EventType e, boolean b){ this(b); eventType = e; }


    public long getEventTime(){ return eventTime; }
    public void setEventTime(long l){ eventTime = l; } // this is only for testing/demonstration of the compareto sorting
                                                       // with event time and not with id or order of addition to priorityqueue

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
