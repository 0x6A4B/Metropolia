package library.system;

public class Rand {
    public static String getRand(String[] s){
        return s[(int)Math.round(Math.random()*(s.length-1))];
    }
}
