package com.planet.models;

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Point P(int x, int y) {
    return new Point(x, y);
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void add(Point point) {
    this.x = getX() + point.getX();
    this.y = getY() + point.getY();
  }

  @Override
  public boolean equals(Object p) {
    if (p == this) {
      return true;
    }
    if (!(p instanceof Point)) {
      return false;
    }

    Point point = (Point) p;

    return point.getX() == getX() && point.getY() == getY();
  }

}
