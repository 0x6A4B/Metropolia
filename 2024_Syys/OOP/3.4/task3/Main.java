package task3;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Student[] students = {
                  new Student("John Smith", 1, 19)
                , new Student("Jack Smith", 1, 29)
                , new Student("Jill Smith", 1, 39)
                , new Student("Jane Smith", 1, 49)
        };

        Course[] coursesForHorses = {
                new Course("A1", "Reading", "Prof. Reader")
                , new Course("A2", "Writing", "Prof. Writer")
                , new Course("B1", "Levitating", "Hairy Potter")
                , new Course("B2", "World Peace", "Josif Stalin")
        };

        Enrollment[] e = new Enrollment[20];

        int j = 0;
        for (int i = 0; i < 20; i++) {
            e[i] = new Enrollment(students[j], coursesForHorses[j], "01.01." + (1911 + i));
            j++;
            if (j > 3) j = 0;
        }

        for (int i = 0; i < e.length; i++){
            System.out.println(e[i].getCourse().getCourseName() + " - " + e[i].getStudent().getName());
        }

        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("object.dat"))){
            for (int i = 0; i < e.length; i++)
                o.writeObject(e[i]);
        }catch (IOException err){
            System.out.println("error wrtiting file");
        }

        e = null;

        ArrayList<Enrollment> readE = new ArrayList<>();

        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream("object.dat"))){
            while (true)
                readE.add((Enrollment) o.readObject());
        }catch (EOFException err){
            System.out.println("Done reading");
        }catch (Exception err){
            System.out.println("Reading error" + err.toString());
        }

        readE.forEach(en -> {
            System.out.printf("Course: %s\tStudent: %s\tDate: %s\tTeacher: %s\n", en.getCourse().getCourseName()
                , en.getStudent().getName(), en.getEnrollmentDate(), en.getCourse().getInstructor());
        });

    }
}
