/*
 * Cat says Meow!
 */

public class OOP_1_1_tehtava4 {


    public void meow() {
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Cat cat = new Cat("Whiskers");
        Cat rex = new Cat("Rex");

        // Call the meow method on the cat instance
        cat.meow(); cat.meow();
        rex.meow();
        cat.meow();
    }
}

public class Cat{

    private String name = "";

    public Cat(String name){
        this.name = name;
    }

    public void meow(){
        System.out.println("The cat named " + name + " says: Meow!");
    }

}
