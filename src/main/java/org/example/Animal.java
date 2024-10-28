package org.example;

public class Animal {
  String name;
  static int animalCounter = 0;

  public Animal(String name) {
    this.name = name;
    animalCounter++;
  }

  public static int getAnimalCounter() {
    return animalCounter;
  }

  public void run(int distance, int maxRunDistance) {
    if (distance <= maxRunDistance && distance > 0) {
      System.out.printf("%s пробежал %d метров.\n", name, distance);
    } else if (distance > maxRunDistance) {
      System.out.printf("%s не может пробежать %d метров.\n", name, distance);
    } else {
      System.out.println("Введёна некорректная длина препятствия.\n");
    }
  }

  public void swim(int distance, int maxSwimDistance) {
    if (distance <= maxSwimDistance && distance > 0) {
      System.out.printf("%s проплыл %d метров.\n", name, distance);
    } else if (distance > maxSwimDistance) {
      System.out.printf("%s не может проплыть %d метров.\n", name, distance);
    } else {
      System.out.println("Введёна некорректная длина препятствия.\n");
    }
  }
}
