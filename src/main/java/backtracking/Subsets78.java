package backtracking;

import java.util.List;
import java.util.ArrayList;

public class Subsets78 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> sub = new ArrayList<>();
  
  public List<List<Integer>> subsets(int[] nums) {
    subsets(0, nums);
    return res;
  }

  public void subsets(int i, int[] nums) {
    if (i == nums.length) {
      res.add(new ArrayList<>(sub));
      return;
    }

    sub.add(nums[i]);
    subsets(i + 1, nums);

    sub.remove(sub.size() - 1);
    subsets(i + 1, nums);
  }
}