package io.github.vhula.leetcode.problems;

import io.github.vhula.leetcode.*;

import java.util.*;

@Problem(title = "Top K Frequent Elements",
    leetcodeUrl = "https://leetcode.com/problems/top-k-frequent-elements/",
    topics = {Topic.ARRAY, Topic.HASH_TABLE, Topic.DIVIDE_AND_CONQUER, Topic.SORTING, Topic.HEAP,
        Topic.BUCKET_SORT, Topic.COUNTING, Topic.QUICK_SELECT},
    difficulty = Difficulty.MEDIUM)
public class TopKFrequentElements {

  @Solution(
      timeComplexity = @TimeComplexity(value = Complexity.N_LOG_N,
          details = "N is the number of unique elements in nums"),
      spaceComplexity = @SpaceComplexity(value = Complexity.LINEAR,
          details = "to store the frequency map"),
      submission = @Submission(runtimeMs = 18, memoryMb = 48.38))
  public int[] topKFrequentUsingSorting(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    List<int[]> sortedByFrequency =
        frequency.entrySet().stream().map(e -> new int[] {e.getValue(), e.getKey()})
            .sorted(Comparator.comparingInt(a -> ((int[]) a)[0]).reversed()).toList();
    return sortedByFrequency.subList(0, k).stream().mapToInt(a -> a[1]).toArray();
  }

  @Solution(
      timeComplexity = @TimeComplexity(customValue = "O(N log K)",
          details = "N is the number of elements in nums. K is the input parameter k"),
      spaceComplexity = @SpaceComplexity(customValue = "O(N + K)",
          details = "to store the frequency map and the heap"),
      submission = @Submission(runtimeMs = 18, memoryMb = 49.32))
  public int[] topKFrequentUsingHeap(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
      int num = entry.getKey();
      int freq = entry.getValue();
      minHeap.offer(new int[] {freq, num});
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll()[1];
    }
    return result;
  }

  @Solution(timeComplexity = @TimeComplexity(Complexity.LINEAR),
      spaceComplexity = @SpaceComplexity(Complexity.LINEAR),
      submission = @Submission(runtimeMs = 10, memoryMb = 49.86))
  public int[] topKFrequentUsingBucketSort(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }
    List<Integer>[] buckets = new List[nums.length + 1];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<>();
    }
    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
      buckets[entry.getValue()].add(entry.getKey());
    }
    int[] result = new int[k];
    for (int i = buckets.length - 1; i >= 0; i--) {
      for (int num : buckets[i]) {
        if (k == 0) {
          return result;
        }
        result[result.length - k] = num;
        k--;
      }
    }
    return result;
  }
}
