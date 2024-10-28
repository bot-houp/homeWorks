package org.example;

import java.util.Arrays;

public class Lesson10 {
  public static void main(String[] args) {

    /**
     * Задание 1
     */

    Cat cat1 = new Cat("Барсик", 30);
    cat1.run(100, cat1.maxRunDistance);
    cat1.swim(1, cat1.maxSwimDistance);

    Cat cat2 = new Cat("Пушистик", 50);
    cat2.run(300, cat2.maxRunDistance);
    cat2.swim(0, cat2.maxSwimDistance);

    Dog dog = new Dog("Бобик");
    dog.run(400, dog.maxRunDistance);
    dog.swim(5, dog.maxSwimDistance);

    System.out.printf("Количество созданных котов: %d.\n", Cat.getCatCounter());
    System.out.printf("Количество созданных собак: %d.\n", Dog.getDogCounter());
    System.out.printf("Количество созданных животных: %d.\n", Animal.getAnimalCounter());

    Cat[] catsArray = new Cat[3];
    catsArray[0] = cat1;
    catsArray[1] = cat2;
    catsArray[2] = new Cat("Рудик", 40);

    Bowl bowl = new Bowl(80);
    bowl.increaseFeed(30);
    for (Cat cat : catsArray) {
      cat.eat(bowl);
    }

    for (Cat cat : catsArray) {
      cat.catInfo();
    }

    System.out.println();

    /**
     * Задание 2
     */

    Circle circle = new Circle(5.6, "фиолетовый", "серый");
    circle.someInfo();

    Rectangle rectangle = new Rectangle(5.6, 3.4, "жёлтый", "зелёный");
    rectangle.someInfo();

    Triangle triangle = new Triangle(5.6, 3.4, 7.8, "белый", "чёрный");
    triangle.someInfo();
  }
}
