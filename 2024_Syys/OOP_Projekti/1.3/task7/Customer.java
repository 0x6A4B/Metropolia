public class Customer{


    private static int lastId = 0;
    
    private int id;
    private long startTime;
    private long endTime;
    private String name;

    public Customer(){
        setId(++lastId);
        System.out.println("Customer: " + this.id + " created");
    }

    public Customer(boolean b){
        setId(++lastId);
        System.out.print("Customer: " + this.id + " created");
        if (b){
            setQueueIn();
            System.out.print(" and set to queue");
        }
        System.out.print("\n");
    }

    private void setId(int id){
        if (id >= 1 && id < Integer.MAX_VALUE){
            this.id = id;
        }
        else        
            System.out.println("Error in setting Id for customer");
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
