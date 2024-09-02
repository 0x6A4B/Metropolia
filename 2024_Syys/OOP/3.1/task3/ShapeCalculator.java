import java.net.InetAddress;
import java.net.UnknownHostException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


import java.util.Random;

public class ShapeCalculator{

    public static void main(String []args){
        int runs = 5, nrOfShapes = 10;
        String[] shapes = { "Circle", "Rectangle", "Triangle" };

        try{
            runs = (args.length > 0) ? Integer.parseInt(args[0]) : runs;
            nrOfShapes = (args.length > 1) ? Integer.parseInt(args[1]) : nrOfShapes;
        }catch(Exception ö){
            try{
            System.out.printf("ÖrrÖr!! User is suck!!\n%s won't play with %s!!\n\n"
                    , InetAddress.getLocalHost().getHostName()
                    , System.getProperty("user.name"));
            }catch(UnknownHostException e){
                System.out.println("I did this to myself :(\n" 
                    + "I'm ashamed but can't help myself\n\n");
                System.exit(69);
            }
            System.exit(666);
        }


        // with polymorphism
        while(runs > 0){

            Shape[] createdShapes = new Shape[nrOfShapes];
            for(int i = 0; i < createdShapes.length; i++){
                try{
                    Class<?> santaClaus = Class.forName(getRand(shapes));
                    Constructor<?> daveTheBuilder = santaClaus.getConstructor();
                    Object obj = daveTheBuilder.newInstance();
                    createdShapes[i] = (Shape) obj;
                }catch(ClassNotFoundException | InstantiationException
                        | IllegalAccessException | InvocationTargetException
                        | NoSuchMethodException e){
                    System.out.println("Surprise surprise...\n" + e.toString());
                        }
               
            }

            for (Shape s : createdShapes)
                System.out.println("Shape: " + s.getClass()
                        + (s.getClass().equals("Circle") ? " radius: " : " side 1 and 2: ")
                        + "1" + " area: " + s.calculateArea(1.0)
                        );

        }

    }

    private static String getRand(String[] s){
        Random r = new Random();
        return s[r.nextInt(0, s.length)];
    }

}
