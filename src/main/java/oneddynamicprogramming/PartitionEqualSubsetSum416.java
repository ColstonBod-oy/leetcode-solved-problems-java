package oneddynamicprogramming;

import java.util.HashSet;
import java.util.stream.IntStream;

public class PartitionEqualSubsetSum416 {
  public boolean canPartition(int[] nums) {
    int sum = IntStream.of(nums).sum();
    
    if (sum % 2 == 1) {
      return false;
    }
    
    HashSet<Integer> dp = new HashSet<>();
    dp.add(0);

    int target = sum / 2;
    
    for (int i : nums) {
      HashSet<Integer> nextDP = new HashSet<>(dp);

      for (int j : dp) {
        if (i + j == target) {
          return true;
        }
        
        nextDP.add(i + j);
      }

      dp = nextDP;
    }

    return false;
  }
}