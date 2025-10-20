package io.github.vhula.leetcode;

public enum ProblemComplexity {
    EASY(10),
    MEDIUM(20),
    HARD(30);

    private final int score;

    ProblemComplexity(int score) {
        this.score = score;
    }

    public boolean harderThan(ProblemComplexity other) {
        return this.score > other.score;
    }
}
