package org.example;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    printThreeWords();
    checkSumSign();
    printColor();
    compareNumbers();
    System.out.println(sumBetween10And20(20, 7));
    checkNumberSing(-7);
    System.out.println(isNegative(-9));
    printText("Hi", 4);
    System.out.println(isLeapYear(1600));
    inverseArrayValues();
    hundredArray();
    lessSix();
    createSquareArray(6);
    printArray(10, 3);
  }

  /**
   * Задача 1
   */
  public static void printThreeWords() {
    String[] arr = {"Orange", "Banana", "Apple"};
    for (String word : arr) {
      System.out.println(word);
    }
  }

  /**
   * Задача 2
   */
  public static void checkSumSign() {
    int a = 10, b = -20;
    if (a + b >= 0) {
      System.out.println("Сумма положительная");
    } else {
      System.out.println("Сумма отрицательная");
    }
  }

  /**
   * Задача 3
   */
  public static void printColor() {
    int value = 300;
    if (value <= 0) {
      System.out.println("Красный");
    } else if (value <= 100) {
      System.out.println("Желтый");
    } else {
      System.out.println("Зеленый");
    }
  }

  /**
   * Задача 4
   */
  public static void compareNumbers() {
    int a = 20, b = 20;
    if (a >= b) {
      System.out.println("a >= b");
    } else {
      System.out.println("a < b");
    }
  }

  /**
   * Задача 5
   */
  public static boolean sumBetween10And20(int a, int b) {
    return a + b >= 10 && a + b <= 20;
  }

  /**
   * Задача 6
   */
  public static void checkNumberSing(int a) {
    if (a < 0) {
      System.out.println("Число отрицательное");
    } else {
      System.out.println("Число положительное");
    }
  }

  /**
   * Задача 7
   */
  public static boolean isNegative(int a) {
    return a < 0;
  }

  /**
   * Задача 8
   */
  public static void printText(String text, int count) {
    for (int i = 0; i < count; i++) {
      System.out.println(text);
    }
  }

  /**
   * Задача 9
   */
  public static boolean isLeapYear(int year) {
    if (year % 400 == 0) {
      return true;
    } else if (year % 4 == 0 && year % 100 != 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Задача 10
   */
  public static void inverseArrayValues() {
    int[] arr = {1, 0, 0, 1, 1, 0, 0};
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] == 0 ? 1 : 0;
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Задача 11
   */
  public static void hundredArray() {
    int[] arr = new int[100];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Задача 12
   */
  public static void lessSix() {
    int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 6) {
        arr[i] *= 2;
      }
    }
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Задача 13
   */
  public static void createSquareArray(int a) {
    int[][] arr = new int[a][a];
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < a; j++) {
        if (i == j | i == a - j - 1) {
          arr[i][j] = 1;
        }
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Задача 14
   */
  public static void printArray(int len, int initialValue) {
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[i] = initialValue;
    }
    System.out.println(Arrays.toString(arr));
  }
}
