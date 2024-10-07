public class task1{

    public static boolean isPalindrome(String s){
        String reversed = "";
        s = s.toLowerCase().replaceAll("[^a-zA-ZäöåÄÖÅ]+", "");

        for (int i = s.length()-1; i >= 0; i--){
            reversed += s.charAt(i);
        }
        return reversed.equals(s);
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("test"));
        System.out.println(isPalindrome("-aa"));
        System.out.println(isPalindrome("1a-a"));
        System.out.println(isPalindrome("ä ö'ä"));
    }

}
