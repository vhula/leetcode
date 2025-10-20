package io.github.vhula.leetcode;

public enum TimeComplexity {
    CONSTANT("O(1)"),
    LOGARITHMIC("O(log n)"),
    LINEAR("O(n)"),
    LINEARITHMIC("O(n log n)"),
    QUADRATIC("O(n^2)"),
    CUBIC("O(n^3)"),
    EXPONENTIAL("O(2^n)"),
    FACTORIAL("O(n!)"),
    UNKNOWN("Unknown");

    private final String notation;

    TimeComplexity(String notation) {
        this.notation = notation;
    }

    @Override
    public String toString() {
        return notation;
    }
}
