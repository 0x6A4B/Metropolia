import java.net.InetAddress;
import java.net.UnknownHostException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


import java.util.Random;

public class ShapeCalculator{

    static double rando;

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
                    String shape = getRand(shapes);
                    Class<?> santaClaus = Class.forName(shape);
                    Constructor<?> daveTheBuilder = santaClaus.getConstructor();
                    Object obj = daveTheBuilder.newInstance();
                    createdShapes[i] = (Shape) obj;
                    // Can't cast to interface?!?! WHYYYY?
                    // Because I didn't implement on all classes... *sigh*
                    //obj.getClass within switch statement is a preview feature...
                    /*
                    switch(shape){
                        case "Circle":
                            createdShapes[i] = (Circle) obj;
                            break;
                        case "Rectangle":
                            createdShapes[i] = (Rectangle) obj;
                            break;
                        case "Triangle":
                            createdShapes[i] = (Triangle) obj;
                            break;

                    }*/
                }catch(ClassNotFoundException | InstantiationException
                        | IllegalAccessException | InvocationTargetException
                        | NoSuchMethodException e){
                    System.out.println("Surprise surprise...\n" + e.toString());
                        }
               
            }

            for (Shape s : createdShapes)
                System.out.printf("Shape: %s \t%s: %.1f \tarea: %.1f\n", s.getClass()
                        , (s.getClass().toString().equals("class Circle") ? "radius" : "side")
                        , createRando(), s.calculateArea(rando));


            System.out.print(runs + " - \n");
            runs--;
        }

    }

    private static double createRando(){ return rando = Math.round(Math.random()*10*10)/10.0; }
    private static String getRand(String[] s){
        Random r = new Random();
        return s[r.nextInt(0, s.length)];
    }

}
