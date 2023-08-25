package actors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartTimeTeacherTest {

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new PartTimeTeacher("Doe", 54, 1003, 1000000, 7.5);
    }


    @Test
    void calculateSalary() {
        double expected = 7500000;
        double result = teacher.calculateSalary();
        assertEquals(expected, result);
    }

    @Test
    void testToString() {
        String expected = "Type: Teacher\tId: 1003\tName: Doe\tAge: 54 years old\tWeekly Hours: 7.5\n";
        String result = teacher.toString();
        assertEquals(expected, result);
    }
}