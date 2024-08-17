package arrayshashing;

import java.util.HashMap;

public class ContainsDuplicate217 {
  HashMap<Integer, Byte> map;
    
  public boolean containsDuplicate(int[] nums) {
    map = new HashMap<>();
      
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], (byte) 0);
      }

      else {
        return true;
      }
    }

    return false;
  }
}