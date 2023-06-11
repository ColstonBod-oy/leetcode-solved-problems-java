package advancedgraphs;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class ReconstructItinerary332 {
  List<String> res = new ArrayList<>();
  HashMap<String, List<String>> adj = new HashMap<>();
  
  public boolean findItinerary(String src, int maxSize, 
      List<List<String>> tickets) {
    if (res.size() == maxSize) {
      return true;
    }

    if (!adj.containsKey(src)) {
      return false;
    }

    List<String> cur = adj.get(src);
    
    for (int i = 0; i < cur.size(); i++) {
      String destination = cur.get(i);
      
      adj.get(src).remove(i);
      res.add(destination);
        
      if (findItinerary(destination, maxSize, 
                        tickets)) {
        return true;
      }

      adj.get(src).add(i, destination);
      res.remove(destination);
    }

    return false;
  }
  
  public List<String> findItinerary
      (List<List<String>> tickets) {
    Comparator<List<String>> comparator 
    = new Comparator<>() {
      @Override
      public int compare(List<String> a, List<String> b) {
        if (a.get(0).equals(b.get(0))) {
          return a.get(1).compareTo(b.get(1));
        }

        return a.get(0).compareTo(b.get(0));
      }
    };

    Collections.sort(tickets, comparator);

    for (List<String> ticket : tickets) {
      adj.computeIfAbsent(ticket.get(0), 
                          k -> new ArrayList<>());
      adj.get(ticket.get(0)).add(ticket.get(1));
    }

    res.add("JFK");
    findItinerary("JFK", tickets.size() + 1, tickets);
    return res;
  }
}