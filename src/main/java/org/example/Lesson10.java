package org.example;

import java.util.Arrays;

public class Lesson10 {
  public static void main(String[] args) {

    /**
     * Задание 1
     */

    final int maxRunDistanceCat = 200;
    final int maxSwimDistanceCat = 0;

    final int maxRunDistanceDog = 500;
    final int maxSwimDistanceDog = 10;

    Cat cat1 = new Cat("Барсик");
    cat1.run(100, maxRunDistanceCat);
    cat1.swim(1, maxSwimDistanceCat);

    Cat cat2 = new Cat("Пушистик");
    cat2.run(201, maxRunDistanceCat);
    cat2.swim(0, maxSwimDistanceCat);

    Dog dog = new Dog("Бобик");
    dog.run(400, maxRunDistanceDog);
    dog.swim(5, maxSwimDistanceDog);

    System.out.printf("Количество созданных котов: %d.\n", Cat.getCatCounter());
    System.out.printf("Количество созданных собак: %d.\n", Dog.getDogCounter());
    System.out.printf("Количество созданных животных: %d.\n", Animal.getAnimalCounter());

    Cat[] catsArray = new Cat[3];
    catsArray[0] = cat1;
    catsArray[1] = cat2;
    catsArray[2] = new Cat("Рудик");

    Bowl bowl = new Bowl(30);
    bowl.increaseFeed(30);
    for (Cat cat : catsArray) {
      if (bowl.feed - cat.capacity >= 0) {
        cat.isSatiety = cat.setSatiety();
        bowl.feed -= cat.capacity;
        System.out.printf("%s наелся.\n", cat.name);
      } else {
        System.out.println("Остальным не хватило еды в миске");
        break;
      }
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
