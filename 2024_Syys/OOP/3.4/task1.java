import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class task1 {

    public static void main(String[] args) {

        URL target;
        StringBuilder response = new StringBuilder();

        try {
            target = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
        } catch (MalformedURLException e) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(target.openStream()));

            String data;
            while ((data = reader.readLine()) != null) response.append(data+"\n");

            reader.close();
        } catch (IOException e) {

        }

        String temp[] = response.toString().split("\n");
        double sum = 0;
        int hits = 0;
        // first line is title, we won't need it
        for (int i = 1; i < temp.length; i++) {
            String[] temp2 = temp[i].split(";");
            // only gonna use the 2 first columns
            if (temp2[0].substring(0, 10).contains("01.01.2023")) {
//                sum += Double.parseDouble(temp2[1].replace(",","."));
                try {
                    sum += NumberFormat.getNumberInstance(
                            Locale.GERMAN).parse(temp2[1]).doubleValue();
                } catch (ParseException e) {
                    System.out.println("Schai...");
                }
                hits++;
            }
        }

        System.out.println("Sum of temperature: " + sum + "\tMeasurements:  " + hits);
        System.out.printf("Average for 01.01.2023: %.2f", sum / hits);

    }
}