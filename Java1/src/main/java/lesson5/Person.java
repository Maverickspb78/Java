package lesson5;

public class Person {
    String name;
    String position;
    String email;
    String phone;
    long salary;

    public int getAge() {
        return age;
    }

    int age;

    public Person(String name, String position, String email, String phone,
                  long salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
