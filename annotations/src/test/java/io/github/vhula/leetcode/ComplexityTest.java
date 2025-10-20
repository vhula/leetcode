package io.github.vhula.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexityTest {

    @Test
    void testHarderThan() {
        assertTrue(Complexity.MEDIUM.harderThan(Complexity.EASY));
        assertTrue(Complexity.HARD.harderThan(Complexity.MEDIUM));
        assertTrue(Complexity.HARD.harderThan(Complexity.EASY));

        assertFalse(Complexity.EASY.harderThan(Complexity.MEDIUM));
        assertFalse(Complexity.MEDIUM.harderThan(Complexity.HARD));
        assertFalse(Complexity.EASY.harderThan(Complexity.HARD));

        assertFalse(Complexity.EASY.harderThan(Complexity.EASY));
        assertFalse(Complexity.MEDIUM.harderThan(Complexity.MEDIUM));
        assertFalse(Complexity.HARD.harderThan(Complexity.HARD));
    }

}