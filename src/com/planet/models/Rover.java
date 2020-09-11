package com.planet.models;

import static com.planet.models.Point.P;

public class Rover {
  private Point location;
  private Direction direction;
  private String country;
  private PathItem finalPath;

  public Rover(Point location, Direction direction, String country) {
    setLocation(location);
    face(direction);
    setCountry(country);
  }

  public static Rover R(Point location, Direction direction, String country) {
    return new Rover(location, direction, country);
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void face(Direction newLocation) {
    this.direction = newLocation;
  }

  public Point currentLocation() {
    return this.location;
  }

  public Direction facing() {
    return this.direction;
  }

  public String getCountry() {
    return this.country;
  }

  public Rover moveVerticalTo(int y) {
    setLocation(P(currentLocation().getX(), y));
    return this;
  }

  public Rover moveHorizontalTo(int x) {
    setLocation(P(x, currentLocation().getY()));
    return this;
  }

  public PathItem getFinalPath() {
    return finalPath;
  }

  public void setFinalPath(PathItem finalPath) {
    this.finalPath = finalPath;
  }


}
