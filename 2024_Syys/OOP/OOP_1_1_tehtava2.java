/*
 *  Joonas Karppinen
 *  joonas.karppinen@metropolia.fi
 *
 *  Tehtava 2: Tulosta asteriskeista pyramidi
 *  Toteutettu apumetodeja käyttäen olio-hengessä
 *
 */


public class OOP_1_1_tehtava2{
    
    private static String spaces(int length, int asterisks){
        int spcs = (length - asterisks) / 2;
        String str = "";
        for (int i = 0; i < spcs; i++) {
            str += " ";
        }
        return str;
    }

    private static String asterisks(int as){
        String str = "";
        for (int i = 0; i < as; i++){
            str += "*";
        }
        return str;
    }


    public static void main(String[] args){
        int length_of_line = 7;
        int number_of_lines = 4;
        int number_of_asterisks = 1;
        int asterisks_added_per_cycle = 2;

        String result = "";

        for (int i = 0; i < number_of_lines; i++){
            result += spaces(length_of_line, number_of_asterisks);
            result += asterisks(number_of_asterisks) + "\n";
            
            number_of_asterisks += asterisks_added_per_cycle;

        }
        System.out.println(result);
    }



}
