package greedy;

public class JumpGame55 {
  public boolean canJump(int[] nums) {
    int goal = nums.length - 1;

    for (int i = goal; i >= 0; i--) {
      if (i + nums[i] >= goal) {
        goal = i;
      }
    }

    return goal == 0;
  }
}