package com.planet;

import static com.planet.models.PathItem.pathItem;
import static com.planet.models.Point.P;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import com.planet.models.Direction;
import com.planet.models.PathItem;
import com.planet.models.Point;
import com.planet.models.Rover;
import com.planet.models.Step;
import com.planet.models.Terrain;

public class GameExecutor {

  private Rover winningRover;


  public void execute(Terrain terrain) {
    System.out.println("Game is started.");
    for (Rover rover : terrain.getRovers()) {
      System.out.println(rover.getCountry() + "'s turn.");
      PathItem minPath = getPath(terrain, rover);
      if (minPath == null) {
        System.out.println("Distance: -1");
        System.out.println("Steps: NA");
      } else {
        System.out.println("Distance: " + minPath.getDist());
        System.out.println("Steps: " + minPath.getSteps());
      }
      rover.setFinalPath(minPath);

      if (winningRover == null
          || (winningRover.getFinalPath() != null && rover.getFinalPath() != null
              && winningRover.getFinalPath().getDist() > rover.getFinalPath().getDist())) {
        winningRover = rover;
      }

    }
    System.out.println("Winner: " + this.winningRover.getCountry());
  }


  public PathItem getPath(Terrain terrain, Rover rover) {

    // To keep track of visited PathItems and mark obsctacle as visited.
    boolean[][] visited =
        new boolean[terrain.getEndPoint().getX() + 1][terrain.getEndPoint().getY() + 1];
    Set<Point> obstacles = terrain.getObstacles();
    for (Point node : terrain.getNodes()) {
      visited[node.getX()][node.getY()] = false;
    }
    for (Point node : obstacles) {
      visited[node.getX()][node.getY()] = true;
    }

    Queue<PathItem> queue = new ArrayDeque<>();
    PathItem roverPathItem = pathItem(rover.currentLocation(), 0);
    queue.add(roverPathItem);
    visited[roverPathItem.getPoint().getX()][roverPathItem.getPoint().getY()] = true;
    while (!queue.isEmpty()) {
      PathItem pItem = queue.poll();


      // sona found;
      if (pItem.getPoint().equals(terrain.getRareElement()))
        return pItem;

      // moving west
      if (pItem.getPoint().getX() - 1 >= 0
          && !visited[pItem.getPoint().getX() - 1][pItem.getPoint().getY()]) {

        List<Step> stepTillNow = getNextSetOfSteps(rover, pItem, Direction.W);
        Point pointToAdd = P(-1, 0);
        generateNextPathItem(visited, queue, pItem, stepTillNow, pointToAdd);
      }

      // moving east
      if (pItem.getPoint().getX() + 1 < terrain.getEndPoint().getX()
          && !visited[pItem.getPoint().getX() + 1][pItem.getPoint().getY()]) {

        List<Step> stepTillNow = getNextSetOfSteps(rover, pItem, Direction.E);
        Point pointToAdd = P(1, 0);
        generateNextPathItem(visited, queue, pItem, stepTillNow, pointToAdd);
      }

      // moving north
      if (pItem.getPoint().getY() - 1 >= 0
          && !visited[pItem.getPoint().getX()][pItem.getPoint().getY() - 1]) {

        List<Step> stepTillNow = getNextSetOfSteps(rover, pItem, Direction.N);
        Point pointToAdd = P(0, -1);
        generateNextPathItem(visited, queue, pItem, stepTillNow, pointToAdd);
      }

      // moving south
      if (pItem.getPoint().getY() + 1 < terrain.getEndPoint().getY()
          && !visited[pItem.getPoint().getX()][pItem.getPoint().getY() + 1]) {

        List<Step> stepTillNow = getNextSetOfSteps(rover, pItem, Direction.S);
        Point pointToAdd = P(0, 1);
        generateNextPathItem(visited, queue, pItem, stepTillNow, pointToAdd);
      }
    }
    return null;
  }


  private void generateNextPathItem(boolean[][] visited, Queue<PathItem> queue, PathItem pItem,
      List<Step> stepTillNow, Point pointToAdd) {
    Point nextPoint = nextPoint(pItem.getPoint(), pointToAdd);
    PathItem nextPathItem = nextPathItem(pItem, nextPoint);
    nextPathItem.setSteps(stepTillNow);
    queue.add(nextPathItem);
    visited[nextPoint.getX()][nextPoint.getY()] = true;
  }


  private List<Step> getNextSetOfSteps(Rover rover, PathItem pItem, Direction direction) {
    Direction currentDirection = rover.facing();
    List<Step> steps = currentDirection.getStepsTo(direction);
    List<Step> stepTillNow = new LinkedList<>(pItem.getSteps());
    stepTillNow.addAll(steps);
    stepTillNow.add(Step.M);
    return stepTillNow;
  }

  private Point nextPoint(Point currentPoint, Point additionPoint) {
    Point newPoint = P(0, 0);
    newPoint.add(currentPoint);
    newPoint.add(additionPoint);
    return newPoint;
  }

  private PathItem nextPathItem(PathItem pathItem, Point newPoint) {
    return pathItem(newPoint, pathItem.getDist() + 1);
  }
}
