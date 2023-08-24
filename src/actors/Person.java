package actors;

public abstract class Person {
    protected String name, type;
    protected int age, id;

    Person(String name, int age, int id, String type){
        this.name = name;
        this.age = age;
        this.id = id;
        this.type = type;
    }

    public abstract String toString();

    public String formatting(){
      return String.format("\nType: %s\tId: %d\tName: %s\tAge: %d years old", type, id, name, age);
    };
}
