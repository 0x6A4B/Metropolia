import java.util.PriorityQueue;

public class EventList{
    PriorityQueue<Event> eventList;

    public EventList(){ eventList = new PriorityQueue<>(); }

    public void addEvent(Event e){ eventList.add(e); }

    public Event pollEvent(){ return eventList.poll(); }

    public Event peekEvent(){ return eventList.peek(); }

    public int size(){ return eventList.size(); }

    public boolean isEmpty(){ return eventList.isEmpty(); }

}
