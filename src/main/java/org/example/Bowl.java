package org.example;

public class Bowl {
  int feed;

  public Bowl(int feed) {
    this.feed = feed;
  }

  public void increaseFeed(int someFeed) {
    feed += someFeed;
  }

  public void decreaseFeed(int someFeed) {
    feed -= someFeed;
  }
}
