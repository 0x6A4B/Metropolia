public class Test{

    public static void main(String[] args){

        Customer[] aA = new Customer[100];

        for (int i = 0; i < 100; i++){
            aA[i] = new Customer();
        }

        if(noIdDuplicates(aA))
            System.out.println("No Id duplicates found");
        else
            System.out.println("Id duplicates found");
        
        if(idAdvancesByOne(aA))
            System.out.println("Id advances by one");
        else
            System.out.println("Id doesn't advance by one as required");

        Customer a = new Customer();
        if (testQueueTime(a))
            System.out.println("Queue time measured within 5ms");
        else
            System.out.println("Queue time failing");

    }

    private static boolean noIdDuplicates(Customer[] a){
        int[] ids = new int[a.length];

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                if (ids[j] == a[i].getId())
                    return false;
            }
            ids[i] = a[i].getId();
        }
        return true;
    }

    private static boolean idAdvancesByOne(Customer[] aa){
        int lastId = 0;
        for(Customer a : aa){
            if (!(a.getId() == lastId+1))
                return false;
            lastId = a.getId();
        }
        return true;
    }
/*
    private static boolean testId(){
        boolean pass = false;
        int[] idArr = new int[100];

        for(int i = 0; i < 100; i++){
            pass = false;
            Customer a = new Customer();
            if(a.getId() > 0){
                for(int u: idArr){
                    if(a.getId() == u)
                        break;
                }
                idArr[i] = a.getId();
                pass = true;
            }
        }
        return pass;
    }

    private static boolean testId(Customer[] a){

        return false;
    }
*/
    private static boolean testQueueTime(Customer a){
        long start, end;

        start = System.currentTimeMillis();
        a.setQueueIn();
        try{
            Thread.sleep(1500);
        }
        catch (Exception e){
            
        }
        end = System.currentTimeMillis();
        a.setQueueOut();
        if (Math.max((end-start), a.getQueueTime())
                - Math.min((end-start), a.getQueueTime()) < 5)
            return true;
        return false;
    }

}
