package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 1}, true),
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void testContainsDuplicate(int[] nums, boolean expected) {
        ContainsDuplicate solution = new ContainsDuplicate();
        if (expected) {
            assertTrue(solution.containsDuplicateQuadratic(nums));
            assertTrue(solution.containsDuplicateWithSorting(nums));
            assertTrue(solution.containsDuplicateWithHashSetForEachLoop(nums));
            assertTrue(solution.containsDuplicateWithHashSetForLoop(nums));
            assertTrue(solution.containsDuplicateWithHashSet2(nums));
        } else {
            assertFalse(solution.containsDuplicateQuadratic(nums));
            assertFalse(solution.containsDuplicateWithSorting(nums));
            assertFalse(solution.containsDuplicateWithHashSetForEachLoop(nums));
            assertFalse(solution.containsDuplicateWithHashSetForLoop(nums));
            assertFalse(solution.containsDuplicateWithHashSet2(nums));
        }
    }

}