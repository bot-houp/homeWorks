package org.example;

public class Rectangle implements GeometricFigure {
  String name;
  double side1;
  double side2;
  String backgroundColor;
  String borderColor;


  public Rectangle(double side1, double side2, String backgroundColor, String borderColor) {
    name = "прямоугольник";
    this.side1 = side1;
    this.side2 = side2;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * (side1 + side2);
  }

  @Override
  public double calculateArea() {
    return side1 * side2;
  }

  @Override
  public void someInfo() {
    System.out.printf("\nФигура: %s;\nпериметр: %.2f;\nплощадь: %.2f;\nцвет фона: %s;\nцвет границ: %s.\n", name, calculatePerimeter(), calculateArea(), backgroundColor, borderColor);
  }
}
