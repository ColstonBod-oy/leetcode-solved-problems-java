import java.util.List;
import java.util.ArrayList;

class Permutations46 {
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> sub = new ArrayList<>();
    
    for (int n : nums) {
      sub.add(n);
    }
    
    return permute(sub);
  }

  public List<List<Integer>> permute(List<Integer> sub) {
    List<List<Integer>> res = new ArrayList<>();
    
    if (sub.size() == 1) {
      List<List<Integer>> perms = new ArrayList<>();
      List<Integer> perm = new ArrayList<>();
      perm.add(sub.get(0));
      perms.add(perm);
      return perms;
    }

    for (int i = 0; i < sub.size(); i++) {
      int n = sub.remove(0);
      List<List<Integer>> perms = permute(sub);

      for (List<Integer> perm : perms) {
        perm.add(n);
        res.add(perm);
      }

      sub.add(n);
    }
    
    return res;
  }
}