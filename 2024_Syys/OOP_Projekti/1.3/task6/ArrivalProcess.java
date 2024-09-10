import java.util.ArrayList;
import eduni.distributions.*;


public class ArrivalProcess{

    Binomial b;
    EventType type;
    long lastArrival = 0;

    public ArrivalProcess(){
        b = new Binomial(0.5, 10);
    }

    public long getRand(){
        return b.sample();
    }
/*
    public void addEvent(EventList e){
        e.addEvent(new Event());
    }
    */
    public void addEvent(EventList e){
        lastArrival += getRand();
        Event ev = new Event();
        ev.setEventTime(lastArrival);
        e.addEvent(ev);
    }

    public void createEvents(int events, EventList e){
        for (int i = 0; i < events; i++){
            addEvent(e);
/*            lastArrival += getRand();
            Event ev = new Event();
            ev.setEventTime(lastArrival);
            e.addEvent(ev);
            */

        }

    }


}
