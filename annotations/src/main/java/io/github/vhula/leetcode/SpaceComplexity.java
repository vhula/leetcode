package io.github.vhula.leetcode;

public enum SpaceComplexity {
    CONSTANT("O(1)"),
    LOGARITHMIC("O(log n)"),
    LINEAR("O(n)"),
    LINEARITHMIC("O(n log n)"),
    QUADRATIC("O(n^2)"),
    CUBIC("O(n^3)"),
    EXPONENTIAL("O(2^n)"),
    UNKNOWN("Unknown");

    private final String notation;

    SpaceComplexity(String notation) {
        this.notation = notation;
    }

    @Override
    public String toString() {
        return notation;
    }
}
