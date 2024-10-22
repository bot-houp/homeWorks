package org.example;

public class Triangle implements GeometricFigure {
  String name;
  double side1;
  double side2;
  double side3;
  String backgroundColor;
  String borderColor;


  public Triangle(double side1, double side2, double side3, String backgroundColor, String borderColor) {
    name = "треугольник";
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
  }

  @Override
  public double calculatePerimeter() {
    return side1 + side2 + side3;
  }

  @Override
  public double calculateArea() {
    double s = (side1 + side2 + side3) / 2; // Полупериметр
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Формула Герона
  }

  @Override
  public void someInfo() {
    System.out.printf("\nФигура: %s;\nпериметр: %.2f;\nплощадь: %.2f;\nцвет фона: %s;\nцвет границ: %s.\n", name, calculatePerimeter(), calculateArea(), backgroundColor, borderColor);
  }
}
