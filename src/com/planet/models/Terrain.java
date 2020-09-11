package com.planet.models;

import static com.planet.models.Point.P;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Terrain {

  private Point endPoint;
  private Set<Point> obstacles;
  private Point rareElement;
  private List<Rover> rovers;
  private Set<Point> nodes = new HashSet<>();

  public Terrain() {}

  public Terrain(Point endPoint, Set<Point> obstacles, Point rareElement, List<Rover> rovers) {
    setEndPoint(endPoint);
    setObstacles(obstacles);
    setRareElement(rareElement);
    setRovers(rovers);
  }

  public Point getEndPoint() {
    return endPoint;
  }

  public Set<Point> getObstacles() {
    return obstacles;
  }

  public Point getRareElement() {
    return rareElement;
  }

  public List<Rover> getRovers() {
    return rovers;
  }

  public Set<Point> getNodes() {
    return nodes;
  }

  public void setEndPoint(Point endPoint) {
    this.endPoint = endPoint;
  }

  public void setObstacles(Set<Point> obstacles) {
    this.obstacles = obstacles;
  }

  public void setRareElement(Point rareElement) {
    this.rareElement = rareElement;
  }

  public void setRovers(List<Rover> rovers) {
    this.rovers = rovers;
  }

  public void buildGraph() {
    for (int i = 0; i <= this.endPoint.getX(); i++) {
      for (int j = 0; j <= this.endPoint.getY(); j++) {
        this.nodes.add(P(i, j));
      }
    }
  }
}
