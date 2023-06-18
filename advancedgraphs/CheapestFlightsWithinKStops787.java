package advancedgraphs;

import java.util.Arrays;

public class CheapestFlightsWithinKStops787 {
  public int findCheapestPrice(int n, int[][] flights, 
                               int src, int dst, int k) {
    int[] prices = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);

    prices[src] = 0;

    for (int i = k + 1; i > 0; i--) {
      int[] temp = Arrays.copyOf(prices, n);
      
      for (int[] flight : flights) {
        if (prices[flight[0]] == Integer.MAX_VALUE) {
          continue;
        }

        if (prices[flight[0]] + flight[2] 
              < temp[flight[1]]) {
          temp[flight[1]] = prices[flight[0]] 
                            + flight[2];
        }
      }

      prices = temp;
    }

    return (prices[dst] != Integer.MAX_VALUE) 
           ? prices[dst] 
           : -1;
  }
}