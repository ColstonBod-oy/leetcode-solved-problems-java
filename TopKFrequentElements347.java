import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class TopKFrequentElements347 {
  public int[] topKFrequent(int[] nums, int k) {
    if (nums.length == 1) {
      return nums;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer>[] buckets = new ArrayList[nums.length];

    for (int i = 0; i < nums.length; i++) {
      buckets[i] = new ArrayList<>();
    }
      
    int[] result = new int[k];
    int resIndex = 0;

    for (int num : nums) {
      map.computeIfAbsent(num, key -> 0);
      map.computeIfPresent(num, (key, val) -> ++val);
    }

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      buckets[e.getValue() - 1].add(e.getKey());
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      for (Integer bucket : buckets[i]) {
        if (resIndex == result.length) {
          return result;
        }

        result[resIndex] = Integer.valueOf(bucket);
        ++resIndex;
      }
    }
      
    return result;
  }
}