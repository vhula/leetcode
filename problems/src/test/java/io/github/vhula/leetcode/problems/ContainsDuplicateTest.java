package io.github.vhula.leetcode.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
            Assertions.assertTrue(solution.containsDuplicateQuadratic(nums));
            Assertions.assertTrue(solution.containsDuplicateWithSorting(nums));
            Assertions.assertTrue(solution.containsDuplicateWithHashSetForEachLoop(nums));
            Assertions.assertTrue(solution.containsDuplicateWithHashSetForLoop(nums));
            Assertions.assertTrue(solution.containsDuplicateWithHashSet2(nums));
        } else {
            Assertions.assertFalse(solution.containsDuplicateQuadratic(nums));
            Assertions.assertFalse(solution.containsDuplicateWithSorting(nums));
            Assertions.assertFalse(solution.containsDuplicateWithHashSetForEachLoop(nums));
            Assertions.assertFalse(solution.containsDuplicateWithHashSetForLoop(nums));
            Assertions.assertFalse(solution.containsDuplicateWithHashSet2(nums));
        }
    }

}