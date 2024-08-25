//
// Will not work reliably if multiple subarrays have the same max sum!
// Will just return the first subarray
//

import java.util.Scanner;

public class OOP_1_4_tehtava2{


    public static void main(String[] args){
        int size = 0, maxSum = 0, indexOfMaxSum = 0, indexOfEnd = 0;
        Scanner input = new Scanner(System.in);
        int array[]; boolean alien = false;

        if (args.length > 0){
            alien = (args[0].equals("alien")) ? true : false;

            array = new int[args.length];
            size = args.length;
            int argNr = 0;
            if (alien){
                String[] args2 = new String[args.length-1];
                for (int l = 1; l < args.length; l++){
                    args2[l-1] = args[l];
                }
                args = new String[args.length-1];
                args = args2;
            }
            for (String a: args){
                array[argNr] = Integer.parseInt(a);
                argNr++;
            }
        }
        else{

            System.out.print("Enter the size of the array: ");
            size = Integer.parseInt(input.nextLine());
            array = new int[size];

            System.out.println("Enter the integers into the array:");

            for(int i = 1; i <= size; i++){
                System.out.print("Enter integer " + i + ": ");
                array[i-1] = Integer.parseInt(input.nextLine());

            }
        }

/*
// Unfinished
        Integer[][] _subA = getSubArrays(array);
        int _maxSum = 0, _start = 0, _size = 0;

        for (Integer[] _i: _subA){
            int _sum = 0;
            for (Integer _ii : _i){
                
                if (_i != null){
                    _sum += _sum;
                    _size++;
                }

            }

        }
*/

        /* Using subarray class */
        OOP_1_4_tehtava2 oo = new OOP_1_4_tehtava2();
        for (SubArray s: oo.getArrayObjects(array)){
            if (s.getSum() > maxSum) {
                maxSum = s.getSum();
                indexOfMaxSum = s.getIndex();
                indexOfEnd = indexOfMaxSum + s.getSize();
            }
            
        }
        System.out.println("Maximum sum: " + maxSum + "\nIntegers: " + (indexOfMaxSum+1) + "-" + indexOfEnd);

        if (alien)
            oo.alien();
    }

    public void alien(){
        new SubArray().printAlien();
    }

    // not used with the class based solution
    private static Integer[][] getSubArrays(int a[]){
        Integer[][] subArr = new Integer[a.length*(a.length+1)/2][a.length];
        int sizeOfSub = 1;
        int nrOfLoops =  a.length;
        int startIndex = 0;
        int ii = 0;

        for (int i = 0; i < subArr.length; i++){
            for (int j = startIndex; j < startIndex + sizeOfSub; j++){
                if (j < a.length)
                    subArr[i][ii] = a[j];
                ii++;
            }
            startIndex++;
            if (ii >= sizeOfSub){
                ii = 0;
            }
            if (startIndex == nrOfLoops){
                sizeOfSub++;
                startIndex = 0;
                nrOfLoops--;
            }
        }

        return subArr;
    }


    // Returns beautiful aliens, so nice.
    private SubArray[] getArrayObjects(int a[]){
        SubArray[] arrays = new SubArray[a.length*(a.length+1)/2];

        int[][] subArr = new int[a.length*(a.length+1)/2][a.length];
        int sizeOfSub = 1;
        int nrOfLoops =  a.length;
        int startIndex = 0;
        int ii = 0;

        for (int i = 0; i < subArr.length; i++){
            for (int j = startIndex; j < startIndex + sizeOfSub; j++){
                if (j < a.length)
                    subArr[i][ii] = a[j];
                ii++;
            }
            arrays[i] = new SubArray(sizeOfSub, subArr[i], startIndex);
            //arrays[i] = new SubArray(sizeOfSub, subArr[i]);
            startIndex++;
            if (ii >= sizeOfSub){
                ii = 0;
            }
            if (startIndex == nrOfLoops){
                sizeOfSub++;
                startIndex = 0;
                nrOfLoops--;
            }
        }

        return arrays;
    }

    // The beautiful alien
    class SubArray{
        private int size;
        private int [] array;
        private int startIndex;
        private String alien = """
            .-.
        .-""`""-.    |(@ @)
     _/`oOoOoOoOo`\\_ \\ \\-/
    '.-=-=-=-=-=-=-.' \\/ \\
jgs   `-=.=-.-=.=-'    \\ /\\
         ^  ^  ^       _H_ \\
         """;

        public SubArray(){
        }
        public SubArray(int s, int[] a){
            this.size = s;
            this.array = a;
        }

        public SubArray(int s, int[] a, int i){
            this.size = s;
            this.array = a;
            this.startIndex = i;
        }

        public void setSize(int s){
            this.size = s;
        }

        public void setArray(int[] a){
            this.array = a;
        }

        public void setIndex(int i){
            this.startIndex = i;
        }

        public int getSize(){
            return size;
        }

        public int[] getArray(){
            return array;
        }

        public int getSum(){
            int sum = 0;
            for (int i : array){
                sum += i;
            }
            return sum;
        }

        public int getIndex(){
            return startIndex;
        }

        public void printAlien(){
            System.out.println("\n\n\n" + alien + "\n\n");
        }
    }

}
