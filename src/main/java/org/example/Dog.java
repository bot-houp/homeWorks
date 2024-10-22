package org.example;

public class Dog extends Animal{
  static int dogCounter = 0;

  public Dog(String name) {
    super(name);
    dogCounter++;
  }

  public static int getDogCounter() {
    return dogCounter;
  }
}
