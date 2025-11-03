package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductOfArrayExceptSelfTest {

  private static Stream<Arguments> testcases() {
    return Stream.of(Arguments.of(new int[] {1, 2, 3, 4}, new int[] {24, 12, 8, 6}),
        Arguments.of(new int[] {-1, 1, 0, -3, 3}, new int[] {0, 0, 9, 0, 0}),
        Arguments.of(new int[] {0, 0}, new int[] {0, 0}),
        Arguments.of(new int[] {5}, new int[] {1}),
        Arguments.of(new int[] {2, 3}, new int[] {3, 2}));
  }

  @ParameterizedTest
  @MethodSource("testcases")
  void testProductExceptSelf(int[] nums, int[] expected) {
    ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

    int[] resultNSquaredComplexity = solution.productExceptSelfQuadratic(nums);
    assertArrayEquals(expected, resultNSquaredComplexity);

    int[] resultDivision = solution.productExceptSelfDivision(nums);
    assertArrayEquals(expected, resultDivision);

    int[] resultPrefixSum = solution.productExceptSelfPrefixSum(nums);
    assertArrayEquals(expected, resultPrefixSum);
  }

}
