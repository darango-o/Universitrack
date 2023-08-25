import actors.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class University {
    ArrayList<Course> courses = new ArrayList<Course>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    Scanner scan = new Scanner(System.in);

    University(ArrayList<Course> courses, ArrayList<Student> students, ArrayList<Teacher> teachers){
        this.courses = courses;
        this.students = students;
        this.teachers = teachers;
    }

    public void createCourse(){
        int choice;
        boolean exit = false;
        scan.nextLine();
        System.out.println("Introduce the name of the course: ");
        String name = scan.nextLine();
        System.out.println("Introduce the classroom of the course: ");
        int classroom = scan.nextInt();
        Course course = new Course(name, classroom);
        System.out.println("Do you want to assign a teacher to this course?\n1. Yes.\n2. No.\n");
        choice = scan.nextInt();
        if (choice == 1) {
            do {
                System.out.println("Introduce the id of the teacher");
                int teacherId = scan.nextInt();
                Teacher temp = (Teacher) searchTeacherById(teacherId, teachers);
                if (temp != null) {
                    course.assignTeacher(temp);
                } else {
                    System.out.println("Invalid id.");
                }
            } while (!course.isHasTeacher());

        }
        System.out.println("Do you want to add students to this course?\n1. Yes.\n2. No.\n");
        do{
            choice = scan.nextInt();
            if (choice == 1){
                boolean added = false;
                do {
                    System.out.println("Introduce the id of the student");
                    int studentId = scan.nextInt();
                    Student temp = (Student) searchStudentById(studentId, students);
                    if (temp != null) {
                        course.enrollStudent(temp);
                        added = true;
                    } else {
                        System.out.println("Invalid id.");
                    }
                } while (!added);
                System.out.println("Do you want to add another student.");
            }else {
                exit = true;
            }
        } while(!exit);
        courses.add(course);
        System.out.println("Course created: " + course.toString());
    }

    public void listCourses(){
        int index;
        int choice;
        do{
            System.out.println("\nEnter the index of any course to see its details: ");
            for(int i = 0; i < courses.size(); i++){
                index = i+1;
                System.out.println(index + ". " + courses.get(i).toString());
            }
            System.out.println("0. Return.");

            choice = scan.nextInt();
            if(choice>=1 && choice<= courses.size()){
                System.out.println("\nDetail Info about: " + courses.get(choice).sumDetails() + courses.get(choice).detailedInfo());
            } else if (choice != 0) {
                System.out.println("\nInvalid option.");
            }
        }while(choice != 0);
    }

    public void createTeacher(){

        int choice;

        System.out.println("Select the type of the teacher to create:\n1. Full time teacher.\n2. Part time teacher.\n0. Return.");
        do{
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    createFullTimeTeacher();
                    return;
                }
                case 2 -> {
                    createPartTimeTeacher();
                    return;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option.");
            }
        }while(true);
    }

    private void createFullTimeTeacher(){
        String name;
        int age, id, expYears;
        double baseSalary;

        scan.nextLine();
        System.out.println("\nEnter the name of the teacher: ");
        name = scan.nextLine();
        System.out.println("\nEnter the age of the teacher: ");
        age = scan.nextInt();
        System.out.println("\nEnter the experience years of the teacher: ");
        expYears = scan.nextInt();
        System.out.println("\nEnter the desired id of the teacher: ");
        id = scan.nextInt();
        System.out.println("\nEnter the base salary of the teacher: ");
        baseSalary = scan.nextDouble();

        Teacher temp = new FullTimeTeacher(name, age, id, baseSalary, expYears);
        System.out.println("\nNew teacher created correctly:\n" + temp.toString());
        teachers.add(temp);
    }

    private void createPartTimeTeacher(){
        String name;
        int age, id;
        double baseSalary, weeklyHours;

        scan.nextLine();
        System.out.println("\nEnter the name of the teacher: ");
        name = scan.nextLine();
        System.out.println("\nEnter the age of the teacher: ");
        age = scan.nextInt();
        System.out.println("\nEnter the desired id of the teacher: ");
        id = scan.nextInt();
        System.out.println("\nEnter the base salary of the teacher: ");
        baseSalary = scan.nextDouble();
        System.out.println("\nEnter the weekly active hours of the teacher: ");
        weeklyHours = scan.nextDouble();

        Teacher temp = new PartTimeTeacher(name, age, id, baseSalary, weeklyHours);
        System.out.println("\nNew teacher created correctly:\n" + temp.toString());
        teachers.add(temp);
    }

    public void listTeachers(){
        int index;
        for(int i = 0; i < teachers.size(); i++){
            index = i+1;
            System.out.println(index + ". " + teachers.get(i).toString());
        }
    }

    public void createStudent(){
        String name;
        int age, id;

        scan.nextLine();
        System.out.println("\nEnter the name of the student: ");
        name = scan.nextLine();
        System.out.println("\nEnter the age of the student: ");
        age = scan.nextInt();
        System.out.println("\nEnter the desired id of the student: ");
        id = scan.nextInt();

        Student temp = new Student(name, age, id);
        System.out.println("\nNew teacher created correctly:\n" + temp.toString());
        students.add(temp);
    }

    public void listStudents(){
        int index;
        for(int i = 0; i < teachers.size(); i++){
            index = i+1;
            System.out.println(index + ". " + teachers.get(i).toString());
        }
    }


    public Person searchTeacherById(int id, ArrayList<Teacher> teachers){
        for(Person person: teachers){
            if (id==person.getId()){
                return person;
            }
        }
        return null;
    }

    public Person searchStudentById(int id, ArrayList<Student> students){
        for(Person person: students){
            if (id==person.getId()){
                return person;
            }
        }
        return null;
    }

    public void getStudentCourses(){
        int id;
        Student tempStudent;
        StringBuilder studentCourses = new StringBuilder();

        System.out.println("Enter the Student Id:\n");
        id = scan.nextInt();
        tempStudent = (Student) searchStudentById(id, students);

        for (int i = 0; i< courses.size(); i++){
            if(courses.get(i).isEnrolled(tempStudent)){
                String tempInfo = i + ". " + courses.get(i).sumDetails() + "\n";
                studentCourses.append(tempInfo);
            }
        }

        System.out.println("The Student is enrolled in the following course(s):\n" + studentCourses.toString());
    }
}
