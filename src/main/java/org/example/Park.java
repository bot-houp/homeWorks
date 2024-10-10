package org.example;

public class Park {
  String parkName;
  String address;
  String HoursWeekday;
  String HoursWeekend;

  public Park(String parkName, String address, String HoursWeekday, String HoursWeekend) {
    this.parkName = parkName;
    this.address = address;
    this.HoursWeekday = HoursWeekday;
    this.HoursWeekend = HoursWeekend;
  }

  public static class Attraction {
    String name;
    int price;

    public Attraction(String name, int price) {
      this.name = name;
      this.price = price;
    }
  }
}
