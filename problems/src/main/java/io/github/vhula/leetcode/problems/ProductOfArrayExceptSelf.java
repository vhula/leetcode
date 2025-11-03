package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

@Problem(title = "Product of Array Except Self",
        difficulty = io.github.vhula.leetcode.Difficulty.MEDIUM,
        leetcodeUrl = "https://leetcode.com/problems/product-of-array-except-self/",
        topics = {io.github.vhula.leetcode.Topic.ARRAY, io.github.vhula.leetcode.Topic.PREFIX_SUM})
public class ProductOfArrayExceptSelf {
    @Solution(timeComplexity = @TimeComplexity(Complexity.QUADRATIC),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(failed = true, failureReason = "Time Limit Exceeded"))
    public int[] productExceptSelfQuadratic(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    @Solution(timeComplexity = @TimeComplexity(Complexity.LINEAR),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(runtimeMs = 1, memoryMb = 72.1))
    public int[] productExceptSelfDivision(int[] nums) {
        int[] result = new int[nums.length];
        int totalProduct = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                if (zeroCount > 1) {
                    return result;
                }
                continue;
            }
            totalProduct *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    result[i] = totalProduct;
                }
            } else {
                result[i] = totalProduct / nums[i];
            }
        }
        return result;
    }

    @Solution(timeComplexity = @TimeComplexity(Complexity.LINEAR),
            spaceComplexity = @SpaceComplexity(Complexity.LINEAR),
            submission = @Submission(runtimeMs = 2, memoryMb = 64.96))
    public int[] productExceptSelfPrefixSum(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
