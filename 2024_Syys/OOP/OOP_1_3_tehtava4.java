import java.util.Scanner;
import java.util.Random;


public class OOP_1_3_tehtava4{

    public static void main(String[] args){
        OOP_1_3_tehtava4 a = new OOP_1_3_tehtava4();
        while (a.run() != 10)
            System.out.println("Not good enough!!! You shall not pass!! Try again!");
        
        System.out.println("Congratulations for full score! You are free to go!");


    }

    private int run(){
        int points = 0; String answer = "";
        Question[] questions = new Question[10];
        Scanner input = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            Question q = new Question().setQuestion();
            questions[i-1] = q;
                
        }
        for (int i = 0; i < 10; i++){
            
            System.out.println(questions[i].question + "?");
            answer = input.nextLine();
            if (questions[i].answer == Integer.parseInt(answer))
                points++;


        }

       return points;

    }
    


    class Question{
        int answer = 0;
        String question = "0";
        
        protected Question(){
            this.answer = 1;
            this.question = "1";
        }

        protected Question(int answer, String question){
            this.answer = answer;
            this.question = question;
        }


        protected Question setQuestion(){
            Random rnd = new Random();
            int a, b;
            a = rnd.nextInt(1, 11);
            b = rnd.nextInt(1, 11);

            return new Question(a*b, "" + a + " * " + b);
        }

    }


}
