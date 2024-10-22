package org.example;

public class Bowl {
  int feed;

  public Bowl(int feed) {
    this.feed = feed;
  }

  public int increaseFeed(int someFeed) {
    feed += someFeed;
    return feed;
  }
}
