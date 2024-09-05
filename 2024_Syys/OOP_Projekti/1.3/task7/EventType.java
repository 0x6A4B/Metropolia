
public enum EventType{
    UNDEFINED ("Undefined"),
    ARRIVAL ("Arrival"),
    EXIT ("Exit");

    private final String eventString;

    EventType(String s){ eventString = s; }

    public String toString(){ return eventString; }
}
