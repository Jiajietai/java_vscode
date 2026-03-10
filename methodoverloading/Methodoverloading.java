package methodoverloading;

public class Methodoverloading {
    public final String name = "Bob";
    private final int age;

    public Methodoverloading() {
        this.age = 0;
    }

    public void methodOverloading(String name, int age) {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }

    public void methodOverloading(int age, String name) {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }
}