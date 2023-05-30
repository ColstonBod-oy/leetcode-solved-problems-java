import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class LongestConsecutiveSequence128 {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>(Arrays.stream(nums)
      .boxed().collect(Collectors.toSet()));
    int res = 0;

    for (int num : nums) {
      int counter = 0;
      int nextNum;
      
      if (!set.contains(num - 1)) {
        ++counter;
        nextNum = num + 1;

        while (set.contains(nextNum)) {
          ++counter;
          ++nextNum;
        }

        if (counter > res) {
          res = counter;
        }
      }
    }
    
    return res;
  }
}