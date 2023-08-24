package actors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Person student;

    @BeforeEach
    void setUp() {
        student = new Student("John", 23, 1001);
    }

    @Test
    void testToString() {
        String expected = "\nType: Student\tId: 1001\tName: John\tAge: 23 years old";
        String result = student.toString();
        assertEquals(expected, result);
    }
}