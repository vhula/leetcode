package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentElementsTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{4, 4, 4, 4, 5, 5, 6}, 2, new int[]{4, 5}),
                Arguments.of(new int[]{1, 1, 2, 1, 2, 3, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{}, 0, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testTopKFrequentElements(int[] nums, int k, int[] expected) {
        TopKFrequentElements solution = new TopKFrequentElements();
        Arrays.sort(expected);

        int[] resultSorting = solution.topKFrequentUsingSorting(nums, k);
        Arrays.sort(resultSorting);
        assertArrayEquals(expected, resultSorting);

        int[] resultHeap = solution.topKFrequentUsingHeap(nums, k);
        Arrays.sort(resultHeap);
        assertArrayEquals(expected, resultHeap);

        int[] resultBucket = solution.topKFrequentUsingBucketSort(nums, k);
        Arrays.sort(resultBucket);
        assertArrayEquals(expected, resultBucket);
    }

}