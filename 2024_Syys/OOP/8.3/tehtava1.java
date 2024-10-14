import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class tehtava1{
    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("john smith", 33, "New York"));
        persons.add(new Person("jack daniels", 55, "Detroit"));
        persons.add(new Person("mike mcdonald", 44, "Chicago"));
        persons.add(new Person("mark masterson", 22, "New York"));

        // city to filter by
        String city = "New York";

        // not 100% sure if the solution below is using comparator interface
        /// in the way required
        //persons.sort(Comparator.comparing(p -> p.getAge()));

        // but this should be what is required?
        Collections.sort(persons, new PersonAgeComparator());

        // do it with stream
        persons.stream().filter(p -> p.getCity().equals(city))
                .toList().forEach(System.out::println);

        // using removeIf
        persons.removeIf((p) -> !p.getCity().equals(city));
        persons.forEach(System.out::println);

    }
}

class PersonAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person a, Person b){ return a.getAge() - b.getAge(); }
}

class Person{

    private String name;
    private int age;
    private String city;

    Person(String name, int age, String city){
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge(){ return age; }
    public String getCity(){ return city; }

    public String toString(){ return name + " - " + age; }
}


