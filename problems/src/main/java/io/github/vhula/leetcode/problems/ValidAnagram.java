package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Problem(
        title = "242. Valid Anagram",
        leetcodeUrl = "https://leetcode.com/problems/valid-anagram/",
        topics = {Topic.HASH_TABLE, Topic.SORTING, Topic.STRING},
        difficulty = Difficulty.EASY
)
public class ValidAnagram {

    @Solution(
            timeComplexity = @TimeComplexity(Complexity.LINEAR),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(runtimeMs = 5, memoryMb = 42.65)
    )
    public boolean isAnagramWithCharArray(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        char a = 'a';
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - a]++;
            count[t.charAt(i) - a]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Solution(
            timeComplexity = @TimeComplexity(Complexity.LINEAR_TWO),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(runtimeMs = 26, memoryMb = 44.54)
    )
    public boolean isAnagramWithHashMap(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }

    @Solution(
            timeComplexity = @TimeComplexity(Complexity.LINEARITHMIC_TWO),
            spaceComplexity = @SpaceComplexity(Complexity.CONSTANT),
            submission = @Submission(runtimeMs = 3, memoryMb = 44.34)
    )
    public boolean isAnagramWithSorting(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

}
