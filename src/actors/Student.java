package actors;

public class Student extends Person {
    Student(String name, int age, int id){
        super(name, age, id, "Student");
    }

    @Override
    public String toString(){
        return formatting() + "\n";
    }
}
