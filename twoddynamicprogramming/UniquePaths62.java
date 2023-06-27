package twoddynamicprogramming;

import java.util.Arrays;

public class UniquePaths62 {
  public int uniquePaths(int m, int n) {
    int[] botRow = new int[n];
    Arrays.fill(botRow, 1);

    for (int i = m - 2; i >=0; i--) {
      int[] newRow = new int[n];
      newRow[n - 1] = 1;

      for (int j = n - 2; j >= 0; j--) {
        newRow[j] = newRow[j + 1] + botRow[j];
      }

      botRow = newRow;
    }

    return botRow[0];
  }
}