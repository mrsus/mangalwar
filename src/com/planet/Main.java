package com.planet;

import static com.planet.models.Point.P;
import static com.planet.models.Rover.R;
import com.planet.models.Direction;
import com.planet.models.Terrain;

class Main {

  public static void main(String[] args) {
    // Test case 1
    Terrain terrain1 = new GameBuilder().addEndPoint(P(2, 2)).addObstacle(P(1, 0))
        .addObstacle(P(0, 2)).addRareElement(P(1, 1)).addRover(R(P(0, 0), Direction.S, "US"))
        .addRover(R(P(0, 1), Direction.S, "RUSSIA")).build();

    // Test case 2
    Terrain terrain2 = new GameBuilder().addEndPoint(P(9, 0)).addObstacle(P(5, 0))
        .addObstacle(P(6, 0)).addRareElement(P(4, 0)).addRover(R(P(3, 0), Direction.N, "US"))
        .addRover(R(P(8, 0), Direction.S, "RUSSIA")).build();

    new GameExecutor().execute(terrain1);
    System.out.println();
    System.out.println();
    new GameExecutor().execute(terrain2);
  }

}
