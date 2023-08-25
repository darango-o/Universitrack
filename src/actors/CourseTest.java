package actors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course;
    private Student student1, student2;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        course = new Course("math", 301);
        teacher = new FullTimeTeacher("John", 54, 1002, 1000000, 7);
        student1 = new Student("Alice", 19, 1001);
        student2 = new Student("Mike", 23, 1000);
    }

    @Test
    void assignWithoutExistingTeacher() {
        course.assignTeacher(teacher);
        assertTrue(course.isHasTeacher());
        assertEquals(teacher, course.getMembers().get(0));
    }

    @Test
    void assignWithExistingTeacher() {
        Teacher tempTeacher = new PartTimeTeacher("Anne", 20, 1007, 1000200, 4);

        course.assignTeacher(teacher);
        course.assignTeacher(tempTeacher);

        assertTrue(course.isHasTeacher());
        assertNotEquals(tempTeacher, course.getMembers().get(0));
    }

    @Test
    void enrollNonExistingStudent() {
        course.enrollStudent(student1);

        assertTrue(course.isEnrolled(student1));
        assertFalse(course.isEnrolled(student2));

    }

    @Test
    void enrollExistingStudent() {
        course.enrollStudent(student1);

        int temp = course.getMembers().size();

        course.enrollStudent(student1);

        assertEquals(temp, course.getMembers().size());
    }

    @Test
    void sumDetails() {
        String expected = "math mat-301";
        String result = course.sumDetails();
        assertEquals(expected, result);
    }

    @Test
    void testToString() {
        String expected = "\nId: mat-301\tName: math\tClassroom: 301\tTeacher assigned: false";
        String result = course.toString();
        assertEquals(expected, result);
    }

    @Test
    void detailedInfo() {
        course.assignTeacher(teacher);
        course.enrollStudent(student1);
        course.enrollStudent(student2);

        String expected = "\nId: mat-301\tName: math\tClassroom: 301\tTeacher assigned: true\nType: Teacher\tId: 1002\tName: John\tAge: 54 years old\tExp. Years: 7\nType: Student\tId: 1001\tName: Alice\tAge: 19 years old\nType: Student\tId: 1000\tName: Mike\tAge: 23 years old";
        String result = course.detailedInfo();
        assertEquals(expected, result);
    }
}