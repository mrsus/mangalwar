package com.planet.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Direction {
  N(1, "N"), E(2, "E"), S(3, "S"), W(4, "W");

  private Integer id;
  private String type;

  Direction(Integer id, String type) {
    this.id = id;
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public String getType() {
    return type;
  }


  public static Direction getDirectionByType(String type) {
    for (Direction d : Direction.values()) {
      if (d.getType().equalsIgnoreCase(type)) {
        return d;
      }
    }
    return null;
  }

  public List<Step> getStepsTo(Direction destination) {
    int diff = destination.getId() - this.getId();
    if (diff == 1 || diff == -3) {
      return Collections.singletonList(Step.R);
    }
    if (diff == -1 || diff == 3) {
      return Collections.singletonList(Step.L);
    }
    if (diff == 2) {
      return Arrays.asList(Step.R, Step.R);
    }
    if (diff == -2) {
      return Arrays.asList(Step.L, Step.L);
    }
    return Collections.emptyList();
  }
}
