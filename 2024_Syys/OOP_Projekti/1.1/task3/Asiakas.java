public class Asiakas{


    private static int lastId = 0;
    
    private int id;
    private long startTime;
    private long endTime;
    private String name;

    public Asiakas(){
        
        setId(++lastId);

        System.out.println("Asiakas: " + this.id + " luotu");

    }


    public Asiakas(int id){

        System.out.println("Asiakas luotu");

    }

    public void setId(int id){

        if (id > 1000 && id < Integer.MAX_VALUE){
            this.id = id;
            lastId++;

        }        
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void printId(){
        System.out.println("Id: " + id);
    }

    public void setQueueIn(){
        this.startTime = System.currentTimeMillis();
    }


    public void setQueueOut(){
        this.endTime = System.currentTimeMillis();
    }

    public long getQueueTime(){
        return this.endTime - this.startTime;
    }
}
