package org.example;

public class Lesson6 {

  public static void main(String[] args) {
    Person per = new Person("Ivanov Ivan", "Engineer", "ivivan@maibox.com", "892312312", 30000, 30);
    per.someInfo();

    Person[] persArray = new Person[5];
    persArray[0] = new Person("Margo Blum", "Manager", "ivivan@maibox.com", "89998881234", 50000, 40);
    persArray[1] = new Person("Petr Petrov", "Developer", "pepetr@mailbox.com", "89998885678", 45000, 35);
    persArray[2] = new Person("Pavel Pavlov", "Analyst", "papavel@mailbox.com", "89223224554", 40000, 30);
    persArray[3] = new Person("Maksim Maksimov", "Tester", "mamaksimpetr@mailbox.com", "89998889012", 35000, 25);
    persArray[4] = new Person("Dmitrii Dmitriev", "Tester", "dmidmitr@mailbox.com", "89223229807", 30000, 20);

    Park attraction1 = new Park();
    attraction1.name = "carusel";
    attraction1.price = 300;
    Park.WorkingHours workingHoursAttraction1 = new Park.WorkingHours();
    workingHoursAttraction1.HoursWeekday = "12:00 - 22:00";
    workingHoursAttraction1.Hoursweekend = "10:00 - 23:00";
  }
}
