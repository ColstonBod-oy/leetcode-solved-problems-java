package oneddynamicprogramming;

public class HouseRobberII213 {
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    
    int house1 = 0;
    int house2 = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      int temp = Math.max(house1 + nums[i], house2);
      house1 = house2;
      house2 = temp;
    }

    int house3 = 0;
    int house4 = 0;

    for (int i = 1; i < nums.length; i++) {
      int temp = Math.max(house3 + nums[i], house4);
      house3 = house4;
      house4 = temp;
    }

    return Math.max(house2, house4);
  }
}