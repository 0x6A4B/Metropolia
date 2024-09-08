package task3;

import java.io.Serializable;

public class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(){}
    public Enrollment(Student student, Course course, String date){
        this.student = student; this.course = course; enrollmentDate = date;
    }


    public Course getCourse() { return course; }
    public String getEnrollmentDate() { return enrollmentDate; }
    public Student getStudent() { return student; }
    public void setCourse(Course course) { this.course = course; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public void setStudent(Student student) { this.student = student; }
}
