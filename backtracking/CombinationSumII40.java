package backtracking;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CombinationSumII40 {
  List<List<Integer>> res = new ArrayList<>();
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    combinationSum2(candidates, 0, 
      new ArrayList<>(), target);
    return res;
  }

  public void combinationSum2(int[] candidates, int pos, List<Integer> subset, int target) {
    if (target == 0) {
      res.add(subset);
    }

    if (target <= 0) {
      return;
    }

    int prev = -1;
    
    for (int i = pos; i < candidates.length; i++) {
      if (candidates[i] == prev) {
        continue;
      }
      
      subset.add(candidates[i]);
      combinationSum2(candidates, i + 1, 
        new ArrayList<>(subset), 
        target - candidates[i]);
      subset.remove((Integer) candidates[i]);

      prev = candidates[i];
    }
  }
}