package oneddynamicprogramming;

public class HouseRobber198 {
  public int rob(int[] nums) {
    int house1 = 0;
    int house2 = 0;

    for (int n : nums) {
      int temp = Math.max(house1 + n, house2);
      house1 = house2;
      house2 = temp;
    }

    return house2;
  }
}