package org.example;

public class Circle implements GeometricFigure {
  String name;
  double radius;
  String backgroundColor;
  String borderColor;


  public Circle(double radius, String backgroundColor, String borderColor) {
    name = "круг";
    this.radius = radius;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public void someInfo() {
    System.out.printf("\nФигура: %s;\nокружность: %.2f;\nплощадь: %.2f;\nцвет фона: %s;\nцвет границ: %s.\n", name, calculatePerimeter(), calculateArea(), backgroundColor, borderColor);
  }
}
