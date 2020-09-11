package com.planet.models;

public enum Step {

  M("M"), L("L"), R("R");

  private String value;

  Step(String value) {
    this.value = value;
  }

  public String toString() {
    return this.value;
  }
}
