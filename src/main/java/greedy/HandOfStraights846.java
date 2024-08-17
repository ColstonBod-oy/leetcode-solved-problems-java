package greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HandOfStraights846 {
  public boolean isNStraightHand(int[] hand, 
                                 int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int card : hand) {
      map.put(card, 1 + map.getOrDefault(card, 0));
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int card : map.keySet()) {
      pq.offer(card);
    }

    while (!pq.isEmpty()) {
      int first = pq.peek();

      for (int i = first; i < first + groupSize; i++) {
        if (!map.containsKey(i)) {
          return false;
        }
        
        map.compute(i, (key, val) -> --val);

        if (map.get(i) == 0) {
          if (i != pq.peek()) {
            return false;
          }

          pq.poll();
        }
      }
    }

    return true;
  }
}