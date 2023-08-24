package actors;

public class Teacher extends Person implements Salary{
    double salary, baseSalary;

    Teacher(String name, int age, int id, int baseSalary){
        super(name, age, id, "Teacher");
        this.baseSalary = baseSalary;
    }

    public String toString(){
        return formatting();
    };

    @Override
    public double calculateSalary() {
        return 0;
    }
}
