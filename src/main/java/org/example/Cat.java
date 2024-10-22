package org.example;

public class Cat extends Animal {
  static int catCounter = 0;
  boolean isSatiety;

  public Cat(String name) {
    super(name);
    isSatiety = false;
    catCounter++;
  }

  public static int getCatCounter() {
    return catCounter;
  }

  @Override
  public void swim(int distance, int maxSwimDistance) {
    System.out.printf("%s не умеет плавать\n", name);
  }

  public void catInfo() {
    System.out.printf("Имя: %s, сытость: %b.\n", name, isSatiety);
  }

  public boolean setSatiety() {
    return true;
  }
}
