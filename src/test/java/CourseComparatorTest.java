import comparator.CourseComparator;
import model.Course;
import model.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseComparatorTest {
    private static final String COURSE_1_TITLE = "Funny English course";
    private static final String COURSE_2_TITLE = "Germany native course";
    private static final String TEACHER_1 = "Bill";
    private static final String TEACHER_2 = "Tom";
    private static final String TEACHER_1_SUR = "Simpson";
    private static final String TEACHER_2_SUR = "Muller";
    private static final LocalDate DATE = LocalDate.parse("1998-12-05");
    private static final LocalDate DATE2 = LocalDate.parse("1990-06-18");


    @Test
    @DisplayName("Сортировка только по названию")
    void sortBookByTitle(){

        List<Course> sortingByTitle = new ArrayList<>();
        sortingByTitle.add(
                new Course()
                .setTitle(COURSE_1_TITLE)
                .setTeacher(
                        new Teacher()
                                .setBirthDate(DATE)
                                .setName(TEACHER_1)
                                .setSurname(TEACHER_1_SUR)
                ));
        sortingByTitle.add(
                new Course()
                .setTitle(COURSE_2_TITLE)
                .setTeacher(
                        new Teacher()
                                .setBirthDate(DATE2)
                                .setName(TEACHER_2)
                                .setSurname(TEACHER_2_SUR)
                ));
        sortingByTitle.sort(new CourseComparator());
        Assertions.assertEquals(sortingByTitle.get(0).getTitle(), COURSE_1_TITLE);
    }

    @Test
    @DisplayName("Сортировка по названию и преподавателя")
    void sortBookByTitleAndAuthor(){

        List<Course> sortingByTitleAndTeacher = new ArrayList<>();
        sortingByTitleAndTeacher.add(
                new Course()
                        .setTitle(COURSE_1_TITLE)
                        .setTeacher(
                                new Teacher()
                                        .setBirthDate(DATE)
                                        .setName(TEACHER_1)
                                        .setSurname(TEACHER_1_SUR)
                        ));
        sortingByTitleAndTeacher.add(
                new Course()
                        .setTitle(COURSE_2_TITLE)
                        .setTeacher(
                                new Teacher()
                                        .setBirthDate(DATE2)
                                        .setName(TEACHER_1)
                                        .setSurname(TEACHER_1_SUR)
                        ));
        sortingByTitleAndTeacher.add(
                new Course()
                        .setTitle(COURSE_2_TITLE)
                        .setTeacher(
                                new Teacher()
                                        .setBirthDate(DATE)
                                        .setName(TEACHER_2)
                                        .setSurname(TEACHER_2_SUR)
                        ));
        sortingByTitleAndTeacher.sort(Comparator.comparing(Course::getTitle).thenComparing(Course::getTeacher));

        Assertions.assertEquals(sortingByTitleAndTeacher.get(1).getTeacher().getName(), TEACHER_2);
    }

}
