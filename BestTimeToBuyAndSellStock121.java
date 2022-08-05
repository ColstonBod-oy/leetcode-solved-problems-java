class BestTimeToBuyAndSellStock121 {
  public int maxProfit(int[] prices) {
    int max = 0;
    int leftPtr = 0;
    int rightPtr = 1;

    while (rightPtr < prices.length) {
      int buyPrice = prices[leftPtr];
      int sellPrice = prices[rightPtr];
            
      if (buyPrice > sellPrice) {
        leftPtr = rightPtr;
      }
            
      if (prices[leftPtr] < sellPrice) {
        if (max < sellPrice - buyPrice) {
          max = sellPrice - buyPrice;
        }
      }

      ++rightPtr;
    }

    return max;
  }
}