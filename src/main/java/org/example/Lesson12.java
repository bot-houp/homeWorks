package org.example;

public class Lesson12 {

  public static void main(String[] args) {

    String[][] validArray = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"},
    };

    String[][] notValidArray = {
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"},
    };

    String[][] dataNotValidArray = {
        {"1", "2", "3", "x"},
        {"x", "6", "7", "8"},
        {"9", "10", "x", "12"},
        {"13", "1x", "15", "16"},
    };

    try {
      System.out.printf("Сумма элементов массива равна %d\n", calculateArray(validArray));
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println(e.getMessage());
    }

    try {
      System.out.printf("Сумма элементов массива равна %d\n", calculateArray(notValidArray));
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println(e.getMessage());
    }

    try {
      System.out.printf("Сумма элементов массива равна %d\n", calculateArray(dataNotValidArray));
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println(e.getMessage());
    }

  }

  public static int calculateArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
    if (array.length != 4 || array[0].length != 4) {
      throw new MyArraySizeException("Массив должен быть размером 4х4\n");
    }

    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        try {
          sum += Integer.parseInt(array[i][j]);
        } catch (NumberFormatException e) {
          throw new MyArrayDataException("Ячейка [" + i + "][" + j + "] содержит нечисловое значение\n");
        }
      }
    }
    return sum;
  }
}

class MyArraySizeException extends Exception {
  public MyArraySizeException(String message) {
    super(message);
  }
}

class MyArrayDataException extends Exception {
  public MyArrayDataException(String message) {
    super(message);
  }
}
