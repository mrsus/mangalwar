package com.planet;

import static com.planet.models.Point.P;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.planet.models.Point;
import com.planet.models.Rover;
import com.planet.models.Terrain;

public class GameBuilder {

  private Terrain terrain;
  private Point endPoint = P(100, 100);
  private Set<Point> obstacles = new HashSet<>();
  private Point rareElement = P(0, 0);
  private List<Rover> rovers = new ArrayList<>();

  GameBuilder() {
    this.terrain = new Terrain();
  }

  GameBuilder(Terrain terrain) {
    this.terrain = terrain;
  }

  public GameBuilder addRover(Rover rover) {
    this.rovers.add(rover);
    return this;
  }

  public GameBuilder addObstacle(Point p) {
    this.obstacles.add(p);
    return this;
  }

  public GameBuilder addEndPoint(Point endPoint) {
    this.endPoint = endPoint;
    return this;
  }

  public GameBuilder addRareElement(Point rareElement) {
    this.rareElement = rareElement;
    return this;
  }

  public Terrain build() {
    this.terrain.setEndPoint(this.endPoint);
    this.terrain.setObstacles(this.obstacles);
    this.terrain.setRareElement(this.rareElement);
    this.terrain.setRovers(this.rovers);
    this.terrain.buildGraph();
    return this.terrain;
  }
}
