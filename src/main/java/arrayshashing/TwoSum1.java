package arrayshashing;

import java.util.HashMap;

public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    if (nums.length == 2) {
      return new int[] {0, 1};
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        if (map.containsKey(target - nums[i])) {
          return new int[] {i, map.get(target - nums[i])};
        }

        else {
          map.put(nums[i], i);
        }
      }

      else {
        if (map.containsKey(target + Math.abs(nums[i]))) {
          return new int[] {i, map.get(target + 
                            Math.abs(nums[i]))};
        }

        else {
          map.put(nums[i], i);
        }
      }
    }

    return new int[] {};
  }
}