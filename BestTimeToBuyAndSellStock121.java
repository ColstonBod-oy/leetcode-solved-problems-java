class BestTimeToBuyAndSellStock121 {
  public int maxProfit(int[] prices) {
    int max = 0;
    int leftPtr = 0;
    int rightPtr = 1;

    while (rightPtr < prices.length) {
      if (prices[leftPtr] > prices[rightPtr]) {
        ++leftPtr;

        if (prices[leftPtr] == prices[rightPtr]) {
          ++rightPtr;
        }
        
        continue;
      }

      if (max < prices[rightPtr] - prices[leftPtr]) {
        max = prices[rightPtr] - prices[leftPtr];
      }

      ++rightPtr;
    }

    return max;
  }
}