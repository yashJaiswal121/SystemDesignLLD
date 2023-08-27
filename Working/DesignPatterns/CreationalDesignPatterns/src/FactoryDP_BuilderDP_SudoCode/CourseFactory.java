package FactoryDP_BuilderDP_SudoCode;

import java.util.ArrayList;
import java.util.List;

public class CourseFactory {

    private static List<Class<? extends ICourse>> allCourses;

    static {
        allCourses = new ArrayList<>();
        allCourses.add(KafkaCourse.class);
        allCourses.add(JavaCourse.class);
    }

    public static ICourse getCourse(Class<? extends ICourse> courseClazz) throws InstantiationException, IllegalAccessException {
        if(allCourses.contains(courseClazz)){
            return courseClazz.newInstance();
        }
        return null;
    }
}
