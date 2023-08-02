package greedy;

import java.util.stream.IntStream;

public class GasStation134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (IntStream.of(gas).sum() 
        < IntStream.of(cost).sum()) {
      return -1;
    }

    int total = 0;
    int res = 0;

    for (int i = 0; i < gas.length; i++) {
      total += gas[i] - cost[i];

      if (total < 0) {
        total = 0;
        res = i + 1;
      }
    }

    return res;
  }
}