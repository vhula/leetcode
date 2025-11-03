package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

import java.util.HashMap;
import java.util.Map;

@Problem(title = "1. Two Sum", leetcodeUrl = "https://leetcode.com/problems/two-sum/",
        topics = {io.github.vhula.leetcode.Topic.ARRAY, io.github.vhula.leetcode.Topic.HASH_TABLE},
        difficulty = io.github.vhula.leetcode.Difficulty.EASY)
public class TwoSum {

    @Solution(timeComplexity = @TimeComplexity(Complexity.LINEAR),
            spaceComplexity = @SpaceComplexity(Complexity.LINEAR),
            submission = @Submission(runtimeMs = 2, memoryMb = 44.88))
    public int[] twoSumLinear(int[] nums, int target) {
        Map<Integer, Integer> numsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numsIndices.containsKey(complement)) {
                return new int[] {numsIndices.get(complement), i};
            }
            numsIndices.put(nums[i], i);
        }
        return null;
    }

    @Solution(timeComplexity = @TimeComplexity(Complexity.QUADRATIC),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(runtimeMs = 44, memoryMb = 44.54))
    public int[] twoSumQuadratic(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

}
