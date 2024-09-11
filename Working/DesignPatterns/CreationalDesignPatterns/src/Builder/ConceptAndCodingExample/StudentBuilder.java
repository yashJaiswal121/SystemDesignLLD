package Builder.ConceptAndCodingExample;

import java.util.List;

public abstract class StudentBuilder {

    //Same instance fields as Student
    private int rollNo;
    private String name;

    protected List<String> subjects;

    public StudentBuilder setRollNo(int rollNo){
        this.rollNo = rollNo;
        return this;
    }

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public abstract StudentBuilder setSubjects();

    public List<String> getSubjects() {
        return subjects;
    }

    public Student build(){
        Student student = new Student(this);
        return student;
    }
}
