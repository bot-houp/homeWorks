package org.example;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateFactorial(-7));
  }

  public static int calculateFactorial(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("Введите целое неотрицательное число.");
    } else if (num == 0) {
      return 1;
    }
    int factorial = 1;
    for (int i = 1; i <= num; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
