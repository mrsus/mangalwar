package com.planet.models;

import java.util.LinkedList;
import java.util.List;

public class PathItem {

  private int dist;
  private Point point;
  private List<Step> steps = new LinkedList<>();

  private PathItem(Point point, int dist) {
    setDist(dist);
    setPoint(point);
  }

  public static PathItem pathItem(Point point, int dist) {
    return new PathItem(point, dist);
  }

  public int getDist() {
    return dist;
  }

  public void setDist(int dist) {
    this.dist = dist;
  }

  public Point getPoint() {
    return point;
  }

  public void setPoint(Point point) {
    this.point = point;
  }

  public List<Step> getSteps() {
    return steps;
  }

  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }
}
