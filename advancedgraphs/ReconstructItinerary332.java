package advancedgraphs;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class ReconstructItinerary332 {
  List<String> res = new ArrayList<>();
  HashMap<String, List<String>> adj = new HashMap<>();
  
  public boolean findItinerary(String src, int maxSize) {
    if (res.size() == maxSize) {
      return true;
    }

    if (!adj.containsKey(src)) {
      return false;
    }

    int size = adj.get(src).size();
    
    for (int i = 0; i < size; i++) {
      String destination = adj.get(src).get(i);
      
      adj.get(src).remove(i);
      res.add(destination);
        
      if (findItinerary(destination, maxSize)) {
        return true;
      }

      adj.get(src).add(i, destination);
      res.remove(res.size() - 1);
    }

    return false;
  }
  
  public List<String> findItinerary
      (List<List<String>> tickets) {
    Collections.sort(tickets, (a, b) -> {
      if (a.get(0).equals(b.get(0))) {
        return a.get(1).compareTo(b.get(1));
      }

      return a.get(0).compareTo(b.get(0));
    });

    for (List<String> ticket : tickets) {
      adj.computeIfAbsent(ticket.get(0), 
                          k -> new ArrayList<>())
         .add(ticket.get(1));
    }

    res.add("JFK");
    findItinerary("JFK", tickets.size() + 1);
    return res;
  }
}