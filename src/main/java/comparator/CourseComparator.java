package comparator;

import model.Course;

import java.util.Comparator;

public class CourseComparator implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
