package actors;

import java.util.ArrayList;

public class Course {
    final String name, id;
    final int classroom;
    private boolean hasTeacher = false;
    private final ArrayList<Person> members = new ArrayList<>();

    public Course(String name, int classroom){
        this.name = name;
        this.classroom = classroom;
        this.id = name.substring(0,3)+"-"+classroom;
    }

    public void assignTeacher(Teacher teacher){
        if(hasTeacher){
            System.out.println("This course already has a teacher.");
            return;
        }
        members.add(0, teacher);
        hasTeacher = true;
    }

    public void enrollStudent(Student student){
        if(isEnrolled(student)){
            System.out.println("This student is already enrolled in this course.");
            return;
        }
        members.add(student);
    }

    public boolean isEnrolled(Student student){
        return members.contains(student);
    }

    public String sumDetails(){
        return name + " " + id;
    }

    public String toString(){
        return String.format("Id: %s\tName: %s\tClassroom: %s\tTeacher assigned: %b\n", id, name, classroom, hasTeacher);
    }

    public String detailedInfo(){
        StringBuilder details = new StringBuilder();

        details.append(this);
        for(Person person : members){
            details.append(person.toString());
        }

        return details.toString();
    }

    public boolean isHasTeacher() {
        return hasTeacher;
    }

    public ArrayList<Person> getMembers() {
        return members;
    }
}
