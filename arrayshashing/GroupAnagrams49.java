package arrayshashing;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class GroupAnagrams49 {
  ArrayList<List<String>> result;
    
  public List<List<String>> groupAnagrams(String[] strs) {
    result = new ArrayList<>();
      
    if (strs.length == 1) {
      result.add(Arrays.asList(strs[0]));
      return result; 
    }

    HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
      
    for (String str : strs) {
      ArrayList<Integer> lettersCounter = new ArrayList<>(
        Collections.nCopies(26, 0));
      str.chars().forEach(c -> lettersCounter
        .set(c - 'a', lettersCounter.get(c - 'a') + 1));
      map.computeIfAbsent(lettersCounter, k -> new ArrayList<>());
      map.get(lettersCounter).add(str);
    }

    result.addAll(map.values());
    return result;
  }
}