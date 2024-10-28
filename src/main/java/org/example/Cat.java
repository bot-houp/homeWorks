package org.example;

public class Cat extends Animal {
  static int catCounter = 0;
  int maxRunDistance;
  int maxSwimDistance;
  boolean isSatiety;
  int capacity;

  public Cat(String name, int capacity) {
    super(name);
    isSatiety = false;
    this.maxRunDistance = 200;
    this.maxSwimDistance = 0;
    this.capacity = capacity;
    catCounter++;
  }

  public static int getCatCounter() {
    return catCounter;
  }

  @Override
  public void swim(int distance, int maxSwimDistance) {
    System.out.printf("%s не умеет плавать\n", name);
  }

  public void eat(Bowl bowl) {
    if (bowl.feed - capacity >= 0) {
      isSatiety = true;
      bowl.decreaseFeed(capacity);
      System.out.printf("%s наелся.\n", name);
    } else {
      System.out.printf("%s не наелся.\n", name);
    }
  }

  public void catInfo() {
    System.out.printf("Имя: %s, сытость: %b.\n", name, isSatiety);
  }

}
