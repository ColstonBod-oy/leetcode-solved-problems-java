package backtracking;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SubsetsII90 {
  List<List<Integer>> res = new ArrayList<>();
  
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    subsetsWithDup(nums, 0, new ArrayList<>());
    return res;
  }

  public void subsetsWithDup(int[] nums, int i, List<Integer> subset) {
    if (i == nums.length) {
      res.add(new ArrayList<>(subset));
      return;
    }

    subset.add(nums[i]);
    subsetsWithDup(nums, i + 1, subset);
    subset.remove((Integer) nums[i]);

    while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
      ++i;
    }

    subsetsWithDup(nums, i + 1, subset);
  }
}