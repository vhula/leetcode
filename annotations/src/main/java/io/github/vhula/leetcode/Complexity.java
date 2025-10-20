package io.github.vhula.leetcode;

public enum Complexity {
    CONSTANT("O(1)"),
    LOGARITHMIC("O(log n)"),
    LINEAR("O(n)"),
    LINEAR_TWO("O(n + m)"),
    LINEARITHMIC("O(n log n)"),
    LINEARITHMIC_TWO("O(n*log(n) + m*log(m))"),
    QUADRATIC("O(n^2)"),
    CUBIC("O(n^3)"),
    EXPONENTIAL("O(2^n)"),
    FACTORIAL("O(n!)"),
    UNKNOWN("Unknown");

    private final String notation;

    Complexity(String notation) {
        this.notation = notation;
    }

    @Override
    public String toString() {
        return notation;
    }
}
