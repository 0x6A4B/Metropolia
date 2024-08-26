public class Test{

    public static void main(String[] args){
        int numberOfRuns = 5, numOfCustomers = 10;

        for (int i = 0; i < numberOfRuns; i++){
            new Test().runTest(numOfCustomers);
        }

    }

    public void runTest(int i){
        ServicePoint servicePoint = generateCustomers(i, new ServicePoint());

        servicePoint.serve();

        int serviceTime = servicePoint.getSumServiceTime();
        int customersServed = servicePoint.getNumOfCustomers();
        System.out.println("Service time for " + customersServed + " customers: "
                + serviceTime + " - Average service time per customer: "
                + (1.0*serviceTime/customersServed));

        if (servicePoint.getNumOfCustomers() != i)
            System.out.println("Failure in serving all customers "
                    + "or keeping track of served customers");
       
        if (servicePoint.getSumServiceTime() <= 1)
            System.out.println("Failure in keeping track of service time");

    }

    public ServicePoint generateCustomers(int i, ServicePoint s){
        return new CustomerGenerator(i, s, true).getServicePoint();
    }
/*
    public boolean checkNumOfCustomers(int i){
        return false;
    }
*/
}
