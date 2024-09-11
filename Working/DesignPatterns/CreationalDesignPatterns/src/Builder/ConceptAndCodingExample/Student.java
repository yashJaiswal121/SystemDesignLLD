package Builder.ConceptAndCodingExample;

import java.util.List;

public class Student {

    private int rollNo;
    private String name;

    private List<String> subjects;

    //Any instance-concreteImpl of StudentBuilder can be passed here
    Student(StudentBuilder studentBuilder){
        this.setName(studentBuilder.getName());
        this.setRollNo(studentBuilder.getRollNo());
        this.setSubjects(studentBuilder.getSubjects());
    }
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
