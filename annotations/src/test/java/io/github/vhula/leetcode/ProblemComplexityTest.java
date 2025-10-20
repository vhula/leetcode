package io.github.vhula.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProblemComplexityTest {

    @Test
    void testHarderThan() {
        assertTrue(ProblemComplexity.MEDIUM.harderThan(ProblemComplexity.EASY));
        assertTrue(ProblemComplexity.HARD.harderThan(ProblemComplexity.MEDIUM));
        assertTrue(ProblemComplexity.HARD.harderThan(ProblemComplexity.EASY));

        assertFalse(ProblemComplexity.EASY.harderThan(ProblemComplexity.MEDIUM));
        assertFalse(ProblemComplexity.MEDIUM.harderThan(ProblemComplexity.HARD));
        assertFalse(ProblemComplexity.EASY.harderThan(ProblemComplexity.HARD));

        assertFalse(ProblemComplexity.EASY.harderThan(ProblemComplexity.EASY));
        assertFalse(ProblemComplexity.MEDIUM.harderThan(ProblemComplexity.MEDIUM));
        assertFalse(ProblemComplexity.HARD.harderThan(ProblemComplexity.HARD));
    }

}