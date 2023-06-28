package twoddynamicprogramming;

import java.util.HashMap;

public class BestTimeToBuyAndSellStockWithCooldown309 {
  HashMap<Pair, Integer> dp = new HashMap<>();

  class Pair<T, V> {
    T key;
    V value;

    Pair(T key, V value) {
      this.key = key;
      this.value = value;
    }

    public T getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }
  }
  
  public int maxProfit(int[] prices, int i, 
                       boolean isBuying) {
    if (i >= prices.length) {
      return 0;
    }

    Pair status = new Pair(i, isBuying);
    
    if (dp.containsKey(status)) {
      return dp.get(status);
    }

    int cooldown = maxProfit(prices, i + 1, isBuying);
    
    if (isBuying) {
      int buy = maxProfit(prices, i + 1, false) 
                - prices[i];
      dp.put(status, Math.max(cooldown, buy));
    } else {
      int sell = maxProfit(prices, i + 2, true) 
                 + prices[i];
      dp.put(status, Math.max(cooldown, sell));
    }

    return dp.get(status);
  }
  
  public int maxProfit(int[] prices) {
    return maxProfit(prices, 0, true);
  }
}
