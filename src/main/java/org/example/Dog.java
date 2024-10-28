package org.example;

public class Dog extends Animal{
  static int dogCounter = 0;
  int maxRunDistance;
  int maxSwimDistance;

  public Dog(String name) {
    super(name);
    this.maxRunDistance = 500;
    this.maxSwimDistance = 10;
    dogCounter++;
  }

  public static int getDogCounter() {
    return dogCounter;
  }
}
