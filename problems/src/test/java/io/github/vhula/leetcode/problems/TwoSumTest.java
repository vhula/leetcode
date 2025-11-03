package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TwoSumTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, 10, null),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, -8, new int[] {2, 4}));
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void testTwoSum(int[] nums, int target, int[] expected) {
        TwoSum solution = new TwoSum();
        if (expected == null) {
            assertNull(solution.twoSumQuadratic(nums, target));
        } else {
            assertArrayEquals(expected, solution.twoSumQuadratic(nums, target));
            assertArrayEquals(expected, solution.twoSumLinear(nums, target));
        }
    }

}
