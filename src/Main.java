import actors.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        initialize(teachers, students, courses);

        int choice;
        Scanner scan = new Scanner(System.in);
        University university = new University(courses, students, teachers);

        System.out.println("Bienvenido a Universitrack.");
        do {
            System.out.println("\nMarque el número con la opción que desee: \n1. Listar profesores.\n2. Crear profesores.\n3. Listar clases.\n4. Create new student.\n5. Create new class.\n6. List student(id) classes.\n0. Salir.");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> university.listTeachers();
                case 2 -> university.createTeacher();
                case 3 -> university.listCourses();
                case 4 -> university.createStudent();
                case 5 -> university.createCourse();
                case 6 -> university.getStudentCourses();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opción inválida. Ingrese una opción válida.");
            }

        } while (true);
    }

    private static void initialize(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<Course> courses){
        initializeTeachers(teachers);
        initializeStudents(students);
        initializeCourses(courses);
    }

    private static void initializeTeachers(ArrayList<Teacher> teachers){
        Teacher teacherFullTime = new FullTimeTeacher("john", 53, 1001,1000000,7);
        Teacher teacherPartTime = new PartTimeTeacher("Doe", 53, 1002,1000000,4);
        teachers.add(teacherFullTime);
        teachers.add(teacherPartTime);
    }

    private static void initializeStudents(ArrayList<Student> students){
        Student student1 = new Student("Alex", 19, 1003);
        Student student2 = new Student("Alexa", 29, 1004);
        Student student3 = new Student("Mike", 20, 1005);
        Student student4 = new Student("Mandy", 21, 1006);
        Student student5 = new Student("Alexis", 19, 1007);
        Student student6 = new Student("Donald", 22, 1008);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
    }

    private static void initializeCourses(ArrayList<Course> courses){
        Teacher teacherFullTime = new FullTimeTeacher("john", 53, 1001,1000000,7);
        Teacher teacherPartTime = new PartTimeTeacher("Doe", 53, 1002,1000000,4);

        Student student1 = new Student("Alex", 19, 1003);
        Student student2 = new Student("Alexa", 29, 1004);
        Student student3 = new Student("Mike", 20, 1005);
        Student student4 = new Student("Mandy", 21, 1006);
        Student student5 = new Student("Alexis", 19, 1007);
        Student student6 = new Student("Donald", 22, 1008);

        Course course1 = new Course("Math", 101);
        Course course2 = new Course("Art", 102);
        Course course3 = new Course("Science", 201);
        Course course4 = new Course("Spanish", 403);
        course1.assignTeacher(teacherFullTime);
        course2.assignTeacher(teacherPartTime);
        course3.assignTeacher(teacherFullTime);
        course4.assignTeacher(teacherPartTime);
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student6);
        course2.enrollStudent(student3);
        course3.enrollStudent(student4);
        course3.enrollStudent(student5);
        course4.enrollStudent(student1);
        course4.enrollStudent(student6);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }
}