package lesson5;

public class TestPerson {
    public static void main(String[] args) {
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivanov Ivan", "Engineer", "iivanov@mailbox.com", "89211234567", 30000, 35);
        personArray[1] = new Person("Petrov Petr", "General dir", "ppetrov@mailbox.com", "89227654321", 100000, 65);
        personArray[2] = new Person("Dart Vader", "Dark lord", "dart@mailbox.com", "89999999999", 90000, 50);
        personArray[3] = new Person("Vasilev Vasily", "HR manager", "vvasilev@mailbox.com", "89411234567", 35000, 40);
        personArray[4] = new Person("Evgeniev Evgeniy", "handyman", "eevgeniev@mailbox.com", "89417654321", 20000, 20);

        personOlder(personArray, 40);
    }

    public static void personOlder(Person[] persArr, int age){
        for (Person pers: persArr){
            if (pers.getAge() >age){
                System.out.println(pers.toString());
            }
        }
    }

}
