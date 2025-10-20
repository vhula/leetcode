package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Problem(
        name = "217. Contains Duplicate",
        leetcodeUrl = "https://leetcode.com/problems/contains-duplicate/",
        topics = {Topic.ARRAY, Topic.HASH_TABLE, Topic.SORTING},
        complexity = ProblemComplexity.EASY
)
public class ContainsDuplicate {

    @Solution(
            timeComplexity = TimeComplexity.LINEAR,
            spaceComplexity = SpaceComplexity.LINEAR,
            submission = @Submission(runtimeMs = 13, memoryMb = 57.8)
    )
    public boolean containsDuplicateWithHashSetForLoop(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            if (seen.contains(left)) {
                return true;
            } else {
                seen.add(left);
            }
        }
        return false;
    }

    @Solution(
            timeComplexity = TimeComplexity.LINEAR,
            spaceComplexity = SpaceComplexity.LINEAR,
            submission = @Submission(runtimeMs = 14, memoryMb = 57.8)
    )
    public boolean containsDuplicateWithHashSetForEachLoop(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            } else {
                seen.add(num);
            }
        }
        return false;
    }

    @Solution(
            timeComplexity = TimeComplexity.LINEAR,
            spaceComplexity = SpaceComplexity.LINEAR,
            submission = @Submission(runtimeMs = 28, memoryMb = 61)
    )
    public boolean containsDuplicateWithHashSet2(int[] nums) {
        return nums.length != new HashSet<>(Arrays.stream(nums).boxed().toList()).size();
    }

    @Solution(
            timeComplexity = TimeComplexity.LINEARITHMIC,
            spaceComplexity = SpaceComplexity.CONSTANT,
            submission = @Submission(runtimeMs = 21, memoryMb = 56.7)
    )
    public boolean containsDuplicateWithSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    @Solution(
            timeComplexity = TimeComplexity.QUADRATIC,
            spaceComplexity = SpaceComplexity.CONSTANT,
            submission = @Submission(failed = true, failureReason = "Time Limit Exceeded")
    )
    public boolean containsDuplicateQuadratic(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
