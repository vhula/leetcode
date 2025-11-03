package io.github.vhula.leetcode;

public enum Difficulty {
  EASY(10),
  MEDIUM(20),
  HARD(30);

  private final int score;

  Difficulty(int score) {
    this.score = score;
  }

  public boolean harderThan(Difficulty other) {
    return this.score > other.score;
  }
}
