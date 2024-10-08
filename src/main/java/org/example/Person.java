package org.example;

/**
 * Задача 1
 */
public class Person {
  String name;  // ФИО
  String position;  // должность
  String email;
  String phoneNumber;
  int salary;
  int age;
  public void someInfo() {
    System.out.printf("ФИО: %s\nДолжность: %s\nemail: %s\nТелефон: %s\nЗарплата: %d\nВозраст: %d\n", name, position, email, phoneNumber, salary, age);
  }

  public Person(String name, String position, String email, String phoneNumber, int salary, int age) {
    this.name =  name;
    this.position = position;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.salary = salary;
    this.age = age;
  }
}
