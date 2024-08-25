public class Test{

    public static void main(String[] args){

//        Asiakas a = new Asiakas();
        Asiakas[] aA = new Asiakas[100];
//        int[] idList = new int[100];

        for (int i = 0; i < 100; i++){
            Asiakas a = new Asiakas();
//            idList
        }

        if(testId())
            System.out.println("Id generation seems to work");
        else
            System.out.println("Id generation doesn't work");

        Asiakas a = new Asiakas();
        if (testQueueTime(a))
            System.out.println("Queue time seems to work");
        else
            System.out.println("Queue time failing");

    }

    private static boolean testId(){
        boolean pass = false;
        int[] idArr = new int[100];

        for(int i = 0; i < 100; i++){
            pass = false;
            Asiakas a = new Asiakas();
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

    private static boolean testId(Asiakas[] a){

        return false;
    }

    private static boolean testQueueTime(Asiakas a){
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
