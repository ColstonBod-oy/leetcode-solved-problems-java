package backtracking;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum39 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> sub = new ArrayList<>();
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    combinationSum(0, 0, candidates, target);
    return res;
  }

  public void combinationSum(int i, int total, int[] candidates, int target) {
    if (total == target) {
      res.add(new ArrayList<>(sub));
      return;
    }

    if (i == candidates.length || total > target) {
      return;
    }

    sub.add(candidates[i]);
    combinationSum(i, total + candidates[i], candidates, target);
    sub.remove(sub.size() - 1);
    combinationSum(i + 1, total, candidates, target);
  }
}