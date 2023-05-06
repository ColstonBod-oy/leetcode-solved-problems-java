import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class ThreeSum15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int i = 0;
    int leftPtr = i + 1;
    int rightPtr = nums.length - 1;
    
    Arrays.sort(nums);
    
    while (i < nums.length - 2) {
      if (i > 0) {
        while (nums[i - 1] == nums[i] && 
               i < nums.length - 2) {
                  ++i;
                  ++leftPtr;
        }
      }

      if (i == nums.length - 2) {
        return result;
      }
      
      while (leftPtr < rightPtr) {
        if (nums[leftPtr] == nums[leftPtr - 1] && 
            nums[leftPtr] != nums[i]) {
              ++leftPtr;
        }

        else if (rightPtr != nums.length - 1 && 
                 nums[rightPtr] == nums[rightPtr + 1]) {
                    --rightPtr;
        }
        
        else if (nums[i] + nums[leftPtr] + 
                 nums[rightPtr] < 0) {
                    ++leftPtr;
        }

        else if (nums[i] + nums[leftPtr] + 
                 nums[rightPtr] > 0) {
                    --rightPtr;
        }

        else {
          result.add(new ArrayList<>(Arrays
            .asList(nums[i], nums[leftPtr], nums[rightPtr])));
          ++leftPtr;
          --rightPtr;
        }
      }

      ++i;
      leftPtr = i + 1;
      rightPtr = nums.length - 1;
    }
    
    return result;
  }
}