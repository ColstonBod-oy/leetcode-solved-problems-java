package oneddynamicprogramming;

public class HouseRobberII213 {
  public int rob(int[] nums, int start, int end) {
    int house1 = 0;
    int house2 = 0;

    for (int i = start; i < end; i++) {
      int temp = Math.max(house1 + nums[i], house2);
      house1 = house2;
      house2 = temp;
    }

    return house2;
  }
  
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    
    if (nums.length == 1) {
      return nums[0];
    }
    
    return Math.max(rob(nums, 0, nums.length - 1), 
                    rob(nums, 1, nums.length));
  }
}