package Builder.ConceptAndCodingExample;

import java.util.ArrayList;

public class MBAStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        this.subjects = new ArrayList<>();
        subjects.add("Economics");
        return this;
    }
}
