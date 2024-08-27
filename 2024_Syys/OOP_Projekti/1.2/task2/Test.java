public class Test{
    
    public static void main(String[] args){
        int events = 10;
        EventList list = new EventList();

        if (args.length > 0)
            try{ events = Integer.parseInt(args[0]); }
            catch (Exception e){}


        for (int i = 0; i < events; i++){ list.addEvent(new Event(true)); }

        while (!list.isEmpty()){
            System.out.println(list.pollEvent().toString());
        }
    }

}
