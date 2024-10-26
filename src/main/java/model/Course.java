package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Course {

    private String title;
    private LanguageType type;
    private Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return title.equals(course.title) && type == course.type && teacher.equals(course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, teacher);
    }
}
