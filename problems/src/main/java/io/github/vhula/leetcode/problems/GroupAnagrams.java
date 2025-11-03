package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

import java.util.*;

@Problem(title = "49. Group Anagrams",
    leetcodeUrl = "https://leetcode.com/problems/group-anagrams/",
    topics = {Topic.HASH_TABLE, Topic.STRING, Topic.SORTING}, difficulty = Difficulty.MEDIUM)
public class GroupAnagrams {

  @Solution(
      timeComplexity = @TimeComplexity(customValue = "O(N * M)",
          details = "N is the number of strings, M is the maximum length of a string"),
      spaceComplexity = @SpaceComplexity(customValue = "O(N * M)", details = "to store the result"),
      submission = @Submission(runtimeMs = 18, memoryMb = 49.65))
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> result = new HashMap<>();
    for (String str : strs) {
      int[] count = new int[26];
      for (int i = 0; i < str.length(); i++) {
        count[str.charAt(i) - 'a']++;
      }
      String key = Arrays.toString(count);
      result.computeIfAbsent(key, _ -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(result.values());
  }

  @Solution(
      timeComplexity = @TimeComplexity(customValue = "O(N * M log M)",
          details = "N is the number of strings, M is the maximum length of a string"),
      spaceComplexity = @SpaceComplexity(customValue = "O(N * M)", details = "to store the result"),
      submission = @Submission(runtimeMs = 6, memoryMb = 48.13))
  public List<List<String>> groupAnagramsSortingWithForEachLoop(String[] strs) {
    Map<String, List<String>> result = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedStr = new String(chars);
      result.putIfAbsent(sortedStr, new ArrayList<>());
      result.get(sortedStr).add(str);
    }
    return new ArrayList<>(result.values());
  }

  @Solution(
      timeComplexity = @TimeComplexity(customValue = "O(N * M log M)",
          details = "N is the number of strings, M is the maximum length of a string"),
      spaceComplexity = @SpaceComplexity(customValue = "O(N * M)", details = "to store the result"),
      submission = @Submission(runtimeMs = 7, memoryMb = 48.1))
  public List<List<String>> groupAnagramsSortingWithForLoop(String[] strs) {
    Map<String, List<String>> result = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String sortedStr = new String(chars);
      result.putIfAbsent(sortedStr, new ArrayList<>());
      result.get(sortedStr).add(strs[i]);
    }
    return new ArrayList<>(result.values());
  }

  @Solution(timeComplexity = @TimeComplexity(customValue = "O(N * M + K)",
      details = "N is the number of strings, M is the maximum length of a string, K is the number of anagram groups"),
      spaceComplexity = @SpaceComplexity(Complexity.LINEAR),
      submission = @Submission(runtimeMs = 498, memoryMb = 47.79))
  public List<List<String>> groupAnagramsSlow(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < strs.length; i++) {
      if (seen.contains(i)) {
        continue;
      }
      List<String> currentResult = new ArrayList<>();
      currentResult.add(strs[i]);
      for (int j = i + 1; j < strs.length; j++) {
        if (isAnagram(strs[i], strs[j])) {
          currentResult.add(strs[j]);
          seen.add(j);
        }
      }
      seen.add(i);
      result.add(currentResult);
    }
    return result;
  }

  private boolean isAnagram(String first, String second) {
    if (first.length() != second.length()) {
      return false;
    }
    int[] count = new int[26];
    for (int i = 0; i < first.length(); i++) {
      char a = 'a';
      count[first.charAt(i) - a]++;
      count[second.charAt(i) - a]--;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

}
