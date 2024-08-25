public class Main{

    public static void main(String[] a){
        ServicePoint servicePoint1 = new ServicePoint();
        CustomerGenerator generator;

        int nrOfCustomers = 10;

        if (a.length > 0){
            try{
                nrOfCustomers = Integer.parseInt(a[0]);
            }catch (Exception e){
                // no error handling, just using default number of customers
            }
        }

        generator = new CustomerGenerator(nrOfCustomers, servicePoint1);
        generator.generateCustomers();

        
        generator.getServicePoint().serve();

        int serviceTime = generator.getServicePoint().getSumServiceTime();
        System.out.println("Service time for " + nrOfCustomers + " customers: "
                + serviceTime + " - Average service time per customer: "
                + (1.0*serviceTime/nrOfCustomers));

    }

}



