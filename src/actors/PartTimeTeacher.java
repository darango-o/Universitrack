package actors;

public class PartTimeTeacher extends Teacher {
    double activeWeeklyHours;

    PartTimeTeacher(String name, int age, int id, double baseSalary, double activeWeeklyHours){
        super(name, age, id, baseSalary);
        this.activeWeeklyHours = activeWeeklyHours;
        this.salary = calculateSalary();
    }

    @Override
    public double calculateSalary(){
        return baseSalary * activeWeeklyHours;
    }

    @Override
    public String toString(){
        return formatting() + "\tWeekly Hours: " + activeWeeklyHours + "\n";
    }
}
