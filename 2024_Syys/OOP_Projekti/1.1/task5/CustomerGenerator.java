public class CustomerGenerator{

    int customers = 10;
    ServicePoint servicePoint;

    public CustomerGenerator(int c, ServicePoint s){
        customers = c;
        servicePoint = s;
    }

    public CustomerGenerator(int c, ServicePoint s, boolean b){
        customers = c;
        servicePoint = s;

        if (b)
            generateCustomers();
    }

    public void generateCustomers(){
        for (int i = 0; i < customers; i++){
            servicePoint.addToQueue(new Customer());
        }
    }

    public void setServicePoint(ServicePoint s){
        this.servicePoint = s;
    }

    public void setCustomerAmount(int i){
        this.customers = i;
    }

    public int getCustomerAmount(){
        return customers;
    }

    public ServicePoint getServicePoint(){
        return servicePoint;
    }

}
