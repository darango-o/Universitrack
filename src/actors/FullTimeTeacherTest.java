package actors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullTimeTeacherTest {
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new FullTimeTeacher("John", 54, 1002, 1000000, 7);
    }

    @Test
    void calculateSalary() {
        double expected = 7700000;
        double result = teacher.calculateSalary();
        assertEquals(expected, result);
    }

    @Test
    void testToString() {
        String expected = "Type: Teacher\tId: 1002\tName: John\tAge: 54 years old\tExp. Years: 7\n";
        String result = teacher.toString();
        assertEquals(expected, result);
    }
}