package actors;

public class FullTimeTeacher extends Teacher{
    int experienceYears;

    FullTimeTeacher(String name, int age, int id, double baseSalary, int experienceYears){
        super(name, age, id, baseSalary);
        this.experienceYears = experienceYears;
        this.salary = calculateSalary();
    }

    @Override
    public double calculateSalary(){
        return baseSalary * 1.1 * experienceYears;
    }

    @Override
    public String toString(){
        return formatting() + "\tExp. Years: " + experienceYears;
    }

}
