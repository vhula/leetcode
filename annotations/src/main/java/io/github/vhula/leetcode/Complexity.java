package io.github.vhula.leetcode;

public enum Complexity {
    EASY(10),
    MEDIUM(20),
    HARD(30);

    private final int score;

    Complexity(int score) {
        this.score = score;
    }

    public boolean harderThan(Complexity other) {
        return this.score > other.score;
    }
}
