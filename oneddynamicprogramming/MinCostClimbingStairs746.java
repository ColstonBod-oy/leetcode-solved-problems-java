package oneddynamicprogramming;

public class MinCostClimbingStairs746 {
  public int minCostClimbingStairs(int[] cost) {
    int one = 0;
    int two = 0;

    for (int i = cost.length - 1; i >= 0; i--) {
      cost[i] += Math.min(one, two);
      int temp = one;
      one = cost[i];
      two = temp;
    }

    return Math.min(cost[0], cost[1]);
  }
}