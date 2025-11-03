package io.github.vhula.leetcode;

public enum Complexity {
  CONSTANT("O(1)"), LOGARITHMIC("O(log n)"), LINEAR("O(n)"), LINEAR_N_PLUS_M("O(n + m)"), N_LOG_N(
      "O(n log n)"), N_LOG_N_PLUS_M_LOG_M("O(n*log(n) + m*log(m))"), QUADRATIC(
          "O(n^2)"), CUBIC("O(n^3)"), EXPONENTIAL("O(2^n)"), FACTORIAL("O(n!)"), CUSTOM("Custom");

  private final String notation;

  Complexity(String notation) {
    this.notation = notation;
  }

  @Override
  public String toString() {
    return notation;
  }
}
