import java.util.LinkedList;
import java.util.Random;

public class ServicePoint{
    int minServiceTime = 500, maxServiceTime = 1500; // ms per customer
    LinkedList<Customer> queue = new LinkedList<Customer>();

    public ServicePoint(){

    }

    public void addToQueue(Customer a){
        a.setQueueIn();
        queue.add(a);
    }

    public Customer removeFromQueue(){
        //return queue.removeLast();
        Customer c = queue.pop();
        c.setQueueOut();
        return c;
    }

    public void serve(){
        Random rand = new Random();
        int serviceTime = 0;
        Customer c;

        while(!queue.isEmpty()){
            c = removeFromQueue();
            serviceTime = rand.nextInt(minServiceTime, maxServiceTime);
            try{
                Thread.sleep(serviceTime);
            }catch (Exception e){
                error(e);
            }
            System.out.println("Customer: " + c.getId() + " - Service time: " + serviceTime + " response time: "
                    + (serviceTime + c.getQueueTime()));

        }
    }

    private void error(Exception e){
        // TODO: error handling
        System.out.println("An error has occurred! Exception: " + e.toString());
    }

}
