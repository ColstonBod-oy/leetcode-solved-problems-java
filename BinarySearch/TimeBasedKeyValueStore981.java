import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class TimeBasedKeyValueStore981 {
  HashMap<String, List<Pair<String, Integer>>> map;
    
  public TimeBasedKeyValueStore981() {
    map = new HashMap<>();
  }
    
  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
      
    map.get(key).add(new Pair(value, timestamp));
  }
    
  public String get(String key, int timestamp) {
    List<Pair<String, Integer>> list = map
      .getOrDefault(key, new ArrayList<>(0)); 
    int l = 0;
    int r = list.size() - 1;
    String res = "";
      
    while (l <= r) {
      int m = (l + r) / 2;

      if (list.get(m).getValue() <= timestamp) {
        res = list.get(m).getKey();
        l = ++m;
      }

      else {
        r = --m;
      }
    }
      
    return res;
  }
  
  class Pair<T, V> {
    T key;
    V value;

    public Pair(T key, V value) {
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
}