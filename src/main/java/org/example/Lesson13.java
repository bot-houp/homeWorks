package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lesson13 {

  public static void main(String[] args) {
    String[] guitarBodyArr = {"Dreadnought", "Jumbo", "Concert", "Grand Concert", "Dreadnought", "Auditorium", "Grand Auditorium", "Parlor", "Concert", "Orchestra Model", "Triple-O", "Mini", "Orchestra Model", "Grand Symphony", "Slope-shoulder Dreadnought"};
    printUniqueValue(guitarBodyArr);
    countEachWord(guitarBodyArr);
    System.out.println();

    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addContact("Иванов", "+79123456789");
    phoneBook.addContact("Петров", "+79123456788");
    phoneBook.addContact("Максимов", "+79123456787");
    phoneBook.addContact("Иванов", "+79123456786");
    phoneBook.getContact("Иванов");
  }


  /**
   * Задание 1
   */

  public static void printUniqueValue(String[] arr) {
    List<String> arrList = Arrays.asList(arr);
    Set<String> arrSet = new HashSet<>(arrList);
    System.out.println(arrSet);
    }

  public static void countEachWord(String[] arr) {
    Map<String, Integer> map = new HashMap<>();
    for (String o : arr) {
      map.put(o, map.getOrDefault(o, 0) + 1);
    }
    for (Map.Entry<String, Integer> o : map.entrySet()) {
      System.out.printf("%s встречается в массиве %d раз(а)\n", o.getKey(), o.getValue());
    }
  }
}

/**
 * Задание 2
 */

class PhoneBook {
  Map<String, String> phoneBookMap;
  public PhoneBook() {
    phoneBookMap = new HashMap<>();
  }

  public void addContact (String surname, String number) {
    phoneBookMap.put(number, surname);
  }

  public void getContact (String surname) {
    for (Map.Entry<String, String> o : phoneBookMap.entrySet()) {
      if (o.getValue() == surname) {
        System.out.printf("%s :%s\n", o.getValue(), o.getKey());
      }
    }
  }
}