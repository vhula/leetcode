package io.github.vhula.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DifficultyTest {

    @Test
    void testHarderThan() {
        assertTrue(Difficulty.MEDIUM.harderThan(Difficulty.EASY));
        assertTrue(Difficulty.HARD.harderThan(Difficulty.MEDIUM));
        assertTrue(Difficulty.HARD.harderThan(Difficulty.EASY));

        assertFalse(Difficulty.EASY.harderThan(Difficulty.MEDIUM));
        assertFalse(Difficulty.MEDIUM.harderThan(Difficulty.HARD));
        assertFalse(Difficulty.EASY.harderThan(Difficulty.HARD));

        assertFalse(Difficulty.EASY.harderThan(Difficulty.EASY));
        assertFalse(Difficulty.MEDIUM.harderThan(Difficulty.MEDIUM));
        assertFalse(Difficulty.HARD.harderThan(Difficulty.HARD));
    }

}
