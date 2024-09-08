package task3;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private int age;

    public Student(){}
    public Student(String name, int id, int age){
        this.age = age; this.name = name; this.id = id;
    }

    public int getId() { return id; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public void setAge(int age) { this.age = age; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
